package org.gocar.cafee_arif_final;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ForgotPasswordActivity extends AppCompatActivity {

    private EditText etEmail;
    private Button btnKirimEmail, btnKembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        etEmail = findViewById(R.id.etEmail);
        btnKirimEmail = findViewById(R.id.btnKirimEmail);
        btnKembali = findViewById(R.id.btnKembali);

        btnKirimEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString().trim();

                if (email.isEmpty()) {
                    Toast.makeText(ForgotPasswordActivity.this,
                            "Email harus diisi!",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!email.contains("@")) {
                    Toast.makeText(ForgotPasswordActivity.this,
                            "Format email tidak valid!",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                Toast.makeText(ForgotPasswordActivity.this,
                        "Link reset password telah dikirim ke " + email,
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
