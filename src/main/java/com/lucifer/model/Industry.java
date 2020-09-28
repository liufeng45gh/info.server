package com.lucifer.model;

import java.util.ArrayList;
import java.util.List;

public class Industry {
	
	private String id;
	
	private String parent_id;
	
	private String name;
	


	private boolean terminal;
	
	public List<Industry> children = new ArrayList<Industry>();
	
	public List<Industry> getChildren() {
		return children;
	}

	public boolean isTerminal() {
		return terminal;
	}

	public void setTerminal(boolean terminal) {
		this.terminal = terminal;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParent_id() {
		return parent_id;
	}

	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}

	public String getName() {
		return name;
	}
	
	public String getText() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	
}
