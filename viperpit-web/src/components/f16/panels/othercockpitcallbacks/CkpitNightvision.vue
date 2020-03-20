<template>
  <button-group
    id="CKPIT: Nightvision"
    description="CKPIT: Nightvision - On"
    label="Nightvision"
    type="button"
  >
    <control
      id="ckpitNightvisionOn"
      description="CKPIT: Nightvision - On"
      label="On"
      type="button"
      role="on"
    />
    <control
      id="ckpitNightvisionOff"
      description="CKPIT: Nightvision - Off"
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
  name: "CkpitNightvision",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
