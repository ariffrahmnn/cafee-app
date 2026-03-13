package org.gocar.cafee_arif_final;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MenuUtamaActivity extends AppCompatActivity {

    private TextView tvSelamatDatang;
    private Button btnMenuCafe, btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_utama);

        tvSelamatDatang = findViewById(R.id.tvSelamatDatang);
        btnMenuCafe = findViewById(R.id.btnMenuCafe);
        btnLogout = findViewById(R.id.btnLogout);

        // Ambil username dari intent
        String username = getIntent().getStringExtra("username");
        tvSelamatDatang.setText("Selamat Datang, " + username + "!");

        // Intent ke Menu Cafe Resto
        btnMenuCafe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuUtamaActivity.this, MenuCafeRestoActivity.class);
                startActivity(intent);
            }
        });

        // Logout dan kembali ke Login
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuUtamaActivity.this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        // Disable tombol back
        // Agar user tidak bisa kembali ke login tanpa logout
    }
}
