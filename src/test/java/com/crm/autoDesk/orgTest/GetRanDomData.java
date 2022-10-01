package com.crm.autoDesk.orgTest;

import java.util.Random;

public class GetRanDomData {

	public static void main(String[] args) {
		
		Random ran = new Random();
		int ranDomNo = ran.nextInt(10000);
		System.out.println(ranDomNo);
	}

}
