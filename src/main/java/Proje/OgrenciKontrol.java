package Proje;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OgrenciKontrol {
    List<Ogrenci> basvuruListesi = new ArrayList<>();
    Veritabani veritabani = new Veritabani();
    Connection con = veritabani.baglantiKur();
    DatabaseIslemleri databaseIslemleri;


    public void basvuruListesiDoldurma(String isim,String soyisim ,String cinsiyet,String brans,int kilo,int boy) throws SQLException {
        Ogrenci ogrenci = new Ogrenci(isim,soyisim,cinsiyet,brans,kilo,boy);
        this.basvuruListesi.add(ogrenci);
        databaseIslemleri = new DatabaseIslemleri(con);
    }

    public void ogrenciKontrol(){
        for(Ogrenci ogrenci : basvuruListesi){
            if(cinsiyetKontrol(ogrenci).equalsIgnoreCase("erkek") && boyKontrol(ogrenci) && kiloKontrol(ogrenci)){
                try {
                    this.databaseIslemleri.veriEkleme(ogrenci.getIsim(), ogrenci.getSoyisim(), ogrenci.getCinsiyet(), ogrenci.getBranş(), ogrenci.getKilo(), ogrenci.getBoy());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }else if (cinsiyetKontrol(ogrenci).equalsIgnoreCase("kadın") && boyKontrol(ogrenci) && kiloKontrol(ogrenci)){
                try {
                    this.databaseIslemleri.veriEkleme(ogrenci.getIsim(), ogrenci.getSoyisim(), ogrenci.getCinsiyet(), ogrenci.getBranş(), ogrenci.getKilo(), ogrenci.getBoy());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }



    public String cinsiyetKontrol(Ogrenci ogrenci){
        String cinsiyet = null;

        if(ogrenci.getCinsiyet().equalsIgnoreCase("erkek")){
            cinsiyet = ogrenci.getCinsiyet();
        }else if(ogrenci.getCinsiyet().equalsIgnoreCase("kadın")){
            cinsiyet = ogrenci.getCinsiyet();
        }

        return cinsiyet;
    }

    public boolean boyKontrol(Ogrenci ogrenci){
        boolean boyKontrol = true;

        if(cinsiyetKontrol(ogrenci).equalsIgnoreCase("erkek")){
            if(ogrenci.getBoy()>160){
                boyKontrol = true;
            }else{
                boyKontrol = false;
            }
        }else if(cinsiyetKontrol(ogrenci).equalsIgnoreCase("kadın")){
            if(ogrenci.getBoy()>150){
                boyKontrol = true;
            }else{
                boyKontrol = false;
            }
        }


        return boyKontrol;
    }


    public boolean kiloKontrol(Ogrenci ogrenci){
        boolean kiloKontrol = true;

        if(cinsiyetKontrol(ogrenci).equalsIgnoreCase("erkek")){
            if(ogrenci.getKilo()>=70 && ogrenci.getKilo()<=90){
                kiloKontrol = true;
            }else{
                kiloKontrol = false;
            }
        }else if(cinsiyetKontrol(ogrenci).equalsIgnoreCase("kadın")){
            if(ogrenci.getKilo()>=50 && ogrenci.getKilo()<=70){
                kiloKontrol = true;
            }else{
                kiloKontrol = false;
            }
        }

        return kiloKontrol;
    }

}
