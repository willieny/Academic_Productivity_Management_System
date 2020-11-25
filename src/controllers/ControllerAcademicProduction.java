package controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import model.entities.AcademicProduction;
import model.entities.Orientation;
import model.entities.Publication;
import model.entities.Teacher;
import views.Menu;

public class ControllerAcademicProduction {
	
	Scanner sc = new Scanner(System.in);
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
	
	private ArrayList<AcademicProduction> academicProductions = new ArrayList<AcademicProduction>();
	
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
	
}
