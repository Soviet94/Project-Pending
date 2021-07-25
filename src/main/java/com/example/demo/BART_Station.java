package com.example.demo;

public class BART_Station {

	private String name;
	private String abbr;
	private int platforms;
	private BART_Station north;
	private BART_Station south;

	public BART_Station() {
	}

	public BART_Station(String name, String abbr, int platforms, BART_Station north, BART_Station south) {
		this.name = name;
		this.abbr = abbr;
		this.platforms = platforms;
		this.north = north;
		this.south = south;
	}

	public String getName() {
		return name;
	}

	public String getAbbr() {
		return abbr;
	}

	public int getPlatforms() {
		return platforms;
	}

	public BART_Station getNorth() {
		return north;
	}

	public BART_Station getSouth() {
		return south;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAbbr(String abbr) {
		this.abbr = abbr;
	}

	public void setPlatforms(int platforms) {
		this.platforms = platforms;
	}

	public void setNorth(BART_Station north) {
		this.north = north;
	}

	public void setSouth(BART_Station south) {
		this.south = south;
	}

}
