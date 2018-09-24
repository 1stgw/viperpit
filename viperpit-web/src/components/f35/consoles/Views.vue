<template>
<div class="container-fluid">
  <div class="row">
  <div class="col-sm-6">
    <view-general-control />
  </div>
  <div class="col-sm-6">
    <view-internal />
  </div>
  </div>
  <div class="row">
  <div class="col-sm-6">
    <view-external />
  </div>
  <div class="col-sm-6">
    <general-radio-options />
  </div>
  </div>
</div>
</template>

<script>
import ViewGeneralControl from '../panels/viewgeneralcontrol/ViewGeneralControl'
import ViewInternal from '../panels/viewinternal/ViewInternal'
import ViewExternal from '../panels/viewexternal/ViewExternal'
import GeneralRadioOptions from '../panels/generalradiooptions/GeneralRadioOptions'

export default {
  name: 'Views',
  components: {
    ViewGeneralControl,
    ViewInternal,
    ViewExternal,
    GeneralRadioOptions
  }
}
</script>
