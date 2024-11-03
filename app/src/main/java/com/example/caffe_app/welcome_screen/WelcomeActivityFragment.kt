package com.example.caffe_app.welcome_screen

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.caffe_app.LoginActivity
import com.example.caffe_app.R
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

class WelcomeActivityFragment : AppCompatActivity() {
    private lateinit var viewPager : ViewPager2
    private lateinit var dotsIndicator : DotsIndicator
    private lateinit var btnNext : Button
    private lateinit var btnSkip : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_welcome_fragment)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        viewPager = findViewById(R.id.viewPager)
        dotsIndicator = findViewById(R.id.dot_indicator)
        btnNext = findViewById(R.id.btnNext)
        btnSkip = findViewById(R.id.btnSkip)

        val fragmentList = listOf(Welcome1Fragment(), Welcome2Fragment(), Welcome3Fragment())
        val adapter = PagerAdapter(this, fragmentList)
        viewPager.adapter = adapter

        dotsIndicator.attachTo(viewPager)

        btnNext.setOnClickListener {
            if(viewPager.currentItem < fragmentList.size - 1){
                viewPager.currentItem +=1
            }else {
                finishWelcomeScreen()
            }
        }

        btnSkip.setOnClickListener {
            finishWelcomeScreen()
        }

        viewPager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if(position == fragmentList.size - 1){
                    btnNext.text = "Mulai Sekarang"
                    btnSkip.visibility = View.GONE
                    btnNext.background = ContextCompat.getDrawable(this@WelcomeActivityFragment, R.drawable.button_background)
                }else {
                    btnNext.text = "Next"
                    btnNext.background = ContextCompat.getDrawable(this@WelcomeActivityFragment, R.drawable.background_orange)
                    btnSkip.visibility = View.VISIBLE
                }
            }
        })
    }

    private  fun finishWelcomeScreen(){
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}