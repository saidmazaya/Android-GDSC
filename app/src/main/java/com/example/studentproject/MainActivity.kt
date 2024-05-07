package com.example.studentproject

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var listView: ListView
    private val list = ArrayList<Hero>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.lv_heroes)

        list.addAll(getListHeroes())
        val adapter = ListHeroAdapter(list)
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val hero = list[position]
            showSelectedHero(hero)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_page -> {
                val moveIntent = Intent(this@MainActivity, AboutPageActivity::class.java)
                startActivity(moveIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListHeroes(): ArrayList<Hero> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataNim = resources.getStringArray(R.array.data_nim)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val dataEmail = resources.getStringArray(R.array.data_email)
        val dataAngkatan = resources.getStringArray(R.array.data_angkatan)
        val dataFakultas = resources.getStringArray(R.array.data_fakultas)
        val dataProdi = resources.getStringArray(R.array.data_prodi)
        val dataSemester = resources.getStringArray(R.array.data_semester)
        val dataStatus = resources.getStringArray(R.array.data_status)
        val listHero = ArrayList<Hero>()
        for (i in dataName.indices) {
            val hero = Hero(dataName[i], dataNim[i], dataPhoto[i], dataEmail[i], dataAngkatan[i], dataFakultas[i], dataProdi[i], dataSemester[i], dataStatus[i])
            listHero.add(hero)
        }
        return listHero
    }

    private fun showSelectedHero(hero: Hero) {
        Toast.makeText(this, "Kamu memilih " + hero.name, Toast.LENGTH_SHORT).show()
    }
}
