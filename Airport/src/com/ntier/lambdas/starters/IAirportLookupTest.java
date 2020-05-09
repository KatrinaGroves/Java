package com.ntier.lambdas.starters;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.function.Predicate;

public class IAirportLookupTest {

	public static void main(String[] args) {
		IAirportLookup airportFinder = AirportLookup::lookup;
//		IAirportLookup airportFinder = s -> AirportLookup.lookup(s);
		listAirportDetails(airportFinder);
		
		IntSupplier getAirportCount = AirportLookup.getAirportMap()::size;
//		IntSupplier getAirportCount = () -> AirportLookup.getAirportMap().size();
		System.out.println(getAirportCount.getAsInt());
		
		Consumer<Collection<String>> showAll = (p -> {
			for(String code : p) {
				try {
					System.out.println(AirportLookup.lookup(code));
				} catch (UnknownAirportException e) {
					System.out.println("Airport not found");
				}
			}
		});
		List<String> codeList = new ArrayList<>();
		codeList.add("LAX");
		codeList.add("DEN");
		codeList.add("BOS");
		codeList.add("JFK");
		showAll.accept(codeList);
		
		Predicate<String> airportsInTimezone = (z -> {
			Map<String, Airport> allAirports = AirportLookup.getAirportMap();
			for(Airport a : allAirports.values()) {
				if(a.getTimezone().toString().equals(z)) return true;
			}
			return false;
		});
		System.out.println(airportsInTimezone.test("US/Eastern"));

		BiPredicate<String,String> airportsInTimezoneOrState = ((z,s) -> {
			Map<String, Airport> allAirports = AirportLookup.getAirportMap();
			for(Airport a : allAirports.values()) {
				if(a.getTimezone().toString().equals(z)) return true;
				if(a.getState().equals(s)) return true;
			}
			return false;
		});
		System.out.println(airportsInTimezoneOrState.test("US/Eastern", "IL"));

		Function<String, Integer> lengthOfAirportName = (c -> {
			try {
				Airport a = AirportLookup.lookup(c);
				return a.getName().length();
			} catch (UnknownAirportException e) {
				return -1;
			}
		});
		System.out.println(lengthOfAirportName.apply("PHX"));
		
		try {
			Consumer<Airport> showAirport = System.out::println;
			Airport a = AirportLookup.lookup("SEA");
			showAirport.accept(a);
		} catch (UnknownAirportException e) { }
	}

	private static void listAirportDetails(IAirportLookup airportFinder) {
		try {
			Airport found = airportFinder.lookup("DEN");
			System.out.println(found);
		} catch (UnknownAirportException e) {
			System.out.println("Airport not found");
		}
	}
}