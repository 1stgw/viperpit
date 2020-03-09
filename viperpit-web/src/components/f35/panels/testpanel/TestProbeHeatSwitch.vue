<template>
  <switch-group
    id="TEST: PROBE HEAT Switch"
    description="TEST: PROBE HEAT Switch - ON"
    label="PROBE HEAT"
    type="switch"
  >
    <control
      id="testprobeheatswitchon"
      description="TEST: PROBE HEAT Switch - ON"
      label="ON"
      type="switch"
      role="on"
    />
    <control
      id="testprobeheatswitchoff"
      description="TEST: PROBE HEAT Switch - OFF"
      label="OFF"
      type="switch"
      role="off"
    />
    <control
      id="testprobeheatswitchtest"
      description="TEST: PROBE HEAT Switch - TEST"
      label="TEST"
      type="switch"
      role="none"
    />
  </switch-group>
</template>

<script>
import Control from "../../controls/Control";
import SwitchGroup from "../../controls/SwitchGroup";

export default {
  name: "TestProbeHeatSwitch",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
