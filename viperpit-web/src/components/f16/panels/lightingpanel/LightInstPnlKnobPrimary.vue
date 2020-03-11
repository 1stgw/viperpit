<template>
  <button-group
    id="LIGHT: INST PNL Knob (Primary)"
    description="LIGHT: INST PNL Knob (Primary) - Step Up"
    label="INST PNL Knob (Primary)"
    type="button"
  >
    <control
      id="lightinstpnlknobprimarystepup"
      description="LIGHT: INST PNL Knob (Primary) - Step Up"
      label="Step Up"
      type="button"
      role="up"
    />
    <control
      id="lightinstpnlknobprimarystepdown"
      description="LIGHT: INST PNL Knob (Primary) - Step Down"
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
  name: "LightInstPnlKnobPrimary",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
