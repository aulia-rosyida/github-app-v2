package com.dicoding.auliarosyida.githubuser

import android.os.Bundle
import android.view.MenuItem
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.auliarosyida.githubuser.databinding.ActivityTabLayoutBinding
import com.google.android.material.tabs.TabLayoutMediator


class TabLayoutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTabLayoutBinding
    private var title: String = "User Detail"

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(
                R.string.tag_profile,
                R.string.tag_followers,
                R.string.tag_following
        )
        const val EXTRA_USER = "extra_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTabLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = intent.getParcelableExtra<User>(EXTRA_USER) as User

        //untuk menghubungkan SectionsPagerAdapter dengan ViewPager2
        val sectionsPagerAdapter = SectionsPagerAdapter(this, user)
        binding.viewPager.adapter = sectionsPagerAdapter

        //menghubungkan ViewPager2 dengan TabLayout dengan menggunakan TabLayoutMediator
        TabLayoutMediator(binding.tabs, binding.viewPager) { tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()
        supportActionBar?.elevation = 0f

        title = "Detail of ${user.name?: user.username}"
        setActionBarTitle(title)

        // calling the action bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }

    // function to the button on press
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}