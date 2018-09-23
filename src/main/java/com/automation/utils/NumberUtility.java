package com.automation.utils;

import java.text.DecimalFormat;

import org.apache.commons.lang.StringUtils;

public class NumberUtility {

  // This string contains amount with comma eg -> 3,337.65
  public static double getAmountFromString(String str) {

    double value = 0;
    str = StringUtils.trimToEmpty(str);
    if (StringUtils.isEmpty(str)) {
      return value;
    }

    str = StringUtils.remove(str, ",");
    value = Double.parseDouble(str);

    return value;
  }

  public static String getRoundedAmount(double value) {
    DecimalFormat df = new DecimalFormat("#####.##");
    return df.format(value);
  }
}
