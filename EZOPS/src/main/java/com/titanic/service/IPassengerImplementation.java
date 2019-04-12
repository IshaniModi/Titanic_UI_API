package com.titanic.service;

import com.titanic.entity.Passenger;
import org.springframework.data.domain.Page;
import java.util.List;
import java.util.Map;

public interface IPassengerImplementation {
    public List<Passenger> findAll();
    List<Passenger> Create(List<Passenger> objPassenger);
    public Page<Passenger> FindByCondition(String orderBy, String direction, int page, int size);
    public Page<Passenger> FindBynameLike(String strName1,String strOrderBy,String direction, int page, int size);
    public Map<String, Long> CountByData(String columnname, String groupby);

}
