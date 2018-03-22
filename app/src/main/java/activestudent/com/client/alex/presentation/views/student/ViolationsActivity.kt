package activestudent.com.client.alex.presentation.views.student

import activestudent.com.client.alex.App
import activestudent.com.client.alex.R
import activestudent.com.client.alex.data.Violations
import activestudent.com.client.alex.model.Message
import activestudent.com.client.alex.presentation.views.recyclerView.adapters.ViolationsAdapter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_violations.*
import kotlinx.android.synthetic.main.my_toolbar.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import javax.inject.Inject

class ViolationsActivity : AppCompatActivity() {

    @Inject
    lateinit var violations: Violations

    @Inject
    lateinit var message: Message

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_violations)
        App.component.inject(this)
        setSupportActionBar(my_toolbar)
        my_toolbar.setNavigationIcon(R.drawable.ic_back)
        my_toolbar.setNavigationOnClickListener({
            onBackPressed()
        })
        recycler.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        recycler.hasFixedSize()

        recycler.adapter = ViolationsAdapter(violations.getViolationsItem()) {
            if (it.violation == "Другое")
                toast("В разработке")
            else {
                message.categoryWork = it.violation
                message.type_work = it.worker
                startActivity<CreatureViolationsActivity>()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.my_menu, menu)
        return super.onCreateOptionsMenu(menu)

    }

}
