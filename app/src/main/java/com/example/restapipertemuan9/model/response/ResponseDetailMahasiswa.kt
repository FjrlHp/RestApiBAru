package com.example.restapipertemuan9.model.response


import com.example.restapipertemuan9.model.request.DetailDataMahasiswa
import com.google.gson.annotations.SerializedName

data class ResponseDetailMahasiswa(
    @SerializedName("data")
    val data : DetailDataMahasiswa,
    @SerializedName("status")
    val status: String
)