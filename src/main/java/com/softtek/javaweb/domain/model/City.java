package com.softtek.javaweb.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="city")
public class City implements Serializable{
	
	private static final long serialVersionUID = 5985769049342837742L;
	@Id
	@Column(name="city_id")
	private Long cityId;
	@Column(name="description")
	private String description;
	
	@ManyToOne()
	@JoinColumn(name="state_id")
	private State state;
	
	
	
	public City(Long cityId, String description, State state) {
		this.cityId = cityId;
		this.description = description;
		this.state = state;
	}
	public City() {}
	
	public Long getCityId() {
		return cityId;
	}
	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "City [cityId=" + cityId + ", description=" + description + ", state=" + (state != null ? state.toString() : null) + "]";
	}
	
	
}
