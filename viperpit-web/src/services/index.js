import Stomp from "webstomp-client";
import * as types from "../store/mutation-types";

export function connectToWebSocket(dispatch, commit) {
  const url = "ws://" + window.location.hostname + ":8090" + "/sockets";
  return connectAndReconnect(url, dispatch, commit);
}

function connectAndReconnect(url, dispatch, commit) {
  const client = Stomp.client(url, { debug: false });
  client.connect(
    {},
    () => {
      installAgentsConnectListener(client, dispatch);
      installAgentsDisconnectListener(client, dispatch);
      installStatesUpdateListener(client, commit);
    },
    error => {
      console.log(error);
      client.disconnect();
      setTimeout(() => {
        connectAndReconnect(url, dispatch, commit);
      }, 1000);
    }
  );
  return client;
}

function installAgentsConnectListener(client, dispatch) {
  return client.subscribe("/topic/cockpit/agents/connect", message => {
    const agent = JSON.parse(message.body);
    if (!agent) {
      return;
    }
    dispatch("connectAgent", agent.id);
  });
}

function installAgentsDisconnectListener(client, dispatch) {
  return client.subscribe("/topic/cockpit/agents/disconnect", message => {
    const agent = JSON.parse(message.body);
    if (!agent) {
      return;
    }
    dispatch("disconnectAgent", agent.id);
  });
}

function installStatesUpdateListener(client, commit) {
  return client.subscribe("/topic/cockpit/states/update", message => {
    const delta = JSON.parse(message.body);
    if (!delta.agent) {
      return;
    }
    commit(types.STATES_UPDATE, delta);
  });
}
