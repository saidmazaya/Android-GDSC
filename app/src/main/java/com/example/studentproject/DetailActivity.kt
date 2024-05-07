package com.example.studentproject

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.studentproject.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    companion object {
        const val KEY_HERO = "key_hero"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataHero = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Hero>(KEY_HERO, Hero::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Hero>(KEY_HERO)
        }

        if (dataHero != null) {
            binding.tvDetailName.text = dataHero.name
            binding.tvDetailNim.text = dataHero.nim
            binding.tvDetailEmail.text = dataHero.email
            binding.tvDetailAngkatan.text = dataHero.angkatan
            binding.tvDetailFakultas.text = dataHero.fakultas
            binding.tvDetailProdi.text = dataHero.prodi
            binding.tvDetailSemester.text = dataHero.semester
            binding.tvDetailStatus.text = dataHero.status
            // Menggunakan Glide untuk menampilkan gambar
            Glide.with(this)
                .load(dataHero.photo) // URL Gambar atau sumber gambar lainnya
                .into(binding.ivDetailPhoto) // ImageView yang akan menampilkan gambar
        }
    }
}