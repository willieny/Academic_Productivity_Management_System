package model.entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.enums.StatusProject;

public class Project {

	private String title;
	private Date start;
	private Date finish;
	private String fundingAgency;
	private Double amount;
	private String objective;
	private String description;
	
	private StatusProject status;
	
	private ArrayList<Collaborator> collaborators = new ArrayList<Collaborator>();
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Project(String title, Date start, Date finish, String fundingAgency, Double amount, String objective,
			String description, StatusProject status) {
		this.title = title;
		this.start = start;
		this.finish = finish;
		this.fundingAgency = fundingAgency;
		this.amount = amount;
		this.objective = objective;
		this.description = description;
		this.status = StatusProject.IN_PREPARATION;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getFinish() {
		return finish;
	}

	public void setFinish(Date finish) {
		this.finish = finish;
	}

	public String getFundingAgency() {
		return fundingAgency;
	}

	public void setFundingAgency(String fundingAgency) {
		this.fundingAgency = fundingAgency;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getObjective() {
		return objective;
	}

	public void setObjective(String objective) {
		this.objective = objective;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public StatusProject getStatus() {
		return status;
	}

	public void setStatus(StatusProject status) {
		this.status = status;
	}
	
	public ArrayList<Collaborator> getCollaborators() {
		return collaborators;
	}

	public void addCollaborator(Collaborator collaborator) {
		collaborators.add(collaborator);
	}
	
	public void removeCollaborator(Collaborator collaborator) {
		collaborators.remove(collaborator);
	}
	
	@Override
	public String toString() {
		return "\nTítulo: " + title + "\nData de início: " + sdf.format(start) + "\nData de término: " + sdf.format(finish)
				+ "\nAgência financiadora: " + fundingAgency + "\nValor financiado: " + String.format("%.2f", amount) + "\nObjetivo: "
				+ objective + "\nDescrição: " + description + "\n";
	}
	
}
