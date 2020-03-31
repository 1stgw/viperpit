<template>
  <v-container>
    <v-row>
      <v-col>
        <view-general-control />
      </v-col>
      <v-col>
        <view-internal />
      </v-col>
    </v-row>
    <v-row>
      <v-col>
        <view-external />
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import ViewGeneralControl from "@/components/f16/panels/ViewGeneralControl";
import ViewInternal from "@/components/f16/panels/ViewInternal";
import ViewExternal from "@/components/f16/panels/ViewExternal";

export default {
  name: "Views",
  components: {
    ViewGeneralControl,
    ViewInternal,
    ViewExternal
  }
};
</script>
