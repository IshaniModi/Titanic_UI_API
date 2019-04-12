package com.titanic.controller;

import com.titanic.entity.Passenger;
import com.titanic.service.IPassengerImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping(value = "")
public class PagingSortingSearchingController {
    @Autowired
    IPassengerImplementation passengerService;

    @RequestMapping(method = RequestMethod.GET, value = "filterbyname/{name1}/{orderby}/{sort}/{page}/{size}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Page<Passenger> PagingSorting(@PathVariable("name1") String strName1,@PathVariable("orderby") String strOrderby, @PathVariable("sort") String strSort, @PathVariable("page") int iPage, @PathVariable("size") int iSize)
    {        return passengerService.FindBynameLike(strName1,strOrderby,strSort,iPage,iSize);    }


    @RequestMapping(method = RequestMethod.GET, value = "filter/{orderby}/{sort}/{page}/{size}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Page<Passenger> PagingSorting(@PathVariable("orderby") String strOrderby, @PathVariable("sort") String strSort, @PathVariable("page") int iPage, @PathVariable("size") int iSize)
    { return passengerService.FindByCondition(strOrderby,strSort,iPage,iSize);    }

    @RequestMapping(method = RequestMethod.GET, value = "count/{columnname}/{groupby}/{sort}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Map<String, Long> Count(@PathVariable("columnname") String columnname, @PathVariable("groupby") String groupby, @PathVariable("sort") String strSort)
    {
        return passengerService.CountByData(columnname,groupby);

    }

}
