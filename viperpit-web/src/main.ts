import "@mdi/font/css/materialdesignicons.css";
import "typeface-oxanium";
import Vue from "vue";
import App from "./App.vue";
import vuetify from "./plugins/vuetify";
import router from "./router";
import store from "./store";

Vue.config.productionTip = false;

new Vue({
  el: "#app",
  components: { App },
  template: "<App />",
  router,
  store,
  vuetify,
  render: h => h(App)
});
