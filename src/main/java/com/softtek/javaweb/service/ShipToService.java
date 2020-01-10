package com.softtek.javaweb.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.javaweb.domain.dto.ResponseStatus;
import com.softtek.javaweb.domain.dto.ShipToForm;
import com.softtek.javaweb.domain.mapper.EntityMapper;
import com.softtek.javaweb.domain.model.ShipTo;
import com.softtek.javaweb.domain.model.State;
//import com.softtek.javaweb.repository.MyRepository;
import com.softtek.javaweb.repository.jpa.ShipToAddressRepository;

@Service
public class ShipToService {

	
	@Autowired
	private ShipToAddressRepository shipToRepository;
	@Autowired
	EntityManager em;
	
	public static final Logger LOGGER = LoggerFactory.getLogger(ShipToService.class);
	
	public List<ShipTo> getList() {
		List<ShipTo> shipTos = this.shipToRepository.findAll();
		LOGGER.info("## ShipTo List Obtained: {}", shipTos);
		return shipTos;
	}

	public ShipTo getOne(final Long id) {
		ShipTo shipTo = this.shipToRepository.findById(id).orElse(null);
		LOGGER.info("## ShipTo Obtained: {}", shipTo);
		return shipTo;
	}
	
	public ResponseStatus update(final ShipTo shipTo) {
		ResponseStatus validateShipTo = validate(shipTo);
		if (validateShipTo.isValid()) {
			LOGGER.info("## Attempting to update shipTo: {}", shipTo);
			if (this.shipToRepository.save(shipTo) == null) {
				validateShipTo.setValid(false);
				validateShipTo.appendServiceMsg("There was an unknown error while attempting to update record. Please contact DBAdmin.");				
			}
		}
		return validateShipTo;
	}
	public ResponseStatus update(final ShipToForm shipToForm) {
		return this.update(EntityMapper.makeShipToFromForm(shipToForm));
	}
	
	public ResponseStatus add(final ShipTo shipTo) {
		ResponseStatus validateShipTo = validate(shipTo);
		if (validateShipTo.isValid()) {
			LOGGER.info("## Attempting to add shipTo: {}", shipTo);
			if (this.shipToRepository.save(shipTo) == null) {
				validateShipTo.setValid(false);
				validateShipTo.appendServiceMsg("There was an unknown error while attempting to add record. Please contact DBAdmin.");				
			}
		}
		return validateShipTo;
	}

	public ResponseStatus add(final ShipToForm shipToForm) {
		return this.add(EntityMapper.makeShipToFromForm(shipToForm));
	}
	public ResponseStatus delete (final Long id) {
		ResponseStatus validateShipTo = new ResponseStatus();
		validateShipTo.setValid(true);
		this.shipToRepository.deleteById(id);
		//if (this.shipToRepository.delete(id) <= 0) {
		//	validateShipTo.setValid(false);
		//	validateShipTo.appendServiceMsg("There was an unknown error while attempting to delete record, or record does not exist. Please contact DBAdmin.");
		//}
				
		return validateShipTo;
	}
	
	public ResponseStatus validate (final ShipTo shipTo) {
		ResponseStatus validateService = new ResponseStatus();
		validateService.setValid(true);

		LOGGER.info("## Validating shipTo: {}", shipTo);

		if (shipTo.getUser().getUsername() == null || shipTo.getUser().getUsername().equals(StringUtils.EMPTY)) { 
			validateService.setValid(false);
			validateService.appendServiceMsg("Username is mandatory.");
		}
		if (shipTo.getName() == null || shipTo.getName().equals(StringUtils.EMPTY)) { 
			validateService.setValid(false);
			validateService.appendServiceMsg("Name is mandatory.");
		}
		if (shipTo.getAddress() == null || shipTo.getAddress().equals(StringUtils.EMPTY)) { 
			validateService.setValid(false);
			validateService.appendServiceMsg("Address line is mandatory.");
		}
		if (shipTo.getCity().getCityId() == null || shipTo.getCity().getCityId().toString().equals(StringUtils.EMPTY)) { 
			validateService.setValid(false);
			validateService.appendServiceMsg("City is mandatory.");
		}
		if (shipTo.getZipcode() == null || shipTo.getZipcode().toString().equals(StringUtils.EMPTY)) { 
			validateService.setValid(false);
			validateService.appendServiceMsg("Zip Code is mandatory.");
		}
		if (shipTo.getPhone() == null || shipTo.getPhone().equals(StringUtils.EMPTY)) { 
			validateService.setValid(false);
			validateService.appendServiceMsg("Phone Number is mandatory.");
		}
		if (shipTo.getEmail() == null || shipTo.getEmail().equals(StringUtils.EMPTY)) { 
			validateService.setValid(false);
			validateService.appendServiceMsg("Email address is mandatory.");
		}
		
		LOGGER.info("## Validating shipTo status: {}", validateService.isValid());
		LOGGER.info("## Validating shipTo status messages: {}", validateService.getServiceMsg());
		
		return validateService;
	}
	public List<ShipTo> getShipToByShippingZone(String ShippingZone){
		return shipToRepository.findByCity_state_shippingZone_shippingZoneIdContaining(ShippingZone);
		// return shipToRepository.findByShippingZoneId(ShippingZone);
		//return shipToRepository.findByaddress(ShippingZone);
		//return shipToRepository.findByShippingZone_shippingZone(ShippingZone);
	}
}