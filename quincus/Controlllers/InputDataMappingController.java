package com.quincus.Controlllers;

import com.google.gson.JsonParseException;
import com.quincus.Constants.Constants;
import com.quincus.Models.*;
import com.quincus.Models.ModelsForOutputMapping.InputStructure;
import com.quincus.Services.PopulateGeoCodeDataServiceImpl;
import com.quincus.Services.PopulateOutputStructureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InputDataMappingController {

    @Autowired
    PopulateGeoCodeDataServiceImpl fillJson;

    @Autowired
    PopulateOutputStructureService fillOutputJson;


    @PostMapping(path = "/formatInput",
            consumes = "application/json",
            produces = "application/json")
    public ResponseEntity<String> addMember(@RequestBody InputTopLayer member) {

        String jsonString = "";
        try {
            jsonString = fillJson.setPopulateGeoCodeData(member);
            return ResponseEntity.status(Constants.OK.getIntValue()).body(jsonString);
        } catch (JsonParseException jpe) {
            return ResponseEntity.status(Constants.HTTP_BAD_REQUEST.getIntValue()).body(jpe.toString());
        } catch (Exception e) {
            System.out.println(e);
        }
//        return "";
        return ResponseEntity.status(Constants.HTTP_BAD_REQUEST.getIntValue()).body("error");
    }

    @PostMapping(path = "/formatOutput",
            consumes = "application/json",
            produces = "application/json")
    public ResponseEntity<String> formatOutput(@RequestBody InputStructure data) {
        String jsonString ="";
        try {
            jsonString=fillOutputJson.setOutputData(data);
            return  ResponseEntity.status(Constants.OK.getIntValue()).body(jsonString);
        }catch (JsonParseException jpe) {
            return  ResponseEntity.status(Constants.HTTP_BAD_REQUEST.getIntValue()).body(jpe.toString());
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return ResponseEntity.status(Constants.HTTP_BAD_REQUEST.getIntValue()).body("error");
    }
}
