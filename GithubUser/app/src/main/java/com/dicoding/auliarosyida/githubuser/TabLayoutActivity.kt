package com.dicoding.auliarosyida.githubuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.StringRes
import com.dicoding.auliarosyida.githubuser.databinding.ActivityTabLayoutBinding
import com.google.android.material.tabs.TabLayoutMediator

class TabLayoutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTabLayoutBinding

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.tag_profile,
            R.string.tag_followers,
            R.string.tag_following
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTabLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sectionsPagerAdapter = SectionsPagerAdapter(this)
        binding.viewPager.adapter = sectionsPagerAdapter
        TabLayoutMediator(binding.tabs, binding.viewPager) { tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()
        supportActionBar?.elevation = 0f
    }
}