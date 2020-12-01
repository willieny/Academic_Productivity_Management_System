package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Publication extends AcademicProduction implements Comparable<Publication>{

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

	public int compareTo(Publication o) {
		if (getYearPublication() == null || o.getYearPublication() == null)
		      return 0;
		 return getYearPublication().compareTo(o.getYearPublication());
	}
	
	@Override
	public String toString() {
		return "\nTítulo: " + getTitle() + "\nConferência: " + conference + "\nAno de publicação: " + sdf.format(yearPublication) + "\nAutores: " + getAuthors() +"\n";
	}
	
}
