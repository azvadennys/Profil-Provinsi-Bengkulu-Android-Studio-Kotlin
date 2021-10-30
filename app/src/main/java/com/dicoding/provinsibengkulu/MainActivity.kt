package com.dicoding.provinsibengkulu

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var rvKabupaten: RecyclerView
    private val list = ArrayList<Kabupaten>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (supportActionBar as ActionBar).title = "PROVINSI BENGKULU"
        rvKabupaten = findViewById(R.id.rv_kabupaten)
        rvKabupaten.setHasFixedSize(true)

        list.addAll(DataProvinsi.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvKabupaten.layoutManager = LinearLayoutManager(this)
        val listKabupatenAdapter = ListKabupatenAdapter(list)
        rvKabupaten.adapter = listKabupatenAdapter

        listKabupatenAdapter.setOnItemClickCallback(object : ListKabupatenAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Kabupaten) {
                showSelectedKabupaten(data)
            }
        })
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun showSelectedKabupaten(kabupaten: Kabupaten) {
        val dataIntent = Intent(this@MainActivity, KabupatenKlik::class.java)
            dataIntent.putExtra(KabupatenKlik.EXTRA_NAME, kabupaten.name)
            dataIntent.putExtra(KabupatenKlik.EXTRA_DETAIL , kabupaten.detail)
            dataIntent.putExtra(KabupatenKlik. EXTRA_PHOTO, kabupaten.photo)
        startActivity(dataIntent)
    }


    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.about -> {
                val aboutIntent = Intent(this@MainActivity, About::class.java)
                startActivity(aboutIntent)
            }
        }
    }
}