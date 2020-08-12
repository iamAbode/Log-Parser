package com.ef.service;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Parameters
{
	private Date startDate;
    private Date endDate;
    private Long threshold;
    private String accessLog;  
    private String duration;
    DateFormat formatter = null;
        
    public Parameters(String[] params) {
    	formatter = new SimpleDateFormat("yyyy-MM-dd.HH:mm:ss", Locale.US);
    	for (String s : params) {

            String[] param = s.split("=");

            switch (param[0]) {

                case "--startDate":
                    try {
                    	System.out.println("Validating start date...");
                    	this.startDate = formatter.parse(param[1]);                       
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    break;

                case "--duration": 
                	this.duration = param[1];
                	System.out.println("Validating duration");
                	if (duration.equals("hourly")) {
                        this.endDate = new Date(this.startDate.getTime() + TimeUnit.HOURS.toMillis( 1 ));
                    } else if (duration.equals("daily")) {
                        this.endDate = new Date(this.startDate.getTime() + TimeUnit.DAYS.toMillis( 1 ));
                    } else {
                    	throw new IllegalArgumentException("Argument " + param[0] + " must be hourly or daily");
                    }                   
                    break;

                case "--threshold":
                	System.out.println("Validating threshold");
                    if (Long.valueOf(param[1]) <= 0) {
                        throw new IllegalArgumentException("Argument " + param[0] + " must be an integer");
                    } else {
                    	this.threshold = Long.valueOf(param[1]);
                    }                    
                    break;

                case "--accesslog":
                	System.out.println("Validating file path");
                    String filePath = param[1];
                    if(!new File(filePath).exists()){
                        throw new IllegalArgumentException("Error: " + filePath + " does not exist.");
                    }
                    else {
                    	this.accessLog = filePath;
                    }
                    
                    break;                
            }
        }   	
    	
    }

	public String getDuration()
	{
		return duration;
	}

	public void setDuration(String duration)
	{
		this.duration = duration;
	}

	public Date getStartDate()
	{
		return startDate;
	}

	public void setStartDate(Date startDate)
	{
		this.startDate = startDate;
	}

	public Date getEndDate()
	{
		return endDate;
	}

	public void setEndDate(Date endDate)
	{
		this.endDate = endDate;
	}

	public Long getThreshold()
	{
		return threshold;
	}

	public void setThreshold(Long threshold)
	{
		this.threshold = threshold;
	}

	public String getAccessLog()
	{
		return accessLog;
	}

	public void setAccessLog(String accessLog)
	{
		this.accessLog = accessLog;
	}
    
    

}
