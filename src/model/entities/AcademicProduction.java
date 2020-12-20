package model.entities;

import java.util.ArrayList;

public abstract class AcademicProduction {
	
	private int id;
	private String title;
	private ArrayList<Collaborator> authors;

	public AcademicProduction(int id, String title) {
		this.id = id;
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ArrayList<Collaborator> getAuthors() {
		return authors;
	}

	public void addAuthor(Collaborator author) {
		authors.add(author);
	}
	
	public void removeAuthor(Collaborator author) {
		authors.remove(author);
	}
	
	@Override
	public abstract String toString();
}
