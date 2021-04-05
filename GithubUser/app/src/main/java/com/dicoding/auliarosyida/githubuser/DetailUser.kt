package com.dicoding.auliarosyida.githubuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.auliarosyida.githubuser.databinding.ActivityDetailUserBinding
import com.dicoding.auliarosyida.githubuser.databinding.ActivityMainBinding

class DetailUser : AppCompatActivity() {
    private var title: String = "User Detail"
    private lateinit var binding: ActivityDetailUserBinding

    companion object {
        const val EXTRA_USER = "extra_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = intent.getParcelableExtra<User>(EXTRA_USER) as User

        Glide.with(this)
            .load(user.photo)
            .apply(RequestOptions().override(550, 550))
            .into(binding.imgReceivedPhoto)
        binding.tvReceivedUsername.text = user.username
        binding.tvReceivedName.text = user.name
        binding.tvReceivedLocation.text = user.location
        binding.tvReceivedCompany.text = user.company
        binding.tvReceivedRepo.text = user.repository.toString()
        binding.tvReceivedFollowers.text = user.followers.toString()
        binding.tvReceivedFollowing.text = user.following.toString()
        binding.repo.text = getString(R.string.tag_repo)
        binding.follower.text = getString(R.string.tag_followers)
        binding.following.text = getString(R.string.tag_following)

        title = "Detail of ${user.name}"
        setActionBarTitle(title)
    }

    private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }
}