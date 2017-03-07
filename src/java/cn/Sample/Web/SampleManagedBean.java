/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.Sample.Web;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;


/**
 *
 * @author ShinRu
 */
@Named(value = "sampleManagedBean")
@RequestScoped
@ManagedBean
public class SampleManagedBean {
    
    private String name;
    private int age;

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
     
    public SampleManagedBean() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    @PostConstruct		
    public void init(){		
    }
    
    public String send(){
        this.name = "";
        return "";
    }		
}
