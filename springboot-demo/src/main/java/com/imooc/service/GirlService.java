package com.imooc.service;

import com.imooc.repository.GirlRepository;
import com.imooc.domain.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void inserTwo(){
        Girl girl=new Girl();
        girl.setAge(22);
        girl.setCupSize("33");
        girl.setId(22);
        girlRepository.save(girl);
        girl.setAge(33);
        girl.setCupSize("33");
        girl.setId(33);
        girlRepository.save(girl);
    }
}
