package rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeMap;

public class RequestOutput extends RestRequest {
	TreeMap<String, String> tm = new TreeMap<String, String>();
	// Contains api for in memory output of response and store response in disk
	// as well

	protected void constructTreeMap(ArrayList<String> input, String type) { // cosntructs
																			// an
																			// in
																			// memory
																			// treeMap
																			// for
																			// value
																			// checkup

		
		if (tm.size() != 0) {
			tm = null;
			tm = new TreeMap<String, String>();
		}
		if (type.equals("csv")) {

			for (String data : input) {
				if (!data.equals("")) {
					String[] arr = data.split(",");
					String key = arr[0];
					String sep = ",";
					arr = data.split(key + sep);
					String value = arr[1];
					tm.put(key, value);
				}

			}
		
		}

	}

	protected String checkParamData(String key) {
		return tm.get(key);

	}

	protected ArrayList<String> responseData(String type) {

		ArrayList<String> output = new ArrayList<String>();
		String add;
		InputStream is = null;
		try {
			is = httpConnection.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			while ((add = br.readLine()) != null) {
				output.add(add);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		constructTreeMap(output, type);
		return output;
	}

}
