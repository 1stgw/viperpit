import Vue from "vue";
import Stomp from "webstomp-client";

export default function stompPlugin(store) {
  const agentId = window.location.hostname;
  const url = "ws://" + agentId + ":8090/sockets";
  const client = Stomp.client(url, { debug: false });
  Vue.prototype.$stomp = client;
  client.connect(
    {},
    () => {
      store.dispatch("initStates");
      store.dispatch("connectAgent", agentId);
      client.subscribe("/topic/cockpit/states/update", message => {
        const delta = JSON.parse(message.body);
        if (!delta.agent) {
          return;
        }
        store.dispatch("updateStates", delta);
      });
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
