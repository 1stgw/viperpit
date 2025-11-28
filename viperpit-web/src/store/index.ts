import Vue from "vue";
import type { HttpResponse } from "vue-resource/types/vue_resource";
import Vuex from "vuex";
import {
  AGENTS_CONNECT,
  AGENTS_DISCONNECT,
  CENTER_PEDESTAL_DISPLAY_UPDATE,
  CONFIGURATION_UPDATE,
  STATES_UPDATE
} from "./mutation-types";
import loaderPlugin from "./plugin";
import type { ConsoleConfiguration, ControlGroupConfiguration, PanelConfiguration } from "./types";

Vue.use(Vuex);

export class State {
  agentId: string | null = null;
  cockpitId = "f16";
  actions: Record<string, { value: boolean }> = {};
  configuration: { consoleConfigurations: ConsoleConfiguration[]; panelConfigurations: PanelConfiguration[] } = {
    consoleConfigurations: [],
    panelConfigurations: []
  };
  latestCenterPedestalDisplayImage?: string = undefined;
}

const store = new Vuex.Store<State>({
  strict: true,
  plugins: [loaderPlugin],
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
        Vue.http.get(`/data/configuration_${context.getters.getCockpit}.json`).then((response: HttpResponse) => {
          context.commit(CONFIGURATION_UPDATE, response.data);
        });
      }
    },
    startStateChange(_context, callback) {
      Vue.http.get(`/services/control/trigger/${callback}/start`);
    },
    endStateChange(_context, callback) {
      Vue.http.get(`/services/control/trigger/${callback}/stop`);
    },
    updateStates({ commit }, delta) {
      commit(STATES_UPDATE, delta);
    },
    updateCenterPedestalDisplay({ commit }, data) {
      commit(CENTER_PEDESTAL_DISPLAY_UPDATE, data);
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
    getControlConfigurationWithActiveState:
      (state: State) => (controlGroupConfiguration: ControlGroupConfiguration) => {
        const actions = state.actions;
        return controlGroupConfiguration.controlConfigurations.find(controlConfiguration => {
          const action = actions[controlConfiguration.callback];
          return action?.value === true ? controlConfiguration : undefined;
        });
      },
    getPanel: state => (consoleId: string, panelId: string) => {
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
    getPanels: () => (consoleId: string) => {
      return store.getters.getConsole(consoleId).panelConfigurations;
    },
    getLatestCenterPedestalDisplayImage: state => {
      return state.latestCenterPedestalDisplayImage;
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
    STATES_UPDATE(state, result) {
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
    },
    CENTER_PEDESTAL_DISPLAY_UPDATE(state, data) {
      state.latestCenterPedestalDisplayImage = data;
    }
  }
});

export default store;
