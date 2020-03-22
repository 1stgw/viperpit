<template>
  <div class="card card-default">
    <div class="card-heading">MAIN INSTRUMENT</div>
    <div class="card-body">
      <div class="row">
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="MAIN: HSI HDG Knob"
              description="MAIN: HSI HDG Knob - Increase (5°)"
              label="HSI HDG"
              type="button"
            >
              <control
                id="mainHsiHdgKnobIncrease5"
                description="MAIN: HSI HDG Knob - Increase (5°)"
                label="Increase (5°)"
                type="button"
                role="none"
              />
              <control
                id="mainHsiHdgKnobDecrease5"
                description="MAIN: HSI HDG Knob - Decrease (5°)"
                label="Decrease (5°)"
                type="button"
                role="none"
              />
              <control
                id="mainHsiHdgKnobIncrease1"
                description="MAIN: HSI HDG Knob - Increase (1°)"
                label="Increase (1°)"
                type="button"
                role="none"
              />
              <control
                id="mainHsiHdgKnobDecrease1"
                description="MAIN: HSI HDG Knob - Decrease (1°)"
                label="Decrease (1°)"
                type="button"
                role="none"
              />
            </button-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="MAIN: HSI CRS Knob"
              description="MAIN: HSI CRS Knob - Increase (5°)"
              label="HSI CRS"
              type="button"
            >
              <control
                id="mainHsiCrsKnobIncrease5"
                description="MAIN: HSI CRS Knob - Increase (5°)"
                label="Increase (5°)"
                type="button"
                role="none"
              />
              <control
                id="mainHsiCrsKnobDecrease5"
                description="MAIN: HSI CRS Knob - Decrease (5°)"
                label="Decrease (5°)"
                type="button"
                role="none"
              />
              <control
                id="mainHsiCrsKnobIncrease1"
                description="MAIN: HSI CRS Knob - Increase (1°)"
                label="Increase (1°)"
                type="button"
                role="none"
              />
              <control
                id="mainHsiCrsKnobDecrease1"
                description="MAIN: HSI CRS Knob - Decrease (1°)"
                label="Decrease (1°)"
                type="button"
                role="none"
              />
            </button-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="MAIN: Altimeter Pressure Knob"
              description="MAIN: Altimeter Pressure Knob - Incr. (5°)"
              label="Altimeter Pressure"
              type="button"
            >
              <control
                id="mainAltimeterPressureKnobIncr5"
                description="MAIN: Altimeter Pressure Knob - Incr. (5°)"
                label="Incr. (5°)"
                type="button"
                role="none"
              />
              <control
                id="mainAltimeterPressureKnobDecr5"
                description="MAIN: Altimeter Pressure Knob - Decr. (5°)"
                label="Decr. (5°)"
                type="button"
                role="none"
              />
              <control
                id="mainAltimeterPressureKnobIncr1"
                description="MAIN: Altimeter Pressure Knob - Incr. (1°)"
                label="Incr. (1°)"
                type="button"
                role="none"
              />
              <control
                id="mainAltimeterPressureKnobDecr1"
                description="MAIN: Altimeter Pressure Knob - Decr. (1°)"
                label="Decr. (1°)"
                type="button"
                role="none"
              />
            </button-group>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Control from "@/components/controls/Control";
import ButtonGroup from "@/components/controls/ButtonGroup";

export default {
  name: "MainInstrument",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
