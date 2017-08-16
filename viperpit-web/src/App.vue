<template>
<div id="app">
    <router-link to="/maps">Maps</router-link> | Cockpits: <router-link to="/cockpits/f16">F-16</router-link> | <router-link to="/cockpits/f35">F-35</router-link>
    <hr />
    <router-view></router-view>
</div>
</template>

<script>
export default {
  name: 'app'
}
</script>

<style>
#app {
	text-align: center;
}
</style>
