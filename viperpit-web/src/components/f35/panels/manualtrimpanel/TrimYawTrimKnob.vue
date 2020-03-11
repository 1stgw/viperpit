<template>
  <button-group
    id="TRIM: YAW TRIM Knob"
    description="TRIM: YAW TRIM Knob - L"
    label="YAW TRIM"
    type="button"
  >
    <control
      id="trimyawtrimknobl"
      description="TRIM: YAW TRIM Knob - L"
      label="L"
      type="button"
      role="left"
    />
    <control
      id="trimyawtrimknobr"
      description="TRIM: YAW TRIM Knob - R"
      label="R"
      type="button"
      role="right"
    />
  </button-group>
</template>

<script>
import Control from "@/components/controls/Control";
import ButtonGroup from "@/components/controls/ButtonGroup";

export default {
  name: "TrimYawTrimKnob",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
