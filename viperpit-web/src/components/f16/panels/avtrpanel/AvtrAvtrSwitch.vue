<template>
  <button-group
    id="AVTR: AVTR Switch"
    description="AVTR: AVTR Switch - Toggle ON / OFF"
    label="AVTR"
    type="button"
  >
    <control
      id="avtravtrswitchtoggleonoff"
      description="AVTR: AVTR Switch - Toggle ON / OFF"
      label="Toggle ON / OFF"
      type="button"
      role="off"
    />
    <control
      id="avtravtrswitchon"
      description="AVTR: AVTR Switch - ON"
      label="ON"
      type="button"
      role="on"
    />
    <control
      id="avtravtrswitchauto"
      description="AVTR: AVTR Switch - AUTO"
      label="AUTO"
      type="button"
      role="none"
    />
    <control
      id="avtravtrswitchoff"
      description="AVTR: AVTR Switch - OFF"
      label="OFF"
      type="button"
      role="off"
    />
  </button-group>
</template>

<script>
import Control from "@/components/controls/Control";
import ButtonGroup from "@/components/controls/ButtonGroup";

export default {
  name: "AvtrAvtrSwitch",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
