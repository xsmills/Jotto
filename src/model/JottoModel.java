package model;

import java.net.*;
import java.util.Random;
import java.io.*;


/**
 * // TODO Write specifications for your JottoModel!
 */
public class JottoModel {
	
	

	
	/**
	 * // TODO Write specifications for the makeGuess function.
	 */
	public String makeGuess(int puzzleNum, String guess) throws Exception {		
		String outputLine = "";
		System.out.println("running....");
		
		String urlGuess = "http://6.005.scripts.mit.edu/jotto.py?puzzle=" + puzzleNum
		  +"&guess=" + guess;
		
		//BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));  
		//String userInput;


		//while ((userInput = stdIn.readLine()) != null) {
			try {		
			URL jottoScripts = new URL(urlGuess);
			  BufferedReader in = new BufferedReader(
			        new InputStreamReader(
			       jottoScripts.openStream()));
			
			//System.out.println(in.readLine());
			outputLine = in.readLine();
			} 
			catch (Exception e) {
				System.out.println(e);
			}

		    //System.out.println(">>> " );
		//}

		
		return outputLine;
	}
	
	
	
	
/*	public static void main(String[] args) throws Exception {	
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));  
		String userInput;


		while ((userInput = stdIn.readLine()) != null) {
			try {
			String urlGuess = makeGuess(userInput);		
			URL jottoScripts = new URL(urlGuess);
			  BufferedReader in = new BufferedReader(
			        new InputStreamReader(
			       jottoScripts.openStream()));
			
			System.out.println(in.readLine());
			} 
			catch (Exception e) {
				System.out.println(e);
			}

		    //System.out.println(">>> " );
		}

		  //in.close();
		    }*/
}
