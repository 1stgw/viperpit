<template>
  <div class="panel panel-default">
    <div class="panel-heading">RWR</div>
    <div class="panel-body">
      <div class="row">
        <div class="col-sm-6 col-md-4">
          <div align="center" style="padding: 0px;">
            <rwr-brightness-knob />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import RwrBrightnessKnob from './RwrBrightnessKnob'

export default {
  name: 'Rwr',
  components: {
    RwrBrightnessKnob
  }
}
</script>
