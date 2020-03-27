import Stomp from "webstomp-client";
import * as types from "../store/mutation-types";

export function connectToWebSocket(dispatch, commit) {
  const url = "ws://" + window.location.hostname + ":8090" + "/sockets";
  return connectAndReconnect(url, dispatch, commit);
}

function connectAndReconnect(url, dispatch, commit) {
  const client = Stomp.client(url, { debug: true });
  client.connect(
    {},
    () => {
      installAgentsConnectListener(client, commit, dispatch);
      installAgentsDisconnectListener(client, commit, dispatch);
      installStatesUpdateListener(client, commit);
    },
    error => {
      console.log(error);
      setTimeout(() => {
        connectAndReconnect(url, dispatch, commit);
      }, 1000);
    }
  );
  return client;
}

function installAgentsConnectListener(client, commit, dispatch) {
  function messageCallback(message) {
    const agent = JSON.parse(message.body);
    if (!agent) {
      return;
    }
    dispatch("connectAgent", agent.id);
  }
  return client.subscribe("/topic/cockpit/agents/connect", messageCallback);
}

function installAgentsDisconnectListener(client, commit, dispatch) {
  function messageCallback(message) {
    const agent = JSON.parse(message.body);
    if (!agent) {
      return;
    }
    dispatch("disconnectAgent", agent.id);
  }
  return client.subscribe("/topic/cockpit/agents/disconnect", messageCallback);
}

function installStatesUpdateListener(client, commit) {
  function messageCallback(message) {
    const delta = JSON.parse(message.body);
    if (!delta.agent) {
      return;
    }
    commit(types.STATES_UPDATE, delta);
  }
  return client.subscribe("/topic/cockpit/states/update", messageCallback);
}
