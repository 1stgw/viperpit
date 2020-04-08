import Vue from "vue";
import Stomp from "webstomp-client";

export default function(store) {
  const url = "ws://" + window.location.hostname + ":3000/ws";
  const client = Stomp.client(url, { debug: false });
  Vue.prototype.$stomp = client;
  client.connect(
    {},
    () => {
      store.dispatch("initStates");
      client.subscribe("/topic/cockpit/agents/connect", message => {
        const body = JSON.parse(message.body);
        if (!body) {
          return;
        }
        store.dispatch("connectAgent", body.agentId);
      });
      client.subscribe("/topic/cockpit/agents/disconnect", message => {
        const body = JSON.parse(message.body);
        if (!body) {
          return;
        }
        store.dispatch("disconnectAgent", body.agentId);
      });
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
      setTimeout(() => {
        this(store);
      }, 1000);
    }
  );
}
