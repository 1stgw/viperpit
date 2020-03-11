<template>
  <a
    type="button"
    :class="[
      { active: isActive(id) },
      'btn ' + type + '-' + role + ' btn-block'
    ]"
    @click="fireAction(id)"
  >
    <div v-if="role === 'up'">
      <font-awesome-icon icon="caret-up" />
    </div>
    <div v-else-if="role === 'down'">
      <font-awesome-icon icon="caret-down" />
    </div>
    <div v-else-if="role === 'left'">
      <font-awesome-icon icon="caret-left" />
    </div>
    <div v-else-if="role === 'right'">
      <font-awesome-icon icon="caret-right" />
    </div>
    <div v-else>
      {{ label }}
    </div>
  </a>
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
