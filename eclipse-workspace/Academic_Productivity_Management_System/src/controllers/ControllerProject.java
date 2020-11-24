package controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import model.entities.Project;
import model.enums.StatusProject;

public class ControllerProject {
	
	Scanner sc = new Scanner(System.in);
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	protected ArrayList<Project> projects = new ArrayList<Project>();

	public void register() throws ParseException {
		System.out.print("Título: ");
		String title = sc.nextLine();
		System.out.print("Data de início (dd/MM/yyyy): ");
		Date start = sdf.parse(sc.nextLine());
		System.out.print("Data de término (dd/MM/yyyy): ");
		Date finish = sdf.parse(sc.nextLine());
		System.out.print("Agência financiadora: ");
		String agency = sc.nextLine();
		System.out.print("Valor financiado: ");
		double amount = sc.nextDouble();
		sc.nextLine();
		System.out.print("Objetivo: ");
		String objective = sc.nextLine();
		System.out.print("Descrição: ");
		String description = sc.nextLine();
		
		Project project = new Project(title, start, finish, agency, amount, objective, description, StatusProject.IN_PREPARATION);
		projects.add(project);
		
		System.out.println("\nStatus do projeto: " + project.getStatus().getStatusProject()+ "\n");
	}
	
}
