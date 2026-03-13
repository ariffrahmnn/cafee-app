package org.gocar.cafee_arif_final;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import java.util.ArrayList;

public class MenuCafeRestoActivity extends AppCompatActivity {

    private ListView lvMakanan, lvMinuman;
    private Button btnKembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_cafe_resto);

        lvMakanan = findViewById(R.id.lvMakanan);
        lvMinuman = findViewById(R.id.lvMinuman);
        btnKembali = findViewById(R.id.btnKembali);

        // Data menu makanan
        ArrayList<String> menuMakanan = new ArrayList<>();
        menuMakanan.add("Nasi Goreng - Rp 25.000");
        menuMakanan.add("Mie Goreng - Rp 20.000");
        menuMakanan.add("Ayam Bakar - Rp 30.000");
        menuMakanan.add("Sate Ayam - Rp 28.000");
        menuMakanan.add("Bakso - Rp 22.000");
        menuMakanan.add("Gado-Gado - Rp 18.000");

        // Data menu minuman
        ArrayList<String> menuMinuman = new ArrayList<>();
        menuMinuman.add("Es Teh - Rp 5.000");
        menuMinuman.add("Es Jeruk - Rp 7.000");
        menuMinuman.add("Kopi - Rp 10.000");
        menuMinuman.add("Cappuccino - Rp 15.000");
        menuMinuman.add("Jus Alpukat - Rp 12.000");
        menuMinuman.add("Milkshake - Rp 18.000");

        // Set adapter untuk ListView
        ArrayAdapter<String> adapterMakanan = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                menuMakanan
        );
        lvMakanan.setAdapter(adapterMakanan);

        ArrayAdapter<String> adapterMinuman = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                menuMinuman
        );
        lvMinuman.setAdapter(adapterMinuman);

        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}