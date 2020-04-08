import Vue from "vue";
import VueResource from "vue-resource";
import router from "./router";
import store from "./store";
import vuetify from "./plugins/vuetify";
import App from "./App";
import "typeface-oxanium";
import "@mdi/font/css/materialdesignicons.css";

Vue.config.productionTip = false;
Vue.use(VueResource);

new Vue({
  components: { App },
  el: "#app",
  template: "<App/>",
  router,
  store,
  vuetify,
  render: h => h(App)
});
