package System;

public class FileObserver implements Observer {
	
	private Filee _subject;

	public FileObserver(Filee f){
		f.attach(this);
		_subject = f;
	}
	
	public void update() {
		System.out.println("File " + _subject.getAbsoluteName() + " has been changed.");
	}
}