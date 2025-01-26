package com.devspace.recyclerview

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        //Criar um data class
        //Criar lista para o tipo do data class
        //Criar um adapter
        //Setar o adapter
        //Linear layout manager
        //Submeter a Lista


        val rvlist = findViewById<RecyclerView>(R.id.rv_list)
        val adapter = ContactListAdapter()

        rvlist.adapter = adapter
        rvlist.layoutManager = LinearLayoutManager(this)
        adapter.submitList(contacts)

        val ivlist = findViewById<ImageView>(R.id.iv_list)
        val ivgrid = findViewById<ImageView>(R.id.iv_grid)

        ivgrid.setOnClickListener(){
            rvlist.layoutManager = GridLayoutManager(this, 2)
        }
        ivlist.setOnClickListener(){
            rvlist.layoutManager = LinearLayoutManager(this)
        }
        adapter.setOnClickListener { contact ->
            Log.d("Roque", contact.toString())

        }
    }
}

private val contacts = listOf(
    Contact(
        "Carla",
        "(55+) 18 997234585",
        R.drawable.sample1
    ),

    Contact(
        "Guilherme",
        "(55+) 18 994780385",
        R.drawable.sample2
    ),

    Contact(
        "Manuela",
        "(55+) 18 996230402",
        R.drawable.sample3
    ),

    Contact(
        "Olivia",
        "(55+) 18 995728743",
        R.drawable.sample4
    ),
    Contact(
        "Kamila",
        "(55+) 18 992033453",
        R.drawable.sample5
    ),

    Contact(
        "Pietra",
        "(55+) 18 923345678",
        R.drawable.sample6
    ),

    Contact(
        "Sofia",
        "(55+) 18 992304567",
        R.drawable.sample7
    ),

    Contact(
        "Francisco",
        "(55+) 18 992034855",
        R.drawable.sample8
    ),

    Contact(
        "Marcos",
        "(55+) 18 997543723",
        R.drawable.sample9
    ),

    Contact(
        "Leandro",
        "(55+) 18 997020403",
        R.drawable.sample10
    ),

    Contact(
        "Julia",
        "(55+) 18 994070892",
        R.drawable.sample11
    ),

    Contact(
        "Amir",
        "(55+) 18 994030504",
        R.drawable.sample12
    ),

    Contact(
        "Paula",
        "(55+) 18 997436532",
        R.drawable.sample13
    ),

    Contact(
        "Anderson",
        "(55+) 18 997030506",
        R.drawable.sample14
    ),

    Contact(
        "Joana",
        "(55+) 18 997040385",
        R.drawable.sample15
    ),

    Contact(
        "Carol",
        "(55+) 18 996421234",
        R.drawable.sample16
    )
)