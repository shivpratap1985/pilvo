package com.automation.utils;

import java.util.Calendar;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class FileHandler {


  public static void getDate(WebDriver driver, String fromDateId, int addDays) {
    Calendar date = CalendarUtils.getCalendarIncrementedByDays(addDays);
    String dateString = CalendarUtils.getDateInFormat(date, Constant.DD_MM_YYYY);
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("document.getElementById('" + fromDateId + "').value='" + dateString + "';");
  }


}
