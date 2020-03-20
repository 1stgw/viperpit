<template>
  <switch-group
    id="GEAR: LG Handle"
    description="GEAR: LG Handle - UP"
    label="LG"
    type="switch"
  >
    <control
      id="gearLgHandleUp"
      description="GEAR: LG Handle - UP"
      label="UP"
      type="switch"
      role="up"
    />
    <control
      id="gearLgHandleDn"
      description="GEAR: LG Handle - DN"
      label="DN"
      type="switch"
      role="down"
    />
  </switch-group>
</template>

<script>
import Control from "@/components/controls/Control";
import SwitchGroup from "@/components/controls/SwitchGroup";

export default {
  name: "GearLgHandle",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
