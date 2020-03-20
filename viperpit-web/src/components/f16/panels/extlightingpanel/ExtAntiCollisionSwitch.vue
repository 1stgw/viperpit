<template>
  <switch-group
    id="EXT: ANTI COLLISION Switch"
    description="EXT: ANTI COLLISION Switch - ON"
    label="ANTI COLLISION"
    type="switch"
  >
    <control
      id="extAntiCollisionSwitchOn"
      description="EXT: ANTI COLLISION Switch - ON"
      label="ON"
      type="switch"
      role="on"
    />
    <control
      id="extAntiCollisionSwitchOff"
      description="EXT: ANTI COLLISION Switch - OFF"
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
  name: "ExtAntiCollisionSwitch",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
