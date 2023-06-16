package com.example.restapipertemuan9.network

import com.example.restapipertemuan9.model.request.MahasiswaData
import com.example.restapipertemuan9.model.response.ResponseDelete
import com.example.restapipertemuan9.model.response.ResponsePostData
import com.example.restapipertemuan9.model.response.ResponseUpdate
import com.example.restapipertemuan9.model.response.ResponseDataMahasiswa
import com.example.restapipertemuan9.model.response.ResponseDetailMahasiswa
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @GET("datamahasiswa/")
    fun getDataMahasiswa() : Call<ResponseDataMahasiswa>

    @GET("datamahasiswa/{nim}")
    fun getDetailMahasiswa(@Path("nim") nim : String) : Call<ResponseDetailMahasiswa>

    @POST("datamahasiswa/")
    fun addDataMahasiswa(@Body data : MahasiswaData) : Call<ResponsePostData>

    @POST("dataMahasiswa/{nim}")
    fun updateDataMahasiswa(@Path("nim") nim: String, @Body data : MahasiswaData) : Call<ResponseUpdate>

    @DELETE("dataMahasiswa/{nim}")
    fun deleteDataMahasiswa(@Path("nim") nim: String) : Call<ResponseDelete>
}