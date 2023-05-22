package com.example.BlakeTest.InfusionTest.Utilities;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;

public final class DateConverter {
  private DateConverter(){}

  public static LocalDateTime convertStringToDate(String incomingString) {
    List<DateTimeFormatter> formatterList = Arrays.asList(
      DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"),
      DateTimeFormatter.ofPattern("yyyy/MM/dd"),
      DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"),
      DateTimeFormatter.ofPattern("dd/MM/yyyy"),
      DateTimeFormatter.ofPattern("dd-MM-yyyy"),
      DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"),
      DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"),
      DateTimeFormatter.ofPattern("yyyy-MM-dd")
    );

    LocalDateTime dateTime = null;
    for (DateTimeFormatter formatter: formatterList) {
      try {
        dateTime = LocalDateTime.parse(incomingString, formatter);
      } catch (DateTimeParseException e) {

      }
    }
    if (dateTime != null) {
      return dateTime;
    } else {
      LocalDateTime now = LocalDateTime.now();
      return now;
    }
  }
}
