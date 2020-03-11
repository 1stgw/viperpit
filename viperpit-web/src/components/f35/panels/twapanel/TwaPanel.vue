<template>
  <div class="card card-default">
    <div class="card-heading">TWA PANEL</div>
    <div class="card-body">
      <div class="row">
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <twa-power-button />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import TwaPowerButton from "./TwaPowerButton";

export default {
  name: "TwaPanel",
  components: {
    TwaPowerButton
  }
};
</script>
