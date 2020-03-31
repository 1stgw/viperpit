import Vue from "vue";
import VueRouter from "vue-router";
import F16 from "@/components/f16/cockpit/F16";
import F16Router from "@/components/f16/router";
import F35 from "@/components/f35/cockpit/F35";
import F35Router from "@/components/f35/router";

Vue.use(VueRouter);

export default new VueRouter({
  routes: [
    {
      path: "/cockpits/f16",
      component: F16,
      children: F16Router.getRoutes()
    },
    {
      path: "/cockpits/f35",
      component: F35,
      children: F35Router.getRoutes()
    }
  ]
});
