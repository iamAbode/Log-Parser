package com.ef.dao;

import java.text.ParseException;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.ef.entity.DailyComment;
import com.ef.entity.HourlyComment;
import com.ef.entity.Log;
import com.ef.service.HibernateUtil;
import com.ef.service.Parameters;

public class LogDAO
{
	Session session = HibernateUtil.getSessionFactory().openSession();
	
public void loadToDb(List<Log> data) {
	System.out.println("Inserting into database, please wait...");
		try {	    		
    		session.beginTransaction();
    		for(Log d: data) {    		
    		session.save(d);    		
    		}
    		
    		session.getTransaction().commit();
    		
    	}		
    	finally {
    		
    	}
	}

public List<Log> find(Parameters params) throws ParseException{
	System.out.println("Finding...");
    TypedQuery<Log> logs = session.createQuery("SELECT l FROM Log l " +
                    " WHERE l.date BETWEEN :startDate AND :endDate " +
            "GROUP BY l.ip HAVING count(l.ip) >= :threshold"
            , Log.class).
            setParameter("startDate", params.getStartDate()).
            setParameter("endDate", params.getEndDate()).
            setParameter("threshold", params.getThreshold());
    return logs.getResultList();
}

public void saveHourly(List<Log> logs, Parameters p) {
	System.out.println("Saving into hourly table");
	try {	    		
		session.beginTransaction();
		for(Log d: logs) { 
		String comment = "The IP: " + d.getIp() + " made more than" + p.getThreshold().toString() +
	            " requests between " + p.getStartDate().toString() + " and " + p.getEndDate().toString();
		
		HourlyComment hc = new HourlyComment(d.getDate(), d.getIp(), d.getRequest(), d.getStatus(), d.getUserAgent(), comment);	
		session.save(hc);    		
		}
		
		session.getTransaction().commit();
		
	}		
	finally {
		
	}
}

public void saveDaily(List<Log> logs, Parameters p) {
	System.out.println("Saving into daily table");
	try {	    		
		session.beginTransaction();
		for(Log d: logs) { 
		String comment = "The IP: " + d.getIp() + " made more than" + p.getThreshold().toString() +
	            " requests between " + p.getStartDate().toString() + " and " + p.getEndDate().toString();
		
		DailyComment dc = new DailyComment(d.getDate(), d.getIp(), d.getRequest(), d.getStatus(), d.getUserAgent(), comment);	
		session.save(dc);    		
		}
		
		session.getTransaction().commit();
		
	}		
	finally {
		
	}
}

public void close() {
	session.close();
}

}
