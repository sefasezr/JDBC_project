package Proje;

public class Ogrenci {
    private String isim;
    private String soyisim;
    private String cinsiyet;
    private String branş;
    private int kilo;
    private int boy;

    public Ogrenci(String isim, String soyisim, String cinsiyet, String branş, int kilo, int boy) {
        this.isim = isim;
        this.soyisim = soyisim;
        this.cinsiyet = cinsiyet;
        this.branş = branş;
        this.kilo = kilo;
        this.boy = boy;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSoyisim() {
        return soyisim;
    }

    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public String getBranş() {
        return branş;
    }

    public void setBranş(String branş) {
        this.branş = branş;
    }

    public int getKilo() {
        return kilo;
    }

    public void setKilo(int kilo) {
        this.kilo = kilo;
    }

    public int getBoy() {
        return boy;
    }

    public void setBoy(int boy) {
        this.boy = boy;
    }
}
