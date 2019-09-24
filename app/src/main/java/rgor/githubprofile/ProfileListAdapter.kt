package rgor.githubprofile

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.profile_list_item.view.*


class ProfileListAdapter(private val dataSet: List<GitHubProfile>,
                         private val context: Context) : RecyclerView.Adapter<ProfileListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.profile_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val profile = dataSet[position]
        holder.bind(profile)
    }



    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        private val title: TextView = itemView.name_label
        private val reposCount: TextView = itemView.repo_count
        private val picture: ImageView = itemView.picture_image

        fun bind(profile: GitHubProfile) {
            this.title.text = profile.name
            this.reposCount.text = profile.repoCount.toString()
            Glide.with(itemView)
                .load(profile.pictureUrl)
                .into(picture)
        }
    }
}

