//package com.avaya.ix.com.mkautomation.test.ui.ngm.web.automation.util;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.UnsupportedEncodingException;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import gherkin
//
//import gherkin.formatter.JSONFormatter;
//import gherkin.formatter.JSONPrettyFormatter;
//import gherkin.parser.Parser;
//import gherkin.util.FixJava;
//
//public class GherkinToJson {
//
//	private String format;
//	// To get the total running time (optional)
//	long startTime = System.currentTimeMillis();
//
//	public GherkinToJson(String outFormat) {
//		this.format = outFormat;
//	}
//
//	public String getOutFormat() {
//		return format;
//	}
//
//	public String gherkinTojson(String fPath) throws JSONException {
//
//		// Define Feature file and JSON File path.
//		String gherkin = null;
//		try {
//			gherkin = FixJava.readReader(new InputStreamReader(new FileInputStream(fPath), "UTF-8"));
//		} catch (FileNotFoundException e) {
//			System.out.println("Feature file not found");
//			// e.printStackTrace();
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		} catch (RuntimeException e) {
//			e.printStackTrace();
//		}
//
//		StringBuilder json = new StringBuilder();
//		JSONFormatter formatter;
//		// pretty or ugly selection, pretty by default
//		if (format.equalsIgnoreCase("ugly")) {
//			formatter = new JSONFormatter(json);// not pretty
//		} else {
//			formatter = new JSONPrettyFormatter(json);// pretty
//		}
//
//		Parser parser = new Parser(formatter);
//		parser.parse(gherkin, fPath, 0);
//		formatter.done();
//		formatter.close();
//		//System.out.println("json output: \n" + json + " ");
//
//		// Finally flush and close
//		/*try {
//			FileWriter file = new FileWriter(jPath);
//			file.write(json.toString());
//			file.flush();
//			file.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}*/
//
//
//
//		return json.toString();
//	}
//
//	/*public static void main(String argsp[]) throws JSONException {
//
//		 Path fpath= Paths.get("src//test//resources//feature//api-open-api-tests.feature").toAbsolutePath();
//		    String path = fpath.toString();
//
//		    Path jfpath= Paths.get("src//test//resources//scenarios//test.json").toAbsolutePath();
//		    String jpath = jfpath.toString();
//
//		    new GherkinToJson("pretty").gherkinTojson(path, jpath);
//	}*/
//}
