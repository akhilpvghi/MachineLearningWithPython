package com.quincus.Services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.quincus.Constants.Constants;
import com.quincus.Models.*;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Component
public class PopulateGeoCodeDataServiceImpl {

    public String setPopulateGeoCodeData(InputTopLayer member) {
        InputTopLayer requestData = null;
        AddressSet indoAddrSet = new AddressSet();
        Gson gson = new GsonBuilder()
                .serializeNulls()
                .create();
        String jsonString = "";
        DateFormat df = new SimpleDateFormat("dd/MM/yy");
        DateFormat tf = new SimpleDateFormat("HH:mm:ss");
        Date dateobj = new Date();
        requestData = member;
        ArrayList<GeocodeStructure> indoDataSet = new ArrayList<GeocodeStructure>();
        String startLat = requestData.getData().getStart_point().getLatitude().toString();
        String startLong = requestData.getData().getStart_point().getLongitude().toString();
        for (ProgressData part : requestData.getData().getOn_progress()) {
            String serviceType = getServiceType(part.getTask_code());
            GeocodeStructure indoDataSetSingle = new GeocodeStructure();
            indoDataSetSingle.setPickup_longitude(getPickupLocation(serviceType, startLong));
            indoDataSetSingle.setPickup_latitude(getPickupLocation(serviceType, startLat));
            indoDataSetSingle.setOrder_date(df.format(dateobj));
            indoDataSetSingle.setOrder_time(tf.format(dateobj));
            indoDataSetSingle.setId(part.getShipment_code()+"SmergedT"+part.getTask_code());
            indoDataSetSingle.setService_type(serviceType);
            indoDataSetSingle.setVolume(part.getVolume().toString());
            indoDataSetSingle.setDelivery_start_time_timezone(Constants.delivery_start_time_timezone.getValue());
            indoDataSetSingle.setDelivery_commit_time(Constants.delivery_commit_time.getValue());
            indoDataSetSingle.setDelivery_country(Constants.delivery_country.getValue());
            indoDataSetSingle.setDispatch_code(Constants.dispatch_code.getValue());
            indoDataSetSingle.setDepot_latitude(startLat);
            indoDataSetSingle.setDepot_longitude(startLong);
            indoDataSetSingle.setPickup_service_time(Constants.pickup_service_time.getValue());
            indoDataSetSingle.setDelivery_service_time(Constants.delivery_service_time.getValue());
            indoDataSet.add(indoDataSetSingle);
        }
        indoAddrSet.setAddresses(indoDataSet);
        jsonString = gson.toJson(indoAddrSet);
        return jsonString;
    }


    private String getServiceType(String service_type) {
        String valuated_service_type = "";
        valuated_service_type = service_type.substring(0, 2).contains("LD") ? "DELIVERY" : "PICKUP";
        return valuated_service_type;
    }

    private String getPickupLocation(String service_type, String startLoc) {
        String valuated_pickupLoc = "";
        valuated_pickupLoc = service_type.substring(0, 5).contains("DELIV") ? startLoc : "";
        return valuated_pickupLoc;
    }
}
