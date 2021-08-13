package com.example.simplecommunity.feature

import android.content.Intent
import android.os.Bundle
import com.example.simplecommunity.R
import com.example.simplecommunity.databinding.ActivityMainBinding
import com.example.simplecommunity.base.BaseActivity

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