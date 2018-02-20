package activestudent.com.client.alex.presentation.views

import activestudent.com.client.alex.App
import activestudent.com.client.alex.R
import activestudent.com.client.alex.data.Violations
import activestudent.com.client.alex.model.Messages
import activestudent.com.client.alex.presentation.views.recyclerView.adapters.ViolationsAdapter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_violations.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import javax.inject.Inject

class ViolationsActivity : AppCompatActivity() {

    @Inject
    lateinit var violations : Violations

    @Inject
    lateinit var messages: Messages

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_violations)
        App.component.inject(this)

        recycler.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        recycler.hasFixedSize()

        recycler.adapter = ViolationsAdapter(violations.getViolationsItem()) {
            if (it.violation == "Другое")
                toast("В разработке")
            else {
                messages.description = it.violation
                messages.type_work = it.worker
                startActivity<CreatureViolationsActivity>()
            }
        }
    }
}
