<template>
  <div class="container-fluid">
    <div v-if="isConnected">
      <nav class="nav justify-content-center">
        <router-link
          class="nav-link"
          active-class="active"
          to="/cockpits/f35/consoles/cmds"
          >Cmds</router-link
        >
        <router-link
          class="nav-link"
          active-class="active"
          to="/cockpits/f35/consoles/comms"
          >Comms</router-link
        >
        <router-link
          class="nav-link"
          active-class="active"
          to="/cockpits/f35/consoles/flight"
          >Flight</router-link
        >
        <router-link
          class="nav-link"
          active-class="active"
          to="/cockpits/f35/consoles/fuel"
          >Fuel</router-link
        >
        <router-link
          class="nav-link"
          active-class="active"
          to="/cockpits/f35/consoles/test"
          >Test</router-link
        >
        <router-link
          class="nav-link"
          active-class="active"
          to="/cockpits/f35/consoles/lights"
          >Lights</router-link
        >
        <router-link
          class="nav-link"
          active-class="active"
          to="/cockpits/f35/consoles/sensors"
          >Sensors</router-link
        >
        <router-link
          class="nav-link"
          active-class="active"
          to="/cockpits/f35/consoles/navi"
          >Navi</router-link
        >
        <router-link
          class="nav-link"
          active-class="active"
          to="/cockpits/f35/consoles/avionics"
          >Avionics</router-link
        >
        <router-link
          class="nav-link"
          active-class="active"
          to="/cockpits/f35/consoles/wpn"
          >Wpn</router-link
        >
        <router-link
          class="nav-link"
          active-class="active"
          to="/cockpits/f35/consoles/emer"
          >Emer</router-link
        >
        <router-link
          class="nav-link"
          active-class="active"
          to="/cockpits/f35/consoles/misc"
          >Misc</router-link
        >
        <router-link
          class="nav-link"
          active-class="active"
          to="/cockpits/f35/consoles/views"
          >Views</router-link
        >
      </nav>
      <router-view></router-view>
    </div>
    <div v-else>
      <div class="alert alert-warning" role="alert">
        <p>
          <span
            class="glyphicon glyphicon-warning-sign"
            aria-hidden="true"
          ></span>
          No Joy...
        </p>
        <p>Currently there is nothing Airborne.</p>
        <p>Please connect an Agent to the server...</p>
      </div>
    </div>
  </div>
</template>

<script>
import { mapGetters } from "vuex";

export default {
  name: "F35",
  computed: {
    ...mapGetters(["isConnected"])
  }
};
</script>
