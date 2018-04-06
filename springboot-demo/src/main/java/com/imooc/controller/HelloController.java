package com.imooc.controller;

import com.imooc.properties.GirlProperties;
import com.imooc.repository.GirlRepository;
import com.imooc.service.GirlService;
import com.imooc.domain.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloController {
    @Autowired
    GirlService girlService;
@Autowired
GirlProperties girlProperties;
    @Autowired
    private GirlRepository girlRepository;

    @Value("${cupSize}")
    private String cupSize;

@RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String say(){
        return cupSize;
    }

    @RequestMapping(value = "/hello2",method = RequestMethod.GET)
    public String say2(){
        return girlProperties.getSize();
    }

    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
     return girlRepository.findAll();
    }

    @PostMapping(value = "/girls")
    public Girl girlAdd(Girl gril){
        return girlRepository.save(gril);
    }

    @GetMapping(value = "/girls/{id}")
    public Girl girlFind(@PathVariable("id")Integer id){
        return girlRepository.findOne(id);
    }

    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id")Integer id,String cupSize,Integer age){
    Girl girl=new Girl();
    girl.setAge(age);
    girl.setCupSize(cupSize);
    girl.setId(id);
        return girlRepository.save(girl);
    }

    @DeleteMapping(value = "/girls/{id}")
    public void girlDelete(@PathVariable("id")Integer id){
        girlRepository.delete(id);
    }

    @GetMapping(value = "/girls/age/{age}")
    public List<Girl>  girlListByAge(@PathVariable("age")Integer age){
        return girlRepository.findByAge(age);
    }

    @PostMapping(value="/girls/two")
    public void girlTwo(){
    girlService.inserTwo();
    }
}
