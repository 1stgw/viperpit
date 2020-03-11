<template>
  <button-group
    id="CKPIT: Nightvision"
    description="CKPIT: Nightvision - On"
    label="Nightvision"
    type="button"
  >
    <control
      id="ckpitnightvisionon"
      description="CKPIT: Nightvision - On"
      label="On"
      type="button"
      role="on"
    />
    <control
      id="ckpitnightvisionoff"
      description="CKPIT: Nightvision - Off"
      label="Off"
      type="button"
      role="off"
    />
  </button-group>
</template>

<script>
import Control from "../../controls/Control";
import ButtonGroup from "../../controls/ButtonGroup";

export default {
  name: "CkpitNightvision",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
