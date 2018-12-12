package com.PickMeUp.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.PickMeUp.model.DepartureResponse;

@Service
public class NsServiceImpl extends BaseService implements NsService
{
	@Value("${ns.webservices.api.host}")
	private String nsHost;
	
	@Value("${ns.webservices.api.vertrektijden}")
    private String departureTimes;
	
	@Value("${ns.webservices.api.storingen}")
    private String interruption;
	
	@Autowired
	private RestTemplate restTemplateNs;
	
	@Value("${ns.webservices.api.username}")
    private String username;
	@Value("${ns.webservices.api.password}")
	private String password;
	
	
	@Override
	public DepartureResponse getCurrentDepartureTime(String station)
	{
		URI uri = getUri(station, departureTimes);
		restTemplateNs.getInterceptors().add(new BasicAuthorizationInterceptor(username, password));
		DepartureResponse response = restTemplateNs.getForObject(uri,
				DepartureResponse.class);
		log.info(response.toString());
		return response;
	}
	
	@Override
	public void getMaintenanceAndMalfunctions()
	{
		
	}
	
	public URI getUri(String station, String endpoint)
	{
		log.info(nsHost);
		return UriComponentsBuilder.newInstance().scheme("https")
				.host(nsHost).path(endpoint)
				.queryParam("station", station).build().toUri();
	}
}
