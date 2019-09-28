package rgor.githubprofile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        val fragments = listOf(
            SearchUsersFragment(),
            Fragment()
        )
        val names = listOf(
            "Users",
            "Repositories"
        )

        val adapter = PagerAdapter(supportFragmentManager, fragments, names)
        viewpager.adapter = adapter
        tabs.setupWithViewPager(viewpager)
    }
}

class PagerAdapter(manager: FragmentManager,
                   private val listFragment: List<Fragment>,
                   private val names : List<String>) : FragmentPagerAdapter(manager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT ) {

    override fun getItem(position: Int): Fragment {
        return listFragment[position]
    }

    override fun getCount(): Int {
        return listFragment.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return names[position]
    }
}