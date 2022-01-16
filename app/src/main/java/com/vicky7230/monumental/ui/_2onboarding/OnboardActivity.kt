package com.vicky7230.monumental.ui._2onboarding

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import com.vicky7230.monumental.R
import com.vicky7230.monumental.databinding.ActivityOnboardingBinding
import com.vicky7230.monumental.extensions.StatusIconColorType
import com.vicky7230.monumental.extensions.setStatusBarAndNavigationBarColor
import com.vicky7230.monumental.ui._3login.LoginActivity
import org.koin.android.ext.android.inject

class OnboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnboardingBinding

    private var dotsArray: Array<AppCompatImageView?>? = null

    private val onboardAdapter: OnboardAdapter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setStatusBarAndNavigationBarColor(
            ContextCompat.getColor(this, R.color.white),
            StatusIconColorType.Dark
        )

        val list = mutableListOf<OnboardItem>()
        list.add(
            OnboardItem(
                getString(R.string.onboard_heading_2),
                R.drawable.onboard_2,
                ""
            )
        )
        list.add(
            OnboardItem(
                getString(R.string.onboard_heading_3),
                R.drawable.onboard_3,
                ""
            )
        )
        list.add(
            OnboardItem(
                getString(R.string.onboard_heading_1),
                R.drawable.account,
                ""
            )
        )
        onboardAdapter.addItems(list)

        binding.onboardPager.adapter = onboardAdapter
        binding.onboardPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {}

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                for (i in 0 until (dotsArray?.size ?: 0))
                    dotsArray?.get(i)?.setImageResource(R.drawable.nonselected_drawable)
                dotsArray?.get(position)?.setImageResource(R.drawable.selected_drawable)

                if (position == 2) {
                    binding.buttonGroup.visibility = View.GONE
                    binding.getStarted.visibility = View.VISIBLE
                } else{
                    binding.buttonGroup.visibility = View.VISIBLE
                    binding.getStarted.visibility = View.GONE
                }
            }
        })

        dotsArray = arrayOfNulls(list.size)
        for (i in 0 until list.size) {
            dotsArray?.set(i, AppCompatImageView(this))
            val params = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(5, 0, 5, 0)
            dotsArray?.get(i)?.layoutParams = params
            dotsArray?.get(i)?.setImageResource(R.drawable.nonselected_drawable)
            binding.dots.addView(dotsArray?.get(i))
            //binding.dots.bringToFront()
        }

        dotsArray?.get(0)?.setImageResource(R.drawable.selected_drawable)

        binding.next.setOnClickListener {
            binding.onboardPager.setCurrentItem(binding.onboardPager.currentItem + 1, true)
        }

        binding.skip.setOnClickListener {
            binding.onboardPager.setCurrentItem(2,true)
        }

        binding.getStarted.setOnClickListener {
            startActivity(Intent(this@OnboardActivity, LoginActivity::class.java))
        }
    }
}