<template>
  <div class="container-fluid">
    <div class="row">
      <div class="col-sm-6">
        <ext-lighting-panel />
      </div>
      <div class="col-sm-6">
        <lighting-panel />
      </div>
    </div>
  </div>
</template>

<script>
import ExtLightingPanel from "../panels/extlightingpanel/ExtLightingPanel";
import LightingPanel from "../panels/lightingpanel/LightingPanel";

export default {
  name: "Lights",
  components: {
    ExtLightingPanel,
    LightingPanel
  }
};
</script>
