package technicaltest.com.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType; 

@Entity
@Table(name = "activity_entity")
public class ActivityEntity implements Serializable{
	


	private static final long serialVersionUID = -3009157732242241606L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String title; //subject
	
	@Column(name = "notes")
	private String notes;
	
	@Column(name = "due")
	private String dueDate;
	
	@Column(name = "contact")
	private String contact;
	
	public ActivityEntity() {
		
	}

	public ActivityEntity(String contact, String title, String notes, String dueDate) {
		super();
		this.contact = contact;
		this.title = title;
		this.notes = notes;
		this.dueDate = dueDate;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

}
