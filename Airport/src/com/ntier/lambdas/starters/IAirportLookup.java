package com.ntier.lambdas.starters;

@FunctionalInterface
public interface IAirportLookup {
	Airport lookup(String port) throws UnknownAirportException;
}
