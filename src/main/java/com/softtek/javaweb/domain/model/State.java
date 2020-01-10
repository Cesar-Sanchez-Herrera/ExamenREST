package com.softtek.javaweb.domain.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="state")
public class State {

	
	@Id
	@Column(name="state_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private Long stateId;
	@Column(name="description")
	private String description;
	
	@ManyToOne()
	@JoinColumn(name="shipping_zone_id")
	private ShippingZone shippingZone;
	
	
	public State(Long stateId, String description, ShippingZone shippingZone) {
		this.stateId = stateId;
		this.description = description;
		this.shippingZone = shippingZone;
	}
	
	public State() {}
	public Long getStateId() {
		return stateId;
	}
	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ShippingZone getShippingZone() {
		return shippingZone;
	}
	public void setShippingZone(ShippingZone shippingZone) {
		this.shippingZone = shippingZone;
	}
	@Override
	public String toString() {
		return "State [stateId=" + stateId + ", description=" + description + ", shippingZone=" + (shippingZone != null ? shippingZone.toString() : null) + "]";
	}	
}
