package Proje;

import java.sql.SQLException;
import java.util.Scanner;

public class OgrenciIslemleri {

    public void ogrenciKayit(){
        Scanner scan  = new Scanner(System.in);
        OgrenciKontrol ogrenciKontrol = new OgrenciKontrol();
        System.out.println("Kurs başvuru uygulamasına hoş geldiniz");
        System.out.println("Aşağıda belirtilen soruları cevaplayınız");
        System.out.println("Kayıt için başvuracak öğrenci sayısı : ");
        int mevcut = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < mevcut; i++) {
            System.out.println(i+1 + ". Öğrenci bilgileri" );
            System.out.println("Öğrenci ismini giriniz: ");
            String isim = scan.nextLine();
            System.out.println("Öğrenci Soyadı giriniz");
            String soyad = scan.nextLine();
            System.out.println("Girmek istedigi branşı giriniz");
            String branş = scan.nextLine();
            while(true){
                System.out.println("Öğrenci cinsiyeti giriniz: (Erkek/Kız)");
                String cinsiyet = scan.next();
                System.out.println("Öğrenci boy giriniz: ");
                int boy = scan.nextInt();
                System.out.println("Öğrenci kilo giriniz: ");
                int kilo = scan.nextInt();
                scan.nextLine();
                if(boy>0 && kilo>0 && (cinsiyet.equalsIgnoreCase("erkek") || cinsiyet.equalsIgnoreCase("kadın"))){
                    try {
                        ogrenciKontrol.basvuruListesiDoldurma(isim,soyad,cinsiyet,branş,kilo,boy);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                }else{
                    System.out.println("Lütfen boy-kilo ve cinsiyet bilgilerini doğru giriniz!");
                }
            }
        }
        ogrenciKontrol.ogrenciKontrol();
    }

    public void ogrenciKontrol(){

    }
}
