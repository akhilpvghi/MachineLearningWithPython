package com.quincus.Models;

import lombok.Data;

import java.util.ArrayList;
@Data
public class IndonesiaInputStructure {
    private Location start_point;
    private ArrayList<ProgressData> on_progress;
}
