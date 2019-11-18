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

class SearchRepositoriesFragment : Fragment(), View.OnClickListener {

    var page = 1
    var text = ""
    override fun onClick(v: View?) {
        fetchApi()
    }

    private fun fetchApi() {
        val text = search_text.text.toString()
        WebClient().userService().queryRepositories(text, page).enqueue(object : Callback<ReposResponse> {
            override fun onFailure(call: Call<ReposResponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<ReposResponse>, response: Response<ReposResponse>) {
                adapter.replaceItems(response.body()?.items)
            }
        })
    }

    private lateinit var recyclerView : RecyclerView
    private lateinit var adapter : RepoListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? = inflater.inflate(R.layout.search_users_activity, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(context==null) return
        adapter = RepoListAdapter(ArrayList(), context!!)
        recyclerView = recycler_view
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = adapter
        recyclerView.addOnScrollListener(PaginateListener(recyclerView.layoutManager as LinearLayoutManager, this))
        search_button.setOnClickListener(this)
    }


    fun callNextPage() {
        page++
        fetchApi()
    }

    class PaginateListener(private val manager: LinearLayoutManager, private val listener: SearchRepositoriesFragment) : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            val total = manager.itemCount - 1
            val lastVisibleIndex = manager.findLastVisibleItemPosition()
            if(lastVisibleIndex == total)
            {
                listener.callNextPage()
            }
        }

    }

}