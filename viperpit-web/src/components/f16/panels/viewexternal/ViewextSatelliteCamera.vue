<template>
  <button-group
    id="VIEWEXT: Satellite Camera"
    description="VIEWEXT: Satellite Camera"
    type="button"
  >
    <control
      id="viewextsatellitecamera"
      description="VIEWEXT: Satellite Camera"
      label="Satellite Camera"
      type="button"
      role="none"
    />
  </button-group>
</template>

<script>
import Control from "@/components/controls/Control";
import ButtonGroup from "@/components/controls/ButtonGroup";

export default {
  name: "ViewextSatelliteCamera",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
