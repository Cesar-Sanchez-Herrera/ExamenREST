package com.softtek.javaweb.domain.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="shipping_zone")
public class ShippingZone {
	
	
	
	@Id
	@Column(name="shipping_zone_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private String shippingZoneId;
	@Column(name="description")
	@NotNull
	private String description;
	@Column(name="delivery_time")
	private Long deliveryTime;
	@Column(name="shipping_cost")
	private Float shippingCost;
	
	
	
	
	public ShippingZone(String shippingZoneId, String description, Long deliveryTime, Float shippingCost) {
		this.shippingZoneId = shippingZoneId;
		this.description = description;
		this.deliveryTime = deliveryTime;
		this.shippingCost = shippingCost;
	}
	public ShippingZone() {}
	
	public String getShippingZoneId() {
		return shippingZoneId;
	}
	public void setShippingZoneId(String shippingZoneId) {
		this.shippingZoneId = shippingZoneId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(Long deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	public Float getShippingCost() {
		return shippingCost;
	}
	public void setShippingCost(Float shippingCost) {
		this.shippingCost = shippingCost;
	}
	@Override
	public String toString() {
		return "ShippingZone [shippingZoneId=" + shippingZoneId + ", description=" + description + ", deliveryTime="
				+ deliveryTime + ", shippingCost=" + shippingCost + "]";
	}
	

}
