package emanuelkrowegoran.ternakode.Info;


import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;



public class Kapal {
    public String nama;
    public String kapasitas;
    public String jadwal;


    public Kapal() {
    }

    public Kapal(String nama, String tahun, String website) {
        this.nama = nama;
        this.kapasitas = kapasitas;
        this.jadwal = jadwal;

    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("nama", nama);
        result.put("kapasitas", kapasitas);
        result.put("jadwal", jadwal);

        return result;
    }

}