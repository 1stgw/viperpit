<template>
  <div class="container-fluid">
    <div v-if="isConnected">
      <div class="row">
        <router-link to="/cockpits/f35/consoles/cmds">Cmds</router-link> |
        <router-link to="/cockpits/f35/consoles/comms">Comms</router-link> |
        <router-link to="/cockpits/f35/consoles/flight">Flight</router-link> |
        <router-link to="/cockpits/f35/consoles/fuel">Fuel</router-link> |
        <router-link to="/cockpits/f35/consoles/test">Test</router-link> |
        <router-link to="/cockpits/f35/consoles/lights">Lights</router-link> |
        <router-link to="/cockpits/f35/consoles/sensors">Sensors</router-link> |
        <router-link to="/cockpits/f35/consoles/navi">Navi</router-link> |
        <router-link to="/cockpits/f35/consoles/avionics">Avionics</router-link>
        <router-link to="/cockpits/f35/consoles/wpn">Wpn</router-link> |
        <router-link to="/cockpits/f35/consoles/emer">Emer</router-link> |
        <router-link to="/cockpits/f35/consoles/misc">Misc</router-link> |
        <router-link to="/cockpits/f35/consoles/views">Views</router-link>
      </div>
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
import Cmds from "../consoles/Cmds";
import Comms from "../consoles/Comms";
import Flight from "../consoles/Flight";
import Fuel from "../consoles/Fuel";
import Test from "../consoles/Test";
import Lights from "../consoles/Lights";
import Sensors from "../consoles/Sensors";
import Navi from "../consoles/Navi";
import Avionics from "../consoles/Avionics";
import Wpn from "../consoles/Wpn";
import Emer from "../consoles/Emer";
import Misc from "../consoles/Misc";
import Views from "../consoles/Views";

export default {
  name: "F35",
  components: {
    Cmds,
    Comms,
    Flight,
    Fuel,
    Test,
    Lights,
    Sensors,
    Navi,
    Avionics,
    Wpn,
    Emer,
    Misc,
    Views
  },
  computed: {
    ...mapGetters(["isConnected"])
  }
};
</script>
