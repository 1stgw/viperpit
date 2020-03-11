<template>
  <button-group
    id="MAIN: HSI HDG Knob"
    description="MAIN: HSI HDG Knob - Increase (5°)"
    label="HSI HDG"
    type="button"
  >
    <control
      id="mainhsihdgknobincrease5"
      description="MAIN: HSI HDG Knob - Increase (5°)"
      label="Increase (5°)"
      type="button"
      role="none"
    />
    <control
      id="mainhsihdgknobdecrease5"
      description="MAIN: HSI HDG Knob - Decrease (5°)"
      label="Decrease (5°)"
      type="button"
      role="none"
    />
    <control
      id="mainhsihdgknobincrease1"
      description="MAIN: HSI HDG Knob - Increase (1°)"
      label="Increase (1°)"
      type="button"
      role="none"
    />
    <control
      id="mainhsihdgknobdecrease1"
      description="MAIN: HSI HDG Knob - Decrease (1°)"
      label="Decrease (1°)"
      type="button"
      role="none"
    />
  </button-group>
</template>

<script>
import Control from "../../controls/Control";
import ButtonGroup from "../../controls/ButtonGroup";

export default {
  name: "MainHsiHdgKnob",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
