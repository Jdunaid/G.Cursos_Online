/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

 
public class DBUtil {

    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection != null)
            return connection;
        else {
            try {
                Properties prop = new Properties();
                
                String user = "postgres";
                String password = "123456";
                //Class.forName("com.mysql.jdbc.Driver"); // Para quem for usar MySql
                Class.forName("com.mysql.jdbc.Driver");// Para quem for usar Postgres
                //connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetoIntegrador", user, password);// Para quem for usar MySql
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cusos_online_db",user, password);// Para quem for usar Postgres
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return connection;
        }

    }
}