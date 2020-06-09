package com.quincus.Services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.quincus.Constants.Constants;
import com.quincus.Models.ModelsForOutputMapping.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class PopulateOutputStructureService  {


    public String setOutputData(InputStructure outputData){
        String jsonString ="";
        String[] code ;
        OutputAddress oa = new OutputAddress();
        OutputTopLayer otp = new OutputTopLayer();
        OutputProgressDataStructure opdss = new OutputProgressDataStructure();
        OutputProgressData opd = new OutputProgressData();

        ArrayList<OutputProgressDataStructure> opds =new ArrayList<OutputProgressDataStructure>();
        Gson gson = new GsonBuilder()
                .serializeNulls()
                .create();
        InputStructure requestData = null;
        requestData = outputData;
        for (InputShipment part : requestData.getRoutes().get(0).getShips()) {
            code = getShipment_code(part.getId());
            opdss.setShipment_code(code[0]);
            opdss.setTask_code(code[1]);
            opdss.setStatus(Constants.status.getValue());
            opdss.setSequence(part.getHandling_id());
            oa.setAddress(part.getDelivery_address());
            oa.setLatitude(part.getDelivery_latitude());
            oa.setLongitude(part.getDelivery_longitude());

            opdss.setLocation(oa);
            opds.add(opdss);
            }
        opd.setOn_progress(opds);
        otp.setData(opd);
        jsonString=gson.toJson(otp);
        return jsonString;
    }

    private String[] getShipment_code(String code){
        String[] shipment_code;
        shipment_code=code.split("SmergedT");
        return shipment_code;
    }

}
