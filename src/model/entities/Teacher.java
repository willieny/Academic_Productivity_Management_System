package model.entities;

import java.util.ArrayList;

public class Teacher extends Collaborator{
	
	private ArrayList<Orientation> orientations = new ArrayList<Orientation>();

	public Teacher(Integer id, String name, String email) {
		super(id, name, email);
	}

	public ArrayList<Orientation> getOrientations() {
		return orientations;
	}
	
	public void addOrientation(Orientation orientation) {
		orientations.add(orientation);
	}
	
	public void removeOrientation(Orientation orientation) {
		orientations.remove(orientation);
	}

	@Override
	public String toString() {
		return "\nid: " + getId() + "\nNome: " + getName() + "\ne-mail: " + getEmail() + "\nCargo: " + "Professor";
	}

}
