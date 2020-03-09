<template>
  <div class="container-fluid">
    <div v-if="isConnected">
      <div class="row">
        <router-link to="/cockpits/f16/consoles/leftconsole"
          >Left Console</router-link
        >
        |
        <router-link to="/cockpits/f16/consoles/leftauxconsole"
          >Left Aux Console</router-link
        >
        |
        <router-link to="/cockpits/f16/consoles/centerconsole"
          >Center Console</router-link
        >
        |
        <router-link to="/cockpits/f16/consoles/rightconsole"
          >Right Console</router-link
        >
        |
        <router-link to="/cockpits/f16/consoles/miscellaneous"
          >Miscellaneous</router-link
        >
        | <router-link to="/cockpits/f16/consoles/views">Views</router-link> |
        <router-link to="/cockpits/f16/consoles/radiocomms"
          >Radio Comms</router-link
        >
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
import LeftConsole from "../consoles/LeftConsole";
import LeftAuxConsole from "../consoles/LeftAuxConsole";
import CenterConsole from "../consoles/CenterConsole";
import RightConsole from "../consoles/RightConsole";
import Miscellaneous from "../consoles/Miscellaneous";
import Views from "../consoles/Views";
import RadioComms from "../consoles/RadioComms";

export default {
  name: "F16",
  components: {
    LeftConsole,
    LeftAuxConsole,
    CenterConsole,
    RightConsole,
    Miscellaneous,
    Views,
    RadioComms
  },
  computed: {
    ...mapGetters(["isConnected"])
  }
};
</script>
