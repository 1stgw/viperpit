import Vue from "vue";
import { Store } from "vuex";
import Stomp from "webstomp-client";
import { State } from ".";

export default function stompPlugin(store: Store<State>) {
  const agentId = window.location.hostname;
  const url = `ws://${agentId}:8090/sockets`;
  const socket = new WebSocket(url);
  const client = Stomp.over(socket, {
    debug: false
  });
  Vue.prototype.$stomp = client;
  client.connect(
    {},
    () => {
      client.subscribe("/topic/cockpit/states/update", message => {
        const delta = JSON.parse(message.body);
        if (!delta.agent) {
          return;
        }
        store.dispatch("updateStates", delta);
      });
      client.subscribe("/topic/cpd/images/update", message => {
        store.dispatch("updateCenterPedestalDisplay", message.body);
      });
      store.dispatch("connectAgent", agentId);
      store.dispatch("initConfiguration");
    },
    error => {
      console.log(error);
      client.disconnect();
      store.dispatch("disconnectAgent", agentId);
      setTimeout(() => {
        stompPlugin(store);
      }, 1000);
    }
  );
}
