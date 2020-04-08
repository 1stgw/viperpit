import express from "express";
import StompServer from "stomp-broker-js";

export default (app, http) => {
  app.use((request, response, next) => {
    response.header("Access-Control-Allow-Origin", "*");
    response.header(
      "Access-Control-Allow-Headers",
      "Origin, X-Requested-With, Content-Type, Accept"
    );
    next();
  });
  app.use(express.json());
  this.agents = [];
  let stompServer = new StompServer({
    server: http,
    path: "/ws",
    debug: console.log
  });
  stompServer.on("connected", (sessionId, headers) => {
    var agentId = headers["agent-id"];
    if (agentId) {
      this.agents[sessionId] = agentId;
      stompServer.send(
        "/topic/cockpit/agents/connect",
        {},
        JSON.stringify({
          agentId: agentId
        })
      );
    }
  });
  stompServer.on("disconnected", sessionId => {
    var agentId = this.agents[sessionId];
    if (agentId) {
      delete this.agents[sessionId];
      stompServer.send(
        "/topic/cockpit/agents/disconnect",
        {},
        JSON.stringify({
          agentId: agentId
        })
      );
    }
  });
  stompServer.subscribe("/app/cockpit/states/init", message => {
    stompServer.send("/topic/cockpit/states/init", {}, message);
  });
  stompServer.subscribe("/app/cockpit/states/toggle", message => {
    stompServer.send("/topic/cockpit/states/toggle", {}, message);
  });
  stompServer.subscribe("/app/cockpit/states/update", message => {
    stompServer.send("/topic/cockpit/states/update", {}, message);
  });
};
