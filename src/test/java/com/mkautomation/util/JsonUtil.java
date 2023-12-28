package com.mkautomation.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.stream.JsonReader;

public class JsonUtil {

	public static void readJsonFromFile() throws IOException {

		JsonReader reader = new JsonReader(new FileReader("src//test//resources//testdata//json1.json"));
		Gson gson = new Gson();

		JsonElement jelement = gson.fromJson(reader, JsonElement.class);
		Object obj = read(jelement);

		Object data = new LinkedTreeMap<String, Object>();
		data = read(jelement);

		System.out.println(data);

		Map<String, Object> map = new LinkedTreeMap<String, Object>();
		map = (Map<String, Object>) read(jelement);

	}

	@SuppressWarnings("unchecked")
	public static Map<String, Object> getData() throws IOException {

		File f = new File("src//test//resources//testdata//json1.json");

		String json = FileUtils.readFileToString(f, "UTF-8");

		Gson gson = new Gson();

		Map<String, Object> data = new LinkedTreeMap<String, Object>();
		data.putAll(gson.fromJson(json, Map.class));
		return data;
	}

	public static Object read(JsonElement json) {

		if (json.isJsonObject()) {
			JsonObject obj = json.getAsJsonObject();
			// jobject = jobject.getAsJsonObject("test");
			// String result = jobject.get("UserName").getAsString();

			Map<String, Object> map = new LinkedTreeMap<String, Object>();
			Set<Map.Entry<String, JsonElement>> entitySet = obj.entrySet();
			for (Map.Entry<String, JsonElement> entry : entitySet) {
				map.put(entry.getKey(), read(entry.getValue()));
			}

		} else if (json.isJsonPrimitive()) {
			JsonPrimitive prim = json.getAsJsonPrimitive();
			if (prim.isBoolean()) {

				return prim.getAsBoolean();
			} else if (prim.isString()) {

				return prim.getAsString();
			} else if (prim.isNumber()) {

				if (prim.getAsString().contains("."))
					return prim.getAsDouble();
				else {
					return prim.getAsLong();
				}
			}
		} else if (json.isJsonArray()) {
			List<Object> list = new ArrayList<Object>();
			JsonArray arr = json.getAsJsonArray();
			for (JsonElement anArr : arr) {
				list.add(read(anArr));
			}
			return list;
		}
		return null;
	}

	public static String getValueFromJsonObjectUsingKeys(JSONObject jsonObject, String[] keys) throws JSONException {
		String currentKey = keys[0];

		if (keys.length == 1 && jsonObject.has(currentKey)) {
			return jsonObject.getString(currentKey);
		} else if (!jsonObject.has(currentKey)) {
			// throw new UnprocessableEntityException(currentKey + "is not a valid key.");
		}

		JSONObject nestedJsonObjectVal = jsonObject.getJSONObject(currentKey);
		int nextKeyIdx = 1;
		String[] remainingKeys = Arrays.copyOfRange(keys, nextKeyIdx, keys.length);
		return getValueFromJsonObjectUsingKeys(nestedJsonObjectVal, remainingKeys);
	}

	public static String[] extractKeys(String path) {
		String dot = "\\.";

		return path.split(dot);
	}

	public static String getData(String file, String key) throws IOException, JSONException {

		File inputStream = new File(file);
		
		String json = FileUtils.readFileToString(inputStream, "UTF-8");

		JSONTokener tokener = new JSONTokener(json);

		JSONObject jsonObject = new JSONObject(tokener);

		String[] keys = JsonUtil.extractKeys(key);

		return JsonUtil.getValueFromJsonObjectUsingKeys(jsonObject, keys);

	}
	
	public static String getData(JSONObject jsonObject, String key) throws JSONException{

		String[] keys = JsonUtil.extractKeys(key);
		return JsonUtil.getValueFromJsonObjectUsingKeys(jsonObject, keys);
	}
	
	public static JSONObject readJsonFile(String file) {
		
		JSONTokener tokener = null;
		try {
			File f = new File(file);
			String json = FileUtils.readFileToString(f, "UTF-8");
			tokener = new JSONTokener(json);
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		try{
			JSONObject jsonObject = new JSONObject(tokener);
			return jsonObject;
		}
		catch(JSONException jsex){
			jsex.printStackTrace();
		}
		return null;
		
	}

	public static void main(String args[]) throws IOException, JSONException {

		// System.out.println(JsonUtil.getData().get("services"));

		JsonUtil util = new JsonUtil();
		String file="src//test//resources//testdata//testdata-regression.json";
		String path = "resources.resourceData2.accountId";
		String[] keys = util.extractKeys(path);
		System.out.println(JsonUtil.getData(file, "cm_data2.cm_name"));
		String osName = System.getProperty("os.name");
		System.out.println(osName);

		System.out.println(RandomStringUtils.randomAlphanumeric(2));
		
		JSONObject jsonObject = JsonUtil.readJsonFile(file);
		System.out.println(JsonUtil.getData(jsonObject, "cm_data2.cm_name"));

		System.out.println("JSON ARRRAY\n");
	//	System.out.println(JsonUtil.getData(jsonObject, "tenant.login_domain_name"));

		JSONArray array1=new JSONArray(JsonUtil.getData(jsonObject, "tenant.login_domain_name"));
		
		System.out.println("Array Lenght:"+array1.length());
		
		for(int i=0;i<array1.length();i++) {
		System.out.println("domain:"+array1.getString(i));
		}
		
	}
}