package com.quincus.Controlllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.quincus.Models.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class IndoDataMapping implements APIInterfaces {
    String jsonString ="";
    private static IndoDataMapping algoAPIObject = new IndoDataMapping();
    private static IndonesiaAddressSet indoAddrSet = new IndonesiaAddressSet();
    Gson gson = new GsonBuilder()
            .serializeNulls()
            .create();
    IndonesiaInput requestData = null;

    @Override
    public IndonesiaInput saveUpdatePerson(IndonesiaInput person) {
        requestData = person;
        return requestData;
    }

    public String getServiceType(String service_type){
        String valuated_service_type="";
        valuated_service_type=service_type.substring(0,2).contains("LD") ?  "DELIVERY" : "PICKUP";
        return valuated_service_type;
    }

    @PostMapping(path = "/mapIndoData", consumes = "application/json", produces = "application/json")
    public String addMember(@RequestBody IndonesiaInput member) {
         ArrayList<IndonesiaDataset> indoDataSet = new ArrayList<IndonesiaDataset>();
        try {
            requestData = algoAPIObject.saveUpdatePerson(member);
            for (ProgressData part : requestData.getData().getOn_progress()) {
                IndonesiaDataset indoDataSetSingle = new IndonesiaDataset();
                indoDataSetSingle.setId(part.getShipment_code());
                indoDataSetSingle.setService_type(getServiceType(part.getTask_code()));
                indoDataSetSingle.setVolume(part.getVolume().toString());
                indoDataSet.add(indoDataSetSingle);
            }
            indoAddrSet.setAddresses(indoDataSet);
            jsonString = gson.toJson(indoAddrSet);
            return jsonString;


        } catch (Exception e) {
            System.out.println(e);
        }
        return "";

    }
}
