package com.ntier.library;

import java.util.concurrent.ConcurrentHashMap;

import com.ntier.util.Branch;
import com.ntier.util.InventoryCatalog;

class Donations {

	private static ConcurrentHashMap<String, Book> library = new ConcurrentHashMap<>();

	public static void main(String[] args) {
		System.out.println("Inventory");
		for (InventoryCard ic : InventoryCatalog.getInventory()) {
			System.out.println(ic);
		}
		System.out.println("\r");
		System.out.println("Donations");
		for (String cl : Branch.getLocationOneCustomerList()) {
			System.out.println(cl.split("\\|")[1]);
		}
		System.out.println("\r");

	}
}