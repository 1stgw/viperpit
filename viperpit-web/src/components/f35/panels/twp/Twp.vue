<template>
  <div class="panel panel-default">
    <div class="panel-heading">TWP</div>
    <div class="panel-body">
      <div class="row">
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <twp-tgt-sep />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <twp-sys-test />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <twp-unknown />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <twp-priority-mode />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <twp-missile-launch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <twp-handoff />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import TwpTgtSep from './TwpTgtSep'
import TwpSysTest from './TwpSysTest'
import TwpUnknown from './TwpUnknown'
import TwpPriorityMode from './TwpPriorityMode'
import TwpMissileLaunch from './TwpMissileLaunch'
import TwpHandoff from './TwpHandoff'

export default {
  name: 'Twp',
  components: {
    TwpTgtSep,
    TwpSysTest,
    TwpUnknown,
    TwpPriorityMode,
    TwpMissileLaunch,
    TwpHandoff
  }
}
</script>
