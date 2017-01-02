package rest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BaseProcessURL { //Base class to process API
	URL url=null;	
	StringBuffer sb=null;
	HttpURLConnection conn=null;
	InputStream ins=null;
HashMap<String,String> dataSet=new HashMap<String,String>();
	String[] tkn;
void jsonResponseApi(String jsonURL)  {
	try {
		url=new URL(jsonURL);
	} catch (MalformedURLException e) {
		e.printStackTrace();
	}
try {
	System.setProperty("http.agent", "Chrome");
	 conn=(HttpURLConnection) url.openConnection();
	conn.setRequestMethod("GET");
	conn.setRequestProperty("content-type", "application/json; charset=utf-8");
	conn.setRequestProperty("Expect", "100-continue");
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
try {
	InputStream ins=conn.getInputStream();
	
//simple--now print the input stream data
InputStreamReader isr=new InputStreamReader(ins);

BufferedReader br=new BufferedReader(isr);
String test;
String root;
String[] tkn;
sb=new StringBuffer();
while ( (test=br.readLine())!=null){
	sb.append(test);
}
} catch (IOException e) {
	// TODO Auto-generated catch block
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
public static void main (String[] args) {
	BaseProcessURL obj=new BaseProcessURL();
	//obj.jsonResponseApi("http://www.thomas-bayer.com/sqlrest/CUSTOMER/");
//obj.jsonResponseApi("http://jsonplaceholder.typicode.com/");
//obj.jsonResponseApi("http://jsonplaceholder.typicode.com/comments");
	obj.jsonResponseApi("http://jsonplaceholder.typicode.com/users");
	System.out.println();
System.out.println(obj.checkData("ErvinHowell"));
}
}
