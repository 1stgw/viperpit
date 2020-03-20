<template>
  <switch-group
    id="AUX: STATION SELECTOR Switch"
    description="AUX: STATION SELECTOR Switch - T/R"
    label="STATION SELECTOR"
    type="switch"
  >
    <control
      id="auxStationSelectorSwitchTR"
      description="AUX: STATION SELECTOR Switch - T/R"
      label="T/R"
      type="switch"
      role="none"
    />
    <control
      id="auxStationSelectorSwitchAATr"
      description="AUX: STATION SELECTOR Switch - A/A TR"
      label="A/A TR"
      type="switch"
      role="none"
    />
  </switch-group>
</template>

<script>
import Control from "@/components/controls/Control";
import SwitchGroup from "@/components/controls/SwitchGroup";

export default {
  name: "AuxStationSelectorSwitch",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
