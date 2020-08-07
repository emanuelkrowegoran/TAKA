package emanuelkrowegoran.ternakode.Pesan.adapter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import emanuelkrowegoran.ternakode.Pesan.Boking;
import emanuelkrowegoran.ternakode.Pesan.FirebaseDBCreateActivity;
import emanuelkrowegoran.ternakode.Pesan.FirebaseDBReadActivity;
import emanuelkrowegoran.ternakode.R;
import emanuelkrowegoran.ternakode.RiwayatBoking.RiwayatBoking;

/**
 * Created by Hafizh Herdi on 10/8/2017.
 */

public class AdapterBarangRecyclerView extends RecyclerView.Adapter<AdapterBarangRecyclerView.ViewHolder> {

    private ArrayList<Boking> daftarBarang;
    private Context context;
    FirebaseDataListener listener;

    public AdapterBarangRecyclerView(ArrayList<Boking> barangs, Context ctx){
        /**
         * Inisiasi data dan variabel yang akan digunakan
         */
        daftarBarang = barangs;
        context = ctx;
        listener = (FirebaseDBReadActivity)ctx;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        /**
         * Inisiasi View
         * Di tutorial ini kita hanya menggunakan data String untuk tiap item
         * dan juga view nya hanyalah satu TextView
         */
        TextView tvTitle;
        CardView cvMain;
        private TextView tvRiwayat, tvTotal, tvTanggal;

        ViewHolder(View v) {
            super(v);
            tvTitle = (TextView) v.findViewById(R.id.tv_namapenumpang);
            cvMain = (CardView) v.findViewById(R.id.cv_main);
            tvRiwayat = (TextView) v.findViewById(R.id.tv_riwayat);
            tvTotal = (TextView) v.findViewById(R.id.tv_total);
            tvTanggal = (TextView) v.findViewById(R.id.tv_tanggal);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        /**
         *  Inisiasi ViewHolder
         */
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        // mengeset ukuran view, margin, padding, dan parameter layout lainnya
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        /**
         *  Menampilkan data pada view
         */
        final String name = daftarBarang.get(position).getNama();
        System.out.println("BARANG DATA one by one "+position+daftarBarang.size());
        holder.cvMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 *  Kodingan untuk tutorial Selanjutnya :p Read detail data
                 */
                context.startActivity(RiwayatBoking.getActIntent((Activity) context).putExtra("data", daftarBarang.get(position)));
            }
        });
        holder.cvMain.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                /**
                 *  Kodingan untuk tutorial Selanjutnya :p Delete dan update data
                 */
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog_view);
                dialog.setTitle("Pilih Aksi");
                dialog.show();

                Button editButton = (Button) dialog.findViewById(R.id.bt_edit_data);
                Button delButton = (Button) dialog.findViewById(R.id.bt_delete_data);

                //apabila tombol edit diklik
                editButton.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialog.dismiss();
                                context.startActivity(FirebaseDBCreateActivity.getActIntent((Activity) context).putExtra("data", daftarBarang.get(position)));
                            }
                        }
                );

                //apabila tombol delete diklik
                delButton.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialog.dismiss();
                                listener.onDeleteData(daftarBarang.get(position), position);
                            }
                        }
                );
                return true;
            }
        });
        holder.tvTitle.setText(name);
    }

    @Override
    public int getItemCount() {
        /**
         * Mengembalikan jumlah item pada barang
         */
        return daftarBarang.size();
    }

    public interface FirebaseDataListener{
        void onDeleteData(Boking barang, int position);
    }
}
