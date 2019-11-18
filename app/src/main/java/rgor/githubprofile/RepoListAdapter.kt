package rgor.githubprofile

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.repo_list_item.view.*

class RepoListAdapter(private val dataSet: MutableList<GitHubRepo>,
                      private val context: Context
) : RecyclerView.Adapter<RepoListAdapter.ViewHolder>() {

    fun addItems(newItems: Collection<GitHubRepo>?)
    {
        newItems?.let {
            val oldSize = dataSet.size
            dataSet.addAll(dataSet.size - 1, newItems)
            notifyItemRangeInserted(oldSize - 1, newItems.size)
        }
    }

    fun replaceItems(newItems : Collection<GitHubRepo>?)
    {
        notifyItemRangeRemoved(0, dataSet.size)
        dataSet.clear()
        newItems?.let { dataSet.addAll(it) }
        notifyItemRangeInserted(0, dataSet.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.repo_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val repo = dataSet[position]
        holder.bind(repo)
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        private val title: TextView = itemView.name_label
        private val desc: TextView = itemView.desc_label

        fun bind(repo: GitHubRepo) {
            this.title.text = repo.name
            this.desc.text = repo.desc
        }
    }
}