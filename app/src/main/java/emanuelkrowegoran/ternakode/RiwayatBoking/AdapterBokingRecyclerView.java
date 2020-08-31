package emanuelkrowegoran.ternakode.RiwayatBoking;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import emanuelkrowegoran.ternakode.Pesan.Boking;
import emanuelkrowegoran.ternakode.R;

// Import library


/**
 * Created by Hafizh Herdi on 10/8/2017.
 */

public class AdapterBokingRecyclerView extends RecyclerView.Adapter<AdapterBokingRecyclerView.ViewHolder> {

    private ArrayList<Boking> daftarBarang;
    private Context context;





    /**
     * Inisiasi data dan variabel yang akan digunakan
     */



    //Membuat Konstruktor, untuk menerima input dari Database
    public AdapterBokingRecyclerView(ArrayList<Boking> barangs, Context ctx) {
        daftarBarang = barangs;
        context = ctx;

    }


    class ViewHolder extends RecyclerView.ViewHolder {


        /**
         * Inisiasi View
         * Di tutorial ini kita hanya menggunakan data String untuk tiap item
         * dan juga view nya hanyalah satu TextView
         */
        private TextView tvRiwayat, tvTotal, tvTanggal, tvId;
        private RelativeLayout tvHapus;
        RecyclerView rv_main;
        int hargaDewasa, hargaAnak;
        int  hargaTotalAnak, hargaTotal;


        ViewHolder(View v) {
            super(v);
            tvRiwayat = (TextView) v.findViewById(R.id.tv_riwayat);
            rv_main = (RecyclerView) v.findViewById(R.id.rv_main);
            tvTanggal = (TextView) v.findViewById(R.id.tv_tanggal);
            tvTotal = (TextView) v.findViewById(R.id.tv_total );
            tvId = (TextView) v.findViewById(R.id.tv_id );



        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        /**
         *  Inisiasi ViewHolder
         */
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_barang, parent, false);
        // mengeset ukuran view, margin, padding, dan parameter layout lainnya
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        /**
         *  Menampilkan data pada view
         */
        final String asal = daftarBarang.get(position).getDataAsal();
        final String tujuan = daftarBarang.get(position).getDataTujuan();
        final String dewasa = daftarBarang.get(position).getDataDewasa();
        final String bayi = daftarBarang.get(position).getDataBayi();
        final String tanggal = daftarBarang.get(position).getDataTanggal();
        final String total = daftarBarang.get(position).getDataTotal();
        final String pasport = daftarBarang.get(position).getDataPasport();





        holder.tvRiwayat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 *  Kodingan untuk tutorial Selanjutnya :p Read detail data
                 */
            }
        });


        holder.tvRiwayat.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                /**
                 *  Kodingan untuk tutorial Selanjutnya :p Delete dan update data
                 */
                return true;
            }
        });




        holder.tvRiwayat.setText("Berhasil melakukan booking untuk melakukan perjalanan dari " + asal + " menuju " + tujuan + " pada tanggal " + tanggal + ". " +
                "Jumlah pembelian tiket dewasa sejumlah " + dewasa + " dan tiket bayi sejumlah " + bayi + ".");
        holder.tvTotal.setText("Total Harga :");
        holder.tvTanggal.setText(tanggal);
        holder.tvTotal.setText("Total Harga :   " + total );
        holder.tvId.setText("ID : " + pasport);
 }






    @Override
    public int getItemCount() {
        /**
         * Mengembalikan jumlah item pada barang
         */
        return daftarBarang.size();
    }
}