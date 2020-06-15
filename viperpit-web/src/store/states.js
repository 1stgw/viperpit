import Vue from "vue";
import configuration from "@/data/f16/configuration.json";
import {
  AGENTS_CONNECT,
  AGENTS_DISCONNECT,
  STATES_UPDATE
} from "./mutation-types";

const state = () => ({
  agentId: null,
  actions: {},
  configuration: configuration
});

const actions = {
  connectAgent({ commit, dispatch }, agentId) {
    dispatch("initStates");
    commit(AGENTS_CONNECT, agentId);
  },
  disconnectAgent({ commit }, agentId) {
    commit(AGENTS_DISCONNECT, agentId);
  },
  initStates() {
    const topic = "/app/cockpit/states/init";
    Vue.prototype.$stomp.send(topic, JSON.stringify({}));
  },
  resetStates() {
    const topic = "/app/cockpit/states/reset";
    Vue.prototype.$stomp.send(topic, JSON.stringify({}));
  },
  toggleState(context, id) {
    const topic = "/app/cockpit/states/toggle";
    Vue.prototype.$stomp.send(
      topic,
      JSON.stringify({
        id: id
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
  getConfiguration: state => {
    return state.configuration;
  },
  getConsole: state => id => {
    return state.configuration.consoleConfigurations.find(
      consoleConfiguration => consoleConfiguration.id === id
    );
  },
  getControlConfigurationWithActiveState: state => controlGroupConfiguration => {
    let actions = state.actions;
    return controlGroupConfiguration.controlConfigurations.find(
      controlConfiguration => {
        let action = actions[controlConfiguration.id];
        if (!action) {
          return false;
        }
        return actions[controlConfiguration.id].value === true;
      }
    );
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
