package com.example.mvpsample.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mvpsample.R
import com.example.mvpsample.main.MainActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity(), LoginContract.View {

    override lateinit var presenter : LoginPresenter

    lateinit var loginInput : TextInputEditText
    lateinit var passwordInput : TextInputEditText
    lateinit var loginButton : MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        presenter = LoginPresenter(this)
        presenter.start()

        loginButton.setOnClickListener {
            presenter.isLoginValid(loginInput.text.toString(), passwordInput.text.toString())
        }
    }

    override fun onStart() {
        super.onStart()
        clearErrors()
    }

    override fun displayErrorMessage() {
        Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
        loginInput.error = "Login Failed!"
        passwordInput.error = "Login Failed!"
    }

    override fun displaySuccessMessage() {
        Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
    }

    override fun clearErrors() {
        loginInput.error = null
        passwordInput.error = null
    }

    override fun startMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    override fun bindViews() {
        loginInput = findViewById(R.id.et_login)
        passwordInput = findViewById(R.id.et_password)
        loginButton = findViewById(R.id.btn_login)
    }
}