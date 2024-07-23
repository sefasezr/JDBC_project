package Proje;

import java.sql.*;

public class Veritabani {
    private final String URL = "jdbc:postgresql://localhost:5432/spor_kurs";
    private final String USER = "proje";
    private final String PASSWORD = "password";

    public Connection baglantiKur() {
        try {
            return DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void baglantiKopar(){
        try{
            Connection con = baglantiKur();
            if(con != null){
                con.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Veritabanı kapatılamadı");
        }

    }
}
