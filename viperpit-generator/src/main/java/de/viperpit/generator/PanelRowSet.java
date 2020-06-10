package de.viperpit.generator;

import java.util.List;

@SuppressWarnings("all")
public class PanelRowSet extends AbstractJsonized {
	public String getPanel() {
		return (String) wrap(delegate.get("panel"), String.class);
	}

	public void setPanel(final String panel) {
		delegate.add("panel", unWrap(panel, String.class));
	}

	public List<PanelRow> getPanelRows() {
		return (List<PanelRow>) wrap(delegate.get("panelRow"), PanelRow.class);
	}

	public void setPanelRows(final List<PanelRow> panelRows) {
		delegate.add("panelRow", unWrap(panelRows, PanelRow.class));
	}
}
