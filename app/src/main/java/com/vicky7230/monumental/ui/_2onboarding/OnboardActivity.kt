package com.vicky7230.monumental.ui._2onboarding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import com.vicky7230.monumental.R
import com.vicky7230.monumental.databinding.ActivityOnboardingBinding
import com.vicky7230.monumental.extensions.StatusIconColorType
import com.vicky7230.monumental.extensions.setStatusBarAndNavigationBarColor
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

        setStatusBarAndNavigationBarColor(ContextCompat.getColor(this,R.color.white), StatusIconColorType.Dark)

        val list = mutableListOf<OnboardItem>()
        list.add(OnboardItem(getString(R.string.onboard_heading_1),R.drawable.onboard_1,getString(R.string.onboard_message)))
        list.add(OnboardItem(getString(R.string.onboard_heading_2),R.drawable.onboard_2,getString(R.string.onboard_message)))
        list.add(OnboardItem(getString(R.string.onboard_heading_3),R.drawable.onboard_3,getString(R.string.onboard_message)))
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
            binding.dots.bringToFront()
        }

        dotsArray?.get(0)?.setImageResource(R.drawable.selected_drawable)
    }
}