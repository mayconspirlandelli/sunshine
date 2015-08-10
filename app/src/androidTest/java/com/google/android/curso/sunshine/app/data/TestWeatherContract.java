package com.google.android.curso.sunshine.app.data;

/**
 * Created by Maycon on 17/03/2015.
 */
import android.net.Uri;
import android.test.AndroidTestCase;
import android.util.Log;

/*
    Students: This is NOT a complete test for the WeatherContract --- just for the functions
    that we expect you to write.
 */
public class TestWeatherContract extends AndroidTestCase {

    public static final String LOG_CAT = TestWeatherContract.class.getSimpleName();

    // intentionally includes a slash to make sure Uri is getting quoted correctly
    private static final String TEST_WEATHER_LOCATION = "/North Pole";
    private static final long TEST_WEATHER_DATE = 1419033600L;  // December 20th, 2014

    /*
        Students: Uncomment this out to test your weather location function.
     */
    public void testBuildWeatherLocation() {
        Uri locationUri = WeatherContract.WeatherEntry.buildWeatherLocation(TEST_WEATHER_LOCATION);
        assertNotNull("Error: Null Uri returned.  You must fill-in buildWeatherLocation in " +
                        "WeatherContract.",
                locationUri);
        assertEquals("Error: Weather location not properly appended to the end of the Uri",
                TEST_WEATHER_LOCATION, locationUri.getLastPathSegment());
        assertEquals("Error: Weather location Uri doesn't match our expected result",
                locationUri.toString(),
                "content://com.example.android.sunshine.app/weather/%2FNorth%20Pole");
    }

    public void testBuildWeatherLocationWithDate(){
        Uri locationUri = WeatherContract.WeatherEntry.buildWeatherLocationWithDate(TEST_WEATHER_LOCATION, TEST_WEATHER_DATE);

        assertNotNull("Error: Null Uri returned.  You must fill-in buildWeatherLocation in " +
                        "WeatherContract.",
                locationUri);

        assertEquals("Error: Weather location Uri doesn't match our expected result",
                locationUri.toString(),
                "content://com.google.android.curso.sunshine.app/weather/%2FNorth%20Pole/1393200000");

        Log.d(LOG_CAT, locationUri.toString());

    }

    public void testBuildWeatherLocationWithStartDate(){
        Uri locationUri = WeatherContract.WeatherEntry.buildWeatherLocationWithStartDate(TEST_WEATHER_LOCATION, TEST_WEATHER_DATE);

        assertNotNull("Error: Null Uri returned.  You must fill-in buildWeatherLocation in " +
                        "WeatherContract.",
                locationUri);

        assertEquals("Error: Weather location Uri doesn't match our expected result",
                locationUri.toString(),
                "content://com.google.android.curso.sunshine.app/weather/%2FNorth%20Pole?date=1393200000");

        Log.d(LOG_CAT, locationUri.toString());

    }
}