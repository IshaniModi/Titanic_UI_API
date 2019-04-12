package com.titanic.controller;

import com.titanic.entity.Passenger;
import com.titanic.service.IPassengerImplementation;
import com.titanic.util.CSVUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "")
public class FileController {
    @Autowired
    IPassengerImplementation passengerService;

    @RequestMapping(value = "/passenger",consumes = MediaType.TEXT_PLAIN_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Passenger> ProcessCSV(@RequestBody String strFile) {


    String strFileName = strFile;//"C:\\Users\\ishan\\Desktop\\titanic\\passenger.csv";
    List<Passenger> passengers = CSVUtil.readCsv(strFileName);
         return  passengerService.Create(passengers);

    }


}

