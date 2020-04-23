package System;

import java.io.*;
import java.util.*;

public class FileSystem extends Node {

	private Directory root;
	private Directory iterator;

	public FileSystem() {
		super(null, null);
	}

	public FileSystem(String n, Directory p) {
		super(n, p);
	}

	public List<String> find(String s) {
		return null;
	}

	public void myImport(String path) {

		child = null;
		root = getRoot(path);
		File input = new File(path);
		iterator = root;

		Scanner scanner = null;
		try {
			scanner = new Scanner(input);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		while (scanner.hasNextLine()) {

			String l = scanner.nextLine();
			String[] parts = (l.substring(l.indexOf(':') + 1)).split("/");

			if (root != null) {

				for (int i = 0; i < parts.length - 1; i++) {

					String temp = parts[i + 1];
					
					if (l.charAt(0) == 'd') {

						if (iterator.has_child(temp) == null) {

							Directory folder = new Directory(temp, iterator);
							iterator.child = folder;
							iterator = (Directory) iterator.child;

						} else
							iterator = (Directory) iterator.has_child(temp);
					}
					else {

						if (iterator.has_child(temp) == null) {

							Filee file = new Filee(temp, iterator);
							Directory folder = new Directory(temp, iterator);
							iterator.child = folder;
							iterator = (Directory) iterator.child;
						}

						else
							iterator = (Directory) iterator.has_child(temp);
					}
				}
			}
			iterator = root;
		}
	}

	public Directory getRoot(String pathstring) {

		if (root == null) {
			File inputfile = new File(pathstring);
			Scanner scanner = null;
			try {
				scanner = new Scanner(inputfile);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			String s = scanner.nextLine();
			String temp;
			temp = s.substring(s.indexOf(':') + 1, s.indexOf('/'));
			root = new Directory(temp);
		}

		return root;
	}
}
