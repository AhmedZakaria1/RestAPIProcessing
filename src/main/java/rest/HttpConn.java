package rest;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpConn {
	HttpURLConnection conn=null;
	public HttpURLConnection con(String apiUrl){
		try {
			System.setProperty("http.agent", "Chrome");
			conn=(HttpURLConnection)new URL(apiUrl).openConnection();
			return conn;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	return null;
}
}
