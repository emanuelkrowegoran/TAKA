package emanuelkrowegoran.ternakode.Info;



import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import emanuelkrowegoran.ternakode.R;


public class KapalViewHolder extends RecyclerView.ViewHolder {

    public TextView tvNama;
    public TextView tvKapasitas;
    public TextView tvJadwal;
    public TextView btnPesan;


    public KapalViewHolder(View itemView) {
        super(itemView);
        tvNama = itemView.findViewById(R.id.tv_nama);
        tvKapasitas = itemView.findViewById(R.id.tv_kapasitas);
        tvJadwal = itemView.findViewById(R.id.tv_jadwal);
        btnPesan = itemView.findViewById(R.id.btn_pesan);


    }

    public void bindToKapal(Kapal kapal, View.OnClickListener onClickListener){
        tvNama.setText(kapal.nama);
        tvKapasitas.setText(kapal.kapasitas);
        tvJadwal.setText(kapal.jadwal);
        btnPesan.setOnClickListener(onClickListener);
    }
}