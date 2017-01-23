package rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProcessRequest extends RequestOutput {
HashMap<String, String> dataSet = new HashMap<String, String>();

protected void testApis(){
	
	Utils util=new Utils();
	//System.out.println(util.propertyValue("ExcelPath"));
	ExcelUtils ExUtil = new ExcelUtils(util.propertyValue("ExcelPath"), 0);
	String apiUrl="";
	for (int i = 1; i <= ExUtil.numberRows(); i++) {
		for (int k = 0; k <= 2; k++) {
		if (ExUtil.cellData(i, k)!=null)
			apiUrl+=ExUtil.cellData(i, k);
		}
		
		setHttpconnection(apiUrl);
		setRequestType(ExUtil.cellData(i, 3));
		setOutPutMimeType(ExUtil.cellData(i, 4));
		Double actual=(double) responseData(ExUtil.cellData(i, 4)).size();
		String keyTest=ExUtil.cellData(i, 6);
		String keyVal=ExUtil.cellData(i, 7);
		System.out.println(keyVal+" "+checkParamData(keyTest)+" "+String.valueOf(actual)+" "+ExUtil.cellData(i, 5));
		if ( String.valueOf(actual).equals(ExUtil.cellData(i, 5))  &&   keyVal.equals(checkParamData(keyTest))){
			System.out.println(keyVal+" "+checkParamData(keyTest));
			ExUtil.setcellData(i, 8, "Pass");
		} else {
		
			ExUtil.setcellData(i, 8, "Fail");
		}
		apiUrl="";
	}

	}

	public boolean checkData(String input) {
		for (Map.Entry ent : dataSet.entrySet()) {

			if (ent.getValue().toString().contains(input)) {
				System.out.println(ent.getKey() + " " + ent.getValue());
				return true;
			}
		}

		return false;

	}

		
	
	}
