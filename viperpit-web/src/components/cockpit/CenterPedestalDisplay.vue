<template>
  <img v-if="getLatestCenterPedestalDisplayImage" :src="getLatestCenterPedestalDisplayImage" />
</template>

<style>
html {
  overflow: auto;
}
</style>

<script lang="ts">
import Vue from "vue";
import { mapGetters } from "vuex";

export default Vue.extend({
  name: "CenterPedestalDisplay",
  computed: {
    ...mapGetters(["getLatestCenterPedestalDisplayImage"])
  }
});
</script>
