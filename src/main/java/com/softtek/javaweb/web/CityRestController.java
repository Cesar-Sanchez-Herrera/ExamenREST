package com.softtek.javaweb.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.javaweb.domain.model.City;
import com.softtek.javaweb.service.CityService;

@RestController
@RequestMapping("/api/ciudades")
public class CityRestController {

	@Autowired
	private CityService cityService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	private List<City> getCiudades(){
		return cityService.getList();
	}
	
	@GetMapping("/{id}")
	private City getCity(@PathVariable Integer id) {
		return cityService.getOne(new Long (id));
	}
	
	@RequestMapping(value = "/ciudad/{description}", method = RequestMethod.GET)
    private List<City> getCiudad(@PathVariable String description){
        return cityService.getCityByName(description);
	}
	
}
