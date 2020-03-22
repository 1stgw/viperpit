<template>
  <div class="container-fluid">
    <div class="row">
      <div class="col-sm-6">
        <other-cockpit-callbacks />
      </div>
      <div class="col-sm-6">
        <simulation-hardware />
      </div>
    </div>
  </div>
</template>

<script>
import OtherCockpitCallbacks from "@/components/f16/panels/OtherCockpitCallbacks";
import SimulationHardware from "@/components/f16/panels/SimulationHardware";

export default {
  name: "Miscellaneous",
  components: {
    OtherCockpitCallbacks,
    SimulationHardware
  }
};
</script>
