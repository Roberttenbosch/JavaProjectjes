package com.PickMeUp.model;

//@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonFormat(shape = JsonFormat.Shape.OBJECT)

public enum AddressComponentType
{
		  STREET_ADDRESS("street_address"),

		  ROUTE("route"),

		  INTERSECTION("intersection"),

		  POLITICAL("political"),

		  COUNTRY("country"),

		  ADMINISTRATIVE_AREA_LEVEL_1("administrative_area_level_1"),

		  ADMINISTRATIVE_AREA_LEVEL_2("administrative_area_level_2"),

		  ADMINISTRATIVE_AREA_LEVEL_3("administrative_area_level_3"),

		  ADMINISTRATIVE_AREA_LEVEL_4("administrative_area_level_4"),

		  ADMINISTRATIVE_AREA_LEVEL_5("administrative_area_level_5"),

		  COLLOQUIAL_AREA("colloquial_area"),

		  LOCALITY("locality"),

		  WARD("ward"),

		  SUBLOCALITY("sublocality"),
		  SUBLOCALITY_LEVEL_1("sublocality_level_1"),
		  SUBLOCALITY_LEVEL_2("sublocality_level_2"),
		  SUBLOCALITY_LEVEL_3("sublocality_level_3"),
		  SUBLOCALITY_LEVEL_4("sublocality_level_4"),
		  SUBLOCALITY_LEVEL_5("sublocality_level_5"),

		  NEIGHBORHOOD("neighborhood"),

		  PREMISE("premise"),

		  SUBPREMISE("subpremise"),

		  POSTAL_CODE("postal_code"),

		  POSTAL_CODE_PREFIX("postal_code_prefix"),

		  POSTAL_CODE_SUFFIX("postal_code_suffix"),

		  NATURAL_FEATURE("natural_feature"),

		  AIRPORT("airport"),

		  PARK("park"),

		  POINT_OF_INTEREST("point_of_interest"),

		  FLOOR("floor"),

		  ESTABLISHMENT("establishment"),

		  PARKING("parking"),

		  POST_BOX("post_box"),

		  POSTAL_TOWN("postal_town"),

		  ROOM("room"),

		  STREET_NUMBER("street_number"),

		  BUS_STATION("bus_station"),

		  TRAIN_STATION("train_station"),

		  SUBWAY_STATION("subway_station"),

		  TRANSIT_STATION("transit_station"),

		  LIGHT_RAIL_STATION("light_rail_station"),

		  UNKNOWN("unknown");

		  private  String addressComponentType;

		  AddressComponentType(String addressComponentType) {
		    this.addressComponentType = addressComponentType;
		  }

		  @Override
		  public String toString() {
		    return addressComponentType;
		  }

		  public String toCanonicalLiteral() {
		    return toString();
		  }
}
