package de.viperpit.generator;

import java.util.List;

@SuppressWarnings("all")
public class ConsoleRow extends AbstractJsonized {
	public List<PanelRowSet> getPanelRowSets() {
		return (List<PanelRowSet>) wrap(delegate.get("panelRowSet"), PanelRowSet.class);
	}

	public void setPanelRowSets(final List<PanelRowSet> panelRowSets) {
		delegate.add("panelRowSet", unWrap(panelRowSets, PanelRowSet.class));
	}
}
