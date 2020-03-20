<template>
  <button-group
    id="Radio-Send Message Tanker"
    description="Radio-Send Message Tanker"
    type="button"
  >
    <control
      id="radioSendMessageTanker"
      description="Radio-Send Message Tanker"
      label="Send Message Tanker"
      type="button"
      role="none"
    />
  </button-group>
</template>

<script>
import Control from "@/components/controls/Control";
import ButtonGroup from "@/components/controls/ButtonGroup";

export default {
  name: "RadioSendMessageTanker",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
