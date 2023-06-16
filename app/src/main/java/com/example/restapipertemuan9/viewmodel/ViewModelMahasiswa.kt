package com.example.restapipertemuan9.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.restapipertemuan9.model.request.MahasiswaData
import com.example.restapipertemuan9.model.response.ResponseDelete
import com.example.restapipertemuan9.model.response.ResponsePostData
import com.example.restapipertemuan9.model.response.ResponseUpdate
import com.example.restapipertemuan9.model.request.DataMahasiswa
import com.example.restapipertemuan9.model.response.ResponseDataMahasiswa
import com.example.restapipertemuan9.model.response.ResponseDetailMahasiswa
import com.example.restapipertemuan9.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelMahasiswa : ViewModel() {
    private val getDataMahasiswa = MutableLiveData<List<DataMahasiswa>?>()
    private val getDetailDataMahasiswa = MutableLiveData<ResponseDetailMahasiswa?>()
    private val insertMahasiswa = MutableLiveData<ResponsePostData?>()
    private val updateMahasiswa = MutableLiveData<ResponseUpdate?>()
    private val deleteMahasiswa = MutableLiveData<ResponseDelete?>()

    fun getDataMahasiswa() : MutableLiveData<List<DataMahasiswa>?>{
        return getDataMahasiswa
    }

    fun getDetailDataMahasiswa() : MutableLiveData<ResponseDetailMahasiswa?>{
        return getDetailDataMahasiswa
    }

    fun insertDataMahasiswa() : MutableLiveData<ResponsePostData?>{
        return insertMahasiswa
    }

    fun updateMahasiswa() : MutableLiveData<ResponseUpdate?>{
        return updateMahasiswa
    }

    fun deleteDataMahasiswa() : MutableLiveData<ResponseDelete?>{
        return deleteMahasiswa
    }

    fun showDataMahasiswa(){
        ApiClient.instance.getDataMahasiswa().enqueue(object : Callback<ResponseDataMahasiswa>{
            override fun onResponse(
                call: Call<ResponseDataMahasiswa>,
                response: Response<ResponseDataMahasiswa>
            ) {
                if (response.isSuccessful){
                    getDataMahasiswa.postValue(response.body()?.data)
                }else{
                    getDataMahasiswa.postValue(null)
                }
            }
            override fun onFailure(call: Call<ResponseDataMahasiswa>, t: Throwable) {
                getDataMahasiswa.postValue(null)
            }

        })
    }

    fun getDetailData(nim : String){
        ApiClient.instance.getDetailMahasiswa(nim).enqueue(object : Callback<ResponseDetailMahasiswa>{
            override fun onResponse(
                call : Call<ResponseDetailMahasiswa>,
                response: Response<ResponseDetailMahasiswa>
            ) {
                if (response.isSuccessful){
                    getDetailDataMahasiswa.postValue(response.body())
                }else{
                    getDetailDataMahasiswa.postValue(null)
                }
            }

            override fun onFailure(call: Call<ResponseDetailMahasiswa>, t: Throwable){
                getDetailDataMahasiswa.postValue(null)
            }
        })
    }

    fun insertMahasiswa(nim : String, nama :String,telepon : String){
        ApiClient.instance.addDataMahasiswa(MahasiswaData(nim,nama,telepon)).enqueue(object : Callback<ResponsePostData>{
            override fun onResponse(
                call: Call<ResponsePostData>,
                response: Response<ResponsePostData>
            ) {
                if (response.isSuccessful){
                    insertMahasiswa.postValue(response.body())
                }else{
                    insertMahasiswa.postValue(null)
                }
            }
            override fun onFailure(call: Call<ResponsePostData>, t: Throwable) {
                insertMahasiswa.postValue(null)
            }
        })
    }

    fun updateMahasiswa(nim: String, nama: String, telepon: String){
        ApiClient.instance.updateDataMahasiswa(nim, MahasiswaData(nim, nama, telepon)).enqueue(object : Callback<ResponseUpdate>{
            override fun onResponse(
                call: Call<ResponseUpdate>,
                response: Response<ResponseUpdate>
            ) {
                if (response.isSuccessful){
                    updateMahasiswa.postValue(response.body())
            }else{
                updateMahasiswa.postValue(null)
                }
            }

            override fun onFailure(call: Call<ResponseUpdate>, t: Throwable) {
                updateMahasiswa.postValue(null)
            }
        })
    }

    fun deleteMahasiswa(nim: String){
        ApiClient.instance.deleteDataMahasiswa(nim).enqueue(object : retrofit2.Callback<ResponseDelete>{
            override fun onResponse(
                call: Call<ResponseDelete>,
                response: Response<ResponseDelete>
            ) {
                if (response.isSuccessful) {
                    deleteMahasiswa.postValue(response.body())
                } else {
                    deleteMahasiswa.postValue(null)
                }
            }

            override fun onFailure(call: Call<ResponseDelete>, t: Throwable) {
                deleteMahasiswa.postValue(null)
            }

        })
    }

}