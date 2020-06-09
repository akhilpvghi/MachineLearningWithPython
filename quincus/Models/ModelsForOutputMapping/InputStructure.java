package com.quincus.Models.ModelsForOutputMapping;

import com.quincus.Models.ModelsForOutputMapping.ShipRoute;
import lombok.Data;

import java.util.ArrayList;

@Data
public class InputStructure {
    private String job_id;
    private String job_name;
    private Double cost;
    private ArrayList<String> missedIds;
    private ArrayList<String> errorPackages;
    private ArrayList<ShipRoute> routes;
}
