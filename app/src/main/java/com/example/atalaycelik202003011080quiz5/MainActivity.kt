package com.example.atalaycelik202003011080quiz5

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var stadiumList: ArrayList<Stadium>
    private lateinit var stadiumCountTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        stadiumList = ArrayList()
        stadiumList.add(Stadium("Luseyl Stadyumu", "Luseyl", "80,000 koltuklu", R.drawable.lusail))
        stadiumList.add(Stadium("El-Beyt Stadyumu", "Havr", "60,000 koltuklu", R.drawable.al_bayt))
        stadiumList.add(Stadium("Stadyum 974", "Doha", "40,000 koltuklu", R.drawable.stadium974))
        stadiumList.add(Stadium("Es-Sümame Stadyumu", "Doha", "40,000 koltuklu", R.drawable.althumama))
        stadiumList.add(Stadium("Eğitim Şehri Stadyumu", "Er-Reyyan", "45,350 koltuklu", R.drawable.educationcity))
        stadiumList.add(Stadium("Ahmed Bin Ali Stadyumu", "Ümelefai", "44,740 koltuklu", R.drawable.ahmedbinali))
        stadiumList.add(Stadium("Uluslararası Halife Stadyumu", "Havr", "40,000 koltuklu", R.drawable.halife))
        stadiumList.add(Stadium("El-Cenub Stadyumu", "Vekre", "40,000 koltuklu", R.drawable.elcenub))

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        val adapter = StadiumAdapter(stadiumList)
        recyclerView.adapter = adapter

        stadiumCountTextView = findViewById(R.id.stadiumCountTextView)
        stadiumCountTextView.text = "Stadyum Sayısı: ${stadiumList.size}"

        adapter.setOnItemClickListener(object : StadiumAdapter.OnItemClickListener {
            override fun onLikeClick(position: Int) {
                val stadiumName = stadiumList[position].name
                Toast.makeText(this@MainActivity, "$stadiumName'ı beğendiniz. Sizi orada görmek isteriz.", Toast.LENGTH_SHORT).show()
            }
        })
    }
}