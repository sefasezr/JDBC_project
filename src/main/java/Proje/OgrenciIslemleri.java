package Proje;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OgrenciIslemleri {
    DatabaseIslemleri databaseIslemleri = new DatabaseIslemleri();
    List<Ogrenci> basvuruListesi = new ArrayList<>();
    GereklilikKontrol gereklilikKontrol = new GereklilikKontrol();

    public void basvuruListesiDoldurma(String isim,String soyisim,String cinsiyet,String brans,int kilo,int boy){
        Ogrenci ogrenci = new Ogrenci(isim,soyisim,cinsiyet,brans,kilo,boy);
        this.basvuruListesi.add(ogrenci);
    }

    public void ogrenciKontrol() throws SQLException {
        for(Ogrenci ogrenci : basvuruListesi){
            if(gereklilikKontrol.cinsiyetKontrol(ogrenci).equalsIgnoreCase("erkek") && gereklilikKontrol.boyKontrol(ogrenci) && gereklilikKontrol.kiloKontrol(ogrenci)){
                databaseIslemleri.ekleIslemleri(ogrenci);
            }else if (gereklilikKontrol.cinsiyetKontrol(ogrenci).equalsIgnoreCase("kadın") && gereklilikKontrol.boyKontrol(ogrenci) && gereklilikKontrol.kiloKontrol(ogrenci)){
                databaseIslemleri.ekleIslemleri(ogrenci);
            }
        }

    }

    public void ogrenciBilgileriGiris() throws SQLException {

        Scanner scan  = new Scanner(System.in);
        System.out.println("Kurs başvuru uygulamasına hoş geldiniz");
        System.out.println("Aşağıda belirtilen soruları cevaplayınız");
        System.out.println("Kayıt için başvuracak öğrenci sayısı : ");
        int mevcut = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < mevcut; i++) {
            System.out.println(i+1 + ". Öğrenci bilgileri" );
            System.out.println("Öğrenci ismini giriniz: ");
            String isim = scan.nextLine();
            System.out.println("Öğrenci soyismini giriniz: ");
            String soyisim = scan.nextLine();
            System.out.println("Öğrenci branş giriniz");
            String brans = scan.nextLine();
            while(true){
                System.out.println("Öğrenci cinsiyeti giriniz: (Erkek/Kız)");
                String cinsiyet = scan.next();
                System.out.println("Öğrenci boy giriniz: ");
                int boy = scan.nextInt();
                System.out.println("Öğrenci kilo giriniz: ");
                int kilo = scan.nextInt();
                scan.nextLine();
                if(boy>0 && kilo>0 && (cinsiyet.equalsIgnoreCase("erkek") || cinsiyet.equalsIgnoreCase("kadın"))){
                    basvuruListesiDoldurma(isim,soyisim,cinsiyet,brans,kilo,boy);
                    break;
                }else{
                    System.out.println("Lütfen boy-kilo ve cinsiyet bilgilerini doğru giriniz!");
                }
            }
        }
        ogrenciKontrol();
    }

}
