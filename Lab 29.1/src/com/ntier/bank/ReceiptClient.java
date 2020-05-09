package com.ntier.bank;

class ReceiptClient {

	public static void main(String[] args) {
		long receiptID = 2000;
		ReceiptWriter atm1 = new ReceiptWriter(receiptID);
		ReceiptWriter atm2 = new ReceiptWriter(receiptID);
		ReceiptWriter atm3 = new ReceiptWriter(receiptID);
		ReceiptWriter atm4 = new ReceiptWriter(receiptID);
		atm1.start();
		atm2.start();
		atm3.start();
		atm4.start();
	}
}
