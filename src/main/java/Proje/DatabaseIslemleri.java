package Proje;

import java.sql.*;
import java.util.Scanner;

public class DatabaseIslemleri {
    Connection con;
    Statement st;
    Database db = new Database();
    PreparedStatement prst;
    Scanner scan  = new Scanner(System.in);

    public DatabaseIslemleri() {
        this.con = db.baglantiKur();
        try {
            st = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void ekleIslemleri(Ogrenci ogrenci) throws SQLException {
        String query = "INSERT INTO ogrenci (isim,soyisim,cinsiyet,brans,kilo,boy) VALUES (?,?,?,?,?,?)";
        prst = con.prepareStatement(query);
        prst.setString(1,ogrenci.getIsim());
        prst.setString(2,ogrenci.getSoyisim());
        prst.setString(3,ogrenci.getCinsiyet());
        prst.setString(4, ogrenci.getBranş());
        prst.setInt(5, ogrenci.getKilo());
        prst.setInt(6, ogrenci.getBoy());
        prst.executeUpdate();
        prst.close();
    }

    public void SilmeIslemleri() throws SQLException {
        System.out.println("Silmek istediğiniz öğrencinin id bilgisini giriniz: ");
        int id = scan.nextInt();
        scan.nextLine();
        String query = "DELETE FROM ogrenci WHERE id = ?";
        prst = con.prepareStatement(query);
        prst.setInt(1, id);
        prst.executeUpdate();
        prst.close();
    }

    public void bransDegistirmeIslemleri() throws SQLException {
        System.out.println("İşlem yapabilmemiz için sporcunuzun id bilgisini giriniz: ");
        int id = scan.nextInt();
        System.out.println("Geçmek istediğiniz branş ismini giriniz: ");
        String brans = scan.nextLine();
        String query = "UPDATE ogrenci SET brans = ? WHERE id = ?";
        prst = con.prepareStatement(query);
        prst.setString(1, brans);
        prst.setInt(2, id);
        prst.executeUpdate();
        prst.close();

    }

    public void ogrenciBilgileriGoruntuleme() throws SQLException {
        System.out.println("Bilgilerini goruntulemek istediginiz ogrencinin id bilgisini giriniz");
        int id = scan.nextInt();
        String query = "SELECT * FROM ogrenci WHERE id = ?";
        prst = con.prepareStatement(query);
        prst.setInt(1, id);
        prst.executeQuery();
        ResultSet rs = prst.getResultSet();
        while (rs.next()) {
            System.out.println("Öğrenci id: "+rs.getInt("id"));
            System.out.println("Öğrenci isim: "+rs.getString("isim"));
            System.out.println("Öğrenci soyisim: "+rs.getString("soyisim"));
            System.out.println("Öğrenci cinsiyet: "+rs.getString("cinsiyet"));
            System.out.println("Öğrenci brans: "+rs.getString("brans"));
            System.out.println("Öğrenci kilo: "+rs.getInt("kilo"));
            System.out.println("Öğrenci boy: "+rs.getInt("boy"));
        }
    }

}
