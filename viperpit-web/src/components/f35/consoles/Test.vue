<template>
  <div class="container-fluid">
    <div class="row">
      <div class="col-sm-12">
        <test-panel />
      </div>
    </div>
  </div>
</template>

<script>
import TestPanel from "../panels/testpanel/TestPanel";

export default {
  name: "Test",
  components: {
    TestPanel
  }
};
</script>
