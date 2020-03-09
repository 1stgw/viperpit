import Cmds from "@/components/f35/consoles/Cmds";
import Comms from "@/components/f35/consoles/Comms";
import Flight from "@/components/f35/consoles/Flight";
import Fuel from "@/components/f35/consoles/Fuel";
import Test from "@/components/f35/consoles/Test";
import Lights from "@/components/f35/consoles/Lights";
import Sensors from "@/components/f35/consoles/Sensors";
import Navi from "@/components/f35/consoles/Navi";
import Avionics from "@/components/f35/consoles/Avionics";
import Wpn from "@/components/f35/consoles/Wpn";
import Emer from "@/components/f35/consoles/Emer";
import Misc from "@/components/f35/consoles/Misc";
import Views from "@/components/f35/consoles/Views";

export default class F35Router {
  static getRoutes() {
    return [
      {
        path: "/cockpits/f35/consoles/cmds",
        name: "CmdsForF35",
        component: Cmds
      },
      {
        path: "/cockpits/f35/consoles/comms",
        name: "CommsForF35",
        component: Comms
      },
      {
        path: "/cockpits/f35/consoles/flight",
        name: "FlightForF35",
        component: Flight
      },
      {
        path: "/cockpits/f35/consoles/fuel",
        name: "FuelForF35",
        component: Fuel
      },
      {
        path: "/cockpits/f35/consoles/test",
        name: "TestForF35",
        component: Test
      },
      {
        path: "/cockpits/f35/consoles/lights",
        name: "LightsForF35",
        component: Lights
      },
      {
        path: "/cockpits/f35/consoles/sensors",
        name: "SensorsForF35",
        component: Sensors
      },
      {
        path: "/cockpits/f35/consoles/navi",
        name: "NaviForF35",
        component: Navi
      },
      {
        path: "/cockpits/f35/consoles/avionics",
        name: "AvionicsForF35",
        component: Avionics
      },
      {
        path: "/cockpits/f35/consoles/wpn",
        name: "WpnForF35",
        component: Wpn
      },
      {
        path: "/cockpits/f35/consoles/emer",
        name: "EmerForF35",
        component: Emer
      },
      {
        path: "/cockpits/f35/consoles/misc",
        name: "MiscForF35",
        component: Misc
      },
      {
        path: "/cockpits/f35/consoles/views",
        name: "ViewsForF35",
        component: Views
      }
    ];
  }
}
