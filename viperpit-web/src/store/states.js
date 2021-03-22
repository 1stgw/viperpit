import Vue from "vue";
import store from ".";
import { AGENTS_CONNECT, AGENTS_DISCONNECT, CONFIGURATION_UPDATE, STATES_UPDATE } from "./mutation-types";

const state = () => ({
  agentId: null,
  cockpitId: "f16",
  actions: {},
  configuration: {
    consoleConfigurations: [],
    panelConfigurations: []
  }
});

const actions = {
  connectAgent({ commit }, agentId) {
    commit(AGENTS_CONNECT, agentId);
  },
  disconnectAgent({ commit }, agentId) {
    commit(AGENTS_DISCONNECT, agentId);
  },
  initConfiguration(context) {
    const cockpitId = context.getters.getCockpit;
    if (cockpitId) {
      Vue.http.get("/data/configuration_" + context.getters.getCockpit + ".json").then(response => {
        context.commit(CONFIGURATION_UPDATE, response.data);
      });
    }
  },
  initStates() {
    const topic = "/app/cockpit/states/init";
    Vue.prototype.$stomp.send(topic, JSON.stringify({}));
  },
  resetStates() {
    const topic = "/app/cockpit/states/reset";
    Vue.prototype.$stomp.send(topic, JSON.stringify({}));
  },
  startStateChange(context, id) {
    const topic = "/app/cockpit/states/triggerStateChange";
    Vue.prototype.$stomp.send(
      topic,
      JSON.stringify({
        id: id,
        start: true
      })
    );
  },
  endStateChange(context, id) {
    const topic = "/app/cockpit/states/triggerStateChange";
    Vue.prototype.$stomp.send(
      topic,
      JSON.stringify({
        id: id,
        start: false
      })
    );
  },
  updateStates({ commit }, delta) {
    commit(STATES_UPDATE, delta);
  }
};

const getters = {
  getAgent: state => {
    return state.agentId;
  },
  getCockpit: state => {
    return state.cockpitId;
  },
  getConfiguration: state => {
    return state.configuration;
  },
  getConsoles: state => {
    return state.configuration.consoleConfigurations;
  },
  getConsole: state => id => {
    const consoleConfiguration = state.configuration.consoleConfigurations.find(
      consoleConfiguration => consoleConfiguration.id === id
    );
    if (consoleConfiguration) {
      return consoleConfiguration;
    } else {
      return {
        panelConfigurations: []
      };
    }
  },
  getControlConfigurationWithActiveState: state => controlGroupConfiguration => {
    let actions = state.actions;
    return controlGroupConfiguration.controlConfigurations.find(controlConfiguration => {
      let action = actions[controlConfiguration.id];
      if (!action) {
        return false;
      }
      return actions[controlConfiguration.id].value === true;
    });
  },
  getPanel: state => (consoleId, panelId) => {
    if (panelId) {
      const panelConfiguration = state.configuration.panelConfigurations.find(
        panelConfiguration => panelConfiguration.id === panelId
      );
      if (panelConfiguration) {
        return panelConfiguration;
      }
    } else if (consoleId) {
      return store.getters.getPanels(consoleId)[0];
    }
    return {
      controlConfigurations: []
    };
  },
  // eslint-disable-next-line no-unused-vars
  getPanels: state => consoleId => {
    return store.getters.getConsole(consoleId).panelConfigurations;
  },
  isConnected: state => {
    return state.actions && state.agentId;
  }
};

const mutations = {
  AGENTS_CONNECT(state, agentId) {
    state.agentId = agentId;
  },
  AGENTS_DISCONNECT(state, agentId) {
    if (state.agentId === agentId) {
      state.agentId = undefined;
    }
  },
  CONFIGURATION_UPDATE(state, configuration) {
    state.configuration = configuration;
  },
  STATES_UPDATE(state, result) {
    for (let id in result.updatedStates) {
      let value = result.updatedStates[id];
      let action = state.actions[id];
      if (action) {
        Vue.set(action, "value", value);
      } else {
        let object = {
          id: id,
          value: value
        };
        Vue.set(state.actions, id, object);
      }
    }
  }
};

export default {
  actions,
  getters,
  state,
  mutations
};
