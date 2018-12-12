package com.PickMeUp.service;

import java.net.URI;
import java.net.URL;

public interface UrlAndUrlService
{

	public URL createUserLocationWithPlaceIdUrl(String placeId);

	public URI getUri(String location, String endpoint);

}
