<template>
  <v-btn
    :input-value="isActive(id)"
    @click="fireAction(id)"
    outlined
    color="light-green"
  >
    <div v-if="role === 'up'">
      <v-icon>mdi-menu-up</v-icon>
    </div>
    <div v-else-if="role === 'down'">
      <v-icon>mdi-menu-down</v-icon>
    </div>
    <div v-else-if="role === 'left'">
      <v-icon>mdi-menu-left</v-icon>
    </div>
    <div v-else-if="role === 'right'">
      <v-icon>mdi-menu-right</v-icon>
    </div>
    <div v-else>
      {{ label }}
    </div>
  </v-btn>
</template>

<script>
import { mapActions, mapGetters } from "vuex";

export default {
  props: {
    id: {
      type: String,
      required: true
    },
    description: {
      type: String,
      required: true
    },
    label: {
      type: String,
      required: true
    },
    type: {
      type: String,
      required: true
    },
    role: {
      type: String,
      required: true
    }
  },
  computed: {
    ...mapGetters(["isActive"])
  },
  methods: {
    ...mapActions(["fireAction"])
  }
};
</script>
