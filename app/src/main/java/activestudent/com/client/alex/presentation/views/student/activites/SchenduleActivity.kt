package activestudent.com.client.alex.presentation.views.student.activites

import activestudent.com.client.alex.R
import activestudent.com.client.alex.presentation.views.student.fragments.SchenduleCallsFragment
import activestudent.com.client.alex.presentation.views.student.fragments.SchenduleLessonFragment
import activestudent.com.client.alex.presentation.views.tabLayout.ViewPagerAdapter
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_schendule.*
import kotlinx.android.synthetic.main.my_toolbar.*

class SchenduleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schendule)
        setSupportActionBar(my_toolbar)
        my_toolbar.setNavigationIcon(R.drawable.ic_back)
        my_toolbar.setNavigationOnClickListener({
            onBackPressed()
        })
        setupViewPager(vpSchendule)
        tlSchundule.setupWithViewPager(vpSchendule)

    }

    private fun setupViewPager(pager: ViewPager) {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(SchenduleLessonFragment(), "Расписание занятий")
        adapter.addFragment(SchenduleCallsFragment(), "Расписание звонков")
        pager.adapter = adapter
    }
}
