package com.example.studentproject

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Hero(
    val name: String,
    val nim: String,
    val photo: String,
    val email: String,
    val angkatan: String,
    val fakultas: String,
    val prodi: String,
    val semester : String,
    val status: String
) : Parcelable
