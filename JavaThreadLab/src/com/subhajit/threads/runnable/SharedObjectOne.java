package com.subhajit.threads.runnable;

public class SharedObjectOne {

	private String content;

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "SharedObjectOne [content=" + content + "]";
	}
	
	
}
