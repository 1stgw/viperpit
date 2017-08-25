<template>
<div id="app">
    <div>
        <router-link to="/maps">Maps</router-link> | Cockpits: <router-link to="/cockpits/f16">F-16</router-link> | <router-link to="/cockpits/f35">F-35</router-link>
    </div>
    <div>
        <small v-if="isConnected">(Connected to {{ getAgent }})</small>
    </div>
    <hr />
    <router-view></router-view>
</div>
</template>

<script>
import { mapGetters } from 'vuex'

export default {
  name: 'app',
  computed: {
    ...mapGetters([
      'getAgent',
      'isConnected'
    ])
  }
}
</script>

<style>
#app {
	text-align: center;
}
</style>
