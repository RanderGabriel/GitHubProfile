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
import kotlinx.android.synthetic.main.profile_list_item.view.*


class ProfileListAdapter(private val dataSet: MutableList<GitHubProfile>,
                         private val context: Context) : RecyclerView.Adapter<ProfileListAdapter.ViewHolder>() {

    fun replaceItems(newItems : Collection<GitHubProfile>?)
    {
        notifyItemRangeRemoved(0, dataSet.size)
        dataSet.clear()
        newItems?.let { dataSet.addAll(it) }
        notifyItemRangeInserted(0, dataSet.size)
    }

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
        private val picture: ImageView = itemView.picture_image

        fun bind(profile: GitHubProfile) {
            this.title.text = profile.name
            Glide.with(itemView)
                .load(profile.pictureUrl)
                .apply(RequestOptions().override(80, 80))
                .into(picture)
        }
    }
}

