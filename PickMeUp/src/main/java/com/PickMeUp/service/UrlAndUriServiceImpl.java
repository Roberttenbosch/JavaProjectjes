package com.PickMeUp.service;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class UrlAndUriServiceImpl extends BaseService
		implements UrlAndUrlService
{
	@Value("${google.maps.api.baseurl}")
	private String	googleBaseUrl;

	@Value("${google.maps.api.embedded.key}")
	private String	googleApikey;

	@Value("${google.maps.api.scheme}")
	private String	googleApiScheme;

	@Value("${google.maps.api.path}")
	private String	googleApiPath;

	@Value("${google.maps.api.embedded.option}")
	private String	googleApiEmbeddedOption;
	
	@Value("${pickmeup.googleconnector.placeid.prefix}")
	private String	placeIdPrefix;

	@Override
	public URL createUserLocationWithPlaceIdUrl(String placeId)
	{
		try
		{
			return createUri(googleApiEmbeddedOption, placeIdPrefix+placeId).toURL();
		}
		catch (MalformedURLException e)
		{
			log.info(e.getMessage());
		}
		return null;
	}

	@Override
	public URI getUri(String location, String endpoint)
	{
		return UriComponentsBuilder.newInstance().scheme("http")
				.host("localhost").path(endpoint).port(18090)
				.queryParam("location", location).build().toUri();
	}

	private URI createUri(String option, String query)
	{
		return UriComponentsBuilder.newInstance().scheme(googleApiScheme)
				.host(googleBaseUrl).path(googleApiPath)
				.queryParam("key", googleApikey).queryParam(option, query)
				.build().toUri();
	}
}
