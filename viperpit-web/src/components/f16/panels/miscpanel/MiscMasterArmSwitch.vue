<template>
  <switch-group
    id="MISC: MASTER ARM Switch"
    description="MISC: MASTER ARM Switch - ON"
    label="MASTER ARM"
    type="switch"
  >
    <control
      id="miscmasterarmswitchon"
      description="MISC: MASTER ARM Switch - ON"
      label="ON"
      type="switch"
      role="on"
    />
    <control
      id="miscmasterarmswitchoff"
      description="MISC: MASTER ARM Switch - OFF"
      label="OFF"
      type="switch"
      role="off"
    />
    <control
      id="miscmasterarmswitchsim"
      description="MISC: MASTER ARM Switch - SIM"
      label="SIM"
      type="switch"
      role="none"
    />
  </switch-group>
</template>

<script>
import Control from "../../controls/Control";
import SwitchGroup from "../../controls/SwitchGroup";

export default {
  name: "MiscMasterArmSwitch",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
