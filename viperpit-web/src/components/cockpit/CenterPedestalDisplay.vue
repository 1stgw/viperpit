<template>
  <img :src="getLatestCenterPedestalDisplayImage" />
</template>

<script lang="ts">
import Vue from "vue";
import { mapGetters } from "vuex";

export default Vue.extend({
  // eslint-disable-next-line vue/multi-word-component-names
  name: "CenterPedestalDisplay",
  components: {},
  props: {
    cockpitId: {
      type: String,
      default: null
    },
    consoleId: {
      type: String,
      required: false,
      default: null
    },
    panelId: {
      type: String,
      required: false,
      default: null
    }
  },
  data: function () {
    return {
      selectedConsoleId: this.consoleId
    };
  },
  computed: {
    ...mapGetters(["getLatestCenterPedestalDisplayImage"])
  }
});
</script>
