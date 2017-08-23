package de.viperpit.agent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AgentCommandLineRunner implements CommandLineRunner {

	@Value("${url}")
	private String url;

	@Autowired
	private AgentWebSocketClient agentWebSocketClient;

	public void run(String... args) {
		agentWebSocketClient.connectTo(url);
	}

}
