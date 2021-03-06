package com.weather.WeatherApi.LiveWeather.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;


/**
 * @author sats17,ashu1521,abhimanyu
 *
 */
@Repository
public class WeatherDaoImpl implements IWeatherDao{
	
	@Value("${api.uri}")
	private String apiPath;
	
	@Value("${api.id}")
	private String apiId;
	
	@Override
	public HttpResponse<JsonNode> getWeather(String city) {
		
		
		//Unirest.config().verifySsl(false);
		HttpResponse<JsonNode> response = Unirest.get(apiPath)
                .queryString("APPID",apiId)
                .queryString("q",city)
                .header("content-type","application/json")
                .asJson();
		return response;
	}
	
	
	
}
