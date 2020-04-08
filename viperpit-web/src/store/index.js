import Vue from "vue";
import Vuex from "vuex";
import states from "./states";
import stompPlugin from "./plugin";
import logger from "vuex/dist/logger";

const debug = process.env.NODE_ENV !== "production";

Vue.use(Vuex);
Vue.config.debug = debug;

export default new Vuex.Store({
  modules: {
    states
  },
  strict: true,
  plugins: debug ? [stompPlugin, logger()] : [stompPlugin]
});
