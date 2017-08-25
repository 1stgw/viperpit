<template>
<div class="container-fluid">
  <div class="row">
  <div class="col-sm-6">
    <view-external />
  </div>
  <div class="col-sm-6">
    <view-internal />
  </div>
  </div>
  <div class="row">
  <div class="col-sm-12">
    <view-general-control />
  </div>
  </div>
</div>
</template>

<script>
import ViewExternal from '../panels/viewexternal/ViewExternal'
import ViewInternal from '../panels/viewinternal/ViewInternal'
import ViewGeneralControl from '../panels/viewgeneralcontrol/ViewGeneralControl'

export default {
  name: 'Views',
  components: {
    ViewExternal,
    ViewInternal,
    ViewGeneralControl
  }
}
</script>
