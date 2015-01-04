package com.SpurFlys.pocketscout;

import java.util.Date;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@SuppressWarnings("unused")
public class EventSearch {
	
	private String country = " ";
	private String region= " ";
	private String date = " ";
	private String baseEventsURL = "http://api.vex.us.nallen.me/get_events?season=current&";
	private String events;
	private String rawEventData;
	
	public EventSearch(String aCountry, String aRegion, String aDate){
		this.country=aCountry;
		this.region=aRegion;
		this.date=aDate;
		if(region == " "){
			if(country == " "){
				this.events = baseEventsURL + "date=" + date;
			}
			else{
				this.events = baseEventsURL + "date=" + date + "&country=" + country; 
			}
		}
		else if(country == " "){
			this.events = baseEventsURL + "date=" + date + "&region=" + region; 
		}
		else{
			this.events = baseEventsURL + "date=" + date + "&country=" + country + "&region=" + region; 
		}
		InputStream in = null;
		try{
			URL url = new URL(events);
			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
			in = new BufferedInputStream(urlConnection.getInputStream());
			readStream(in);
		}
		catch(Exception e){
			System.out.print(e.getMessage());
		}
//		finally {
//			urlConnection.disconnect();
//		}
	}
	
	private void readStream(InputStream is) throws IOException {
	    StringBuilder sb = new StringBuilder();  
	    BufferedReader r = new BufferedReader(new InputStreamReader(is),1000);  
	    for (String line = r.readLine(); line != null; line =r.readLine()){  
	        sb.append(line);  
	    }  
	    is.close();  
	    System.out.println(sb.toString());
	    rawEventData = sb.toString();
	}
}
