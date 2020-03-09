<template>
  <switch-group
    id="GEAR: LG Handle"
    description="GEAR: LG Handle - UP"
    label="LG"
    type="switch"
  >
    <control
      id="gearlghandleup"
      description="GEAR: LG Handle - UP"
      label="UP"
      type="switch"
      role="up"
    />
    <control
      id="gearlghandledn"
      description="GEAR: LG Handle - DN"
      label="DN"
      type="switch"
      role="down"
    />
  </switch-group>
</template>

<script>
import Control from "../../controls/Control";
import SwitchGroup from "../../controls/SwitchGroup";

export default {
  name: "GearLgHandle",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
