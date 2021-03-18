package com.dicoding.auliarosyida.githubuser

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: UserAdapter
    private lateinit var dataUsername: Array<String>
    private lateinit var dataName: Array<String>
    private lateinit var dataLocation: Array<String>
    private lateinit var dataRepository: Array<String>
    private lateinit var dataCompany: Array<String>
    private lateinit var dataFollowers: Array<String>
    private lateinit var dataFollowing: Array<String>
    private lateinit var dataPhoto: TypedArray
    private var users = arrayListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView: ListView = findViewById(R.id.lv_list)
        adapter = UserAdapter(this)
        listView.adapter = adapter

        //untuk inisialisasi array
        prepare()
        //untuk memasukkan data
        addItem()

        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            Toast.makeText(this@MainActivity, users[position].name, Toast.LENGTH_SHORT).show()
        }
    }

    //menyiapkan data
    private fun prepare() {
        dataUsername = resources.getStringArray(R.array.username)
        dataName = resources.getStringArray(R.array.name)
        dataLocation = resources.getStringArray(R.array.location)
        dataRepository = resources.getStringArray(R.array.repository)
        dataCompany = resources.getStringArray(R.array.company)
        dataFollowers = resources.getStringArray(R.array.followers)
        dataFollowing = resources.getStringArray(R.array.following)
        dataPhoto = resources.obtainTypedArray(R.array.avatar)
    }
    private fun addItem() {
        for (position in dataName.indices) {
            val user = User(
                dataUsername[position],
                dataName[position],
                dataLocation[position],
                dataRepository[position],
                dataCompany[position],
                dataFollowers[position],
                dataFollowing[position],
                dataPhoto.getResourceId(position, -1),
            )
            users.add(user)
        }
        adapter.users = users
    }
}