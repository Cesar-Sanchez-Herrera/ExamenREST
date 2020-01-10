package com.softtek.javaweb.domain.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="status")
public class Status {

	@Id
	@Column(name="status_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long statusId;
	@Column(name="description")
	@NotNull
	private String description;
	@Column(name="status_type")
	private String statusType;
	
	public Status(Long statusId, String description, String statusType) {
		this.statusId = statusId;
		this.description = description;
		this.statusType = statusType;
	}
	public Status() {}
	public Long getStatusId() {
		return statusId;
	}
	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatusType() {
		return statusType;
	}
	public void setStatusType(String statusType) {
		this.statusType = statusType;
	}
	@Override
	public String toString() {
		return "Status [statusId=" + statusId + ", description=" + description + ", statusType=" + statusType + "]";
	}	
}
