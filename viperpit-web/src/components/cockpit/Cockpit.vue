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
  computed: {
    ...mapGetters(["getConfiguration", "isConnected"])
  },
  props: {
    cockpitId: {
      type: String
    },
    consoleId: {
      type: String
    }
  }
};
</script>
