package dmc.tm.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;

public final class Item {

	@Id
	private String id;
	private String idUser;
	private Date start;
	private Date end;
	private Long diff;
	private String title;
	private String description;
	private boolean note;
	private Date created;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public Long getDiff() {
		return diff;
	}

	public void setDiff(Long diff) {
		this.diff = diff;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isNote() {
		return note;
	}

	public void setNote(boolean note) {
		this.note = note;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

}
