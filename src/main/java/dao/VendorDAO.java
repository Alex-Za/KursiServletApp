package dao;

import entities.Country;
import entities.Vendor;
import exception.CantFindCountryException;
import exception.CantFindVendorException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendorDAO {
    private Connection connection;

    public VendorDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Vendor> findById(int countryId) throws CantFindVendorException {
        try {
            List<Vendor> result = new ArrayList<>();
            PreparedStatement ps = connection.prepareStatement("select * from vendor where country_id = "+countryId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                result.add(new Vendor(id, name, countryId));
            }
            return result;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new CantFindVendorException(throwables);
        }
    }
}
