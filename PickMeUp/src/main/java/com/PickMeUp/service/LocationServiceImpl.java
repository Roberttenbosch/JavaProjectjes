package com.PickMeUp.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class LocationServiceImpl extends BaseService implements LocationService
{
	@Autowired
	private RestTemplate		restTemplate;

	@Autowired
	private UrlAndUrlService	urlAndUrlService;

	@Value("${pickmeup.googleconnector.port}")
	private int					googleBaseUrl;

	@Value("${pickmeup.googleconnector.formattedaddress}")
	private String				endpointFormattedAddress;

	@Value("${pickmeup.googleconnector.placeid}")
	private String				endpointPlaceId;

	@Value("${pickmeup.googleconnector.result}")
	private String				endpointResult;
	
	@Value("${reliable.placeid}")
	private String				reliablePlaceId;
	@Value("${reliable.formattedaddress}")
	private String				reliableFormattedAddress;

	@Override
	@HystrixCommand(fallbackMethod = "reliableFormattedAddress")
	public String getFormattedAddress(String location)
	{
		URI uri = urlAndUrlService.getUri(location, endpointFormattedAddress);
		log.info("Uri = {}", uri.toString());
		ResponseEntity<String> response = restTemplate.getForEntity(uri,
				String.class);
		log.info(response.toString());
		return response.getBody();

	}

	@Override
	@HystrixCommand(fallbackMethod = "reliablePlaceId")
	public String getPlaceId(String location)
	{
		URI uri = urlAndUrlService.getUri(location, endpointPlaceId);
		log.info("Uri = {}", uri.toString());
		ResponseEntity<String> response = restTemplate.getForEntity(uri,
				String.class);
		log.info(response.toString());
		return response.getBody();

	}

	@Override
	@HystrixCommand(fallbackMethod = "reliablePlaceId")
	public String getPlaceId2(String location)
	{
		URI uri = getUri2(location, endpointPlaceId);
		log.info("Uri = {}", uri.toString());
		String response = restTemplate.getForObject(uri,
				String.class);
		log.info(response.toString());
		return response;

	}

	public String reliableFormattedAddress(String location)
	{
		log.info("reliable voor {} actief ", location);
		return reliableFormattedAddress;
	}

	public String reliablePlaceId(String location)
	{
		log.info("reliable voor {} actief ", location);
		return reliablePlaceId;
	}

	private URI getUri2(String location, String endpoint)
	{
		return UriComponentsBuilder.newInstance().scheme("http")
				.host("192.168.0.76")
				.path("/GoogleConnector-0.0.1-SNAPSHOT/" + endpoint).port(8181)
				.queryParam("location", location).build().toUri();
	}

}
