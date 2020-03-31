import Vue from "vue";
import Vuetify from "vuetify/lib";
import dark from "./theme";

Vue.use(Vuetify);

export default new Vuetify({
  theme: {
    dark: true,
    themes: {
      dark
    }
  }
});
