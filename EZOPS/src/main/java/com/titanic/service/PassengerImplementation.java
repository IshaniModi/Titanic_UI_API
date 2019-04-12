package com.titanic.service;

import com.titanic.entity.Passenger;
import com.titanic.exception.BadRequestException;
import com.titanic.repository.IPassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PassengerImplementation implements IPassengerImplementation {
    @Autowired
    private IPassengerRepository repository;

    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<Passenger> findAll() {

        List<Passenger> passenger = (List<Passenger>) repository.findAll();

        return passenger;
    }

    @Override
    @Transactional
    public List<Passenger> Create(List<Passenger> objPassenger) {
        Iterable<Passenger> passenger = repository.saveAll ( objPassenger );

        if(passenger == null)
        {
            throw new BadRequestException("Passenger  not created successfully");
        }
        return (List<Passenger>)passenger;
    }

    @Override
    public Page<Passenger> FindByCondition(String orderBy, String direction, int page, int size) {
        Sort sort = null;
            sort =  new Sort(Sort.Direction.ASC, orderBy);
        if (direction.equals("DESC")) {
            sort = new Sort(Sort.Direction.DESC, orderBy);
        }
        Pageable pageable = PageRequest.of(page,size);
        Page<Passenger> pageObj = repository.findAll(pageable);
        return pageObj;
    }

    @Override
    public Page<Passenger> FindBynameLike( String strName1,String strOrderBy,String direction, int page, int size)
    {
         Sort sort = null;
         sort =  new Sort(Sort.Direction.ASC,strOrderBy);
        if (direction.equals("DESC")) {
            sort = new Sort(Sort.Direction.DESC,strOrderBy);
        }
        Pageable pageable = PageRequest.of(page,size,sort);
        Page<Passenger> pageObj = repository.findByName1IsLike( "%"+strName1+"%",pageable);
        if(pageable.getPageNumber() <= page)  return pageObj; else return null;

    }

    @Override
    public Map<String, Long> CountByData(String columnname, String groupby) {
        Query query = entityManager.createQuery("Select p."+ columnname+" , count(*) as countvar from Passenger p group by p."+groupby);
        List<Object[]> listObj = query.getResultList();
        Map<String, Long> map = null;
        if(listObj.size() != 0){
            map = new HashMap<String, Long>();
            for (Object[] object : listObj) {
                map.put(object[0].toString(),(Long)object[1]);
            }
        }
        return map;
    }
}
