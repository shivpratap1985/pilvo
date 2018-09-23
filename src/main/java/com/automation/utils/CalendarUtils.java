package com.automation.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.TimeZone;

import org.apache.http.client.utils.DateUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CalendarUtils {

  public static Calendar getCalendarIncrementedByDays(int daysIncrement) {
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.DATE, daysIncrement);
    return calendar;
  }

  public static String getCurrentTime(String timeFormat) {
    return new SimpleDateFormat(timeFormat).format(Calendar.getInstance().getTime());
  }

  public static String getDateInFormat(Calendar calendar, String format) {
    DateFormat formatter = new SimpleDateFormat(format);
    formatter.setCalendar(calendar);
    formatter.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));
    return formatter.format(calendar.getTime());
  }

  public static String getFormattedTime(Calendar calendar) {
    DateFormat formatter = new SimpleDateFormat("HH:mm");
    formatter.setCalendar(calendar);
    formatter.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));
    return formatter.format(calendar.getTime());
  }

  public static String getStringDate() {

    Calendar calendar = Calendar.getInstance();
    String format = "MM-dd-yyyy";
    String currentDate = DateUtils.formatDate(calendar.getTime(), format);
    return currentDate;

  }

  public static void entryDateJS(WebDriver driver, String fromCal, String toCal) {

    Calendar calendar = Calendar.getInstance();
    String format = "dd/MM/yyyy";
    String currentDate = DateUtils.formatDate(calendar.getTime(), format);
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("document.getElementById('" + fromCal + "').value='" + currentDate + "';");
    js.executeScript("document.getElementById('" + toCal + "').value='" + currentDate + "';");

  }
  
  public static String getCurrentDate(String format) {
    return LocalDateTime.now().format(DateTimeFormatter.ofPattern(format));
  }
}
