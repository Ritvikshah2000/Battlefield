package System;

import java.util.*;

public abstract class Node {

	protected String _name;
	protected Directory _parent;
	protected Node child;

	Node(String name, Directory parent) {
		this._name = name;
		this._parent = parent;
		if (this._parent != null) {
			_parent.add(this);
		}
	}

	public String getAbsoluteName() {
		String path;
		if (this._parent != null) 
			path = this._parent.getAbsoluteName() + "/" + this._name;
		else
			path = this._name;
		return path;
	}

	public String toString() {
		return getAbsoluteName();
	}

	public abstract List<String> find(String s);

}
