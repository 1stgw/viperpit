<template>
  <v-container>
    <v-row>
      <v-col>
        <general-radio-options />
      </v-col>
    </v-row>
  </v-container>
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
