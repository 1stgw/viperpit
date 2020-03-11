<template>
  <switch-group
    id="AUX: REPLY Switch"
    description="AUX: REPLY Switch - B"
    label="REPLY"
    type="switch"
  >
    <control
      id="auxreplyswitchb"
      description="AUX: REPLY Switch - B"
      label="B"
      type="switch"
      role="none"
    />
    <control
      id="auxreplyswitcha"
      description="AUX: REPLY Switch - A"
      label="A"
      type="switch"
      role="none"
    />
    <control
      id="auxreplyswitchout"
      description="AUX: REPLY Switch - OUT"
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
  name: "AuxReplySwitch",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
