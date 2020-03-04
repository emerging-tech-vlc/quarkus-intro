package org.acme;

import io.quarkus.runtime.annotations.RegisterForReflection;

/**
 * Greeting
 */
@RegisterForReflection
public class Greeting {

    private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
    
}