package com.ef.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="log")
public class Log
{
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="log_date")
	private Date date;
	
	@Column(name="ip")
	private String ip;
	
	@Column(name="request")
	private String request;
	
	@Column(name="status")
	private String status;
	
	@Column(name="user_agent")
	private String userAgent;

	
	@Override
	public String toString()
	{
		return "Log [Date="
					+ date
					+ ", IP="
					+ ip
					+ ", Request="
					+ request
					+ ", Status="
					+ status
					+ ", User Agent="
					+ userAgent
					+ "]";
	}

	public Log(Date date, String ip, String request, String status, String userAgent)
	{
		super();
		this.date = date;
		this.ip = ip;
		this.request = request;
		this.status = status;
		this.userAgent = userAgent;
	}
	public Log() {}
	
	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

	public String getIp()
	{
		return ip;
	}

	public void setIp(String ip)
	{
		this.ip = ip;
	}

	public String getRequest()
	{
		return request;
	}

	public void setRequest(String request)
	{
		this.request = request;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public String getUserAgent()
	{
		return userAgent;
	}

	public void setUserAgent(String userAgent)
	{
		this.userAgent = userAgent;
	}
	
	
}
