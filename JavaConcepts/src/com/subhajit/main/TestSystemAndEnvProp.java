package com.subhajit.main;

public class TestSystemAndEnvProp {

	public static void main(String[] args) {

		System.out.println(System.getenv("UNAME"));
		System.getenv().forEach((k, v) -> {
			System.out.println(k + " : " + v);
		});
		System.out.println("-------------------------------------------------------------");
		 
		/*
		 * System.setProperty("SNAME", "Pallobi"); System.getProperties().forEach((k,v)
		 * ->{ System.out.println(k + " : "+v); });
		 */
	}
}
