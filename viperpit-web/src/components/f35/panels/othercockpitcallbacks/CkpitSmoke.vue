<template>
  <button-group
    id="CKPIT: Smoke"
    description="CKPIT: Smoke - On"
    label="Smoke"
    type="button"
  >
    <control
      id="ckpitSmokeOn"
      description="CKPIT: Smoke - On"
      label="On"
      type="button"
      role="on"
    />
    <control
      id="ckpitSmokeOff"
      description="CKPIT: Smoke - Off"
      label="Off"
      type="button"
      role="off"
    />
  </button-group>
</template>

<script>
import Control from "@/components/controls/Control";
import ButtonGroup from "@/components/controls/ButtonGroup";

export default {
  name: "CkpitSmoke",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
