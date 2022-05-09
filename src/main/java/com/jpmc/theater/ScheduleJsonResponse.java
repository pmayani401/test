package com.jpmc.theater;

public class ScheduleJsonResponse {
	int sequenceofDay;
	String startTime;
	String title;
	String humanFormat;
	double movieFee;
	
	ScheduleJsonResponse(int seqDay,String stTime,String tle,String hmFormat, double mFee){
		sequenceofDay = seqDay;
		startTime = stTime;
		title = tle;
		humanFormat = hmFormat;
		movieFee = mFee;
	}
	ScheduleJsonResponse(){
		
	}
	
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String stTime) {
		stTime = startTime;
	}
	public double getMovieFee() {
		return movieFee;
	}
	public void setMovieFee(double movieFee) {
		this.movieFee = movieFee;
	}
	public int getSequenceofDay() {
		return sequenceofDay;
	}
	public void setSequenceofDay(int sequenceofDay) {
		this.sequenceofDay = sequenceofDay;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getHumanFormat() {
		return humanFormat;
	}
	public void setHumanFormat(String humanFormat) {
		this.humanFormat = humanFormat;
	}

}
