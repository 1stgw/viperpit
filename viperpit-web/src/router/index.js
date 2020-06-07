import Cockpit from "@/components/cockpit/Cockpit";
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
    }
  ]
});
