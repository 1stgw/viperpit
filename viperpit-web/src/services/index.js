import Stomp from 'webstomp-client'
import * as types from '../store/mutation-types'

export function connectToWebSocket (connectCallback, errorCallback) {
  const client = Stomp.client('ws://' + window.location.hostname + ':8090' + '/sockets', {
    debug: false
  })
  if (!connectCallback) {
    connectCallback = function (response) {
    }
  }
  if (!errorCallback) {
    errorCallback = function (response) {
    }
  }
  const headers = {}
  client.connect(headers, connectCallback, errorCallback)
  return client
}

export function installAgentsConnectListener (client, commit, dispatch) {
  function messageCallback (message) {
    const agent = JSON.parse(message.body)
    if (!agent) {
      return
    }
    dispatch('connectAgent', agent.id)
  }
  return client.subscribe('/topic/cockpit/agents/connect', messageCallback)
}

export function installAgentsDisconnectListener (client, commit, dispatch) {
  function messageCallback (message) {
    const agent = JSON.parse(message.body)
    if (!agent) {
      return
    }
    dispatch('disconnectAgent', agent.id)
  }
  return client.subscribe('/topic/cockpit/agents/disconnect', messageCallback)
}

export function installStatesUpdateListener (client, commit) {
  function messageCallback (message) {
    const delta = JSON.parse(message.body)
    if (!delta.agent) {
      return
    }
    commit(types.STATES_UPDATE, delta)
  }
  return client.subscribe('/topic/cockpit/states/update', messageCallback)
}
