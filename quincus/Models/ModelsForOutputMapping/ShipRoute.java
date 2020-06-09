package com.quincus.Models.ModelsForOutputMapping;

import lombok.Data;

import java.util.ArrayList;

@Data
public class ShipRoute {
    private String driverId;
    private String vehicleId;
    private String lat;
    private String lon;
    private String driverName;
    private ArrayList<InputShipment> ships;
}
