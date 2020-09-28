package com.lucifer.model;

import java.util.ArrayList;
import java.util.List;

public class BusinessType {

	private String id;
	
	private String name;
	
	private String parent_id;
	
	private String name_py;
	
	private String name_pj;
	
	private boolean terminal;
	
	public List<BusinessType> children = new ArrayList<BusinessType>();
	
	public List<BusinessType> children(){
		return this.children;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParent_id() {
		return parent_id;
	}

	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}

	public String getName_py() {
		return name_py;
	}

	public void setName_py(String name_py) {
		this.name_py = name_py;
	}

	public String getName_pj() {
		return name_pj;
	}

	public void setName_pj(String name_pj) {
		this.name_pj = name_pj;
	}

	public boolean isTerminal() {
		return terminal;
	}

	public void setTerminal(boolean terminal) {
		this.terminal = terminal;
	}
	
	
}
