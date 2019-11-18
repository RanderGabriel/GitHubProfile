package rgor.githubprofile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.search_users_activity.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchUsersFragment : Fragment(), View.OnClickListener {
    override fun onClick(v: View?) {
        val text = search_text.text.toString()
        WebClient().userService().queryUsers(text).enqueue(object: Callback<UserResponse> {
            override fun onFailure(call: Call<UserResponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                adapter.replaceItems(response.body()!!.users)
            }
        })
    }

    private lateinit var recyclerView : RecyclerView
    private lateinit var adapter : ProfileListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? = inflater.inflate(R.layout.search_users_activity, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(context==null) return
        adapter = ProfileListAdapter(ArrayList(), context!!)
        recyclerView = recycler_view
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = adapter
        search_button.setOnClickListener(this)
    }
}
