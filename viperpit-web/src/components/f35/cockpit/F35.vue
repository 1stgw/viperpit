<template>
  <div class="container-fluid">
    <div v-if="isConnected">
      <nav class="nav justify-content-center">
        <router-link
          class="nav-link"
          active-class="active"
          to="/cockpits/f35/consoles/leftconsole"
          >Left Console</router-link
        >
        <router-link
          class="nav-link"
          active-class="active"
          to="/cockpits/f35/consoles/leftauxconsole"
          >Left Aux Console</router-link
        >
        <router-link
          class="nav-link"
          active-class="active"
          to="/cockpits/f35/consoles/centerconsole"
          >Center Console</router-link
        >
        <router-link
          class="nav-link"
          active-class="active"
          to="/cockpits/f35/consoles/rightconsole"
          >Right Console</router-link
        >
        <router-link
          class="nav-link"
          active-class="active"
          to="/cockpits/f35/consoles/miscellaneous"
          >Miscellaneous</router-link
        >
        <router-link
          class="nav-link"
          active-class="active"
          to="/cockpits/f35/consoles/views"
          >Views</router-link
        >
        <router-link
          class="nav-link"
          active-class="active"
          to="/cockpits/f35/consoles/radiocomms"
          >Radio Comms</router-link
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
