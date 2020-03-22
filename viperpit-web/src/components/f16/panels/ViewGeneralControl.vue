<template>
  <div class="card card-default">
    <div class="card-heading">VIEW GENERAL CONTROL</div>
    <div class="card-body">
      <div class="row">
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="VIEWGEN: Rotate View Up"
              description="VIEWGEN: Rotate View Up"
              type="button"
            >
              <control
                id="viewgenRotateViewUp"
                description="VIEWGEN: Rotate View Up"
                label="Rotate View Up"
                type="button"
                role="up"
              />
            </button-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="VIEWGEN: Rotate View Down"
              description="VIEWGEN: Rotate View Down"
              type="button"
            >
              <control
                id="viewgenRotateViewDown"
                description="VIEWGEN: Rotate View Down"
                label="Rotate View Down"
                type="button"
                role="down"
              />
            </button-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="VIEWGEN: Rotate View Left"
              description="VIEWGEN: Rotate View Left"
              type="button"
            >
              <control
                id="viewgenRotateViewLeft"
                description="VIEWGEN: Rotate View Left"
                label="Rotate View Left"
                type="button"
                role="left"
              />
            </button-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="VIEWGEN: Rotate View Right"
              description="VIEWGEN: Rotate View Right"
              type="button"
            >
              <control
                id="viewgenRotateViewRight"
                description="VIEWGEN: Rotate View Right"
                label="Rotate View Right"
                type="button"
                role="right"
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
  name: "ViewGeneralControl",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
