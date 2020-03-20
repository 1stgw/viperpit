<template>
  <switch-group
    id="AVIONICS: MFD Switch"
    description="AVIONICS: MFD Switch - ON"
    label="MFD"
    type="switch"
  >
    <control
      id="avionicsMfdSwitchOn"
      description="AVIONICS: MFD Switch - ON"
      label="ON"
      type="switch"
      role="on"
    />
    <control
      id="avionicsMfdSwitchOff"
      description="AVIONICS: MFD Switch - OFF"
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
  name: "AvionicsMfdSwitch",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
