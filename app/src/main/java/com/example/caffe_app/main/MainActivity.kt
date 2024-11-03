package com.example.caffe_app.main

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatDelegate
import com.example.caffe_app.R
import com.example.caffe_app.main.history.HistoryFragment
import com.example.caffe_app.main.order.OrderFragment
import com.example.caffe_app.main.product.HomeFragment
import com.example.caffe_app.main.setting.SettingFragment


class MainActivity : AppCompatActivity() {

    private lateinit var toolbarText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setContentView(R.layout.activity_main)

        toolbarText = findViewById(R.id.toolbarText)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        replaceFragment(HomeFragment())

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.HomeFragment -> {
                    replaceFragment(HomeFragment())
                    toolbarText.text = "Menu Cafe"
                }
                R.id.OrderFragment -> {
                    replaceFragment(OrderFragment())
                    toolbarText.text = "Daftar Pesanan"
                }
                R.id.HistoryFragment -> {
                    replaceFragment(HistoryFragment())
                    toolbarText.text = "History"
                }
                R.id.SettingFragment -> {
                    replaceFragment(SettingFragment())
                    toolbarText.text = "Settings"
                }
                else -> false
            }
            true
        }
    }

     fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}
