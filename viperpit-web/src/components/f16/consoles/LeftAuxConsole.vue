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
import AltGearControl from "@/components/f16/panels/AltGearControl";
import TwaPanel from "@/components/f16/panels/TwaPanel";
import HmcsPanel from "@/components/f16/panels/HmcsPanel";
import CmdsPanel from "@/components/f16/panels/CmdsPanel";
import GearPanel from "@/components/f16/panels/GearPanel";

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
