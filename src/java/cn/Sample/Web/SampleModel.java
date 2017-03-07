/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.Sample.Web;

/**
 *
 * @author ShinRu
 */
public class SampleModel {
    
    public long user_id
;    
    public String user_name;
    
    public void setUserid(long userid) {
        this.user_id = userid;
    }

    public long getUserid() {
        return user_id;
    }
    
    public void setName(String name) {
        this.user_name = name;
    }

    public String getName() {
        return user_name;
    }

}
