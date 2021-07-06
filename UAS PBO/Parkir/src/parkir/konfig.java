/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkir;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Firdaus Fieri Andrian Al - Irsyad
 */
public class konfig {
    
    private static Connection konek;
    public static Connection configDB()throws SQLException{
        try{
            String url="jdbc:mysql://localhost:3306/parkir";
            String user="root";
            String pass="";
            
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            konek = DriverManager.getConnection(url, user, pass);
        }catch(SQLException e){
            System.out.println("Koneksi ke Database Gagal" + e.getMessage());
        }
        return konek;
    }
}
