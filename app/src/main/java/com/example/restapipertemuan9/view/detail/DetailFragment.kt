package com.example.restapipertemuan9.view.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.restapipertemuan9.R
import com.example.restapipertemuan9.databinding.FragmentDetailBinding
import com.example.restapipertemuan9.viewmodel.ViewModelMahasiswa

class DetailFragment : Fragment() {
    lateinit var binding : FragmentDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val nim = arguments?.getString("nim")

        val viewModel = ViewModelProvider(this).get(ViewModelMahasiswa::class.java)
        viewModel.getDetailDataMahasiswa().observe(viewLifecycleOwner){
            if(it != null){
                binding.txtnama.text = it.data?.nama
                binding.txtnim.text = it.data?.nim
                binding.txtTelepon.text = it.data?.telepon
            }else{
                Toast.makeText(context,"Data not found",Toast.LENGTH_SHORT).show()
            }
        }
        viewModel.getDetailData(nim!!)
    }
}