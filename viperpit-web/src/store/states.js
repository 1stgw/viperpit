import Vue from 'vue'
import * as services from '../services'
import * as types from './mutation-types'

const state = {
  agentId: null,
  agents: null,
  actions: {}
}

const actions = {
  initialize ({ dispatch, commit }) {
    const client = services.connectToWebSocket((response) => {
      services.installAgentsConnectListener(client, commit, dispatch)
      services.installAgentsDisconnectListener(client, commit, dispatch)
      services.installStatesUpdateListener(client, commit)
    })
    dispatch('loadAgents').then(() => {
      if (!state.agents || state.agents.length === 0) {
        return
      }
      dispatch('connectAgent', state.agents[0])
    })
  },
  connectAgent ({ commit, dispatch }, agentId) {
    dispatch('loadAgents').then(() => {
      commit(types.AGENTS_CONNECT, agentId)
      dispatch('loadState', 'ramp').then(() => {
      })
    })
  },
  disconnectAgent ({ commit }, agentId) {
    commit(types.AGENTS_DISCONNECT, agentId)
  },
  loadAgents ({ commit }) {
    return Vue.http.get('/services/cockpit/agents/load').then(response => {
      if (!response.body || response.body.length === 0) {
        return
      }
      const agents = response.body.map((agent) => agent.id)
      commit(types.AGENTS_LOAD, agents)
    }, response => {
      console.log(response)
    })
  },
  loadState ({ commit }, preset) {
    if (state.agentId) {
      return Vue.http.get('/services/cockpit/states/load/' + state.agentId + '/' + preset).then(response => {
        const actions = response.body.actions
        if (!actions) {
          return
        }
        const result = Object.assign({}, ...actions.map((action) => ({ [action.id]:
        {
          'active': action.active,
          'callback': action.callback
        }
        })))
        commit(types.STATES_LOAD, result)
      }, response => {
        console.log(response)
      })
    }
  },
  fireAction ({ commit }, id) {
    const action = state.actions[id]
    if (!action) {
      return
    }
    const callback = action.callback
    Vue.http.post('/services/cockpit/states/fire/' + state.agentId + '/' + callback).then(response => {
    }, response => {
      console.log(response)
    })
  }
}

const getters = {
  getAgent: state => {
    return state.agentId
  },
  isActive: state => (id) => {
    if (state.actions[id]) {
      return state.actions[id].active
    } else {
      return false
    }
  },
  isConnected: state => {
    return state.actions && state.agentId
  }
}

const mutations = {
  [types.AGENTS_CONNECT] (state, result) {
    state.agentId = result
  },
  [types.AGENTS_DISCONNECT] (state, result) {
    if (state.agentId === result) {
      state.agentId = undefined
      state.actions = undefined
    }
    if (state.agents.length > 0 && state.agents[result]) {
      state.agents[result] = undefined
    }
  },
  [types.AGENTS_LOAD] (state, result) {
    state.agents = result
  },
  [types.STATES_LOAD] (state, result) {
    state.actions = result
  },
  [types.STATES_UPDATE] (_state, result) {
    if (!result.agent) {
      return
    }
    if (result.agent.id !== _state.agentId) {
      return
    }
    for (let affectedAction of result.actions) {
      const action = state.actions[affectedAction.id]
      if (action && action.active !== affectedAction.active) {
        action.active = affectedAction.active
      }
    }
  }
}

export default {
  actions,
  getters,
  state,
  mutations
}
