package com.mkautomation.util;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.regex.Pattern;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Utility {
	
	private static final Logger log = LoggerFactory.getLogger(Utility.class);
	
	static WebDriver driver;

	public static void scrollIntoView(WebElement element) {

		try {
			JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
			javascriptExecutor.executeScript("arguments[0].scrollIntoView();", element);
		}
		catch(Exception e) {
			
		}

	}

	public static void scrollIntoView(String loc) {
		try {

			JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
			javascriptExecutor.executeScript("arguments[0].scrollIntoView();", LocatorUtils.getBy(loc));
		}
		catch(Exception e) {
			
		}

	}

	public static boolean isRoundBracketBalanced(String str) {

		Map<Character, Character> brackets = new HashMap<>();

		brackets.put(')', '(');
		Set<Character> openers = new HashSet<>(brackets.values());

		Stack<Character> stack = new Stack<>();

		for (Character c : str.toCharArray()) {

			if (openers.contains(c)) {
				stack.push(c);
			} else if (brackets.containsKey(c)) {
				try {
					Character opener = stack.pop();
					if (!brackets.get(c).equals(opener)) {
						return false;
					}
				} catch (EmptyStackException ignore) {
					return false;
				}
			}
		}

		if (!stack.isEmpty()) {
			System.out.println("Each opening has not a closing bracket or vice-versa");
			return false;
		}
		System.out.println("Each opening has a closing bracket");
		return true;
	}

	public static String[] getRangeValues(String range) {

		String[] values = range.split(":");

		ArrayList<Integer> list = new ArrayList<Integer>();

		Integer i;
		for (i = Integer.valueOf(values[0]); i <= Integer.valueOf(values[1]); i++) {
			list.add(i);
		}
		String rangeValues[] = new String[list.size()];

		for (Integer i1 = 0; i1 < list.size(); i1++) {
			rangeValues[i1] = String.valueOf(list.get(i1));

		}
		return rangeValues;

	}
	
	public static boolean isValidInput(String regex,String input) {
		
	    input = "reyrty";
	    regex="([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
	    Pattern pattern = Pattern.compile(regex);
	    if (pattern.matcher(input).matches()) {
	    	return true;
	    }
		return false;
		
	}
	
	public static void moveToElement(WebElement element) {
		
		try {
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
			
		}catch(Exception e) {
			
		}
	}
	
	
}
