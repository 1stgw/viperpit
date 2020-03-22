<template>
  <div class="card card-default">
    <div class="card-heading">AUDIO 2 PANEL</div>
    <div class="card-body">
      <div class="row">
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="AUDIO2: INTERCOM Knob"
              description="AUDIO2: INTERCOM Knob - Volume Incr."
              label="INTERCOM"
              type="button"
            >
              <control
                id="audio2IntercomKnobVolumeIncr"
                description="AUDIO2: INTERCOM Knob - Volume Incr."
                label="Volume Incr."
                type="button"
                role="up"
              />
              <control
                id="audio2IntercomKnobVolumeDecr"
                description="AUDIO2: INTERCOM Knob - Volume Decr."
                label="Volume Decr."
                type="button"
                role="down"
              />
            </button-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <switch-group
              id="AUDIO2: ILS Knob"
              description="AUDIO2: ILS Knob - ON"
              label="ILS"
              type="switch"
            >
              <control
                id="audio2IlsKnobOn"
                description="AUDIO2: ILS Knob - ON"
                label="ON"
                type="switch"
                role="on"
              />
              <control
                id="audio2IlsKnobOff"
                description="AUDIO2: ILS Knob - OFF"
                label="OFF"
                type="switch"
                role="off"
              />
            </switch-group>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Control from "@/components/controls/Control";
import ButtonGroup from "@/components/controls/ButtonGroup";
import SwitchGroup from "@/components/controls/SwitchGroup";

export default {
  name: "Audio2Panel",
  components: {
    Control,
    ButtonGroup,
    SwitchGroup
  }
};
</script>
