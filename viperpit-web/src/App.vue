<template>
  <div id="app">
    <div class="row justify-content-end">
      <div>
        <small v-if="isConnected">(Connected to {{ getAgent }})</small>
      </div>
      <div>
        <nav class="nav">
          <router-link class="nav-link" active-class="active" to="/maps"
            >Maps</router-link
          >
          <router-link class="nav-link" active-class="active" to="/cockpits/f16"
            >F-16</router-link
          >
          <router-link class="nav-link" active-class="active" to="/cockpits/f35"
            >F-35</router-link
          >
        </nav>
      </div>
    </div>
    <router-view></router-view>
  </div>
</template>

<script>
import { mapActions, mapGetters } from "vuex";

export default {
  name: "App",
  computed: {
    ...mapGetters(["getAgent", "isConnected"])
  },
  created() {
    this.initialize();
  },
  methods: {
    ...mapActions(["initialize", "loadState"])
  }
};
</script>

<style>
#app {
  text-align: center;
}
</style>
