package com.dicoding.auliarosyida.githubuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailUser : AppCompatActivity() {
    private var title: String = "User Detail"

    companion object {
        const val EXTRA_USER = "extra_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_user)

        val tvImageReceived: ImageView = findViewById(R.id.img_received_photo)
        val tvUnameReceived: TextView = findViewById(R.id.tv_received_username)
        val tvNameReceived: TextView = findViewById(R.id.tv_received_name)
        val tvLocationReceived: TextView = findViewById(R.id.tv_received_location)
        val tvCompanyReceived: TextView = findViewById(R.id.tv_received_company)
        val tvRepoReceived: TextView = findViewById(R.id.tv_received_repo)
        val tvFollowersReceived: TextView = findViewById(R.id.tv_received_followers)
        val tvFollowingReceived: TextView = findViewById(R.id.tv_received_following)
        val tvRepo: TextView = findViewById(R.id.repo)
        val tvFollower: TextView = findViewById(R.id.follower)
        val tvFollowing: TextView = findViewById(R.id.following)

        val user = intent.getParcelableExtra<User>(EXTRA_USER) as User
        tvImageReceived.setImageResource(user.photo)
        tvUnameReceived.text = user.username.toString()
        tvNameReceived.text = user.name.toString()
        tvLocationReceived.text = user.location.toString()
        tvCompanyReceived.text = user.company.toString()
        tvRepoReceived.text = user.repository.toString()
        tvFollowersReceived.text = user.followers.toString()
        tvFollowingReceived.text = user.following.toString()
        tvRepo.text = getString(R.string.tag_repo)
        tvFollower.text = getString(R.string.tag_followers)
        tvFollowing.text = getString(R.string.tag_following)

        title = "Detail of ${user.name.toString()}"
        setActionBarTitle(title)
    }

    private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }
}