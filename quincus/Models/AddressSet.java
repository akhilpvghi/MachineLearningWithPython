package com.quincus.Models;

import lombok.Data;

import java.util.ArrayList;

@Data
public class AddressSet {
    private ArrayList<GeocodeStructure> addresses;
}
