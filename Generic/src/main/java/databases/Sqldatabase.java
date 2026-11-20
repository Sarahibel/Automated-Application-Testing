package databases;

import java.sql.*;

public class Sqldatabase {

    public String connectDatab(String tablename,String columnforRow,String columnvalue,String columnLabel) {

        String url = ConnectToSqlDB.databaseSetting("PROJECT_2020_DB_URL");
        String user = ConnectToSqlDB.databaseSetting("PROJECT_2020_DB_USER");

        String password = ConnectToSqlDB.databaseSetting("PROJECT_2020_DB_PASSWORD");

        Connection connection = null;
        Statement statement = null;
        ResultSet rs;
        String sqldata = null;


        //need to parameterized
        String query1 = "select * from "+ tablename +" where " + columnforRow +"  = "+columnvalue+" ";

        try {
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
            rs = statement.executeQuery(query1);


            while (rs.next()) {

                sqldata = rs.getString(columnLabel);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException sq) {

            }

        }

        return sqldata;

    }
}
