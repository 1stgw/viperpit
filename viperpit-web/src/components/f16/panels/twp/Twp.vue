<template>
  <div class="card card-default">
    <div class="card-heading">TWP</div>
    <div class="card-body">
      <div class="row">
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <twp-handoff />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <twp-missile-launch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <twp-sys-test />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <twp-tgt-sep />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import TwpHandoff from "./TwpHandoff";
import TwpMissileLaunch from "./TwpMissileLaunch";
import TwpSysTest from "./TwpSysTest";
import TwpTgtSep from "./TwpTgtSep";

export default {
  name: "Twp",
  components: {
    TwpHandoff,
    TwpMissileLaunch,
    TwpSysTest,
    TwpTgtSep
  }
};
</script>
