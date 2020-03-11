import Vue from "vue";
import VueResource from "vue-resource";
import { library as fontAwesomeIconLibrary } from "@fortawesome/fontawesome-svg-core";
import { FontAwesomeIcon } from "@fortawesome/vue-fontawesome";
import {
  faCaretUp,
  faCaretDown,
  faCaretLeft,
  faCaretRight
} from "@fortawesome/free-solid-svg-icons";
import App from "./App";
import router from "./router";
import store from "./store";
import "./assets/scss/viperpit.scss";

fontAwesomeIconLibrary.add(faCaretUp);
fontAwesomeIconLibrary.add(faCaretDown);
fontAwesomeIconLibrary.add(faCaretLeft);
fontAwesomeIconLibrary.add(faCaretRight);

Vue.component("font-awesome-icon", FontAwesomeIcon);

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
