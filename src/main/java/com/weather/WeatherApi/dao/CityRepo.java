package com.weather.WeatherApi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.weather.WeatherApi.beans.City;

/**
 * @author sats17,ashu1521,abhimanyu
 *
 */
public interface CityRepo extends JpaRepository<City, Integer>{

	/**
	 * @param city
	 * @return City
	 */
	@Query(value = "SELECT c FROM City c WHERE city = :city")
	City getCityByName(String city);
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM City c where c.city = :city")
	void deleteCity(String city);
}
