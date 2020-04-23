package System;

import java.io.*;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Directory root = new Directory("");
		Directory usr = new Directory("usr", root);
		new Filee("core", root);
		new Filee("adm", usr);
		new Directory("foo", usr);
		new Filee("bar1", usr);
		new Filee("xbar2", usr);
		new Directory("yybarzz3", usr);
		System.out.println(root.find("bar"));

		Filee core = new Filee("core", root);
		// create observer for file core
		FileObserver obs = new FileObserver(core);
		core.write("hello");
		core.write("world");

		// create a FileSystem object
		FileSystem fs = new FileSystem();
		fs.myImport("./src/main/resources/inputFile.txt");
	}
}