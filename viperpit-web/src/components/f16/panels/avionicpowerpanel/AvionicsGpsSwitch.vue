<template>
  <switch-group
    id="AVIONICS: GPS Switch"
    description="AVIONICS: GPS Switch - ON"
    label="GPS"
    type="switch"
  >
    <control
      id="avionicsgpsswitchon"
      description="AVIONICS: GPS Switch - ON"
      label="ON"
      type="switch"
      role="on"
    />
    <control
      id="avionicsgpsswitchoff"
      description="AVIONICS: GPS Switch - OFF"
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
  name: "AvionicsGpsSwitch",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
