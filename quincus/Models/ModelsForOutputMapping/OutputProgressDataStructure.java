package com.quincus.Models.ModelsForOutputMapping;

import lombok.Data;

@Data
public class OutputProgressDataStructure {
    private String shipment_code;
    private String task_code;
    private String sequence;
    private String status;
    private OutputAddress location;
}
