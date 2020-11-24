package model.entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Publication extends AcademicProduction{

	private String conference;
	private Date yearPublication;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
	
	public Publication(String title, String conference, Date yearPublication) {
		super(title);
		this.conference = conference;
		this.yearPublication = yearPublication;
	}

	public String getConference() {
		return conference;
	}

	public void setConference(String conference) {
		this.conference = conference;
	}

	public Date getYearPublication() {
		return yearPublication;
	}

	public void setYearPublication(Date yearPublication) {
		this.yearPublication = yearPublication;
	}
	
	@Override
	public String toString() {
		return "\nTítulo: " + getTitle() + "\nConferência: " + conference + "\nAno de publicação: " + sdf.format(yearPublication) + "\n";
	}
	
}
