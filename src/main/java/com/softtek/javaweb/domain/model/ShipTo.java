package com.softtek.javaweb.domain.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="ship_to")

@NamedQuery(name="ShipTo.findByShippingZoneId",query="SELECT st From ShipTo st JOIN City c ON st.city.cityId= c.cityId "
		+ "JOIN State s ON c.state.stateId = s.stateId WHERE s.shippingZone.shippingZoneId=:ShippingZone")

public class ShipTo {
	@Id
	@Column(name="ship_to_id")
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long shipToId;
	@NotNull
	@ManyToOne()
	@JoinColumn(name="user")
	private User user;
	@Column(name="name")
	private String name;
	@Column(name="address")
	private String address;
	@NotNull
	@ManyToOne()
	@JoinColumn(name="city_id")
	private City city;
	@Column(name="zip_code")
	private Long zipcode;
	@Column(name="phone")
	private String phone;
	@Column(name="email")
	private String email;

	public ShipTo(Long shipToId, User user, String name, String address, City city, Long zipcode, String phone,
			String email) {
		this.shipToId = shipToId;
		this.user = user;
		this.name = name;
		this.address = address;
		this.city = city;
		this.zipcode = zipcode;
		this.phone = phone;
		this.email = email;
	}
	public ShipTo() {}
	
	public Long getShipToId() {
		return shipToId;
	}
	public void setShipToId(Long shipToId) {
		this.shipToId = shipToId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public Long getZipcode() {
		return zipcode;
	}
	public void setZipcode(Long zipcode) {
		this.zipcode = zipcode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "shipTo [shipToId=" + shipToId + ", user=" + (user != null ? user.toString() : null) + ", name=" + name + ", address=" + address + ", city="
				+ (city != null ? city.toString() : null) + ", zipcode=" + zipcode + ", phone=" + phone + ", email=" + email + "]";
	}
}
