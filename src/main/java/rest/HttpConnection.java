package rest;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpConnection {
	HttpURLConnection httpConnection=null;
	protected void setHttpconnection(String apiUrl){
		try {
			System.setProperty("http.agent", "Chrome");
			this.httpConnection=(HttpURLConnection)new URL(apiUrl).openConnection();
		
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}
}