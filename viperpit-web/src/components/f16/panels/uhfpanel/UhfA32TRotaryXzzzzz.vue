<template>
  <button-group
    id="UHF: A-3-2-T Rotary X__.___"
    description="UHF: A-3-2-T Rotary X__.___ - Step Up"
    label="A-3-2-T Rotary X__.___"
    type="button"
  >
    <control
      id="uhfa32trotaryxstepup"
      description="UHF: A-3-2-T Rotary X__.___ - Step Up"
      label="Step Up"
      type="button"
      role="up"
    />
    <control
      id="uhfa32trotaryxstepdown"
      description="UHF: A-3-2-T Rotary X__.___ - Step Down"
      label="Step Down"
      type="button"
      role="down"
    />
  </button-group>
</template>

<script>
import Control from "@/components/controls/Control";
import ButtonGroup from "@/components/controls/ButtonGroup";

export default {
  name: "UhfA32TRotaryXzzzzz",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
