<template>
  <switch-group
    id="GEAR: STORES CONFIG Switch"
    description="GEAR: STORES CONFIG Switch - CAT I"
    label="STORES CONFIG"
    type="switch"
  >
    <control
      id="gearStoresConfigSwitchCatI"
      description="GEAR: STORES CONFIG Switch - CAT I"
      label="CAT I"
      type="switch"
      role="none"
    />
    <control
      id="gearStoresConfigSwitchCatIii"
      description="GEAR: STORES CONFIG Switch - CAT III"
      label="CAT III"
      type="switch"
      role="none"
    />
  </switch-group>
</template>

<script>
import Control from "@/components/controls/Control";
import SwitchGroup from "@/components/controls/SwitchGroup";

export default {
  name: "GearStoresConfigSwitch",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
