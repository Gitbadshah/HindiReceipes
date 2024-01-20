package com.badshahapps.hindireceipe

import AppDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.badshahapps.hindireceipe.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var rvAdapter: PopularAdapter
    private lateinit var dataList: ArrayList<Recipe>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up RecyclerView and its adapter
        setUpRecyclerView()
    }


    private fun setUpRecyclerView() {
        dataList = ArrayList()

        // Initialize the adapter with an empty list
        rvAdapter = PopularAdapter(dataList, this)
        binding.rvPopular.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvPopular.adapter = rvAdapter
        
        val db: AppDatabase by lazy {
            Room.databaseBuilder(this, AppDatabase::class.java, "db_name")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .createFromAsset("recipe.db")
                .build()
        }

        // Retrieve data from the database
        val daoObject = db.getDao()
        val recipes = daoObject.getAll()

        // Check if recipes is not null before proceeding
        if (recipes != null) {
            for (i in recipes.indices) {
                if (recipes[i]?.category?.contains("Popular") == true) {
                    dataList.add(recipes[i]!!)
                }
            }

            // Notify the adapter that the data set has changed
            rvAdapter.notifyDataSetChanged()
        }
    }



//    private fun setUpRecyclerView() {
//        dataList = ArrayList()
//
//
//        rvAdapter = PopularAdapter(dataList, this)
//        binding.rvPopular.adapter = rvAdapter
//
////        Adapter(Constant.getData(),this)
//
//
//        binding.rvPopular.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
//
//        val db = Room.databaseBuilder(this@HomeActivity, AppDatabase::class.java, "db_name")
//            .allowMainThreadQueries()
//            .fallbackToDestructiveMigration()
//            .createFromAsset("recipe.db")
//            .build()
//
//        val daoObject = db.getDao()
//        val recipes = daoObject.getAll()
//
//        for (i in recipes!!.indices) {
//            if (recipes[i]!!.category.contains("Popular")) {
//                dataList.add(recipes[i]!!)
//            }
//        }
//
//        // Move the adapter initialization and setting outside the loop
//        rvAdapter = PopularAdapter(dataList, this)
//        binding.rvPopular.adapter = rvAdapter
//    }

}