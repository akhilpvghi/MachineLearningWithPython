package com.quincus.Models;

import lombok.Data;

import java.util.ArrayList;
@Data
public class InputJSONStructure {
    private Location start_point;
    private ArrayList<ProgressData> on_progress;
}
