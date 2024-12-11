package com.subhajit.main.vatiety;

public class TestMainVariety {
	
	// Will be executed while class loading
	static {
		System.out.println("TestMainVariety loaded");
	}
	
	{
		System.out.println("TestMainVariety object created");
	}
	
	//TestMainVariety obj1 = new TestMainVariety(); // Will create infinite obejct creation loop
	
	static TestMainVariety obj2 = new TestMainVariety(); // Object will be created
	
	//Error: Main method not found in class com.subhajit.main.vatiety.TestMainVariety
	// applicable for private/default/protected
	/*
	 * public static void main(String[] args) {
	 * System.out.println("private static void main"); }
	 */
	
	//Error: Main method is not static in class com.subhajit.main.vatiety.TestMainVariety
	/*
	 * public void main(String[] args) {
	 * System.out.println("public void main"); }
	 */
	
	//Error: Main method must return a value of type void in class com.subhajit.main.vatiety.TestMainVariety
	/*
	 * public static int main(String[] args) {
	 * System.out.println("public static int main"); return 1; }
	 */
	
	//Error: Main method not found in class com.subhajit.main.vatiety.TestMainVariety
	/*
	 * public static void main() {
	 * System.out.println("public static int main without args"); }
	 */
	
	// Will run fine
	public static void main(String[] args) {
		System.out.println("public static int main with args");
		//main("value");
	}
	
	// Will be considered as ordinary method
	public static void main(String var) {
		System.out.println("public static int main with String arg");
	}
	
}
