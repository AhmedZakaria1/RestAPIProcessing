package rest;

import java.net.ProtocolException;

public class RestRequest extends HttpConnection {

	protected void setRequestType(String requestType){
		if (requestType.equals("GET")) {
			try {
				super.httpConnection.setRequestMethod("GET");
			} catch (ProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	if (requestType.equals("POST")) {
		try {
			super.httpConnection.setRequestMethod("POST");
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
	
	protected void setOutPutMimeType(String format){
	
	if (format.equals("json")){
		httpConnection.setRequestProperty("content-type", "application/json; charset=utf-8");
	}
	if (format.equals("csv")){
		httpConnection.setRequestProperty("content-type", "application/msexcel;charset=ISO-8859-1");
	}
}



}