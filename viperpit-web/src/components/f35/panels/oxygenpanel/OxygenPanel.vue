<template>
  <div class="panel panel-default">
    <div class="panel-heading">OXYGEN PANEL</div>
    <div class="panel-body">
      <div class="row">
        <div class="col-sm-6 col-md-4">
          <div align="center" style="padding: 0px;">
            <oxy-setting2 />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import OxySetting2 from './OxySetting2'

export default {
  name: 'OxygenPanel',
  components: {
    OxySetting2
  }
}
</script>
