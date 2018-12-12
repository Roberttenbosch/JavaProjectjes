package com.PickMeUp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GeocodingResult
{
	@JsonProperty("address_components")
	private AddressComponent[]	addressComponents;
	
	@JsonProperty("formatted_address")
	private String				formattedAddress;;

	@JsonProperty("postcode_localities")
	private String[]			postcodeLocalities;
	
	@JsonProperty("geometry")
	private Geometry			geometry;
	
/*	@JsonProperty("types")
	private AddressType[]		types;*/
	
	@JsonProperty("partial_match")
	private boolean				partialMatch;
	
	@JsonProperty("place_id")
	private String				placeId;

	public AddressComponent[] getAddressComponents()
	{
		return addressComponents;
	}

	public void setAddressComponents(AddressComponent[] addressComponents)
	{
		this.addressComponents = addressComponents;
	}

	public String getFormattedAddress()
	{
		return formattedAddress;
	}

	public void setFormattedAddress(String formattedAddress)
	{
		this.formattedAddress = formattedAddress;
	}

	public String[] getPostcodeLocalities()
	{
		return postcodeLocalities;
	}

	public void setPostcodeLocalities(String[] postcodeLocalities)
	{
		this.postcodeLocalities = postcodeLocalities;
	}

	public Geometry getGeometry()
	{
		return geometry;
	}

	public void setGeometry(Geometry geometry)
	{
		this.geometry = geometry;
	}

/*	public AddressType[] getTypes()
	{
		return types;
	}

	public void setTypes(AddressType[] types)
	{
		this.types = types;
	}*/

	public boolean isPartialMatch()
	{
		return partialMatch;
	}

	public void setPartialMatch(boolean partialMatch)
	{
		this.partialMatch = partialMatch;
	}

	public String getPlaceId()
	{
		return placeId;
	}

	public void setPlaceId(String placeId)
	{
		this.placeId = placeId;
	}
}
