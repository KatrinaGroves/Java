package com.ntier.bank;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.ReentrantLock;

class ReceiptWriter extends Thread {

	private double dollar = ThreadLocalRandom.current().nextDouble() * 100000;
	private LocalDateTime timeStamp = LocalDateTime.now();
	private long receiptID;
	private DecimalFormat df = new DecimalFormat("$###,###.00");
	private DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM, FormatStyle.SHORT);

	public void run() {
		try {
			Thread.sleep(1000);
		}catch(InterruptedException ie) {
			ie.printStackTrace();
		}
		StringBuffer sb = new StringBuffer();
		ReentrantLock lock = new ReentrantLock();
		boolean isLocked = lock.tryLock();
		try {
			sb.append("Receipt #: " + receiptID);
		}finally {
			if(isLocked) {
				lock.unlock();
			}
		}
		StringBuilder receiptValue = new StringBuilder();

		for (int i = 1; i <= 2000; i++) {
			receiptValue.replace(0, receiptValue.length(),
					new String(df.format(dollar) + "\n" + dtf.format(timeStamp) + "\n" + receiptID++));
		}
		System.out.println(receiptValue);
	}

	ReceiptWriter(long receiptID) {
		this.receiptID = receiptID;
	}
	
}
