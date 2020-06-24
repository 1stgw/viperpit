<template>
  <v-container>
    <div v-if="consoleId">
      <console :id="consoleId" />
    </div>
  </v-container>
</template>

<script>
import Console from "@/components/cockpit/Console";
import { mapGetters } from "vuex";

export default {
  name: "Cockpit",
  components: {
    Console
  },
  props: {
    cockpitId: {
      type: String,
      default: null
    },
    consoleId: {
      type: String,
      default: null
    }
  },
  computed: {
    ...mapGetters(["getConfiguration", "isConnected"])
  }
};
</script>
