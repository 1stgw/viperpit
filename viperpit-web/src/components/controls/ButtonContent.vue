<template>
  <span>
    <div v-if="icon">
      <v-icon>{{ icon }}</v-icon>
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
  },
  computed: {
    icon: function () {
      switch (this.controlConfiguration.role) {
        case "up":
          return "mdi-menu-up";
        case "down":
          return "mdi-menu-down";
        case "left":
          return "mdi-menu-left";
        case "right":
          return "mdi-menu-right";
        case "increase":
          return "mdi-menu-plus";
        case "decrease":
          return "mdi-menu-minus";
        default:
          return null;
      }
    }
  }
};
</script>
