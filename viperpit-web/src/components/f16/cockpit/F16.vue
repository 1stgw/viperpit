<template>
<div class="container-fluid">
  <h1>F16</h1>
  <div class="row">
    <router-link to="/cockpits/f16/consoles/leftconsole">Left Console</router-link> | 
    <router-link to="/cockpits/f16/consoles/leftauxconsole">Left Aux Console</router-link> | 
    <router-link to="/cockpits/f16/consoles/centerconsole">Center Console</router-link> | 
    <router-link to="/cockpits/f16/consoles/rightconsole">Right Console</router-link> | 
    <router-link to="/cockpits/f16/consoles/miscellaneous">Miscellaneous</router-link> | 
    <router-link to="/cockpits/f16/consoles/views">Views</router-link> | 
    <router-link to="/cockpits/f16/consoles/radiocomms">Radio Comms</router-link>
  </div>
  <hr/>
  <router-view></router-view>
</div>
</template>

<script>
import { mapActions } from 'vuex'
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
      'loadState'
    ])
  },
  created () {
    this.loadState()
  }
}
</script>
