# InfusionRestApi

This is the readme for a test web api using spring boot that I am completing for Infusion.

The process to run this project is to run the "InfusionTestApplication"

# UnitTests
To ensure that the date range is working,
Hit the end point without date range specified. Check that all sessions were returned.
Hit the end point with two correct datetime. Check returned array start dates are within dates passed.
Hit the end point with an impossible daterange (latest timestamp is before earliest timestamp). Check that no records were returned.


