package com.softtek.javaweb.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.softtek.javaweb.domain.model.ShipTo;
import com.softtek.javaweb.domain.model.ShippingZone;
import com.softtek.javaweb.domain.model.State;

public interface ShipToAddressRepository extends BaseRepository<ShipTo,Long>{
	//List<ShipTo> findByCity_cityId(String ShippingZone);
	//List<State> findByShippingZone_shippingZone(String ShippingZone);
//	@Query("SELECT st From ShipTo st JOIN City c ON st.city.cityId= c.cityId "
//			+ "JOIN State s ON c.state.stateId = s.stateId WHERE s.shippingZone.shippingZoneId = :ShippingZone")
//	List<ShipTo> findByShippingZoneId(@Param("ShippingZone")String ShippingZone);
	List<ShipTo> findByCity_state_shippingZone_shippingZoneIdContaining(String id);
}
