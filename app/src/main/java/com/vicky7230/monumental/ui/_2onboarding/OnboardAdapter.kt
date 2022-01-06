package com.vicky7230.monumental.ui._2onboarding

import android.os.Build
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.vicky7230.monumental.R

class OnboardAdapter(
    private val list: MutableList<OnboardItem>
) : PagerAdapter() {

    fun addItems(onboardList: List<OnboardItem>) {
        this.list.addAll(onboardList)
        notifyDataSetChanged()
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val layout =
            LayoutInflater.from(container.context).inflate(R.layout.onboard_item, container, false)
        val heading = layout.findViewById<AppCompatTextView>(R.id.heading)
        heading.text = list[position].heading

        Glide
            .with(container.context)
            .load(list[position].image)
            .into(layout.findViewById<AppCompatImageView>(R.id.image))
        container.addView(layout)
        return layout
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun isViewFromObject(view: View, `object`: Any) = view == `object`

    override fun getCount() = list.size
}