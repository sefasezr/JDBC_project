package Proje;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        start();
    }

    private static void start() throws SQLException {
        DatabaseIslemleri databaseIslemleri = new DatabaseIslemleri();
        OgrenciIslemleri ogrenciIslemleri = new OgrenciIslemleri();
        Scanner scan  = new Scanner(System.in);
        int choice = -1;
        while(choice != 0){
            System.out.println("Kurs uygulama menüsüne hoşgeldiniz");
            System.out.println("1-Öğrenci Kayıt");
            System.out.println("2-Öğrenci Silme");
            System.out.println("3-Öğrenci Branş Güncelleme");
            System.out.println("4-Öğrenci Bilgileri Görüntüleme");
            System.out.println("0-Çıkış");
            choice = scan.nextInt();
            scan.nextLine();
            switch(choice){
                case 1:
                    ogrenciIslemleri.ogrenciBilgileriGiris();
                    break;
                case 2:
                    databaseIslemleri.SilmeIslemleri();
                    break;
                case 3:
                    databaseIslemleri.bransDegistirmeIslemleri();
                    break;
                case 4:
                    databaseIslemleri.ogrenciBilgileriGoruntuleme();
                    break;
                case 0:
                    System.out.println("Uygulamadan çıkış yaptınız.");
                    break;
                default:
                    System.out.println("Geçersiz işlem tekrar deneyiniz");
                    break;
            }
        }
    }
}
