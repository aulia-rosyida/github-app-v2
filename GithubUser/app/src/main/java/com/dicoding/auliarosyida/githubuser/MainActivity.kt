package com.dicoding.auliarosyida.githubuser

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.auliarosyida.githubuser.databinding.ActivityMainBinding
import com.google.gson.Gson
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpClient.log
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    private var title: String = "Github User List"
    private var tempSearch = "aulia-"

    private lateinit var binding: ActivityMainBinding
    private var users = mutableListOf<User>()

    private var listUserAdapter = UserAdapter(users)
    var dummyUser = User("Please try with another username","Sorry, this username could not been find", "", "","","","","")

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

        listUserAdapter.setOnItemClickCallback(object : UserAdapter.OnItemClickCallback{
            override fun onItemClicked(data: User) {
                getDetailUserApi(data)
            }
        })
    }

    private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }

   override fun onCreateOptionsMenu(menu: Menu): Boolean {
       val inflater = menuInflater
       inflater.inflate(R.menu.option_menu, menu)

       val manageSearch = getSystemService(Context.SEARCH_SERVICE) as SearchManager
       val viewSearch = menu.findItem(R.id.search).actionView as SearchView

       viewSearch.setSearchableInfo(manageSearch.getSearchableInfo(componentName))
       viewSearch.queryHint = resources.getString(R.string.search_hint)
       viewSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
           //method ini ketika search selesai atau OK
           override fun onQueryTextSubmit(query: String): Boolean {
               Toast.makeText(this@MainActivity, query, Toast.LENGTH_SHORT).show()
               tempSearch = query
               log.d(TAG, "ini suda keganti querynyaw $query")
               getUsersApi()
               return true
           }

           // method ini untuk merespon tiap perubahan huruf pada searchView
           override fun onQueryTextChange(newText: String): Boolean {
               return false
           }
       })
       return true
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
            if(users.size == 0 )users.addAll(listUser)
            else if(listUser.size == 0){
                users.clear()
                users.add(dummyUser)
            }
            else{
                users.clear()
                users.addAll(listUser)
            }
            showRecyclerList(users)
        } catch (e: Exception) {
            Toast.makeText(this@MainActivity, e.message, Toast.LENGTH_SHORT).show()
            e.printStackTrace()
        }
    }

    private fun showRecyclerList(usersTemp: MutableList<User>) {
        listUserAdapter = UserAdapter(usersTemp)
        binding.rvList.adapter?.notifyDataSetChanged();
    }

    private fun getDetailUserApi(aUser: User) {
        val clientDetail = AsyncHttpClient()
       clientDetail.addHeader("Authorization", "token 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")
       clientDetail.addHeader("User-Agent", "request")
        val url = "https://api.github.com/users/${aUser.username}"

        clientDetail.get(url, object : AsyncHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Array<Header>, responseBody: ByteArray) {
                // Parsing JSON
                val resultDetail = String(responseBody)

                val gson = Gson()
                val dataObject = JSONObject(resultDetail)
                val newUser = gson.fromJson(dataObject.toString(), User::class.java)
                showSelectedUser(newUser)
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

    private fun showSelectedUser(user: User) {
        val moveWithObjectIntent = Intent(this@MainActivity, TabLayoutActivity::class.java)
        moveWithObjectIntent.putExtra(TabLayoutActivity.EXTRA_USER, user)
        startActivity(moveWithObjectIntent)
    }
}