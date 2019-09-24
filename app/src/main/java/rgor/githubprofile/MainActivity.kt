package rgor.githubprofile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView : RecyclerView
    private lateinit var adapter : ProfileListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = recycler_view
        recyclerView.layoutManager = LinearLayoutManager(this)
        val list : List<GitHubProfile> = listOf(
            GitHubProfile("Randinho", 10, "https://avatars0.githubusercontent.com/u/1?v=4"),
            GitHubProfile("Randinho", 10, "https://avatars0.githubusercontent.com/u/1?v=4"),
            GitHubProfile("Randinho", 10, "https://avatars0.githubusercontent.com/u/1?v=4"),
            GitHubProfile("Randinho", 10, "https://avatars0.githubusercontent.com/u/1?v=4")
        )
        adapter = ProfileListAdapter(list, this)
        recyclerView.adapter = adapter

    }
}
