package com.vicky7230.monumental.ui._3login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.google.gson.JsonElement
import com.vicky7230.monumental.data.network.Resource
import com.vicky7230.monumental.data.network.Status
import com.vicky7230.monumental.databinding.ActivityLoginBinding
import com.vicky7230.monumental.extensions.isEmail
import com.vicky7230.monumental.ui._0base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel
import retrofit2.Response

class LoginActivity : BaseActivity() {

    private lateinit var binding: ActivityLoginBinding

    private val loginViewModel: LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.getOtp.setOnClickListener {
            if (binding.emailField.text.toString().isEmail()) {

                loginViewModel.getOTP().observe(
                    this@LoginActivity,
                    Observer { response: Resource<Response<JsonElement>> ->
                        when (response.status) {
                            Status.SUCCESS -> {

                            }
                            Status.LOADING -> {

                            }
                        }
                    })

            }
        }

    }
}