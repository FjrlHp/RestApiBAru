package com.example.restapipertemuan9.model.response


import com.example.restapipertemuan9.model.request.DataMahasiswa
import com.google.gson.annotations.SerializedName

data class ResponseDataMahasiswa(
    @SerializedName("data")
    val `data`: List<DataMahasiswa>,
    @SerializedName("status")
    val status: String
)