package controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import model.entities.AcademicProduction;
import model.entities.Collaborator;
import model.entities.Orientation;
import model.entities.Publication;
import model.entities.Teacher;
import views.Menu;

public class ControllerAcademicProduction {
	
	Scanner sc = new Scanner(System.in);
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
	
	protected ArrayList<AcademicProduction> academicProductions = new ArrayList<AcademicProduction>();
	
	public void register(ControllerCollaborator controllerCollaborator) throws ParseException {
		
		Menu.showMenuAcademicProduction();
		int type = sc.nextInt();
		sc.nextLine();
		System.out.print("Título: ");
		String title = sc.nextLine();
		
		AcademicProduction academicProduction = null;
		
		switch(type) {
			case 1:
				System.out.print("Conferência onde foi publicada: ");
				String conference = sc.nextLine();
				System.out.print("Ano de publicação: ");
				Date year = sdf.parse(sc.nextLine());
				academicProduction = new Publication(title, conference, year);
				break;
			case 2:
				System.out.print("Nome do professor: ");
				String name = sc.nextLine();
				Teacher teacher = (Teacher)controllerCollaborator.findTeacher(name);
				academicProduction = new Orientation(title, teacher);
				break;
		}
		academicProductions.add(academicProduction);
		System.out.println(academicProduction);
	}
	
	public void allocationOfParticipants(ControllerCollaborator controllerCollaborator) {		
		System.out.print("Título da produção acadêmica: ");
		String title = sc.nextLine();
		AcademicProduction academicProduction = findAcademicProduction(title);
		System.out.print("Nome do colaborador a ser alocado: ");
		String name = sc.nextLine();
		Collaborator collaborator = controllerCollaborator.findCollaborator(name);
		academicProduction.addAuthor(collaborator);
		collaborator.addAcademicProduction(academicProduction);
		System.out.println(academicProduction);
	}
	
	public int numberOfPublication() {
		int publication = 0;
		for(AcademicProduction p : academicProductions) {
			if(p instanceof Publication) {
				publication+=1;
			}
		}
		return publication;
	}
	public int numberOfOrientation() {
		int orientation = 0;
		for(AcademicProduction p : academicProductions) {
			if(p instanceof Orientation) {
				orientation+=1;
			}
		}
		return orientation;
	}
	
	public AcademicProduction findAcademicProduction(String title) {
		for(AcademicProduction ap : academicProductions) {
	       if(ap.getTitle().equals(title)) {
	           return ap;
	       }
		}
		return null;
	}
	
}
