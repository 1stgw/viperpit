import Vue from "vue";
import VueResource from "vue-resource";
import App from "./App";
import router from "./router";
import store from "./store";
import "./assets/scss/viperpit.scss";

Vue.config.productionTip = false;
Vue.use(VueResource);

/* eslint-disable no-new */
new Vue({
  store,
  el: "#app",
  router,
  template: "<App/>",
  render: h => h(App)
});
