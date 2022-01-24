import Cockpit from "@/components/cockpit/Cockpit.vue";
import Vue from "vue";
import VueRouter from "vue-router";

Vue.use(VueRouter);

export default new VueRouter({
  routes: [
    {
      name: "Cockpit",
      path: "/cockpit/:cockpitId",
      component: Cockpit,
      props: true
    },
    {
      name: "CockpitWithConsole",
      path: "/cockpit/:cockpitId/console/:consoleId",
      component: Cockpit,
      props: true
    },
    {
      name: "CockpitWithConsoleAndPanel",
      path: "/cockpit/:cockpitId/console/:consoleId/panel/:panelId",
      component: Cockpit,
      props: true
    }
  ]
});
