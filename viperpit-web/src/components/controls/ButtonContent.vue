<template>
  <span>
    <div v-if="controlConfiguration.role === 'up'">
      <v-icon>mdi-menu-up</v-icon>
    </div>
    <div v-else-if="controlConfiguration.role === 'down'">
      <v-icon>mdi-menu-down</v-icon>
    </div>
    <div v-else-if="controlConfiguration.role === 'increase'">
      <v-icon>mdi-plus</v-icon>
    </div>
    <div v-else-if="controlConfiguration.role === 'decrease'">
      <v-icon>mdi-minus</v-icon>
    </div>
    <div v-else-if="controlConfiguration.role === 'left'">
      <v-icon>mdi-menu-left</v-icon>
    </div>
    <div v-else-if="controlConfiguration.role === 'right'">
      <v-icon>mdi-menu-right</v-icon>
    </div>
    <div v-else>{{ controlConfiguration.label }}</div>
  </span>
</template>

<script>
export default {
  name: "ButtonContent",
  props: {
    controlConfiguration: {
      type: Object,
      required: true
    }
  }
};
</script>
