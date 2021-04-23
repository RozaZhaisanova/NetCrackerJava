package com.netcracker.db;

import com.netcracker.contract.*;
import com.netcracker.person.Person;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.Date;

public class DatabaseParser implements IDatabaseParser {

    public Date convertToDateViaSqlDate(LocalDate dateToConvert) {
        return java.sql.Date.valueOf(dateToConvert);
    }
    /**
     * Метод, устанавливающий соединение с базой данных
     */
    private Connection getDBConnection() {
        FileInputStream dbp = null;
        try {
            dbp = new FileInputStream("src/main/resources/application.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties props = new Properties();
        try {
            props.load(dbp);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String url = props.getProperty("datasource.url");
        String driver = props.getProperty("datasource.driver");
        String username = props.getProperty("datasource.username");
        String password = props.getProperty("datasource.password");

        Connection dbConnection = null;
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(url, username, password);
            return dbConnection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dbConnection;
    }

    /**
     * Метод для сохранения в бд клиентов
     */
    @Override
    public void savePerson(Person person) throws SQLException {
        Connection dbConnection = null;
        final String insertIntoClients = "insert into clients (id, name, surname, birthday) values (?,?,?,?)";
        try {
            dbConnection = getDBConnection();
            PreparedStatement pr = dbConnection.prepareStatement(insertIntoClients);
            pr.setInt(1, person.getID());
            pr.setString(2, person.getName());
            pr.setString(3, person.getSurname());
            pr.setDate(4, java.sql.Date.valueOf(person.getDateOfBirth()));
            pr.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }
    /**
     * Метод для сохранения в бд контрактов
     */
    @Override
    public void saveContract(Contract contract) throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;
        String insertTableSQL;
        Date begin=convertToDateViaSqlDate(contract.getBeginDate());
        Date end=convertToDateViaSqlDate(contract.getEndDate());
        String contractType = contract.getClass().getName().replace("com.netcracker.contract.", "");
        switch (contractType) {
            case "Internet":
                insertTableSQL = "insert into contracts"
                        + "(\"contractId\", "
                        + "\"numberContract\", "
                        + "\"begin\", "
                        + "        \"end\", "
                        + "        \"descriptor\", "
                        + "        \"maxSpeed\", "
                        + "        \"clientId\") " + "values"
                        + "(" + contract.getID() + ", " +
                        contract.getNumber() + ", '" +
                        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.000").format(begin) + "', '" +
                        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.000").format(end) + "', '" +
                        contractType + "', " +
                        ((Internet)contract).getMaxSpeed() + ", " +
                        contract.getClient().getID() + ")";
            break;
            case "Television":
                insertTableSQL = "insert into contracts"
                        + "(\"contractId\", "
                        + "\"numberContract\", "
                        + "\"begin\", "
                        + "        \"end\", "
                        + "        \"channelPackage\", "
                        + "        \"descriptor\", "
                        + "        \"clientId\") " + "values"
                        + "(" + contract.getID() + ", " +
                        contract.getNumber() + ", '" +
                        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.000").format(begin) + "', '" +
                        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.000").format(end) + "', '" +
                        ((Television) contract).getChannelPackage().toString() + "', '" +
                        contractType + "', " +
                        contract.getClient().getID() + ")";
                break;
            case "Mobile":
                insertTableSQL = "insert into contracts"
                        + "(\"contractId\", "
                        + "\"numberContract\", "
                        + "\"begin\", "
                        + "        \"end\", "
                        + "        \"descriptor\", "
                        + "        \"min\", "
                        + "        \"sms\", "
                        + "        \"mb\", "
                        + "        \"clientId\") " + "values"
                        + "(" + contract.getID() + ", " +
                        contract.getNumber() + ", '" +
                        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.000").format(begin) + "', '" +
                        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.000").format(end) + "', '" +
                        contractType + "', " +
                        ((Mobile) contract).getMin() + ", " +
                        ((Mobile) contract).getSms() + ", " +
                        ((Mobile) contract).getMb() + ", " +
                        contract.getClient().getID() + ")";
                break;
            default:
                throw new IllegalStateException("Unexpected value");
        }
        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();
            statement.execute(insertTableSQL);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }
    /**
     * Метод восстанавливающий из бд контракты
     */
    @Override
    public void  getAllContracts() throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;
        String selectTableSQL = "select * from contracts c1 left join clients c on c1.\"clientId\" = c.id";
        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                System.out.print(rs.getString(1) + " ");
                System.out.print(rs.getString(2) + " ");
                System.out.print(rs.getString(3) + " ");
                System.out.print(rs.getString(4) + " ");
                System.out.print(rs.getString(5) + " ");
                System.out.print(rs.getString(6) + " ");
                System.out.print(rs.getString(7) + " ");
                System.out.print(rs.getString(8) + " ");
                System.out.println(rs.getString(9) + " ");

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }
    /**
     * Метод восстанавливающий из бд клиентов
     */
    @Override
    public void getAllClients() throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;
        String selectTableSQL = "select c.* from clients c";
        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                System.out.print(rs.getString(1) + " ");
                System.out.print(rs.getString(2) + " ");
                System.out.print(rs.getString(3) + " ");
                System.out.println(rs.getString(4) + " ");


            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }

    }



}