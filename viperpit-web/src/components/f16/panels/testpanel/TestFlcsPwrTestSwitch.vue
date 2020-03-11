<template>
  <button-group
    id="TEST: FLCS PWR TEST Switch"
    description="TEST: FLCS PWR TEST Switch - Hold"
    type="button"
  >
    <control
      id="testflcspwrtestswitchhold"
      description="TEST: FLCS PWR TEST Switch - Hold"
      label="FLCS PWR TEST"
      type="button"
      role="none"
    />
  </button-group>
</template>

<script>
import Control from "@/components/controls/Control";
import ButtonGroup from "@/components/controls/ButtonGroup";

export default {
  name: "TestFlcsPwrTestSwitch",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
