package activestudent.com.client.alex.presentation.views.tabLayout

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class ViewPagerAdapter(fm : FragmentManager) : FragmentPagerAdapter(fm) {

    private var listFragments = ArrayList<Fragment>()
    private var titleFragments = ArrayList<String>()

    override fun getItem(position: Int): Fragment {
        return listFragments[position]
    }

    override fun getCount(): Int {
        return listFragments.size
    }

    fun addFragment(fragment: Fragment, title : String) {
        listFragments.add(fragment)
        titleFragments.add(title)
    }

    override fun getPageTitle(position: Int): CharSequence {
        return  titleFragments[position]
    }
}