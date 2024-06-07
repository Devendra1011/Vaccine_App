package com.example.vaccineapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity implements ItemClickListener {
    // 1 - AdapterView: RecyclerView
    RecyclerView recyclerView;

    //2 - Data Source
    VaccineModel[] myListData;

    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        recyclerView = findViewById(R.id.recycler_view);
        myListData = new VaccineModel[]{
                new VaccineModel("Hepatitis B Vaccine",R.drawable.vaccine1),
                new VaccineModel("Tetanus Vaccine",R.drawable.vaccine4),
                new VaccineModel("Pneumococcal Vaccine",R.drawable.vaccine5),
                new VaccineModel("Rotavirus",R.drawable.vaccine6),
                new VaccineModel("Measles",R.drawable.vaccine7),
                new VaccineModel("Cholera Virus",R.drawable.vaccine8),
                new VaccineModel("Covid 19",R.drawable.vaccine9)
        };

        adapter = new MyAdapter(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        // Handling click events
        adapter.setClickListener(this);



    }

    @Override
    public void onClick(View view, int pos) {
        Toast.makeText(this, "Vaccine Name: "+myListData[pos].getVaccineName(), Toast.LENGTH_SHORT).show();
    }
}