package controllers;

import java.util.ArrayList;
import java.util.Collections;

import model.entities.Project;
import model.entities.Publication;

public class SortByDate {

	public static ArrayList<Project> sortProject(ArrayList<Project> projects) {
        Collections.sort(projects);
        Collections.reverse(projects);
        return projects;
	}
	
	public static ArrayList<Publication> sortPublication(ArrayList<Publication> publications) {
        Collections.sort(publications);
        Collections.reverse(publications);
        return publications;
	}
}
