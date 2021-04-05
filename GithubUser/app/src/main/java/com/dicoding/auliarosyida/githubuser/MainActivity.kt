package com.dicoding.auliarosyida.githubuser

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.auliarosyida.githubuser.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var title: String = "Github User List"
    private lateinit var binding: ActivityMainBinding
    private var users = arrayListOf<User>()

//    private lateinit var adapter: UserAdapter
//    private lateinit var dataUsername: Array<String>
//    private lateinit var dataName: Array<String>
//    private lateinit var dataLocation: Array<String>
//    private lateinit var dataRepository: Array<String>
//    private lateinit var dataCompany: Array<String>
//    private lateinit var dataFollowers: Array<String>
//    private lateinit var dataFollowing: Array<String>
//    private lateinit var dataPhoto: TypedArray

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setActionBarTitle(title)

        binding.rvList.setHasFixedSize(true)
        users.addAll(getListUsers())
        showRecyclerList()
    }

    private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }

    private fun getListUsers(): ArrayList<User> {

        val dataUsername = resources.getStringArray(R.array.username)
        val dataName = resources.getStringArray(R.array.name)
        val dataLocation = resources.getStringArray(R.array.location)
        val dataRepository = resources.getStringArray(R.array.repository)
        val dataCompany = resources.getStringArray(R.array.company)
        val dataFollowers = resources.getStringArray(R.array.followers)
        val dataFollowing = resources.getStringArray(R.array.following)
        val dataPhoto = resources.obtainTypedArray(R.array.avatar)

        val listUser = ArrayList<User>()
        for (position in dataUsername.indices) {
            val user = User(
                    dataUsername[position],
                    dataName[position],
                    dataLocation[position],
                    dataRepository[position],
                    dataCompany[position],
                    dataFollowers[position],
                    dataFollowing[position],
                    dataPhoto.getResourceId(position, -1)
            )
            listUser.add(user)
        }
        return listUser
    }

    private fun showRecyclerList() {
        binding.rvList.layoutManager = LinearLayoutManager(this)
        val listUserAdapter = UserAdapter(users)
        binding.rvList.adapter = listUserAdapter

        listUserAdapter.setOnItemClickCallback(object : UserAdapter.OnItemClickCallback{
            override fun onItemClicked(data: User) {
                showSelectedUser(data)
            }
        })
    }

    private fun showSelectedUser(user: User) {
        Toast.makeText(this, "Kamu memilih ${user.name}", Toast.LENGTH_SHORT).show()
    }
}