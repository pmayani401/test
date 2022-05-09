package com.jpmc.theater;

import java.text.DecimalFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Movie {
    private static int MOVIE_CODE_SPECIAL = 1;

    private String title;
    private String description;
    private Duration runningTime;
    private double ticketPrice;
    private int specialCode;

    public Movie(String title, Duration runningTime, double ticketPrice, int specialCode) {
        this.title = title;
        this.runningTime = runningTime;
        this.ticketPrice = ticketPrice;
        this.specialCode = specialCode;
    }

    public String getTitle() {
        return title;
    }

    public Duration getRunningTime() {
        return runningTime;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public double calculateTicketPrice(Showing showing) {
        return ticketPrice - getDiscount(showing.getSequenceOfTheDay(),showing.getStartTime());
    }

    private double getDiscount(int showSequence,LocalDateTime dt) {
    	double largest = 0;
        double specialDiscount = 0;
        if (MOVIE_CODE_SPECIAL == specialCode) {
            specialDiscount = ticketPrice * 0.2;  // 20% discount for special movie
        }

        double sequenceDiscount = 0;
        if (showSequence == 1) {
            sequenceDiscount = 3; // $3 discount for 1st show
        } else if (showSequence == 2) {
            sequenceDiscount = 2; // $2 discount for 2nd show
        }
        if(dt.getHour() >= 11 && dt.getHour() <= 16) {
        	specialDiscount = ticketPrice * 0.25; //Updating the special discount value if the time is between 11 and 4
        }
        double getMonthDiscount= 0;
        //If the day of month is 7 we add a 1 dollar discount
        if(dt.getDayOfMonth() == 7) {
        	getMonthDiscount = 1;
        } 
        //Get the largest discount out of the three values and then rounding it to two decimals
        largest = getMonthDiscount > (specialDiscount > sequenceDiscount ? specialDiscount : sequenceDiscount) ? getMonthDiscount : ((specialDiscount > sequenceDiscount) ? specialDiscount : sequenceDiscount);
        largest = Math.round(largest * 100.0) / 100.0;
        // biggest discount wins
        return largest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Double.compare(movie.ticketPrice, ticketPrice) == 0
                && Objects.equals(title, movie.title)
                && Objects.equals(description, movie.description)
                && Objects.equals(runningTime, movie.runningTime)
                && Objects.equals(specialCode, movie.specialCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, runningTime, ticketPrice, specialCode);
    }
}