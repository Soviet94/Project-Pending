import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class BART_API {

	// Base of the API call
	private String host = "http://api.bart.gov/api/bsa.aspx?";

	// API Key
	private String key = "&key=MW9S-E7SL-26DU-VV8V";
	
	//API call for the current departure estimates
	public Document estimatedDeparture() {
		return apiCall(host, key, "cmd=etd");
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
