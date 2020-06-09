package com.quincus.Constants;

public enum Constants {
    dispatch_code("INITIAL"),
    delivery_country("INDONESIA"),
    pickup_service_time("240"),
    delivery_service_time("240"),
    delivery_commit_time("17:00:00 PM"),
    delivery_start_time_timezone("GMT+07:00"),
    status("OK"),
    HTTP_BAD_REQUEST(400),
     OK(200);
    private String value;
    private int int_value;

    public String getValue()
    {
        return this.value;
    }
    public int getIntValue()
    {
        return this.int_value;
    }

    private Constants(String keyValue)
    {
        this.value = keyValue;
    }
    private Constants(int keyValueInt)
    {
        this.int_value = keyValueInt;
    }
}
