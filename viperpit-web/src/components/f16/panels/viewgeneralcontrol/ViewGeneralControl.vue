<template>
  <div class="panel panel-default">
    <div class="panel-heading">VIEW GENERAL CONTROL</div>
    <div class="panel-body">
      <div class="row">
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <viewgen-rotate-view-right />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <viewgen-rotate-view-left />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <viewgen-rotate-view-down />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <viewgen-rotate-view-up />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import ViewgenRotateViewRight from './ViewgenRotateViewRight'
import ViewgenRotateViewLeft from './ViewgenRotateViewLeft'
import ViewgenRotateViewDown from './ViewgenRotateViewDown'
import ViewgenRotateViewUp from './ViewgenRotateViewUp'

export default {
  name: 'ViewGeneralControl',
  components: {
    ViewgenRotateViewRight,
    ViewgenRotateViewLeft,
    ViewgenRotateViewDown,
    ViewgenRotateViewUp
  }
}
</script>
