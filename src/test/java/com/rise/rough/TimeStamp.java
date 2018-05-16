package com.rise.rough;

import java.util.Date;

public class TimeStamp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date d = new Date();
		String date = d.toString().replace(":", "_").replace(" ", "_")+".jpg";
		System.out.println(d);
		System.out.println(date);
		
	}

}
