package org.acme;

import io.quarkus.runtime.annotations.RegisterForReflection;

/**
 * Greeting
 */
@RegisterForReflection
public class Greeting {

	private String text;
	private boolean send;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isSend() {
		return send;
	}

	public void setSend(boolean send) {
		this.send = send;
	}
	
}