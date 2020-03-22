<template>
  <div class="container-fluid">
    <div class="row">
      <div class="col-sm-6">
        <alt-gear-control />
      </div>
      <div class="col-sm-6">
        <twa-panel />
      </div>
    </div>
    <div class="row">
      <div class="col-sm-6">
        <hmcs-panel />
      </div>
      <div class="col-sm-6">
        <cmds-panel />
      </div>
    </div>
    <div class="row">
      <div class="col-sm-12">
        <gear-panel />
      </div>
    </div>
  </div>
</template>

<script>
import AltGearControl from "@/components/f35/panels/AltGearControl";
import TwaPanel from "@/components/f35/panels/TwaPanel";
import HmcsPanel from "@/components/f35/panels/HmcsPanel";
import CmdsPanel from "@/components/f35/panels/CmdsPanel";
import GearPanel from "@/components/f35/panels/GearPanel";

export default {
  name: "LeftAuxConsole",
  components: {
    AltGearControl,
    TwaPanel,
    HmcsPanel,
    CmdsPanel,
    GearPanel
  }
};
</script>
