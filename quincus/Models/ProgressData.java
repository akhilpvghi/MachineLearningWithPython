package com.quincus.Models;

import lombok.Data;

@Data
public class ProgressData {
    private String shipment_code;
    private String task_code;
    private Address location;
    private Integer volume;
}
