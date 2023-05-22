package com.example.BlakeTest.InfusionTest.Utilities;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;
import java.util.Arrays;
import java.util.List;

public final class DateConverter {
  private DateConverter(){}

  public static LocalDateTime convertStringToDate(String incomingString) {
    DateTimeFormatter fmt = new DateTimeFormatterBuilder()
      .appendPattern("[yyyy-MM-dd][yyyy/MM/dd][dd-MM-yyyy][dd/MM/yyyy]")
      .optionalStart()
      .appendPattern(" HH:mm")
      .optionalEnd()
      .parseDefaulting(ChronoField.HOUR_OF_DAY,0)
      .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
      .toFormatter();

    LocalDateTime dateTime = null;
    dateTime = LocalDateTime.parse(incomingString, fmt);

    if (dateTime != null) {
      return dateTime;
    } else {
      return null;
    }
  }
}
