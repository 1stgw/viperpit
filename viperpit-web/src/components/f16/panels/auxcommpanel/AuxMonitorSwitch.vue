<template>
  <switch-group
    id="AUX: MONITOR Switch"
    description="AUX: MONITOR Switch - AUDIO"
    label="MONITOR"
    type="switch"
  >
    <control
      id="auxMonitorSwitchAudio"
      description="AUX: MONITOR Switch - AUDIO"
      label="AUDIO"
      type="switch"
      role="none"
    />
    <control
      id="auxMonitorSwitchOut"
      description="AUX: MONITOR Switch - OUT"
      label="OUT"
      type="switch"
      role="off"
    />
  </switch-group>
</template>

<script>
import Control from "@/components/controls/Control";
import SwitchGroup from "@/components/controls/SwitchGroup";

export default {
  name: "AuxMonitorSwitch",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
