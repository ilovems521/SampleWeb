/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.Sample.Web;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author ShinRu
 */
@Named(value = "jDBCSampleBean")
@SessionScoped
public class JDBCSampleBean implements Serializable {

    private DataSource dataSource;

    public JDBCSampleBean() {
        try {
            Context context = new InitialContext();
            dataSource = (DataSource) context.lookup("java:app/jdbc/myDatasource");
        } catch (NamingException e) {
        }
    }

    //@Resource(name = "jdbc/MySQLDataSource")
    public List<SampleModel> getNameList(Long userid) throws SQLException {
        if (dataSource == null) {
            throw new SQLException("Can't get data source");
        }

        Connection conn = dataSource.getConnection();

        if (conn == null) {
            throw new SQLException("Can't get database connection");
        }

        String sql = "select user_id , user_name from sample_web_db where user_id = ?";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, userid);

        ResultSet result = ps.executeQuery();

        List<SampleModel> list = new ArrayList<SampleModel>();

        if (result == null) {
            return null;
        }

        while (result.next()) {
            SampleModel sampleModel = new SampleModel();
            sampleModel.setUserid(result.getLong("user_id"));
            sampleModel.setName(result.getString("user_name"));
            list.add(sampleModel);
        }

        return list;
    }

}
