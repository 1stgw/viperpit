export type CockpitConfiguration = {
  id: string;
  label: string;
  consoleConfigurations: ConsoleConfiguration[];
};

export type ConsoleConfiguration = {
  id: string;
  label: string;
  panelConfigurations: PanelConfiguration[];
};

export type PanelConfiguration = {
  id: string;
  label: string;
  controlGroupConfigurations: ControlGroupConfiguration[];
};

export type ControlGroupConfiguration = {
  id: string;
  label: string;
  stateful: string;
  controlConfigurations: ControlConfiguration[];
};

export type ControlConfiguration = {
  callback: string;
  label: string;
  description: string;
  style: string;
  role: string;
  type: string;
  stateful: boolean;
};
