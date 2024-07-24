package Proje;

public class GereklilikKontrol {


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
