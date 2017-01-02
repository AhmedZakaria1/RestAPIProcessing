package rest;

import java.net.ProtocolException;

public class RestRequest extends HttpConn {

	public void setRequestType(String requestType){
		if (requestType.equals("GET")) {
			try {
				super.conn.setRequestMethod("GET");
			} catch (ProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	if (requestType.equals("POST")) {
		try {
			super.conn.setRequestMethod("POST");
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
	
public void setOutPutMimeType(String format){
	
	if (format.equals("json")){
		conn.setRequestProperty("content-type", "application/json; charset=utf-8");
	}
}



}
