import LeftConsole from '@/components/f16/consoles/LeftConsole'
import LeftAuxConsole from '@/components/f16/consoles/LeftAuxConsole'
import CenterConsole from '@/components/f16/consoles/CenterConsole'
import RightConsole from '@/components/f16/consoles/RightConsole'
import Miscellaneous from '@/components/f16/consoles/Miscellaneous'
import Views from '@/components/f16/consoles/Views'
import RadioComms from '@/components/f16/consoles/RadioComms'

export default class F16Router {
  static getRoutes () {
    return [
      {
        path: '/cockpits/f16/consoles/leftconsole',
        name: 'LeftConsoleForF16',
        component: LeftConsole
      },
      {
        path: '/cockpits/f16/consoles/leftauxconsole',
        name: 'LeftAuxConsoleForF16',
        component: LeftAuxConsole
      },
      {
        path: '/cockpits/f16/consoles/centerconsole',
        name: 'CenterConsoleForF16',
        component: CenterConsole
      },
      {
        path: '/cockpits/f16/consoles/rightconsole',
        name: 'RightConsoleForF16',
        component: RightConsole
      },
      {
        path: '/cockpits/f16/consoles/miscellaneous',
        name: 'MiscellaneousForF16',
        component: Miscellaneous
      },
      {
        path: '/cockpits/f16/consoles/views',
        name: 'ViewsForF16',
        component: Views
      },
      {
        path: '/cockpits/f16/consoles/radiocomms',
        name: 'RadioCommsForF16',
        component: RadioComms
      }
    ]
  }
}
