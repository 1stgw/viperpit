<template>
  <switch-group
    id="AUX: MONITOR Switch"
    description="AUX: MONITOR Switch - AUDIO"
    label="MONITOR"
    type="switch"
  >
    <control
      id="auxmonitorswitchaudio"
      description="AUX: MONITOR Switch - AUDIO"
      label="AUDIO"
      type="switch"
      role="none"
    />
    <control
      id="auxmonitorswitchout"
      description="AUX: MONITOR Switch - OUT"
      label="OUT"
      type="switch"
      role="off"
    />
  </switch-group>
</template>

<script>
import Control from "../../controls/Control";
import SwitchGroup from "../../controls/SwitchGroup";

export default {
  name: "AuxMonitorSwitch",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
