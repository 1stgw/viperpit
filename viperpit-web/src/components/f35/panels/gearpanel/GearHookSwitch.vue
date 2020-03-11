<template>
  <switch-group
    id="GEAR: HOOK Switch"
    description="GEAR: HOOK Switch - UP"
    label="HOOK"
    type="switch"
  >
    <control
      id="gearhookswitchup"
      description="GEAR: HOOK Switch - UP"
      label="UP"
      type="switch"
      role="up"
    />
    <control
      id="gearhookswitchdn"
      description="GEAR: HOOK Switch - DN"
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
  name: "GearHookSwitch",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
