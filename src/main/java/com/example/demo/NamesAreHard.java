package com.example.demo;

import java.util.Map;

public class NamesAreHard {
	
	public static BART_API bart = new BART_API();
	
    public static void main(String[] args) {
       System.out.println("Hello World!");
       System.out.println(bart.trainCount());
       Map<String, BART_Station> list = bart.stationList();
    }
}