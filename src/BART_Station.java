
public class BART_Station {

	private String name;
	private String abbr;
	private int platforms;
	private BART_Station north;
	private BART_Station south;

	public BART_Station(String name, String abbr, int platforms, BART_Station north, BART_Station south) {
		this.name = name;
		this.abbr = abbr;
		this.platforms = platforms;
		this.north = north;
		this.south = south;
	}

	public BART_Station getNorthConnection() {
		return north;
	}
	
	public BART_Station getSouthConnection() {
		return south;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAbbreviation() {
		return abbr;
	}
	
	public int getPlatforms() {
		return platforms;
	}

}
