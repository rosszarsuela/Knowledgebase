package com.oris.mis.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang.StringUtils;
import org.directwebremoting.annotations.DataTransferObject;

@SuppressWarnings("serial")
@Entity
@Table(name = "speaker")
@DataTransferObject(type = "hibernate3")
public class Speaker implements Serializable {

	private Long id;
	private String name;
	private String subject;
	private String time;
	private Event event;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SPEAKER_ID_PK")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EVENT_ID_FK", nullable = false)
	public Event getEvent(){
			return this.event;
	}

	@Column(name = "NAME")
	public String getName() {
		return StringUtils.isNotEmpty(name) ? name.toUpperCase() : name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "SUBJECT")
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Column(name = "TIME")
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

}
