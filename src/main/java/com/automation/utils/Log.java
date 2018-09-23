package com.automation.utils;

import org.apache.log4j.Logger;

public class Log {
  // Initialize Log4j logs
  private static Logger log; // = Logger.getLogger(Log.class.getName());

  public static void setLog(Class<?> className) {
    log = Logger.getLogger(className.getName());
  }

  // This is to print log for the beginning of the test case, as we usually
  // run so many test cases as a test suite
  public static void startTestCase(String sTestCaseName) {
    log.info("****************************************************************************************");
    log.info("$$$$$$$$$$$$$$$$$$$$$                 " + sTestCaseName
        + "       $$$$$$$$$$$$$$$$$$$$$$$$$");
    log.info("****************************************************************************************");
  }

  // This is to print log for the ending of the test case
  public static void endTestCase(String sTestCaseName) {
    log.info("XXXXXXXXXXXXXXXXXXXXXXX             " + "-E---N---D-"
        + "             XXXXXXXXXXXXXXXXXXXXXX");
    log.info("X");
    log.info("X");
    log.info("X");
    log.info("X");
  }

  public static void divider(String testId) {
    log.info(testId + "------------------------------------------------------------------");
  }

  // Need to create these methods, so that they can be called
  public static void info(String testId, String message) {
    log.info(testId + " " + message);
  }

  public static void warn(String testId, String message) {
    log.warn(testId + " " + message);
  }

  public static void error(String testId, String message) {
    log.error(testId + " " + message);
  }

  public static void fatal(String testId, String message) {
    log.fatal(testId + " " + message);
  }

  public static void debug(String testId, String message) {
    log.debug(testId + " " + message);
  }

  public static void info(String message) {
    log.info(message);
  }

  public static void warn(String message) {
    log.warn(message);
  }

  public static void error(String message) {
    log.error(message);
  }

  public static void fatal(String message) {
    log.fatal(message);
  }

  public static void debug(String message) {
    log.debug(message);
  }
}
