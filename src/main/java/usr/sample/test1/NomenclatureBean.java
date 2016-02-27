package usr.sample.test1;

import usr.sample.entity.Nomenclature;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vallon on 2016.02.22.
 */
@ManagedBean(name = "nomenclatureBean")
@SessionScoped
public class NomenclatureBean {

    private List<Nomenclature> nomenclatures;
    private List<Nomenclature> filteredNomenclatures;
    private Nomenclature selectedNomenclature;

    public void initDBConnection() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String query = "SELECT id, name, comment FROM nomenclature WHERE id > ?";

        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/testdb1", "postgres", "a1");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, 0);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                nomenclatures.add(new Nomenclature(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3)));
            }
            resultSet.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public NomenclatureBean() {
        nomenclatures = new ArrayList<Nomenclature>();
        filteredNomenclatures = new ArrayList<Nomenclature>();
        initDBConnection();
        //nomenclatures.add(new Nomenclature("name1","desc1"));
        //nomenclatures.add(new Nomenclature("name2","desc2"));
    }

    public List<Nomenclature> getNomenclatures() {
        return nomenclatures;
    }

    public Nomenclature getSelectedNomenclature() {
        return selectedNomenclature;
    }

    public void setSelectedNomenclature(Nomenclature selectedNomenclature) {
        this.selectedNomenclature = selectedNomenclature;
    }

    public List<Nomenclature> getFilteredNomenclatures() {
        return filteredNomenclatures;
    }

    public void setFilteredNomenclatures(List<Nomenclature> filteredNomenclatures) {
        this.filteredNomenclatures = filteredNomenclatures;
    }
}
