package rgor.githubprofile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.logging.Logger

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        val text = search_text.text.toString()
        WebClient().userService().query(text).enqueue(object: Callback<UserResponse> {
            override fun onFailure(call: Call<UserResponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                adapter.replaceItems(response.body()!!.users)
            }
        })
    }

    private lateinit var recyclerView : RecyclerView
    private lateinit var adapter : ProfileListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = recycler_view
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ProfileListAdapter(ArrayList(), this)
        recyclerView.adapter = adapter
        search_button.setOnClickListener(this)
    }

    fun createAdapter(list : List<GitHubProfile>)
    {
        adapter = ProfileListAdapter(list as MutableList<GitHubProfile>, this)
    }
}
