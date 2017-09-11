import Cmds from '@/components/f35/consoles/Cmds'
import Comms from '@/components/f35/consoles/Comms'
import Flight from '@/components/f35/consoles/Flight'
import Fuel from '@/components/f35/consoles/Fuel'
import Test from '@/components/f35/consoles/Test'
import Lights from '@/components/f35/consoles/Lights'
import Sensors from '@/components/f35/consoles/Sensors'
import Nav from '@/components/f35/consoles/Nav'
import Avionics from '@/components/f35/consoles/Avionics'
import LeftAuxConsole from '@/components/f35/consoles/LeftAuxConsole'
import CenterConsole from '@/components/f35/consoles/CenterConsole'
import RightConsole from '@/components/f35/consoles/RightConsole'
import Miscellaneous from '@/components/f35/consoles/Miscellaneous'
import Views from '@/components/f35/consoles/Views'
import RadioComms from '@/components/f35/consoles/RadioComms'

export default class F35Router {
  static getRoutes () {
    return [
      {
        path: '/cockpits/f35/consoles/cmds',
        name: 'CmdsForF35',
        component: Cmds
      },
      {
        path: '/cockpits/f35/consoles/comms',
        name: 'CommsForF35',
        component: Comms
      },
      {
        path: '/cockpits/f35/consoles/flight',
        name: 'FlightForF35',
        component: Flight
      },
      {
        path: '/cockpits/f35/consoles/fuel',
        name: 'FuelForF35',
        component: Fuel
      },
      {
        path: '/cockpits/f35/consoles/test',
        name: 'TestForF35',
        component: Test
      },
      {
        path: '/cockpits/f35/consoles/lights',
        name: 'LightsForF35',
        component: Lights
      },
      {
        path: '/cockpits/f35/consoles/sensors',
        name: 'SensorsForF35',
        component: Sensors
      },
      {
        path: '/cockpits/f35/consoles/nav',
        name: 'NavForF35',
        component: Nav
      },
      {
        path: '/cockpits/f35/consoles/avionics',
        name: 'AvionicsForF35',
        component: Avionics
      },
      {
        path: '/cockpits/f35/consoles/leftauxconsole',
        name: 'LeftAuxConsoleForF35',
        component: LeftAuxConsole
      },
      {
        path: '/cockpits/f35/consoles/centerconsole',
        name: 'CenterConsoleForF35',
        component: CenterConsole
      },
      {
        path: '/cockpits/f35/consoles/rightconsole',
        name: 'RightConsoleForF35',
        component: RightConsole
      },
      {
        path: '/cockpits/f35/consoles/miscellaneous',
        name: 'MiscellaneousForF35',
        component: Miscellaneous
      },
      {
        path: '/cockpits/f35/consoles/views',
        name: 'ViewsForF35',
        component: Views
      },
      {
        path: '/cockpits/f35/consoles/radiocomms',
        name: 'RadioCommsForF35',
        component: RadioComms
      }
    ]
  }
}
