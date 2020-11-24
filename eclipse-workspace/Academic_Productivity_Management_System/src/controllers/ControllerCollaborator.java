package controllers;

import java.util.ArrayList;
import java.util.Scanner;

import model.entities.AcademicProduction;
import model.entities.Collaborator;
import model.entities.Student;
import model.entities.Teacher;
import model.enums.TypeStudent;
import views.Menu;

public class ControllerCollaborator {
	
	Scanner sc = new Scanner(System.in);
	
	protected ArrayList<Collaborator> collaborators = new ArrayList<Collaborator>();
	
	public void register() {
		Menu.showMenuCollaborator();
		int type = sc.nextInt();
		sc.nextLine();
		System.out.print("Nome: ");
		String name = sc.nextLine();
		System.out.print("e-mail: ");
		String email = sc.nextLine();
		
		typeCollaborator(type, name, email);
		print();
	}
	
	public boolean typeCollaborator(int type, String name, String email) {
		Collaborator collaborator = null;
		switch(type) {
			case 1:
				collaborator = new Teacher(name, email);
				break;
			case 2:
				collaborator = new Student(name, email, TypeStudent.GRADUATE_STUDENT);
				break;
			case 3:
				collaborator = new Student(name, email, TypeStudent.MASTER_STUDENT);
				break;
			case 4:
				collaborator = new Student(name, email, TypeStudent.PHD_STUDENT);
				break;
			case 5:
				collaborator = new Student(name, email, TypeStudent.RESEARCHER);
				break;
		}
		collaborators.add(collaborator);
		return true;
	}
	
	public Collaborator findTeacher(String name) {
		for(Collaborator c : collaborators) {
			 if (c instanceof Teacher) {
                 if(c.getName().equals(name)) {
                	 return c;
                 }
             }
		}
		return null;
	}
	
	public void print() {
		for(Collaborator c : collaborators) {
			System.out.println(c);
		}
	}

	
}
