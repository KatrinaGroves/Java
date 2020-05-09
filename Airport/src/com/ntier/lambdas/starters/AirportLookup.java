package com.ntier.lambdas.starters;

import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

public class AirportLookup {

	private static Map<String, Airport> airportMap;
	
	static{
		populateMap();
	}
	
	static void populateMap(){
		airportMap = new HashMap<>();
		
		String[][] airportData = getAirportData();
		
		for(String[] ra : airportData){
			String code  = ra[0];
			String name  = ra[1];
			String city  = ra[2];
			String state = ra[3];
			String zone  = ra[4];
			ZoneId tz = ZoneId.of(zone);
			airportMap.put(code, new Airport(code, name, city, state, tz));
		}
	}
	
	public static Map<String, Airport> getAirportMap() {
		return airportMap;
	}
	
	public static Airport lookup(String code) throws UnknownAirportException{
		Airport found = airportMap.get(code);
		if(found == null){
			throw new UnknownAirportException("Unknown airport: " + code);
		}
		return found;
	}
	
	private static String[][] getAirportData() {
		  String[][] airportData = {
		    {"EYW", "Key West International Airport",           "Key West",    "FL", "US/Eastern"},
		    {"LAS", "McCarran International Airport",           "Las Vegas",   "NV", "US/Pacific"},
		    {"SAN", "San Diego International Airport",          "San Diego",   "CA", "US/Pacific"},
		    {"SEA", "Seattle International Airport",            "Seattle",     "WA", "US/Pacific"},
		    {"PHX", "Phoenix Sky Harbor International Airport", "Phoenix",     "AZ", "US/Pacific"},
		    {"DEN", "Denver International Airport",             "Denver",      "CO", "US/Mountain"},
		    {"BOS", "Boston Logan International Airport",       "Boston",      "MA", "US/Eastern"},
		    {"JFK", "John F. Kennedy International Airport",    "New York",    "NY", "US/Eastern"},
		    {"MCO", "Orlando International Airport",            "Orlando",     "FL", "US/Eastern"},
		    {"LAX", "Los Angeles International Airport",        "Los Angeles", "CA", "US/Pacific"},
		    {"DFW", "Dallas/Fort Worth International Airport",  "Dallas",      "TX", "US/Central"},
		    {"ORD", "Chicago O'hare International Airport",     "Chicago",     "IL", "US/Central"},
		    {"PWM", "Portland International Jetport",           "Portland",    "ME", "US/Pacific"},
		    {"BMI", "Central Illinois Regional Airport",        "Bloomington", "IL", "US/Central"}
		  };
		  return airportData;
		}
}
