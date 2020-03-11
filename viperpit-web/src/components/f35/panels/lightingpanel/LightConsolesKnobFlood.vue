<template>
  <button-group
    id="LIGHT: CONSOLES Knob (Flood)"
    description="LIGHT: CONSOLES Knob (Flood) - Step Up"
    label="CONSOLES Knob (Flood)"
    type="button"
  >
    <control
      id="lightconsolesknobfloodstepup"
      description="LIGHT: CONSOLES Knob (Flood) - Step Up"
      label="Step Up"
      type="button"
      role="up"
    />
    <control
      id="lightconsolesknobfloodstepdown"
      description="LIGHT: CONSOLES Knob (Flood) - Step Down"
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
  name: "LightConsolesKnobFlood",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
