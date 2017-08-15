import Vue from 'vue'
import Vuex from 'vuex'
import createLogger from 'vuex/dist/logger'
import configuration from './configuration'
import states from './states'

Vue.use(Vuex)
Vue.config.debug = true

const debug = process.env.NODE_ENV !== 'production'

export default new Vuex.Store({
  modules: {
    configuration,
    states
  },
  strict: debug,
  plugins: debug ? [createLogger()] : []
})
