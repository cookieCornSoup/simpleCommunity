package com.example.myapplication.feature

import android.content.Intent
import android.os.Bundle
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.feature.singup.BaseActivity
import com.example.myapplication.feature.singup.EmailCheckActivity

class MainActivity : BaseActivity<ActivityMainBinding>({ ActivityMainBinding.inflate(it) }) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.scrap -> {

                    true
                }
                R.id.writing -> {
                    startActivity(Intent(this@MainActivity, PostWriting::class.java))
                    true
                }
                else -> false
            }
        }


    }
}