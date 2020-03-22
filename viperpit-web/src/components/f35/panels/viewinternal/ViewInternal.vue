<template>
  <div class="card card-default">
    <div class="card-heading">VIEW INTERNAL</div>
    <div class="card-body">
      <div class="row">
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="VIEWINT: Padlock"
              description="VIEWINT: Padlock"
              type="button"
            >
              <control
                id="viewintPadlock"
                description="VIEWINT: Padlock"
                label="Padlock"
                type="button"
                role="none"
              />
            </button-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="VIEWINT: HUD Only"
              description="VIEWINT: HUD Only"
              type="button"
            >
              <control
                id="viewintHudOnly"
                description="VIEWINT: HUD Only"
                label="HUD Only"
                type="button"
                role="none"
              />
            </button-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="VIEWINT: Snap (3D) Cockpit"
              description="VIEWINT: Snap (3D) Cockpit"
              type="button"
            >
              <control
                id="viewintSnap3dCockpit"
                description="VIEWINT: Snap (3D) Cockpit"
                label="Snap (3D) Cockpit"
                type="button"
                role="none"
              />
            </button-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="VIEWINT: Pan (3D) Cockpit"
              description="VIEWINT: Pan (3D) Cockpit"
              type="button"
            >
              <control
                id="viewintPan3dCockpit"
                description="VIEWINT: Pan (3D) Cockpit"
                label="Pan (3D) Cockpit"
                type="button"
                role="none"
              />
            </button-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="VIEWINT: Glance Forward"
              description="VIEWINT: Glance Forward"
              type="button"
            >
              <control
                id="viewintGlanceForward"
                description="VIEWINT: Glance Forward"
                label="Glance Forward"
                type="button"
                role="none"
              />
            </button-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="VIEWINT: Glance Backward"
              description="VIEWINT: Glance Backward"
              type="button"
            >
              <control
                id="viewintGlanceBackward"
                description="VIEWINT: Glance Backward"
                label="Glance Backward"
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
  name: "ViewInternal",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
