<template>
  <switch-group
    id="ECM: OPR Switch"
    description="ECM: OPR Switch - OPR"
    label="OPR"
    type="switch"
  >
    <control
      id="ecmOprSwitchOpr"
      description="ECM: OPR Switch - OPR"
      label="OPR"
      type="switch"
      role="on"
    />
    <control
      id="ecmOprSwitchOff"
      description="ECM: OPR Switch - OFF"
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
  name: "EcmOprSwitch",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
