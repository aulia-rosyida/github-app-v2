package com.dicoding.auliarosyida.listveggie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvVeggies: RecyclerView
    private var list: ArrayList<Veggie> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvVeggies = findViewById(R.id.rv_veggies)
        rvVeggies.setHasFixedSize(true)

        list.addAll(VeggieData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvVeggies.layoutManager = LinearLayoutManager(this)
        val listVeggieAdapter = ListVeggieAdapter(list)
        rvVeggies.adapter = listVeggieAdapter


        listVeggieAdapter.setOnItemClickCallback(object : ListVeggieAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Veggie) {
                showSelectedVeggie(data)
            }
        })
    }

    private fun showSelectedVeggie(veggie: Veggie) {
        Toast.makeText(this, "Kamu memilih " + veggie.name, Toast.LENGTH_SHORT).show()
        val moveWithVeggieIntent = Intent(this@MainActivity, DetailVeggie::class.java)
        moveWithVeggieIntent.putExtra(DetailVeggie.EXTRA_NAME, veggie.name)
        moveWithVeggieIntent.putExtra(DetailVeggie.EXTRA_DETAIL, veggie.detail)
        moveWithVeggieIntent.putExtra(DetailVeggie.EXTRA_PHOTO, veggie.photo)
        startActivity(moveWithVeggieIntent)
    }
}