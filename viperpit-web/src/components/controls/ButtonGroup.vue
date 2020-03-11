<template>
  <div class="button-group">
    <div align="center">
      {{ label }}
    </div>
    <div align="center">
      <div class="btn-group-vertical" role="group" :aria-label="description">
        <slot></slot>
      </div>
    </div>
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
      required: false,
      default: ""
    },
    type: {
      type: String,
      required: true
    }
  }
};
</script>
