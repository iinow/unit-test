package com.ha.http;

import java.io.IOException;

import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.json.JSONObject;

public class AddressRetriever {
	private Http http;
	
	public AddressRetriever(Http http) {
		this.http = http;
	}

	public Address retrieve(double latitude, double longitude) throws IOException, ParseException {
		String parms = String.format("lat=%.6f&lon=%.6f", latitude, longitude);
		String response = http.get("http://open.mapquestapi.com/nominatim/v1/reverse?format=json&" + parms);

		JSONObject obj = new JSONObject(response);

		JSONObject address = (JSONObject) obj.get("address");
		String country = (String) address.get("country_code");
		if (!country.equals("us"))
			throw new UnsupportedOperationException("cannot support non-US addresses at this time");

		String houseNumber = (String) address.get("house_number");
		String road = (String) address.get("road");
		String city = (String) address.get("city");
		String state = (String) address.get("state");
		String zip = (String) address.get("postcode");
		return new Address(houseNumber, road, city, state, zip);
	}
}
