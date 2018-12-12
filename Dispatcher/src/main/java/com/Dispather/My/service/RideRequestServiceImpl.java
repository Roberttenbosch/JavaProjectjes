package com.Dispather.My.service;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.Dispather.My.model.OutputFormat;

@Service
public class RideRequestServiceImpl implements RideRequestService
{
	private static final Logger	log	= LoggerFactory
			.getLogger(RideRequestServiceImpl.class);
	
	@Value("${google.maps.api.baseurl}")
	private String googleBaseUrl;
	
	@Value("${google.maps.api.key}")
	private String googleApikey;
	
	@Value("${google.maps.api.scheme}")
	private String googleApiScheme;
	
	@Value("${google.maps.api.geocode}")
	private String googleApiGeocode;
	
	@Value("${google.maps.api.path}")
	private String googleApiPath;
	
	
	/* (non-Javadoc)
	 * @see com.Dispather.My.service.RideRequestService#getCoordinates(java.lang.String)
	 */
	@Override
	public void getCoordinates(String location)
	{
		RestTemplate restTemplate = new RestTemplate();
		
		URI uri = getGoogleUri(location);
		log.info(uri.toString());
		
		ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
		log.info(response.getBody());
	}
	
	private URI getGoogleUri(String query) {
		
		return UriComponentsBuilder.newInstance()
				.scheme(googleApiScheme)
				.host(googleBaseUrl)
				.path(googleApiPath )
				.pathSegment(googleApiGeocode)
				.pathSegment(OutputFormat.JSON.format())
				.queryParam("address", query)
				.queryParam("key", googleApikey)
				.build()
				.toUri();
	}
}
