/**
* @author  Ajith Manjunath
* @date    06-Sep-2019
 * Purpose:	To handle json file read actions.
 */
package framework.utils;

import java.io.FileReader;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonHandler {

	//To read json data using json object
	public static String readDataFromJson(FileReader reader, String dataPage, String dataString)
	{
		JsonObject jsonObject = new JsonParser().parse(reader).getAsJsonObject();
		String data = jsonObject.getAsJsonObject(dataPage).get(dataString).getAsString();
		return data;
	}
	
	//To read json data using json array object
	public static String[] readDataFromJsonArray(FileReader reader, String jsonArrayName, String dataString)
	{
		JsonObject jsonObject = new JsonParser().parse(reader).getAsJsonObject();
		
		JsonArray arr = jsonObject.getAsJsonArray(jsonArrayName);
		
		String data[] = new  String [arr.size()];
		
		for(int i=0;i<arr.size();i++)
		{
			data[i]=arr.getAsJsonObject().get(dataString).getAsString();
		}
		return data;
	}
}
