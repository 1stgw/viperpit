import Vue from "vue";
import Stomp from "webstomp-client";

export default function stompPlugin(store) {
  const agentId = window.location.hostname;
  const url = "ws://" + agentId + ":8090/sockets";
  const socket = new WebSocket(url);
  var client = Stomp.over(socket, {
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
      store.dispatch("connectAgent", agentId);
      store.dispatch("initStates");
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
