package com.PickMeUp.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.PickMeUp.model.GeocodingResponse;
import com.PickMeUp.model.GoogleLocationOption;
import com.PickMeUp.model.OutputFormat;

@Service
public class GCLocationServiceImpl extends BaseService
		implements GCLocationService
{
	@Value("${google.maps.api.baseurl}")
	private String			googleBaseUrl;

	@Value("${google.maps.api.geocode.key}")
	private String			googleApikey;

	@Value("${google.maps.api.scheme}")
	private String			googleApiScheme;

	@Value("${google.maps.api.geocode}")
	private String			googleApiGeocode;

	@Value("${google.maps.api.path}")
	private String			googleApiPath;

	@Autowired
	private RestTemplate	restTemplate;

	@Override
	@Cacheable("formattedAddress")
	public String getFormattedAddress(String location)
	{

		URI uri = createGoogleLocationUri(
				GoogleLocationOption.ADDRESS.toString(), location);
		log.info(uri.toString());

		try
		{
			GeocodingResponse response = restTemplate
					.getForObject(uri, GeocodingResponse.class);
			log.info("response = {}",
					response.getResult()[0].getPlaceId());
			return response.getResult()[0].getFormattedAddress().toString();

		}
		catch (Exception e)
		{
			log.info(e.toString());
		}
		return HttpStatus.BAD_REQUEST.toString();
	}
	
	@Override
	@Cacheable("placeId")
	public String getPlaceIdByLoction(String location)
	{

		URI uri = createGoogleLocationUri(
				GoogleLocationOption.ADDRESS.toString(), location);
		log.info(uri.toString());

		try
		{
			GeocodingResponse response = restTemplate
					.getForObject(uri, GeocodingResponse.class);
			
			return response.getResult()[0].getPlaceId().toString();

		}
		catch (Exception e)
		{
			log.info(e.toString());
		}
		return HttpStatus.BAD_REQUEST.toString();
	}

	@Override
	@Cacheable("location")
	public String getLocation(String lat, String lng)
	{
		StringBuilder sb = new StringBuilder();
		sb.append(lat);
		sb.append(',');
		sb.append(lng);

		URI uri = createGoogleLocationUri(
				GoogleLocationOption.ADDRESS.toString(), sb.toString());
		log.info(uri.toString());

		GeocodingResponse response = restTemplate
				.getForObject(uri, GeocodingResponse.class);
		return response.getResult().toString();
	}

	private URI createGoogleLocationUri(String option, String query)
	{

		return UriComponentsBuilder.newInstance().scheme(googleApiScheme)
				.host(googleBaseUrl).path(googleApiPath)
				.pathSegment(googleApiGeocode)
				.pathSegment(OutputFormat.JSON.format())
				.queryParam(option, query).queryParam("key", googleApikey)
				.build().toUri();
	}

}
