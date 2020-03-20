<template>
  <switch-group
    id="TEST: PROBE HEAT Switch"
    description="TEST: PROBE HEAT Switch - ON"
    label="PROBE HEAT"
    type="switch"
  >
    <control
      id="testProbeHeatSwitchOn"
      description="TEST: PROBE HEAT Switch - ON"
      label="ON"
      type="switch"
      role="on"
    />
    <control
      id="testProbeHeatSwitchOff"
      description="TEST: PROBE HEAT Switch - OFF"
      label="OFF"
      type="switch"
      role="off"
    />
    <control
      id="testProbeHeatSwitchTest"
      description="TEST: PROBE HEAT Switch - TEST"
      label="TEST"
      type="switch"
      role="none"
    />
  </switch-group>
</template>

<script>
import Control from "@/components/controls/Control";
import SwitchGroup from "@/components/controls/SwitchGroup";

export default {
  name: "TestProbeHeatSwitch",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
