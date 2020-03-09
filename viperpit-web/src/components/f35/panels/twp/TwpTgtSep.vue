<template>
  <button-group
    id="TWP: TGT SEP"
    description="TWP: TGT SEP - Push"
    type="button"
  >
    <control
      id="twptgtseppush"
      description="TWP: TGT SEP - Push"
      label="TGT SEP"
      type="button"
      role="none"
    />
  </button-group>
</template>

<script>
import Control from "../../controls/Control";
import ButtonGroup from "../../controls/ButtonGroup";

export default {
  name: "TwpTgtSep",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
