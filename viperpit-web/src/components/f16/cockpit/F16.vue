<template>
<div class="container-fluid">
  <div v-if="isConnected">
    <div class="row">
      <router-link to="/cockpits/f16/consoles/leftconsole">Left Console</router-link> | 
      <router-link to="/cockpits/f16/consoles/leftauxconsole">Left Aux Console</router-link> | 
      <router-link to="/cockpits/f16/consoles/centerconsole">Center Console</router-link> | 
      <router-link to="/cockpits/f16/consoles/rightconsole">Right Console</router-link> | 
      <router-link to="/cockpits/f16/consoles/miscellaneous">Miscellaneous</router-link> | 
      <router-link to="/cockpits/f16/consoles/views">Views</router-link> | 
      <router-link to="/cockpits/f16/consoles/radiocomms">Radio Comms</router-link>
    </div>
    <div class="row">
      <small>Connected to {{ getAgent }}</small>
    </div>
    <hr/>
    <router-view></router-view>
  </div>
  <div v-else>
    <div class="alert alert-danger" role="alert">
      <p><strong>No Joy...</strong></p>
      <p>There is no Agent on Air.</p>
    </div>
  </div>
</div>
</template>

<script>
import { mapActions, mapGetters } from 'vuex'
import LeftConsole from '../consoles/LeftConsole'
import LeftAuxConsole from '../consoles/LeftAuxConsole'
import CenterConsole from '../consoles/CenterConsole'
import RightConsole from '../consoles/RightConsole'
import Miscellaneous from '../consoles/Miscellaneous'
import Views from '../consoles/Views'
import RadioComms from '../consoles/RadioComms'

require('../../../assets/f16.less')

export default {
  name: 'F16',
  components: {
    LeftConsole,
    LeftAuxConsole,
    CenterConsole,
    RightConsole,
    Miscellaneous,
    Views,
    RadioComms
  },
  methods: {
    ...mapActions([
      'initialize'
    ])
  },
  computed: {
    ...mapGetters([
      'getAgent',
      'isConnected'
    ])
  },
  created () {
    this.initialize()
  }
}
</script>
