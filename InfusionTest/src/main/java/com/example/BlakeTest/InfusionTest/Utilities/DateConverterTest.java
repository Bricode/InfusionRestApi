package com.example.BlakeTest.InfusionTest.Utilities;


import org.junit.Test;

import java.time.LocalDateTime;

import static junit.framework.TestCase.assertEquals;

public class DateConverterTest {

  @Test
  public void testDashesHourMinuteDateString() {
    String testValue = "2020-03-05 13:10";
    LocalDateTime expected = LocalDateTime.of(2020,03,05,13,10);
    assertEquals(expected,DateConverter.convertStringToDate(testValue));
  }
  @Test
  public void testDashesReversedHourMinuteDateString() {
    String testValue = "05-03-2020 13:10";
    LocalDateTime expected = LocalDateTime.of(2020,03,05,13,10);
    assertEquals(expected,DateConverter.convertStringToDate(testValue));
  }

  @Test
  public void testDashesDateString() {
    String testValue = "2020-03-05";
    LocalDateTime expected = LocalDateTime.of(2020,03,05,00,00);
    assertEquals(expected,DateConverter.convertStringToDate(testValue));
  }
  @Test
  public void testDashesReversedDateString() {
    String testValue = "05-03-2020";
    LocalDateTime expected = LocalDateTime.of(2020,03,05,00,00);
    assertEquals(expected,DateConverter.convertStringToDate(testValue));
  }
  @Test
  public void testSlashesHourMinuteDateString() {
    String testValue = "2020/03/05 13:10";
    LocalDateTime expected = LocalDateTime.of(2020,03,05,13,10);
    assertEquals(expected,DateConverter.convertStringToDate(testValue));
  }
  @Test
  public void testSlashesDateString() {
    String testValue = "2020/03/05";
    LocalDateTime expected = LocalDateTime.of(2020,03,05,00,00);
    assertEquals(expected,DateConverter.convertStringToDate(testValue));
  }
  @Test
  public void testSlashesReversedDateString() {
    String testValue = "05/03/2020";
    LocalDateTime expected = LocalDateTime.of(2020,03,05,00,00);
    assertEquals(expected,DateConverter.convertStringToDate(testValue));
  }

  @Test
  public void testSlashesReversedHourMinuteDateString() {
    String testValue = "05/03/2020 13:10";
    LocalDateTime expected = LocalDateTime.of(2020,03,05,13,10);
    assertEquals(expected,DateConverter.convertStringToDate(testValue));
  }
}
