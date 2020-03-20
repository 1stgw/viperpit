<template>
  <switch-group
    id="HUD: DED Data Switch"
    description="HUD: DED Data Switch - DED"
    label="DED Data"
    type="switch"
  >
    <control
      id="hudDedDataSwitchDed"
      description="HUD: DED Data Switch - DED"
      label="DED"
      type="switch"
      role="none"
    />
    <control
      id="hudDedDataSwitchPfl"
      description="HUD: DED Data Switch - PFL"
      label="PFL"
      type="switch"
      role="none"
    />
    <control
      id="hudDedDataSwitchOff"
      description="HUD: DED Data Switch - OFF"
      label="OFF"
      type="switch"
      role="off"
    />
  </switch-group>
</template>

<script>
import Control from "@/components/controls/Control";
import SwitchGroup from "@/components/controls/SwitchGroup";

export default {
  name: "HudDedDataSwitch",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
