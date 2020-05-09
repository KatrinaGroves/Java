package com.ntier.labs.parallelstreams;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.stream.Stream;

import com.kodehaus.data.AccountServices;

class ParallelStreams {
//PS-473473to|hansen cummings|65010 Cambridge Road|Houston|TX|77229|268.00
	public static void main(String[] args) {
		average();
		averageOver200();
	}

	private static void average() {
		String[] accounts = AccountServices.getCustomerAccountList();
		Stream<String> accountStream = Arrays.stream(accounts);
		OptionalDouble accountAVG = accountStream.parallel().mapToDouble(i -> Double.parseDouble(i.split("\\|")[6]))
				.average();
		System.out.println(accountAVG.getAsDouble());
	}

	private static void averageOver200() {
		String[] accounts = AccountServices.getCustomerAccountList();
		Stream<String> accountStream = Arrays.stream(accounts);
		OptionalDouble accountAVG = accountStream.parallel().mapToDouble(i -> Double.parseDouble(i.split("\\|")[6])).filter(i -> i > 200)
				.average();
		System.out.println(accountAVG.getAsDouble());
	}
}
