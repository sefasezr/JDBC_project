package Proje;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseIslemleri {
    private Connection con;
    Statement st;

    public DatabaseIslemleri(Connection con) throws SQLException {
        this.con = con;
        this.st = con.createStatement();
    }

    public void veriEkleme(String isim,String soyisim,String cinsiyet,String brans,int kilo,int boy ) throws SQLException {
        String ekleme = "INSERT INTO ogrenci (isim,soyisim,cinsiyet,brans,kilo,boy) VALUES(?,?,?,?,?,?)";
        PreparedStatement prst = con.prepareStatement(ekleme);
        prst.setString(1, isim);
        prst.setString(2, soyisim);
        prst.setString(3, cinsiyet);
        prst.setString(4, brans);
        prst.setInt(5, kilo);
        prst.setInt(6, boy);
        prst.executeUpdate();
        prst.close();
        st.close();
    }

    public void veriSilme(int id) throws SQLException {
        String silme = "DELETE FROM ogrenci WHERE id = ?";
        PreparedStatement prst = con.prepareStatement(silme);
        prst.setInt(1, id);
        prst.executeUpdate();
    }
}
