package com.camcast.crm.generic.fileutility;
import java.io.FileReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONUtility {

	public String getDataFromJson(String key) throws IOException, Throwable {
		FileReader fri = new FileReader("./configAppData/JsonCommonData.json");
		JSONParser json = new JSONParser();
		Object jsondata = json.parse(fri);
		JSONObject map = (JSONObject) jsondata;
		String value = map.get("key").toString();
		return value;

	}

}
