package com.dicoding.auliarosyida.listveggie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvVeggies: RecyclerView
    private var list: ArrayList<Veggie> = arrayListOf()
    private var title: String = "Veggie List"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setActionBarTitle(title)

        rvVeggies = findViewById(R.id.rv_veggies)
        rvVeggies.setHasFixedSize(true)

        list.addAll(VeggieData.listData)
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    @Override
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_profile -> {
                val moveprofilepage = Intent(this@MainActivity, profile::class.java)
                startActivity(moveprofilepage)
                true
            }
            else -> return super.onOptionsItemSelected(item)
        }
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
        val moveWithVeggieIntent = Intent(this@MainActivity, DetailVeggie::class.java)
        moveWithVeggieIntent.putExtra(DetailVeggie.EXTRA_NAME, veggie.name)
        moveWithVeggieIntent.putExtra(DetailVeggie.EXTRA_DETAIL, veggie.detail)
        moveWithVeggieIntent.putExtra(DetailVeggie.EXTRA_PHOTO, veggie.photo)
        startActivity(moveWithVeggieIntent)
    }

    private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }
}
