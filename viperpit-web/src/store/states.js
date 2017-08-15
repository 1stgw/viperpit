import Vue from 'vue'
import Stomp from 'webstomp-client'
import * as types from './mutation-types'

const state = {
  loaded: false,
  agent: null,
  agents: null,
  actions: {}
}

const actions = {
  loadState ({ commit }) {
    Vue.http.get('/services/cockpit/agents/load').then(response => {
      const agents = response.body
      if (!agents) {
        return
      }
      commit(types.LOAD_AGENTS, agents)
      const client = Stomp.client('ws://office:9000/viperpit/sockets')
      function onConnect (user) {
        function onMessage (message) {
          const affectedActions = JSON.parse(message.body).actions
          if (!affectedActions) {
            return
          }
          commit(types.FIRE_ACTION, affectedActions)
        }
        client.subscribe('/topic/cockpit/states/update/' + state.agent.id, onMessage)
      }
      client.connect({}, onConnect)
      if (state.agent) {
        Vue.http.get('/services/cockpit/states/load/' + state.agent.id + '/ramp').then(response => {
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
          commit(types.LOAD_STATE, result)
        }, response => {
          console.log(response)
        })
      }
    }, response => {
      console.log(response)
    })
  },
  fireAction ({ commit }, id) {
    const action = state.actions[id]
    if (!action) {
      return
    }
    const callback = action.callback
    Vue.http.post('/services/cockpit/states/fire/' + state.agent.id + '/' + callback).then(response => {
    }, response => {
      console.log(response)
    })
  }
}

const getters = {
  isActive: state => (id) => {
    if (state.actions[id]) {
      return state.actions[id].active
    } else {
      return false
    }
  }
}

const mutations = {
  [types.FIRE_ACTION] (_state, result) {
    for (let affectedAction of result) {
      const action = state.actions[affectedAction.id]
      if (action && action.active !== affectedAction.active) {
        action.active = affectedAction.active
      }
    }
  },
  [types.LOAD_STATE] (state, result) {
    state.loaded = true
    state.actions = result
  },
  [types.LOAD_AGENTS] (state, result) {
    state.agent = result[0]
    state.agents = result
  }
}

export default {
  actions,
  getters,
  state,
  mutations
}
