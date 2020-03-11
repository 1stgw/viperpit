<template>
  <switch-group
    id="HUD: Scales Switch"
    description="HUD: Scales Switch - VV/VAH"
    label="Scales"
    type="switch"
  >
    <control
      id="hudscalesswitchvvvah"
      description="HUD: Scales Switch - VV/VAH"
      label="VV/VAH"
      type="switch"
      role="none"
    />
    <control
      id="hudscalesswitchvah"
      description="HUD: Scales Switch - VAH"
      label="VAH"
      type="switch"
      role="none"
    />
    <control
      id="hudscalesswitchoff"
      description="HUD: Scales Switch - OFF"
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
  name: "HudScalesSwitch",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
