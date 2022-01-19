package com.vicky7230.monumental.ui._3login

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import com.google.gson.JsonElement
import com.vicky7230.monumental.R
import com.vicky7230.monumental.data.network.Resource
import com.vicky7230.monumental.data.network.Status
import com.vicky7230.monumental.databinding.ActivityLoginBinding
import com.vicky7230.monumental.extensions.StatusIconColorType
import com.vicky7230.monumental.extensions.isEmail
import com.vicky7230.monumental.extensions.setStatusBarAndNavigationBarColor
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

        setStatusBarAndNavigationBarColor(
            ContextCompat.getColor(this, R.color.sky),
            StatusIconColorType.Dark
        )

        binding.getOtp.setOnClickListener {
            if (binding.emailField.text?.trim().toString().isEmail()) {

                loginViewModel.getOTP(binding.emailField.text?.trim().toString()).observe(
                    this@LoginActivity,
                    Observer { response: Resource<Response<JsonElement>> ->
                        when (response.status) {
                            Status.SUCCESS -> {
                                hideLoading()
                                showMessage(response.data?.body()?.asJsonObject?.get("message")?.asString)
                                binding.emailContainer.visibility = View.GONE
                                binding.getOtp.visibility = View.GONE
                                binding.otpContainer.visibility = View.VISIBLE
                                binding.verifyOtp.visibility = View.VISIBLE
                            }
                            Status.LOADING -> {
                                showLoading()
                            }
                            Status.ERROR -> {
                                hideLoading()
                                showError(response.message)
                            }
                        }
                    })

            } else {
                showError("Enter a valid Email")
            }
        }

        binding.verifyOtp.setOnClickListener {

            if (binding.otpField.text?.trim().toString().isEmpty()) {
                showError("OTP cannot be empty")
                return@setOnClickListener
            }

            loginViewModel.verifyOTP(
                email = binding.emailField.text?.trim().toString(),
                otp = binding.otpField.text?.trim().toString()
            ).observe(this, Observer {

            })
        }

    }
}