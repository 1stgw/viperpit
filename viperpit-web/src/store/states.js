import Vue from "vue";
import {
  AGENTS_CONNECT,
  AGENTS_DISCONNECT,
  STATES_UPDATE
} from "./mutation-types";

const state = () => ({
  agentId: null,
  actions: {}
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
    Vue.prototype.$stomp.send("/app/cockpit/states/init", JSON.stringify({}));
  },
  toggleState(context, id) {
    Vue.prototype.$stomp.send(
      "/app/cockpit/states/toggle",
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
    if (!result.agent) {
      return;
    }
    if (!state.agentId) {
      state.agentId = result.agent.id;
    }
    if (result.agent.id !== state.agentId) {
      return;
    }
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
