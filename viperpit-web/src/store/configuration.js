import * as types from './mutation-types'

const actions = {
  loadConfiguration ({ commit }) {
  }
}

const state = {
  consoles: [],
  panels: [],
  groups: [],
  controls: []
}

const mutations = {
  [types.CONFIGURATION_LOAD] (state, configuration) {
    state.consoles = configuration.consoles
    state.panels = configuration.panels
    state.groups = configuration.groups
    state.controls = configuration.controls
  }
}

export default {
  actions,
  state,
  mutations
}
