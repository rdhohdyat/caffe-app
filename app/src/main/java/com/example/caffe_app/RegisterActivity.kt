package com.example.caffe_app

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatDelegate

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setContentView(R.layout.activity_register)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.register)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val loginLink: TextView = findViewById(R.id.masuk);

        loginLink.setOnClickListener {
            val i = Intent(this, LoginActivity::class.java)
            startActivity(i)
        }

        val sharedPref : SharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)

        val emailValue : EditText = findViewById<EditText?>(R.id.emailEditText)
        val passwordValue : EditText = findViewById(R.id.passwordEditText)
        val confirmPasswordValue : EditText = findViewById(R.id.confirmPasswordEditText)

        val registerButton : Button = findViewById(R.id.registerButton)

        registerButton.setOnClickListener {
            val email = emailValue.text.toString()
            val password = passwordValue.text.toString()
            val confirmPassword = confirmPasswordValue.text.toString()

            if(email.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()){
                if(password != confirmPassword){
                    showSnackBar("Password dan konfirmasi password tidak sama!")
                }else {
                    val editor = sharedPref.edit()
                    editor.putString("email", email)
                    editor.putString("password", password)
                    editor.apply()

                    showSnackBar("Berhasil membuat akun!")

                    val i = Intent(this, LoginActivity::class.java)
                    startActivity(i)
                    finish()
                }
            }else {
                showSnackBar("Mohon isi semua kolom inputan")
            }
        }
    }

    private fun showSnackBar(message : String){
        val view = this.findViewById<View>(android.R.id.content)
        val snackbar = Snackbar.make(view,message, Snackbar.LENGTH_LONG)

        snackbar.show()
    }
}