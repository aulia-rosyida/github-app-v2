package com.dicoding.auliarosyida.githubuser

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class SectionsPagerAdapter(activity: AppCompatActivity, detailUser: User) : FragmentStateAdapter(activity) {

    var tempUser: User = detailUser

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = ProfileFragment(tempUser)
            1 -> fragment = FollowersFragment()
            2 -> fragment = FollowingFragment()
        }
        return fragment as Fragment
    }

}