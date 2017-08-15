<template>
<a type="button" :class="[{ active: isActive(id) }, 'btn ' + type + '-' + role + ' btn-block']" v-on:click="fireAction(id)">
    {{label}}
</a>
</template>

<script>
import { mapActions, mapGetters } from 'vuex'

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
    ...mapActions([
      'fireAction'
    ])
  },
  computed: {
    ...mapGetters([
      'isActive'
    ])
  }
}
</script>
