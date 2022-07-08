package com.example.cleankost;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Order_Cleaning extends AppCompatActivity {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private ProgressDialog progressDialog;
    private String id = "";
    private EditText ed_nama, ed_alm, ed_tlpn, ed_order;
    private Button batal, pesan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_cleaning);

        ed_nama = findViewById(R.id.ed_nama);
        ed_tlpn = findViewById(R.id.ed_alm);
        ed_alm = findViewById(R.id.ed_tlpn);
        ed_order = findViewById(R.id.ed_oder);
        batal = findViewById(R.id.batalkan);
        pesan = findViewById(R.id.Pesan);

        progressDialog = new ProgressDialog(Order_Cleaning.this);
        progressDialog.setTitle("Loading..");
        progressDialog.setMessage("Menyimpan..");

        pesan.setOnClickListener(v -> {

            if (ed_nama.getText().length() > 0 && ed_alm.getText().length() > 0 && ed_tlpn.getText().length() > 0 && ed_order.getText().length() > 0) {
                saveData(ed_nama.getText().toString(), ed_alm.getText().toString(), ed_tlpn.getText().toString(), ed_order.getText().toString());
            } else {
                Toast.makeText(getApplicationContext(), "Silahkan Isi kembali", Toast.LENGTH_SHORT).show();

            }
        });

        batal.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), beranda.class);
            startActivity(intent);
        });


        Intent intent = getIntent();
        if (intent != null) {
            id = intent.getStringExtra("id");
            ed_nama.setText(intent.getStringExtra("nama"));
            ed_alm.setText(intent.getStringExtra("alamat"));
            ed_tlpn.setText(intent.getStringExtra("no_telepon"));
            ed_order.setText(intent.getStringExtra("namapesan"));
        }
    }

    private void saveData(String nama, String alamat, String telpon, String pesan) {
        Map<String, Object> user = new HashMap<>();
        user.put("nama", nama);
        user.put("alamat", alamat);
        user.put("no_telepon", telpon);
        user.put("namapesan", pesan);

        progressDialog.show();

        if (id != null) {
            /**
             *  kode untuk edit data firestore dengan mengambil id
             */
            db.collection("users").document(id)
                    .set(user)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(Order_Cleaning.this, "Berhasil di Edit", Toast.LENGTH_SHORT).show();
                                finish();
                            } else {
                                Toast.makeText(Order_Cleaning.this, "Gagal di Edit", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        } else {
            /**
             * Code untuk menambahkan data dengan add
             */
            db.collection("users")
                    .add(user)
                    .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentReference> task) {
                            Toast.makeText(Order_Cleaning.this, "penyimpanan berhasil", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                            finish();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(Order_Cleaning.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        }
                    });
        }
    }
}