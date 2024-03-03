import Vue from "vue";
import Vuex from "vuex";
import { AGENTS_CONNECT, AGENTS_DISCONNECT, CONFIGURATION_UPDATE, STATES_UPDATE } from "./mutation-types";
import stompPlugin from "./plugin";

Vue.use(Vuex);

class State {
  agentId: string | null = null;
  cockpitId = "f16";
  actions = {};
  configuration: { consoleConfigurations: []; panelConfigurations: [] } = {
    consoleConfigurations: [],
    panelConfigurations: []
  };
}

const store = new Vuex.Store({
  strict: true,
  plugins: [stompPlugin],
  state: new State(),
  actions: {
    connectAgent({ commit }, agentId) {
      commit(AGENTS_CONNECT, agentId);
    },
    disconnectAgent({ commit }, agentId) {
      commit(AGENTS_DISCONNECT, agentId);
    },
    initConfiguration(context) {
      const cockpitId = context.getters.getCockpit;
      if (cockpitId) {
        (Vue as any).http.get("/data/configuration_" + context.getters.getCockpit + ".json").then((response: any) => {
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
    startStateChange(context, callback) {
      const topic = "/app/cockpit/states/triggerStateChange";
      Vue.prototype.$stomp.send(
        topic,
        JSON.stringify({
          callback: callback,
          start: true
        })
      );
    },
    endStateChange(context, callback) {
      const topic = "/app/cockpit/states/triggerStateChange";
      Vue.prototype.$stomp.send(
        topic,
        JSON.stringify({
          callback: callback,
          start: false
        })
      );
    },
    updateStates({ commit }, delta) {
      commit(STATES_UPDATE, delta);
    }
  },
  getters: {
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
    getConsole: state => (id: string) => {
      const consoleConfiguration = state.configuration.consoleConfigurations.find(
        (consoleConfiguration: any) => consoleConfiguration.id === id
      );
      if (consoleConfiguration) {
        return consoleConfiguration;
      } else {
        return {
          panelConfigurations: []
        };
      }
    },
    getControlConfigurationWithActiveState: (state: any) => (controlGroupConfiguration: any) => {
      const actions = state.actions;
      return controlGroupConfiguration.controlConfigurations.find((controlConfiguration: any) => {
        const action = actions[controlConfiguration.callback];
        return action?.value === true ? controlConfiguration : undefined;
      });
    },
    getPanel: state => (consoleId: string, panelId: string) => {
      if (panelId) {
        const panelConfiguration: any = state.configuration.panelConfigurations.find(
          (panelConfiguration: any) => panelConfiguration.id === panelId
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
    getPanels: state => (consoleId: string) => {
      return store.getters.getConsole(consoleId).panelConfigurations;
    },
    isConnected: state => {
      return state.actions && state.agentId;
    }
  },
  mutations: {
    AGENTS_CONNECT(state, agentId) {
      state.agentId = agentId;
    },
    AGENTS_DISCONNECT(state, agentId) {
      if (state.agentId === agentId) {
        state.agentId = null;
      }
    },
    CONFIGURATION_UPDATE(state, configuration) {
      state.configuration = configuration;
    },
    STATES_UPDATE(state: any, result) {
      for (const callback in result.updatedStates) {
        const value = result.updatedStates[callback];
        const action = state.actions[callback];
        if (action) {
          Vue.set(action, "value", value);
        } else {
          const object = {
            callback: callback,
            value: value
          };
          Vue.set(state.actions, callback, object);
        }
      }
    }
  }
});

export default store;
