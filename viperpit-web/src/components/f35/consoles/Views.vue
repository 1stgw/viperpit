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
      <div class="col-sm-12">
        <view-external />
      </div>
    </div>
  </div>
</template>

<script>
import ViewGeneralControl from "@/components/f35/panels/ViewGeneralControl";
import ViewInternal from "@/components/f35/panels/ViewInternal";
import ViewExternal from "@/components/f35/panels/ViewExternal";

export default {
  name: "Views",
  components: {
    ViewGeneralControl,
    ViewInternal,
    ViewExternal
  }
};
</script>
