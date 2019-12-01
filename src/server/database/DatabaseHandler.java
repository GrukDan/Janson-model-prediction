package server.database;

import client.Objects.User;
import server.database.entities.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends DatabaseConfig {

    Connection dbConection;

    public Connection getDbConection() {

        String connectionURL = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            dbConection = DriverManager.getConnection(connectionURL, dbUser, dbPass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dbConection;
    }

    public boolean registrationUser(User user) {

        if (getUserByLoginAndPassword(user.getLogin(), user.getPassword()) == null) {
            String insertSQL = "INSERT INTO " + UserEntity.USER_TABLE + "(" +
                    UserEntity.NAME + "," + UserEntity.SURNAME + "," + UserEntity.ROLE + "," +
                    UserEntity.LOGIN + "," + UserEntity.PASSWORD + ")" + " VALUES (?,?,?,?,?)";
            try {
                PreparedStatement preparedStatement = getDbConection().prepareStatement(insertSQL);
                preparedStatement.setString(1, user.getName());
                preparedStatement.setString(2, user.getSurname());
                preparedStatement.setString(3, user.getRole());
                preparedStatement.setString(4, user.getLogin());
                preparedStatement.setString(5, user.getPassword());

                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return true;
        } else return false;
    }

    public boolean saveData(List<Record> records) {

        if (records.size() != 0) {
            try {

                for (Record record : records) {
                    String deleteSQL = "DELETE FROM " + FundEntity.FUND_TABLE + " WHERE " + FundEntity.DATE + "!=?";
                    PreparedStatement preparedStatement = getDbConection().prepareStatement(deleteSQL);
                    preparedStatement.setDate(1, new java.sql.Date(record.getDate().getTime()));
                    preparedStatement.executeUpdate();
                }
                for (Record record : records) {

                    //fund-table insert
                    String saveSQL = "REPLACE  INTO " + FundEntity.FUND_TABLE + "(" +
                            FundEntity.DATE + "," +
                            FundEntity.CASH + "," +
                            FundEntity.PAYMENT_ACCOUNT + "," +
                            FundEntity.CURRENCY_ACCOUNT + ")" + "VALUES(?,?,?,?);";
                    PreparedStatement preparedStatement = getDbConection().prepareStatement(saveSQL);
                    preparedStatement.setDate(1, new java.sql.Date(record.getDate().getTime()));
                    preparedStatement.setDouble(2, record.getCash());
                    preparedStatement.setDouble(3, record.getPaymentAccount());
                    preparedStatement.setDouble(4, record.getCurrencyAccount());
                    preparedStatement.executeUpdate();

                    //sources table insert
                    saveSQL = "REPLACE  INTO " + SourcesOfEquityEntity.SOURCES_OF_EQUITY_TABLE + "(" +
                            SourcesOfEquityEntity.DATE + "," +
                            SourcesOfEquityEntity.AUTHORIZED_CAPITAL + "," +
                            SourcesOfEquityEntity.UNDISTRIBUTED_PROFITS + "," +
                            SourcesOfEquityEntity.RESERVES + "," +
                            SourcesOfEquityEntity.SINKING_FUND +
                            ")" + "VALUES(?,?,?,?,?);";
                    preparedStatement = getDbConection().prepareStatement(saveSQL);
                    preparedStatement.setDate(1, new java.sql.Date(record.getDate().getTime()));
                    preparedStatement.setDouble(2, record.getAuthorizedCapital());
                    preparedStatement.setDouble(3, record.getUndesterbutedProfits());
                    preparedStatement.setDouble(4, record.getReserves());
                    preparedStatement.setDouble(5, record.getSinkingFund());
                    preparedStatement.executeUpdate();

                    //liquid_parameters insert
                    saveSQL = "REPLACE  INTO " + LiquidParamEntity.LIQUID_PARAM_TABLE + "(" +
                            LiquidParamEntity.DATE + "," +
                            LiquidParamEntity.ACCOUNT_RECEIV + "," +
                            LiquidParamEntity.SECURITES +
                            ")" + "VALUES(?,?,?);";
                    preparedStatement = getDbConection().prepareStatement(saveSQL);
                    preparedStatement.setDate(1, new java.sql.Date(record.getDate().getTime()));
                    preparedStatement.setDouble(2, record.getAccountsReceivable());
                    preparedStatement.setDouble(3, record.getSecurites());
                    preparedStatement.executeUpdate();

                    //loan_sources insert
                    saveSQL = "REPLACE  INTO " + LoanSourcesEntity.LOAN_SOURCES_TABLE + "(" +
                            LoanSourcesEntity.DATE + "," +
                            LoanSourcesEntity.SHORT_TERM_DEBT + "," +
                            LoanSourcesEntity.LONG_TERM_DEBT +
                            ")" + "VALUES(?,?,?);";
                    preparedStatement = getDbConection().prepareStatement(saveSQL);
                    preparedStatement.setDate(1, new java.sql.Date(record.getDate().getTime()));
                    preparedStatement.setDouble(2, record.getShorttermDebt());
                    preparedStatement.setDouble(3, record.getLongtermDebt());
                    preparedStatement.executeUpdate();

                    //business_activity_param insert
                    saveSQL = "REPLACE  INTO " + BusinessActivityParamEntity.BUSINESS_ACTIVITY_PARAM_TABLE + "(" +
                            BusinessActivityParamEntity.DATE + "," +
                            BusinessActivityParamEntity.NET_BALANCE_CURRENCY + "," +
                            BusinessActivityParamEntity.FIXED_ASSETS + "," +
                            BusinessActivityParamEntity.OTHER_INVESTMENTS +
                            ")" + "VALUES(?,?,?,?);";
                    preparedStatement = getDbConection().prepareStatement(saveSQL);
                    preparedStatement.setDate(1, new java.sql.Date(record.getDate().getTime()));
                    preparedStatement.setDouble(2, record.getNetBalanceCurrency());
                    preparedStatement.setDouble(3, record.getFixedAssets());
                    preparedStatement.setDouble(4, record.getOtherInvestments());
                    preparedStatement.executeUpdate();

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return true;
        } else {
            try {
                String deleteSQL = "DELETE  FROM " + FundEntity.FUND_TABLE;
                PreparedStatement preparedStatement = getDbConection().prepareStatement(deleteSQL);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return true;
        }
    }


    public List<Record> getAllInBetween(java.util.Date beginDate, java.util.Date endDate) {
        List<Record> records = new ArrayList<>();
        try {
            String selectSQL = "SELECT * FROM " + FundEntity.FUND_TABLE +
                    " INNER JOIN " + SourcesOfEquityEntity.SOURCES_OF_EQUITY_TABLE + " USING" +
                    "(" + FundEntity.DATE + ")" +
                    " INNER JOIN " + LiquidParamEntity.LIQUID_PARAM_TABLE + " USING" +
                    "(" + FundEntity.DATE + ")" +
                    " INNER JOIN " + LoanSourcesEntity.LOAN_SOURCES_TABLE + " USING" +
                    "(" + FundEntity.DATE + ")" +
                    " INNER JOIN " + BusinessActivityParamEntity.BUSINESS_ACTIVITY_PARAM_TABLE + " USING" +
                    "(" + FundEntity.DATE + ") WHERE " + FundEntity.DATE + " BETWEEN ? AND ?";

            PreparedStatement preparedStatement = getDbConection().prepareStatement(selectSQL);
            preparedStatement.setDate(1, new java.sql.Date(beginDate.getTime()));
            preparedStatement.setDate(2, new java.sql.Date(endDate.getTime()));
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                records.add(new Record(
                        new java.util.Date(resultSet.getDate(1).getTime()),
                        resultSet.getDouble(2),
                        resultSet.getDouble(3),
                        resultSet.getDouble(4),
                        resultSet.getDouble(5),
                        resultSet.getDouble(6),
                        resultSet.getDouble(7),
                        resultSet.getDouble(8),
                        resultSet.getDouble(9),
                        resultSet.getDouble(10),
                        resultSet.getDouble(11),
                        resultSet.getDouble(12),
                        resultSet.getDouble(13),
                        resultSet.getDouble(14),
                        resultSet.getDouble(15)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return records;
    }



    public List<Record> getAll() {
        List<Record> records = new ArrayList<>();
        try {
            String selectSQL = "SELECT * FROM " + FundEntity.FUND_TABLE +
                    " INNER JOIN " + SourcesOfEquityEntity.SOURCES_OF_EQUITY_TABLE + " USING" +
                    "(" + FundEntity.DATE + ")" +
                    " INNER JOIN " + LiquidParamEntity.LIQUID_PARAM_TABLE + " USING" +
                    "(" + FundEntity.DATE + ")" +
                    " INNER JOIN " + LoanSourcesEntity.LOAN_SOURCES_TABLE + " USING" +
                    "(" + FundEntity.DATE + ")" +
                    " INNER JOIN " + BusinessActivityParamEntity.BUSINESS_ACTIVITY_PARAM_TABLE + " USING" +
                    "(" + FundEntity.DATE + ")";

            PreparedStatement preparedStatement = getDbConection().prepareStatement(selectSQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                records.add(new Record(
                        new java.util.Date(resultSet.getDate(1).getTime()),
                        resultSet.getDouble(2),
                        resultSet.getDouble(3),
                        resultSet.getDouble(4),
                        resultSet.getDouble(5),
                        resultSet.getDouble(6),
                        resultSet.getDouble(7),
                        resultSet.getDouble(8),
                        resultSet.getDouble(9),
                        resultSet.getDouble(10),
                        resultSet.getDouble(11),
                        resultSet.getDouble(12),
                        resultSet.getDouble(13),
                        resultSet.getDouble(14),
                        resultSet.getDouble(15)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return records;
    }

    public User getUserByLoginAndPassword(String login, String password) {

        User user = null;
        String selectSQL = "SELECT * FROM " + UserEntity.USER_TABLE + " WHERE " +
                UserEntity.LOGIN + "=? AND " + UserEntity.PASSWORD + "=?";
        try {
            PreparedStatement preparedStatement = getDbConection().prepareStatement(selectSQL);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                if (resultSet.getString(5).trim().equalsIgnoreCase(login) &
                        resultSet.getString(6).trim().equalsIgnoreCase(password)) {
                    user = new User(
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6));
                    System.out.println(user.toString());
                }
                break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }



    public List<Record> getAllDate(){
        List<Record> recordList = new ArrayList<>();
        try{
            String selectSQL = "SELECT " + FundEntity.DATE + " FROM " + FundEntity.FUND_TABLE;
            PreparedStatement preparedStatement = getDbConection().prepareStatement(selectSQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Record record = new Record();
                record.setDate(new java.util.Date(resultSet.getDate(1).getTime()));
                recordList.add(record);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recordList;
    }

    public void closeConnection() {
        try {
            dbConection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
