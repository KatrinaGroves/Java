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

public class AirportTest {

	public static void main(String[] args) {
		IAirportLookup airportFinder = AirportLookup::lookup;
		System.out.println(airportFinder);
		
		IntSupplier getAirportCount = AirportLookup.getAirportMap()::size;
		System.out.println(getAirportCount.getAsInt());
		
		Consumer<Collection<String>> showAll = (p -> {
			for (String code : p) {
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

		Predicate<String> timeZoneFinder = (p -> {
			Map<String, Airport> ap = AirportLookup.getAirportMap();
			for (Airport pool : ap.values()) {
				if (pool.getTimezone().toString().equals(p)) {
					return true;
				}
			}
			return false;
		});
		System.out.println(timeZoneFinder.test("US/Pacific"));

		BiPredicate<String, String> zoneAndStateFinder = ((b, p) -> {
			Map<String, Airport> ap = AirportLookup.getAirportMap();
			for (Airport pool : ap.values()) {
				if (pool.getTimezone().toString().equals(b) | 
						pool.getState().toString().equals(p)) {
					return true;
				}
			}
			return false;
		});
		System.out.println(zoneAndStateFinder.test("US/Pacific", "CA"));

		Function<String, Integer> airportLength = (f) -> {
			try {
				Airport a = AirportLookup.lookup(f);
				return a.getName().length();
			} catch (UnknownAirportException e) {
				e.printStackTrace();
			}
			return null;
		};
		System.out.println(airportLength.apply("LAX"));
	}
}
