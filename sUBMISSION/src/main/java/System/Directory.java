package System;

import java.util.*;

class Directory extends Node {
	private List<Node> _children;

	Directory(String n) {
		this(n, null);
        _children = new ArrayList<Node>();

	}

	Directory(String n, Directory p) {
		super(n, p);
		_children = new ArrayList<Node>();
	}

	public void add(Node n) {
		_children.add(n);
	}

	public List<String> find(String s) {

		List<String> result = new ArrayList<String>();

		if (_name.indexOf(s) != -1) {
			result.add(getAbsoluteName());
		}
		for (Node child : _children) {
			result.addAll(child.find(s));
		}
		return result;
	}
	public Node has_child(String s) {
        Node n = null;
        for(Node child: _children) {
            if(child._name.contentEquals(s)) {
                n = child;
                Directory temp = new Directory(n._name, n._parent);
                return temp;
            }
        }
        return null;
	}
}