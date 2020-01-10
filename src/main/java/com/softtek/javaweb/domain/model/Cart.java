package com.softtek.javaweb.domain.model;


import java.sql.Timestamp;

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
@Table(name="cart")
public class Cart {
	
	
	@Id
	@Column(name="cart_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private Long cartId;
	@Column(name="lines_amount")
	private Float linesAmount;
	@Column(name="shipping_amount")
	private Float shippingAmount;
	@Column(name="cart_amount")
	private Float cartAmount;
	
	@ManyToOne()
	@JoinColumn(name="ship_to_id")
	private ShipTo shipTo;
	
	@NotNull
	@ManyToOne()
	@JoinColumn(name="status_id")
	private Status status;
	@Column(name="create_user")
	private String createUser;
	@Column(name="create_date")
	private Timestamp createDate;
	@Column(name="update_user")
	private String updateUser;
	@Column(name="update_date")
	private Timestamp updateDate;
	
	public Cart(Long cartId, Float linesAmount, Float shippingAmount, Float cartAmount, ShipTo shipTo, Status status,
			String createUser, Timestamp createDate, String updateUser, Timestamp updateDate) {
		this.cartId = cartId;
		this.linesAmount = linesAmount;
		this.shippingAmount = shippingAmount;
		this.cartAmount = cartAmount;
		this.shipTo = shipTo;
		this.status = status;
		this.createUser = createUser;
		this.createDate = createDate;
		this.updateUser = updateUser;
		this.updateDate = updateDate;
	}
	public Cart() {}

	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public Float getLinesAmount() {
		return linesAmount;
	}

	public void setLinesAmount(Float linesAmount) {
		this.linesAmount = linesAmount;
	}

	public Float getShippingAmount() {
		return shippingAmount;
	}

	public void setShippingAmount(Float shippingAmount) {
		this.shippingAmount = shippingAmount;
	}

	public Float getCartAmount() {
		return cartAmount;
	}

	public void setCartAmount(Float cartAmount) {
		this.cartAmount = cartAmount;
	}

	public ShipTo getShipTo() {
		return shipTo;
	}

	public void setShipTo(ShipTo shipTo) {
		this.shipTo = shipTo;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", linesAmount=" + linesAmount + ", shippingAmount=" + shippingAmount
				+ ", cartAmount=" + cartAmount + ", shipTo=" + (shipTo != null ? shipTo.toString() : null) + ", status=" + (status != null ? status.toString() : null) + ", createUser="
				+ createUser + ", createDate=" + createDate + ", updateUser=" + updateUser + ", updateDate="
				+ updateDate + "]";
	}	
}
