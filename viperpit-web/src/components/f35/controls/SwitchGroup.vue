<template>
<div id="switch-group">
    <div align="center" style="padding: 0px;">
        <strong>{{label}}</strong>
    </div>
    <div align="center" style="padding: 0px;">
        <div class="btn-group-vertical" role="group"
            :aria-label="description">
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
      required: true
    },
    type: {
      type: String,
      required: true
    }
  }
}
</script>
