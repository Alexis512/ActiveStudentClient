package activestudent.com.client.alex.presentation.views

import activestudent.com.client.alex.App
import activestudent.com.client.alex.R
import activestudent.com.client.alex.model.Messages
import activestudent.com.client.alex.presentation.mvp.presenterImpl.CreatureViolationsPresenterImpl
import activestudent.com.client.alex.presentation.mvp.view.CreatureViolationsView
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_creature_violations.*
import org.jetbrains.anko.startActivity
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject


class CreatureViolationsActivity : AppCompatActivity(), CreatureViolationsView {
    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }

    @Inject
    lateinit var messages: Messages
    @Inject
    lateinit var presenter: CreatureViolationsPresenterImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_creature_violations)
        App.component.inject(this)
        presenter.attachView(this)
        setListener()
    }

    fun setListener() {
        btnSend.setOnClickListener({ onClickBtnSend() })
    }

    fun onClickBtnSend() {
        messages.location = "Общежитие №" + edHostel.text + " , комната №" + edRoom.text
        messages.time_state = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").format(Date())
        messages.id_stud = presenter.getStudId()
        presenter.sendMessage()
        startActivity<AccountStudent>()
    }
}
