package emanuelkrowegoran.ternakode.Info;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import emanuelkrowegoran.ternakode.Pesan.Pemesanan;
import emanuelkrowegoran.ternakode.R;


public class InfoActivity extends AppCompatActivity {

    // [START define_database_reference]
    private DatabaseReference mDatabase;
    // [END define_database_reference]

    private FirebaseRecyclerAdapter<Kapal, KapalViewHolder> mAdapter;
    private RecyclerView mRecycler;
    private LinearLayoutManager mManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        setTitle("Informasi Kapal Feri");

        mDatabase = FirebaseDatabase.getInstance().getReference();

        mRecycler = findViewById(R.id.list_perusahaan);
        mRecycler.setHasFixedSize(true);

        mManager = new LinearLayoutManager(this);
        mManager.setReverseLayout(true);
        mManager.setStackFromEnd(true);
        mRecycler.setLayoutManager(mManager);

        // Set up FirebaseRecyclerAdapter with the Query
        Query query = getQuery(mDatabase);

        FirebaseRecyclerOptions options = new FirebaseRecyclerOptions.Builder<Kapal>()
                .setQuery(query, Kapal.class)
                .build();

        mAdapter = new FirebaseRecyclerAdapter<Kapal, KapalViewHolder>(options) {
            @Override
            public KapalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                LayoutInflater inflater = LayoutInflater.from(parent.getContext());
                return new KapalViewHolder(inflater.inflate(R.layout.item_infokapal, parent, false));
            }
            @Override
            protected void onBindViewHolder(@NonNull KapalViewHolder holder, int position, @NonNull final Kapal model) {
                holder.bindToKapal(model, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(InfoActivity.this, Pemesanan.class);
                        startActivity(intent);
                    }
                });
            }
        };

        mAdapter.notifyDataSetChanged();
        mRecycler.setAdapter(mAdapter);
    }

    @Override
    public void onStart() {
        super.onStart();
        if (mAdapter != null) {
            mAdapter.startListening();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAdapter != null) {
            mAdapter.stopListening();
        }
    }

    private Query getQuery(DatabaseReference mDatabase){
        Query query = mDatabase.child("z-perusahaan");
        return query;
    }

    @SuppressWarnings("unchecked")
    public void myMethod()
    {
        //...
    }
}