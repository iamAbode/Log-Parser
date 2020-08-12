package com.ef;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.ef.dao.LogDAO;
import com.ef.entity.Log;
import com.ef.service.Parameters;
import com.ef.service.ParserUtil;

public class Parser
{	
	static List<Log> data = new ArrayList<Log>();
	static Parameters parameters = null;
	
	public static void main(String[] args) 
	{	
		if(args.length > 0) {
			System.out.println("Sending arguments...");
		    parameters = new Parameters(args);
		  
		data = new ParserUtil().parseFile(parameters.getAccessLog());
		
			if(!data.isEmpty()) {		
	  	  	LogDAO logdao = new LogDAO();
	  	  	logdao.loadToDb(data);
	  	  	List<Log> logs = null;
			try
			{
				logs = logdao.find(parameters);
				System.out.println("Printing result");
				logs.forEach(log -> System.out.println(log));
			}
			catch (ParseException e)
			{// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (parameters.getDuration().equals("hourly")) {
				logdao.saveHourly(logs, parameters);
			}
			else if (parameters.getDuration().equals("daily")) {
				logdao.saveDaily(logs, parameters);
			}
			System.out.println("Data Saved");
			logdao.close();
			
			}
			else {
				System.out.println("Log Data could not be extracted from file. check the input file");
			}
		
		}
		else {
			System.out.println("Please supply arguments");
		}
		
		

	}	
	
	
	
	
}
