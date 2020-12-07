package controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import model.entities.Collaborator;
import model.entities.Orientation;
import model.entities.Publication;
import model.entities.Teacher;
import views.Menu;

public class ControllerAcademicProduction {
	
	Scanner sc = new Scanner(System.in);
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
	
	protected ArrayList<Publication> publications = new ArrayList<Publication>();
	protected ArrayList<Orientation> orientations = new ArrayList<Orientation>();
	
	public void register(ControllerCollaborator controllerCollaborator) throws ParseException {
		
		Menu.showMenuAcademicProduction();
		int type = sc.nextInt();
		sc.nextLine();
		System.out.print("Título: ");
		String title = sc.nextLine();
		
		switch(type) {
			case 1: 
				System.out.print("Conferência onde foi publicada: ");
				String conference = sc.nextLine();
				System.out.print("Ano de publicação: ");
				Date year = sdf.parse(sc.nextLine());
				Publication publication = new Publication(title, conference, year);
				publications.add(publication);
				break;
			case 2:
				System.out.print("Nome do professor: ");
				String name = sc.nextLine();
				Teacher teacher = (Teacher)controllerCollaborator.findTeacher(name);
				Orientation orientation = new Orientation(title, teacher);
				orientations.add(orientation);
				teacher.addOrientation(orientation);
				break;
		}
	}
	
	public void allocationOfParticipants(ControllerCollaborator controllerCollaborator) {		
		Menu.showMenuAcademicProduction();
		int type = sc.nextInt();
		sc.nextLine(); 
		System.out.print("Título da produção acadêmica: ");
		String title = sc.nextLine();
		System.out.print("Nome do colaborador a ser alocado: ");
		String name = sc.nextLine();
		Collaborator collaborator = controllerCollaborator.findCollaborator(name);
		switch(type) {
		case 1:
			Publication publication = findPublication(title);
			publication.addAuthor(collaborator);
			collaborator.addPublication(publication);
			break;
		case 2:
			Teacher teacher = (Teacher)collaborator;
			Orientation orientation = findOrientation(title);
			orientation.addAuthor(collaborator);
			teacher.addOrientation(orientation);
			break;
		}
	}
	
	public Publication findPublication(String title) {
		for(Publication p : publications) {
	       if(p.getTitle().equals(title)) {
	           return p;
	       }
		}
		return null;
	}
	
	public Orientation findOrientation(String title) {
		for(Orientation o : orientations) {
	       if(o.getTitle().equals(title)) {
	           return o;
	       }
		}
		return null;
	}
	
}
