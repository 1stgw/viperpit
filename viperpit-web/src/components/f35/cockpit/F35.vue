<template>
<div class="container-fluid">
  <div v-if="isConnected">
    <div class="row">
      <router-link to="/cockpits/f35/consoles/cmds">Cmds</router-link> | 
      <router-link to="/cockpits/f35/consoles/comms">Comms</router-link> | 
      <router-link to="/cockpits/f35/consoles/fuel">Fuel</router-link> | 
      <router-link to="/cockpits/f35/consoles/test">Test</router-link> | 
      <router-link to="/cockpits/f35/consoles/lights">Lights</router-link> | 
      <router-link to="/cockpits/f35/consoles/sensors">Sensors</router-link> | 
      <router-link to="/cockpits/f35/consoles/nav">Nav</router-link> | 
      <router-link to="/cockpits/f35/consoles/avionics">Avionics</router-link> | 
      <router-link to="/cockpits/f35/consoles/leftconsole">Left Console</router-link> | 
      <router-link to="/cockpits/f35/consoles/leftauxconsole">Left Aux Console</router-link> | 
      <router-link to="/cockpits/f35/consoles/centerconsole">Center Console</router-link> | 
      <router-link to="/cockpits/f35/consoles/rightconsole">Right Console</router-link> | 
      <router-link to="/cockpits/f35/consoles/miscellaneous">Miscellaneous</router-link> | 
      <router-link to="/cockpits/f35/consoles/views">Views</router-link> | 
      <router-link to="/cockpits/f35/consoles/radiocomms">Radio Comms</router-link>
    </div>
    <router-view></router-view>
  </div>
  <div v-else>
    <div class="alert alert-warning" role="alert">
      <p><span class="glyphicon glyphicon-warning-sign" aria-hidden="true"></span> No Joy...</p>
      <p>Currently there is nothing Airborne.</p>
      <p>Please connect an Agent to the server...</p>
    </div>
  </div>
</div>
</template>

<script>
import { mapActions, mapGetters } from 'vuex'
import Cmds from '../consoles/Cmds'
import Comms from '../consoles/Comms'
import Fuel from '../consoles/Fuel'
import Test from '../consoles/Test'
import Lights from '../consoles/Lights'
import Sensors from '../consoles/Sensors'
import Nav from '../consoles/Nav'
import Avionics from '../consoles/Avionics'
import LeftConsole from '../consoles/LeftConsole'
import LeftAuxConsole from '../consoles/LeftAuxConsole'
import CenterConsole from '../consoles/CenterConsole'
import RightConsole from '../consoles/RightConsole'
import Miscellaneous from '../consoles/Miscellaneous'
import Views from '../consoles/Views'
import RadioComms from '../consoles/RadioComms'

require('../../../assets/f35.less')

export default {
  name: 'F35',
  components: {
    Cmds,
    Comms,
    Fuel,
    Test,
    Lights,
    Sensors,
    Nav,
    Avionics,
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
      'isConnected'
    ])
  },
  created () {
    this.initialize()
  }
}
</script>
