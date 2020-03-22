<template>
  <div class="card card-default">
    <div class="card-heading">LEFT SIDE WALL</div>
    <div class="card-body">
      <div class="row">
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="LEFT WALL: SLAP Switch (ECM-PGRM # 5)"
              description="LEFT WALL: SLAP Switch (ECM-PGRM # 5)"
              type="button"
            >
              <control
                id="leftWallSlapSwitchEcmPgrm5"
                description="LEFT WALL: SLAP Switch (ECM-PGRM # 5)"
                label="SLAP Switch (ECM-PGRM # 5)"
                type="button"
                role="none"
              />
            </button-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="LEFT WALL: CANOPY"
              description="LEFT WALL: CANOPY - Open"
              label="CANOPY"
              type="button"
            >
              <control
                id="leftWallCanopyOpen"
                description="LEFT WALL: CANOPY - Open"
                label="Open"
                type="button"
                role="none"
              />
              <control
                id="leftWallCanopyClose"
                description="LEFT WALL: CANOPY - Close"
                label="Close"
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
  name: "LeftSideWall",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
