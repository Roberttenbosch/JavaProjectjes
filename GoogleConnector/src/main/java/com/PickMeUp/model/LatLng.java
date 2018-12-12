package com.PickMeUp.model;

import java.util.Locale;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LatLng
{
	@JsonProperty("lat")
	private double	lat;

	@JsonProperty("lng")
	private double	lng;

	/**
	 * Constructs a location with a latitude/longitude pair.
	 *
	 * @param lat
	 *            The latitude of this location.
	 * @param lng
	 *            The longitude of this location.
	 */
	public LatLng(double lat, double lng)
	{
		this.lat = lat;
		this.lng = lng;
	}

	public LatLng()
	{
	}

	public double getLat()
	{
		return lat;
	}

	public void setLat(double lat)
	{
		this.lat = lat;
	}

	public double getLng()
	{
		return lng;
	}

	public void setLng(double lng)
	{
		this.lng = lng;
	}

	@Override
	public String toString()
	{
		return toUrlValue();
	}

	public String toUrlValue()
	{
		// Enforce Locale to English for double to string conversion
		return String.format(Locale.ENGLISH, "%.8f,%.8f", lat, lng);
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		LatLng latLng = (LatLng) o;
		return Double.compare(latLng.lat, lat) == 0
				&& Double.compare(latLng.lng, lng) == 0;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(lat, lng);
	}
}
