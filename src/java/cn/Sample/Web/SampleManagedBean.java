package cn.Sample.Web;

import java.sql.SQLException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

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
    public void init() {
    }

    public String send() {
        JDBCSampleBean jdbcsb = new JDBCSampleBean();
        try {
            List<SampleModel> list = jdbcsb.getNameList(Long.parseLong(name));
            if (list != null) {
                this.name = "result is null";
                return "";
            }
            this.name = list.get(0).getName();
        } catch (SQLException e) {
            this.name = e.getMessage();
        }
        return "";
    }
}
