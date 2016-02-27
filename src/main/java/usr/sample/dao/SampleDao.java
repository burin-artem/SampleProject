package usr.sample.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import usr.sample.entity.Nomenclature;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

@ComponentScan("usr.sample.test1")
public class SampleDao {

    @Autowired
    private DataSource dataSource;

    public void insert(){

        String sql = "INSERT INTO nomenclature " +
                "(id, name, comment) VALUES ((select max(id)+1 from nomenclature), ?, ?)";
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            //ps.setInt(1, 1);
            ps.setString(1, "aaa " + Math.random());
            ps.setString(2, "bbb " + Math.random());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
    }

    public List<Nomenclature> getNomenclatureList() {
        List<Nomenclature> res = new ArrayList<Nomenclature>();
        String query = "SELECT id, name, comment FROM nomenclature WHERE id > ?";
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, 0);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                res.add(new Nomenclature(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3)));
            }
            resultSet.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

 /*   public Customer findByCustomerId(int custId){

        String sql = "SELECT * FROM CUSTOMER WHERE CUST_ID = ?";

        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, custId);
            Customer customer = null;
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                customer = new Customer(
                        rs.getInt("CUST_ID"),
                        rs.getString("NAME"),
                        rs.getInt("Age")
                );
            }
            rs.close();
            ps.close();
            return customer;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
    }*/
}
