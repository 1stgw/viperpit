<template>
  <button-group
    id="AUX: CHANNEL"
    description="AUX: CHANNEL - Cycle Up Left Digit"
    label="CHANNEL"
    type="button"
  >
    <control
      id="auxChannelCycleUpLeftDigit"
      description="AUX: CHANNEL - Cycle Up Left Digit"
      label="Cycle Up Left Digit"
      type="button"
      role="none"
    />
    <control
      id="auxChannelCycleDownLeftDigit"
      description="AUX: CHANNEL - Cycle Down Left Digit"
      label="Cycle Down Left Digit"
      type="button"
      role="none"
    />
    <control
      id="auxChannelCycleUpCenterDigit"
      description="AUX: CHANNEL - Cycle Up Center Digit"
      label="Cycle Up Center Digit"
      type="button"
      role="none"
    />
    <control
      id="auxChannelCycleDownCenterDig"
      description="AUX: CHANNEL - Cycle Down Center Dig."
      label="Cycle Down Center Dig."
      type="button"
      role="none"
    />
    <control
      id="auxChannelCycleUpRightDigit"
      description="AUX: CHANNEL - Cycle Up Right Digit"
      label="Cycle Up Right Digit"
      type="button"
      role="none"
    />
    <control
      id="auxChannelCycleDownRightDigit"
      description="AUX: CHANNEL - Cycle Down Right Digit"
      label="Cycle Down Right Digit"
      type="button"
      role="none"
    />
    <control
      id="auxChannelToggleBandX"
      description="AUX: CHANNEL - Toggle Band X"
      label="Toggle Band X"
      type="button"
      role="none"
    />
    <control
      id="auxChannelToggleBandY"
      description="AUX: CHANNEL - Toggle Band Y"
      label="Toggle Band Y"
      type="button"
      role="none"
    />
  </button-group>
</template>

<script>
import Control from "@/components/controls/Control";
import ButtonGroup from "@/components/controls/ButtonGroup";

export default {
  name: "AuxChannel",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
