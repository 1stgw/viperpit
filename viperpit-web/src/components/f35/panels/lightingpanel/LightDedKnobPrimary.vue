<template>
  <button-group
    id="LIGHT: DED Knob (Primary)"
    description="LIGHT: DED Knob (Primary) - Step Up"
    label="DED Knob (Primary)"
    type="button"
  >
    <control
      id="lightdedknobprimarystepup"
      description="LIGHT: DED Knob (Primary) - Step Up"
      label="Step Up"
      type="button"
      role="up"
    />
    <control
      id="lightdedknobprimarystepdown"
      description="LIGHT: DED Knob (Primary) - Step Down"
      label="Step Down"
      type="button"
      role="down"
    />
  </button-group>
</template>

<script>
import Control from "../../controls/Control";
import ButtonGroup from "../../controls/ButtonGroup";

export default {
  name: "LightDedKnobPrimary",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
