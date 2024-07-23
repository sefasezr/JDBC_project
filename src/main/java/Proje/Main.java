package Proje;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        start();
    }

    private static void start() {
        OgrenciIslemleri ogrenciIslemleri = new OgrenciIslemleri();

        Scanner scan  = new Scanner(System.in);
        int choice = -1;
        while(choice != 0){
            System.out.println("Kurs uygulama menüsüne hoşgeldiniz");
            System.out.println("1-Öğrenci Kayıt");
            System.out.println("2-Öğrenci Silme");
            //Menüde branş değiştirme öğrenci bilgisi görüntüleme gibi seçenekler de olacak
            System.out.println("0-Çıkış");
            choice = scan.nextInt();
            scan.nextLine();
            switch(choice){
                case 1:
                    ogrenciIslemleri.ogrenciKayit();
                    break;
                case 2:
                    //Ogrenci silmek için metod oluşturacağım
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Geçersiz işlem tekrar deneyiniz");
                    break;
            }
        }
    }
}
