<template>
  <button-group
    id="SEAT: EJECT Handle"
    description="SEAT: EJECT Handle - Hold For Eject"
    type="button"
  >
    <control
      id="seatejecthandleholdforeject"
      description="SEAT: EJECT Handle - Hold For Eject"
      label="EJECT"
      type="button"
      role="none"
    />
  </button-group>
</template>

<script>
import Control from "@/components/controls/Control";
import ButtonGroup from "@/components/controls/ButtonGroup";

export default {
  name: "SeatEjectHandle",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
