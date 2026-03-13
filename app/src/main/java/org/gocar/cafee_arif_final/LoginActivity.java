package org.gocar.cafee_arif_final;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private Button btnLogin;
    private TextView tvRegister, tvForgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Inisialisasi views
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvRegister = findViewById(R.id.tvRegister);
        tvForgotPassword = findViewById(R.id.tvForgotPassword);

        // Event handler login
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                // Validasi input kosong
                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginActivity.this,
                            "Username dan Password harus diisi!",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                // Validasi kredensial admin
                if (username.equals("admin") && password.equals("12345")) {
                    Toast.makeText(LoginActivity.this,
                            "Login Berhasil!",
                            Toast.LENGTH_SHORT).show();

                    // Intent ke Menu Utama
                    Intent intent = new Intent(LoginActivity.this, MenuUtamaActivity.class);
                    intent.putExtra("username", username);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this,
                            "Username atau Password salah!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Intent ke Register
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        // Intent ke Forgot Password
        tvForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
                startActivity(intent);
            }
        });
    }
}