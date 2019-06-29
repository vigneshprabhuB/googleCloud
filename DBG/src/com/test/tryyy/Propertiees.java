package com.test.tryyy;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Propertiees {

	public static void main(String a[]) throws IOException, ParseException {
 
    new Propertiees().getListOfMonths("2018-11-01", "2019-11-01", "MONTHLY", 10, "END DATE");
	}

	public static Date convertToDate(String dateStr) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.parse(dateStr);
	}
	
	public List<String> getListOfMonths(String startDate,String endDate,String frequency,int occurance,String endDateBasedOn) throws ParseException{
		
		ArrayList<String> scheduleMonths = new ArrayList<String>();
		//LocalDate startDateLd = convertToDate(startDate).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate endDateLd = convertToDate(endDate).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		
		LocalDate lastUpdateDate = convertToDate(startDate).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

		if (endDateBasedOn.equals("OCCURANCE")) {

			for (int i = 1; i <= occurance; i++) {
				
				switch (frequency) {

				case "DAILY":
					scheduleMonths.add(lastUpdateDate.toString());
					lastUpdateDate = lastUpdateDate.plusDays(1);
					break;
				case "WEEKLY":
					scheduleMonths.add(lastUpdateDate.toString());
					lastUpdateDate = lastUpdateDate.plusWeeks(1);
					break;
				case "MONTHLY":
					scheduleMonths.add(lastUpdateDate.toString());
					lastUpdateDate = lastUpdateDate.plusMonths(1);
					break;
				case "TRIANNUAL":
					scheduleMonths.add(lastUpdateDate.toString());
					lastUpdateDate = lastUpdateDate.plusMonths(1 * 4);
					break;
				case "QUARTERLY":
					scheduleMonths.add(lastUpdateDate.toString());
					lastUpdateDate = lastUpdateDate.plusMonths(1 * 3);
					break;
				case "HALF-ANNUALLY":
					scheduleMonths.add(lastUpdateDate.toString());
					lastUpdateDate = lastUpdateDate.plusMonths(1 * 6);
					break;
				case "ANNUALLY":
					scheduleMonths.add(lastUpdateDate.toString());
					lastUpdateDate = lastUpdateDate.plusYears(1);
					break;
				}
			}
		}

		if (endDateBasedOn.equals("END DATE")) {

			boolean doSchedule = true;
			while (doSchedule) {

				switch (frequency) {

				case "DAILY":
					scheduleMonths.add(lastUpdateDate.toString());
					if (lastUpdateDate.plusDays(1).isBefore(endDateLd)) {
						lastUpdateDate = lastUpdateDate.plusDays(1);
					} else {
						doSchedule = false;
						break;
					}
					break;

				case "WEEKLY":
					scheduleMonths.add(lastUpdateDate.toString());
					if (lastUpdateDate.plusWeeks(1).isBefore(endDateLd)) {
						lastUpdateDate = lastUpdateDate.plusWeeks(1);
					} else {
						doSchedule = false;
						break;
					}
					break;

				case "MONTHLY":
					scheduleMonths.add(lastUpdateDate.toString());
					if (lastUpdateDate.plusMonths(1).isBefore(endDateLd)) {
						lastUpdateDate = lastUpdateDate.plusMonths(1);
					} else {
						doSchedule = false;
						break;
					}
					break;

				case "TRIANNUAL":
					scheduleMonths.add(lastUpdateDate.toString());
					if (lastUpdateDate.plusMonths(1 * 4).isBefore(endDateLd)) {
						lastUpdateDate = lastUpdateDate.plusMonths(1 * 4);
					} else {
						doSchedule = false;
						break;
					}
					break;

				case "QUARTERLY":
					scheduleMonths.add(lastUpdateDate.toString());
					if (lastUpdateDate.plusMonths(1 * 3).isBefore(endDateLd)) {
						lastUpdateDate = lastUpdateDate.plusMonths(1 * 3);
					} else {
						doSchedule = false;
						break;
					}
					break;

				case "HALF-ANNUALLY":
					scheduleMonths.add(lastUpdateDate.toString());
					if (lastUpdateDate.plusMonths(1 * 6).isBefore(endDateLd)) {
						lastUpdateDate = lastUpdateDate.plusMonths(1 * 6);
					} else {
						doSchedule = false;
						break;
					}
					break;

				case "ANNUALLY":

					scheduleMonths.add(lastUpdateDate.toString());
					if (lastUpdateDate.plusYears(1).isBefore(endDateLd)) {
						lastUpdateDate = lastUpdateDate.plusYears(1);
					} else {
						doSchedule = false;
						break;
					}
					break;

				}
			}
		}
  System.out.println(scheduleMonths);
	return scheduleMonths;
	}
 
}
