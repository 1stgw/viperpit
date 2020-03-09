<template>
  <button-group
    id="Radio-Send Message Tanker"
    description="Radio-Send Message Tanker"
    type="button"
  >
    <control
      id="radiosendmessagetanker"
      description="Radio-Send Message Tanker"
      label="Send Message Tanker"
      type="button"
      role="none"
    />
  </button-group>
</template>

<script>
import Control from "../../controls/Control";
import ButtonGroup from "../../controls/ButtonGroup";

export default {
  name: "RadioSendMessageTanker",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
