package com.dicoding.auliarosyida.githubuser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.auliarosyida.githubuser.databinding.ActivityMainBinding
import com.google.gson.Gson
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    private var title: String = "Github User List"
    private lateinit var binding: ActivityMainBinding
    private var users = arrayListOf<User>()
    private var tempSearch = "aulia-"
    private var listUserAdapter = UserAdapter(users)

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setActionBarTitle(title)

        binding.rvList.setHasFixedSize(true)
        binding.rvList.adapter = listUserAdapter
        binding.rvList.layoutManager = LinearLayoutManager(this)
        binding.progressBar.visibility = View.VISIBLE

        getUsersApi()
    }

    private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }

    private fun getUsersApi() {
        binding.progressBar.visibility = View.VISIBLE
        val client = AsyncHttpClient()
        client.addHeader("Authorization", "token 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")
        client.addHeader("User-Agent", "request")
        val url = "https://api.github.com/search/users?q=$tempSearch"

        client.get(url, object : AsyncHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Array<Header>, responseBody: ByteArray) {
                // Jika koneksi berhasil
                binding.progressBar.visibility = View.INVISIBLE
                // Parsing JSON
                val result = String(responseBody)
                getListUsers(result)

            }
            override fun onFailure(statusCode: Int, headers: Array<Header>, responseBody: ByteArray, error: Throwable) {
                // Jika koneksi gagal
                binding.progressBar.visibility = View.INVISIBLE
                val errorMessage = when (statusCode) {
                    401 -> "$statusCode : Bad Request"
                    403 -> "$statusCode : Forbidden"
                    404 -> "$statusCode : Not Found"
                    else -> "$statusCode : ${error.message}"
                }
                Toast.makeText(this@MainActivity, errorMessage, Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun getListUsers(response: String) {
        val listUser = ArrayList<User>()

        try{
            val responseObject = JSONObject(response)
            val dataArray = responseObject.getJSONArray("items")

            val gson = Gson()
            for(i in 0 until dataArray.length()){
                val dataObject = dataArray.getJSONObject(i)
                val data = gson.fromJson(dataObject.toString(), User::class.java)
                listUser.add(data)
            }
            users.addAll(listUser)
            showRecyclerList(users)
        } catch (e: Exception) {
            Toast.makeText(this@MainActivity, e.message, Toast.LENGTH_SHORT).show()
            e.printStackTrace()
        }
    }

    private fun showRecyclerList(usersTemp: ArrayList<User>) {
        listUserAdapter = UserAdapter(usersTemp)
        binding.rvList.adapter?.notifyDataSetChanged();

        listUserAdapter.setOnItemClickCallback(object : UserAdapter.OnItemClickCallback{
            override fun onItemClicked(data: User) {
                showSelectedUser(data)
            }
        })
    }

    private fun showSelectedUser(user: User) {
        Toast.makeText(this, "Kamu memilih ${user.name}", Toast.LENGTH_SHORT).show()

        val moveWithObjectIntent = Intent(this@MainActivity, DetailUser::class.java)
        moveWithObjectIntent.putExtra(DetailUser.EXTRA_USER, user)
        startActivity(moveWithObjectIntent)
    }
}