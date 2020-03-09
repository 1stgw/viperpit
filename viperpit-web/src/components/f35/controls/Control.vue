<template>
  <a
    type="button"
    :class="[
      { active: isActive(id) },
      'btn ' + type + '-' + role + ' btn-block'
    ]"
    v-on:click="fireAction(id)"
  >
    <div v-if="role === 'up'">
      <span class="glyphicon glyphicon-chevron-up" aria-hidden="true"></span>
    </div>
    <div v-else-if="role === 'down'">
      <span class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>
    </div>
    <div v-else-if="role === 'left'">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    </div>
    <div v-else-if="role === 'right'">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
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
  methods: {
    ...mapActions(["fireAction"])
  },
  computed: {
    ...mapGetters(["isActive"])
  }
};
</script>
