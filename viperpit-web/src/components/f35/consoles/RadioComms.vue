<template>
  <div class="container-fluid">
    <div class="row">
      <div class="col-sm-12">
        <general-radio-options />
      </div>
    </div>
  </div>
</template>

<script>
import GeneralRadioOptions from "@/components/f35/panels/GeneralRadioOptions";

export default {
  name: "RadioComms",
  components: {
    GeneralRadioOptions
  }
};
</script>
