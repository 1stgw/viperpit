package de.viperpit.agent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.viperpit.agent.data.SharedMemoryStateProvider;
import de.viperpit.agent.keys.KeyDispatcherService;
import de.viperpit.agent.model.StateChangeEvent;
import de.viperpit.commons.cockpit.StateType;

@RestController
@RequestMapping("/services/control")
public class AgentController {

	@Autowired
	private KeyDispatcherService keyDispatcherService;

	@Autowired
	private SharedMemoryStateProvider sharedMemoryStateProvider;

	@GetMapping("/state")
	public StateType getState() {
		return this.sharedMemoryStateProvider.getCurrentStateType();
	}

	@GetMapping("/trigger/{callback}/{action}")
	public StateChangeEvent onStatesToggle( //
			@PathVariable("callback") String callback, //
			@PathVariable("action") String action //
	) {
		if (callback == null) {
			return null;
		}
		if (action == null) {
			return null;
		}
		if ("start".equals(action)) {
			keyDispatcherService.keyDown(callback);
		} else {
			keyDispatcherService.keyUp(callback);
		}
		return null;
	}
}