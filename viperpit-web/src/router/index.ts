import Vue from "vue";
import VueRouter from "vue-router";
import CenterPedestalDisplay from "@/components/cockpit/CenterPedestalDisplay.vue";
import Cockpit from "@/components/cockpit/Cockpit.vue";
import CockpitFrame from "@/components/cockpit/CockpitFrame.vue";

Vue.use(VueRouter);

export default new VueRouter({
  routes: [
    {
      name: "CockpitFrame",
      path: "/cockpit",
      component: CockpitFrame,
      children: [
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
    },
    {
      name: "CenterPedestalDisplay",
      path: "/cpd",
      component: CenterPedestalDisplay,
      props: true
    }
  ]
});
