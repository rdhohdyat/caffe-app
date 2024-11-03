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
import com.example.caffe_app.main.MainActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.login)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val loginButton: Button = findViewById(R.id.loginButton)
        val registerLink: TextView = findViewById(R.id.daftar);

        var emailText: EditText = findViewById(R.id.emailInput)
        var passwordText: EditText = findViewById(R.id.passwordInput)

        val sharedPref: SharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)

        val isLogin = sharedPref.getString("isLogin", null)

        if (isLogin.equals("1")) {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
            finish()
        }

        loginButton.setOnClickListener {
            val emailInput = emailText.text.toString()
            val passwordInput = passwordText.text.toString()

            val email = sharedPref.getString("email", null).toString()
            val password = sharedPref.getString("password", null).toString()

            if (emailInput.isNotEmpty() && password.isNotEmpty() && emailInput == email && passwordInput == password) {
               val editor = sharedPref.edit()
                editor.putString("isLogin", "1")
                editor.apply()

                val i = Intent(this, MainActivity::class.java)
                startActivity(i)
            } else {
                showSnackBar("Mohon isi akun anda untuk masuk")
            }
        }

        registerLink.setOnClickListener {
            val i = Intent(this, RegisterActivity::class.java)
            startActivity(i)
            finish()
        }
    }

    private fun showSnackBar(message: String) {
        val view = this.findViewById<View>(android.R.id.content)
        val snackbar = Snackbar.make(view, message, Snackbar.LENGTH_LONG)

        snackbar.show()
    }
}