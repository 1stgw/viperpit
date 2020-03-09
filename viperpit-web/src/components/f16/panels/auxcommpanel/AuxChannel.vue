<template>
  <button-group
    id="AUX: CHANNEL"
    description="AUX: CHANNEL - Cycle Up Left Digit"
    label="CHANNEL"
    type="button"
  >
    <control
      id="auxchannelcycleupleftdigit"
      description="AUX: CHANNEL - Cycle Up Left Digit"
      label="Cycle Up Left Digit"
      type="button"
      role="none"
    />
    <control
      id="auxchannelcycledownleftdigit"
      description="AUX: CHANNEL - Cycle Down Left Digit"
      label="Cycle Down Left Digit"
      type="button"
      role="none"
    />
    <control
      id="auxchannelcycleupcenterdigit"
      description="AUX: CHANNEL - Cycle Up Center Digit"
      label="Cycle Up Center Digit"
      type="button"
      role="none"
    />
    <control
      id="auxchannelcycledowncenterdig"
      description="AUX: CHANNEL - Cycle Down Center Dig."
      label="Cycle Down Center Dig."
      type="button"
      role="none"
    />
    <control
      id="auxchannelcycleuprightdigit"
      description="AUX: CHANNEL - Cycle Up Right Digit"
      label="Cycle Up Right Digit"
      type="button"
      role="none"
    />
    <control
      id="auxchannelcycledownrightdigit"
      description="AUX: CHANNEL - Cycle Down Right Digit"
      label="Cycle Down Right Digit"
      type="button"
      role="none"
    />
    <control
      id="auxchanneltogglebandx"
      description="AUX: CHANNEL - Toggle Band X"
      label="Toggle Band X"
      type="button"
      role="none"
    />
    <control
      id="auxchanneltogglebandy"
      description="AUX: CHANNEL - Toggle Band Y"
      label="Toggle Band Y"
      type="button"
      role="none"
    />
  </button-group>
</template>

<script>
import Control from "../../controls/Control";
import ButtonGroup from "../../controls/ButtonGroup";

export default {
  name: "AuxChannel",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
