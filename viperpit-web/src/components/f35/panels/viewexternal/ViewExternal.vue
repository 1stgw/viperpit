<template>
  <div class="card card-default">
    <div class="card-heading">VIEW EXTERNAL</div>
    <div class="card-body">
      <div class="row">
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="VIEWEXT: Orbit Camera"
              description="VIEWEXT: Orbit Camera"
              type="button"
            >
              <control
                id="viewextOrbitCamera"
                description="VIEWEXT: Orbit Camera"
                label="Orbit Camera"
                type="button"
                role="none"
              />
            </button-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="VIEWEXT: Satellite Camera"
              description="VIEWEXT: Satellite Camera"
              type="button"
            >
              <control
                id="viewextSatelliteCamera"
                description="VIEWEXT: Satellite Camera"
                label="Satellite Camera"
                type="button"
                role="none"
              />
            </button-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="VIEWEXT: Flyby Camera"
              description="VIEWEXT: Flyby Camera"
              type="button"
            >
              <control
                id="viewextFlybyCamera"
                description="VIEWEXT: Flyby Camera"
                label="Flyby Camera"
                type="button"
                role="none"
              />
            </button-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="VIEWEXT: Chase Camera"
              description="VIEWEXT: Chase Camera"
              type="button"
            >
              <control
                id="viewextChaseCamera"
                description="VIEWEXT: Chase Camera"
                label="Chase Camera"
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
  name: "ViewExternal",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
