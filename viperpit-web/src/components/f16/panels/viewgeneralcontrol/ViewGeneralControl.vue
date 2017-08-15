<template>
  <div class="panel panel-default">
    <div class="panel-heading">VIEW GENERAL CONTROL</div>
    <div class="panel-body">
      <div class="row">
        <div class="col-sm-6 col-md-4">
          <div align="center" style="padding: 0px;">
            <viewgen-rotate-view-up />
          </div>
        </div>
        <div class="col-sm-6 col-md-4">
          <div align="center" style="padding: 0px;">
            <viewgen-rotate-view-down />
          </div>
        </div>
        <div class="col-sm-6 col-md-4">
          <div align="center" style="padding: 0px;">
            <viewgen-rotate-view-left />
          </div>
        </div>
        <div class="col-sm-6 col-md-4">
          <div align="center" style="padding: 0px;">
            <viewgen-rotate-view-right />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import ViewgenRotateViewUp from './ViewgenRotateViewUp'
import ViewgenRotateViewDown from './ViewgenRotateViewDown'
import ViewgenRotateViewLeft from './ViewgenRotateViewLeft'
import ViewgenRotateViewRight from './ViewgenRotateViewRight'

export default {
  name: 'ViewGeneralControl',
  components: {
    ViewgenRotateViewUp,
    ViewgenRotateViewDown,
    ViewgenRotateViewLeft,
    ViewgenRotateViewRight
  }
}
</script>
