package com.ef.service;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.ef.entity.Log;

public class ParserUtil
{	
	List<Log> data = new ArrayList<Log>();
	DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
	
	public List<Log> parseFile(String filePath) {
		System.out.println("Parsing log file...");
		File file = new File(filePath);
	  	  Scanner sc = null;
	  	  try {
	  	   sc = new Scanner(file);
	  	   // Check if there is another line of input
	  	   while(sc.hasNextLine()){
	  	    String str = sc.nextLine();
	  	    data.add(parseLine(str));
	  	   }
	  	   
	  	  } catch (IOException  exp) {
	  	   // TODO Auto-generated catch block
	  	   exp.printStackTrace();
	  	  }  	  
	  	  sc.close();  
	  	  
	  	  return data;
	}	
	
	
	@SuppressWarnings("unused")
	public Log parseLine(String str){
		  Date date = null;
	  	  String ip, request, status, userAgent;
	  	  Log log = null;
	  	  Scanner sc = new Scanner(str);
	  	  sc.useDelimiter("[|]");

	  	  // Check if there is another line of input
	  	  while(sc.hasNext()){
	  		try{date = formatter.parse(sc.next());}
			catch (ParseException e){e.printStackTrace();}
	  		ip = sc.next();
	  		request = sc.next();
	  		status = sc.next();
	  		userAgent = sc.next();		  		
			log = new Log(date, ip, request, status, userAgent);  	    
	  	  }
	  	  sc.close();
	  	  
	  	return log; 
	  	
	  	 } 
			
}
