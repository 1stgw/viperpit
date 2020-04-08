<template>
  <div class="switch-group">
    <p>{{ label }}</p>
    <v-btn-toggle>
      <slot></slot>
    </v-btn-toggle>
  </div>
</template>

<script>
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
    }
  }
};
</script>
