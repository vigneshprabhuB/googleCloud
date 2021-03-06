package com.test.tryyy;

import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

public class SimpleTry {

	static int financialYearStartMonth = 4;
	static int financialMonthBeforeCurrentMonth = 2;
	static int financialMonthAfterCurrentMonth = 0;
	static int financialMonthTotalMonthDispaly = 3;

	public static void main(String ar[]) throws JSONException {
		
		SimpleTry simpleTry = new SimpleTry();
		List<Integer> monthArray = simpleTry.bulidMonthArray(financialYearStartMonth);
		JSONObject initailResult = simpleTry.getCustomerBudgetVisibleData(monthArray,financialMonthTotalMonthDispaly, financialYearStartMonth);
		System.out.println(initailResult.get("monthDisp"));
		System.out.println(initailResult.get("financialYearDisp"));
	}

	public synchronized List<Integer> bulidMonthArray(int financialStartMonth) {

		int staryMont = financialStartMonth;
		int monthArraySize = 0;
		List<Integer> totalMonths = new ArrayList<Integer>();
		while (monthArraySize <= 11) {
			if (staryMont <= 12) {
				totalMonths.add(staryMont);
				staryMont++;
				monthArraySize++;
			}
			if (staryMont > 12) {
				totalMonths.add(staryMont - 12);
				staryMont++;
				monthArraySize++;
			}

		}

		return totalMonths;

	}

	public JSONObject getCustomerBudgetVisibleData(List<Integer> motthArray,
			int totalMonthDisplayed, int financialYearStartMonth)
			throws JSONException {

		List<Integer> monthToBeDiaplayed = new ArrayList<Integer>();
		JSONObject monthYearDisp = new JSONObject();
		int currentMonth = new Date().getMonth() + 1;
		int currentMonthIndex = motthArray.indexOf(currentMonth);
		int currentMonthIndexEx = motthArray.size();

		// get month to be displayed baseed on totalMonthDisplayed
		while (totalMonthDisplayed >= 1) {
			if ((currentMonthIndex) >= 0) {
				monthToBeDiaplayed.add(motthArray.get(currentMonthIndex));
				totalMonthDisplayed--;
				currentMonthIndex--;
			} else {
				monthToBeDiaplayed.add(motthArray.get(currentMonthIndexEx - 1));
				totalMonthDisplayed--;
				currentMonthIndexEx--;
			}
		}
		JSONObject monthDisplayOutput = new JSONObject();
		// month data to be displayed
		for (int i = 0; i < 12; i++) {
			String month = Month.of(i + 1).toString().toLowerCase();
			monthDisplayOutput.put(month,
					monthToBeDiaplayed.indexOf(i + 1) >= 0 ? true : false);
		}

		int currentFinancialYear = new Date().getYear() + 1900;
		String financialCurrentYear = "";
		String financialCurrentBeforeYear = "";
		if (new Date().getMonth() + 1 >= financialYearStartMonth) {
			financialCurrentYear = (currentFinancialYear) + "-"
					+ (currentFinancialYear + 1);
		} else {
			financialCurrentYear = (currentFinancialYear - 1) + "-"
					+ (currentFinancialYear);
		}
		String[] years = financialCurrentYear.split("-");
		if (years.length >= 2) {
			financialCurrentBeforeYear = (Integer.parseInt(years[0]) - 1) + "-"
					+ Integer.parseInt(years[0]);
		}

		JSONObject financialYearDisp = new JSONObject();
		for (int j = 0; j < 11; j++) {
			financialYearDisp
					.put(Month.of(j + 1).toString().toLowerCase() + "Fyear",
							monthToBeDiaplayed.indexOf(j + 1) < 0 ? financialCurrentYear
									: monthToBeDiaplayed.get(0) == j + 1 ? financialCurrentYear
											: motthArray.indexOf(j + 1) < motthArray
													.indexOf(monthToBeDiaplayed
															.get(0)) ? financialCurrentYear
													: financialCurrentBeforeYear);
		}

		monthYearDisp.put("monthDisp", monthDisplayOutput);
		monthYearDisp.put("financialYearDisp", financialYearDisp);
	
		return monthYearDisp;

	}
}
