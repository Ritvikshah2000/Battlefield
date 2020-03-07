//handles the updating all objects
public class Handler {

	LinkedList<Reward> object = new LinkedList<Reward>(); //stores the rewards
	
	public void tick() {
		for(int i = 0; i < object.size(); i++) { //runs through all our objects
			Reward tempObject = object.get(i); //gets the object
			
			tempObject.tick(); 
			
		}
    }
    
    //be able to add or remove objects from the list:
	public void addObject(Reward tempObject) {
		object.add(tempObject);
	}
	public void removeObject(Reward tempObject) {
		object.remove(tempObject);
}

}