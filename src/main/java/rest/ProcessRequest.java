package rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ProcessRequest extends RestRequest{
	HashMap<String,String> dataSet=new HashMap<String,String>();
public void processRestApi(String url,String requestType,String outputFormat){	
	ProcessRequest sub=new ProcessRequest();
sub.con(url);
sub.setRequestType(requestType);
sub.setOutPutMimeType(outputFormat);

	StringBuffer sb=new StringBuffer();
	String test;
	String[] tkn;
	
	try {
		InputStream ins=sub.conn.getInputStream();
	InputStreamReader isr=new InputStreamReader(ins);
	BufferedReader br=new BufferedReader(isr);
	
	while ( (test=br.readLine())!=null){
		sb.append(test);
	}
	} catch (IOException e) {
		e.printStackTrace();
	}
	String tt=sb.toString();
	String tt1=(tt.trim().replace(" ", "").replace("[", "").replace("{", "").replace("}", ""));
	tkn=tt1.split(":");
	String mainToken=tkn[0];
	tkn=tt1.split(mainToken);
	for (String spl:tkn){
		if (!spl.equals("")){
		String man=mainToken+spl;
		tkn=man.split(",");
		dataSet.put(tkn[0].replace("\"", ""), spl);
		//	System.out.println(man.replace(",\"", ",").replace("\":", "-"));
		}
	}
	for (Map.Entry ent:dataSet.entrySet()){
		System.out.println(ent.getKey()+" "+ent.getValue());
	}
	}

	public boolean checkData(String input){
		for (Map.Entry ent:dataSet.entrySet()){
		
		if (ent.getValue().toString().contains(input))	{
			System.out.println(ent.getKey()+" "+ent.getValue());
		return true;
		}
		}	
		
		
		return false;
		
	}

	
	
}
