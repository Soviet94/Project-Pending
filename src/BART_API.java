import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class BART_API {

	// Base of the API call
	private String host = "http://api.bart.gov/api/bsa.aspx?";

	// API Key
	private String key = "&key=MW9S-E7SL-26DU-VV8V";

	// API call for the current departure estimates
	public Document estimatedDeparture() {
		return apiCall(host, key, "cmd=etd");
	}

	// All Stations API call
	public Map<String, BART_Station> stationList() {
		Map<String, BART_Station> list = new HashMap<String, BART_Station>();
		host = "http://api.bart.gov/api/stn.aspx?";

		Document response = apiCall(host, key, "cmd=stns");
		
		if (response == null) {
			return null;
		}

		response.getDocumentElement().normalize();
		
		NodeList stnList =((Element)(((Element) response.getElementsByTagName("root").item(0)).getElementsByTagName("stations")).item(0)).getElementsByTagName("station");
				
		for (int i=0; i<stnList.getLength(); i++) {
			BART_Station stn = new BART_Station();
			stn.setName(((Element) stnList.item(i)).getElementsByTagName("name").item(0).getTextContent());
			stn.setAbbr(((Element) stnList.item(i)).getElementsByTagName("abbr").item(0).getTextContent());
			list.put(stn.getAbbr(), stn);
		}
		
		return list;
	}

	// All Stations API call
	private BART_Station stationInfo(String stationAbbr, BART_Station station) {
		Document response = apiCall(host, key, "cmd=count");

		if (response == null) {
			return null;
		}

		response.getDocumentElement().normalize();
		return station;
	}

	// API call for the train count
	public Integer trainCount() {
		Document response = apiCall(host, key, "cmd=count");

		if (response == null) {
			return null;
		}

		response.getDocumentElement().normalize();
		return Integer.parseInt((((Element) response.getElementsByTagName("root").item(0))
				.getElementsByTagName("traincount").item(0).getTextContent()));
	}

	// Base API call function
	private Document apiCall(String host, String key, String cmd) {
		HttpURLConnection con;
		try {
			String call = host + cmd + key;
			URL url = new URL(call);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");

			InputStream responseStream = con.getInputStream();

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			return builder.parse(responseStream);

		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}

	}

}
