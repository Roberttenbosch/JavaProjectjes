package com.PickMeUp.model;

public enum LocationType
{
	 ROOFTOP,

	  /**
	   * Restricts the results to those that reflect an approximation (usually on a road) interpolated
	   * between two precise points (such as intersections). An interpolated range generally indicates
	   * that rooftop geocodes are unavailable for a street address.
	   */
	  RANGE_INTERPOLATED,

	  /**
	   * Restricts the results to geometric centers of a location such as a polyline (for example, a
	   * street) or polygon (region).
	   */
	  GEOMETRIC_CENTER,

	  /** Restricts the results to those that are characterized as approximate. */
	  APPROXIMATE,

	  /**
	   * Indicates an unknown location type returned by the server. The Java Client for Google Maps
	   * Services should be updated to support the new value.
	   */
	  UNKNOWN;

	  public String toUrlValue() {
	    if (this == UNKNOWN) {
	      throw new UnsupportedOperationException("Shouldn't use LocationType.UNKNOWN in a request.");
	    }
	    return name();
	  }
}
