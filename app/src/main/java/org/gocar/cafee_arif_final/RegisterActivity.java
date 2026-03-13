package org.gocar.cafee_arif_final;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private EditText etNamaLengkap, etEmail, etUsername, etPassword, etKonfirmasiPassword;
    private Button btnDaftar, btnKembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Inisialisasi views
        etNamaLengkap = findViewById(R.id.etNamaLengkap);
        etEmail = findViewById(R.id.etEmail);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        etKonfirmasiPassword = findViewById(R.id.etKonfirmasiPassword);
        btnDaftar = findViewById(R.id.btnDaftar);
        btnKembali = findViewById(R.id.btnKembali);

        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namaLengkap = etNamaLengkap.getText().toString().trim();
                String email = etEmail.getText().toString().trim();
                String username = etUsername.getText().toString().trim();
                String password = etPassword.getText().toString().trim();
                String konfirmasiPassword = etKonfirmasiPassword.getText().toString().trim();

                // Validasi input kosong
                if (namaLengkap.isEmpty() || email.isEmpty() || username.isEmpty() ||
                        password.isEmpty() || konfirmasiPassword.isEmpty()) {
                    Toast.makeText(RegisterActivity.this,
                            "Semua field harus diisi!",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                // Validasi email
                if (!email.contains("@")) {
                    Toast.makeText(RegisterActivity.this,
                            "Format email tidak valid!",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                // Validasi password match
                if (!password.equals(konfirmasiPassword)) {
                    Toast.makeText(RegisterActivity.this,
                            "Password tidak cocok!",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                // Validasi panjang password
                if (password.length() < 5) {
                    Toast.makeText(RegisterActivity.this,
                            "Password minimal 5 karakter!",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                // Simulasi pendaftaran berhasil
                Toast.makeText(RegisterActivity.this,
                        "Pendaftaran berhasil! Silakan login.",
                        Toast.LENGTH_LONG).show();
                finish();
            }
        });

        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}