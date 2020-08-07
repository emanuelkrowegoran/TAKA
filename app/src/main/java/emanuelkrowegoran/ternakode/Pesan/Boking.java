package emanuelkrowegoran.ternakode.Pesan;

import com.google.firebase.database.IgnoreExtraProperties;
import java.io.Serializable;

@IgnoreExtraProperties
public class Boking implements Serializable{
    private String DataAsal;
    private String DataTujuan;
    private String DataDewasa;
    private String DataBayi;
    private String DataKapal;
    private String DataTanggal;
    private String key;
    private String nama, nama2;
    private String bayi;
    private String nohp;
    private String DataTotal;




    public Boking() {
        //this constructor is required
    }

    public Boking(String DataAsal, String DataTujuan, String DataDewasa, String DataBayi, String DataTanggal, String DataTotal, String DataKapal) {

        this.DataAsal = DataAsal;
        this.DataTujuan = DataTujuan;
        this.DataDewasa = DataDewasa;
        this.DataBayi = DataBayi;
        this.DataTanggal = DataTanggal;
        this.DataTotal = DataTotal;
        this.DataKapal = DataKapal;




    }

    public String getDataTotal() {
        return DataTotal;
    }
    public void setDataTotal(String DataTotal) {
        this.DataTotal = DataTotal;
    }

    public String getDataAsal() {
        return DataAsal;
    }

    public void setDataAsal(String DataAsal) {
        this.DataAsal = DataAsal;
    }

    public String getDataTujuan() {
        return DataTujuan;
    }

    public void setDataTujuan(String DataTujuan) {
        this.DataTujuan = DataTujuan;
    }

    public String getDataDewasa() {
        return DataDewasa;
    }

    public void setDataDewasa(String DataDewasa) {
        this.DataDewasa = DataDewasa;
    }

    public String getDataBayi() {
        return DataBayi;
    }

    public void setDataBayi(String DataBayi) {
        this.DataBayi = DataBayi;
    }

    public String getDataKapal() {
        return DataKapal;
    }

    public void setDataKapal(String DataKapal) {
        this.DataKapal = DataKapal;
    }

    public String getDataTanggal() {
        return DataTanggal;
    }

    public void setDataTanggal(String DataTanggal) {
        this.DataTanggal = DataTanggal;
    }

    //getter n setter
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }


    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getBayi() {
        return bayi;
    }

    public void setBayi(String bayi) {
        this.bayi = bayi;
    }
    public String getNohp() {
        return nohp;
    }

    public void setNohp(String nohp) {
        this.nohp = nohp;
    }

    public String getnama2() {
        return nama2;
    }

    public void setnama2(String nama2) {
        this.nama2 = nama2;
    }



    @Override
    public String toString() {
        return " "+nama+"\n" +
                " "+nama2+"\n" +
                " "+bayi +"\n" +
                " "+nohp;
    }

    public Boking(String nm, String byi, String hp, String nma){
        nama = nm;
        nama2 = nma;
        bayi = byi;
        nohp = hp;
    }
}

