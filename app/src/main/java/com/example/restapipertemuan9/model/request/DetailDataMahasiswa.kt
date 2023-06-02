package com.example.restapipertemuan9.model.request


import com.google.gson.annotations.SerializedName

data class DetailDataMahasiswa(
    @SerializedName("NIM")
    val nim: String,
    @SerializedName("Nama")
    val nama: String,
    @SerializedName("Telepon")
    val telepon: String
)