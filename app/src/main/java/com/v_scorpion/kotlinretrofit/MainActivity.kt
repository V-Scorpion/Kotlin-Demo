package com.v_scorpion.kotlinretrofit

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import dmax.dialog.SpotsDialog
import retrofit2.Call
import retrofit2.Callback


import com.v_scorpion.kotlinretrofit.databinding.ActivityMainBinding


import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var mService: RetrofitServices
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: MyMovieAdapter
    lateinit var dialog: AlertDialog


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mService = Common.retrofitService

        binding.recyclerMovieList.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        binding.recyclerMovieList.layoutManager = layoutManager
        dialog = SpotsDialog.Builder().setCancelable(true).setContext(this).build()

        getAllMovieList()
    }

    private fun getAllMovieList() {
        dialog.show()
        mService.getMovieList().enqueue(object : Callback<MutableList<PojoMovie>> {
            override fun onFailure(call: Call<MutableList<PojoMovie>>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<MutableList<PojoMovie>>,
                response: Response<MutableList<PojoMovie>>
            ) {
                adapter = MyMovieAdapter(response.body() as MutableList<PojoMovie>)
                adapter.notifyDataSetChanged()
                binding.recyclerMovieList.adapter = adapter

                dialog.dismiss()
            }
        })
    }
}