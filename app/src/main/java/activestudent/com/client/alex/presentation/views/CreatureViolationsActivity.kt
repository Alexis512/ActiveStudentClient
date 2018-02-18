package activestudent.com.client.alex.presentation.views

import activestudent.com.client.alex.App
import activestudent.com.client.alex.R
import activestudent.com.client.alex.model.Messages
import activestudent.com.client.alex.presentation.mvp.presenterImpl.CreatureViolationsPresenterImpl
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_creature_violations.*
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject


class CreatureViolationsActivity : AppCompatActivity() {


    @Inject
    lateinit var messages: Messages
    @Inject
    lateinit var presenter: CreatureViolationsPresenterImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_creature_violations)
        App.component.inject(this)
        setListener()
    }

    fun setListener() {
        btnSend.setOnClickListener({ onClickBtnSend() })
    }

    fun onClickBtnSend() {
        messages.address = "Общежитие №" + edHostel.text + " , комната №" + edRoom.text
        messages.timeState = SimpleDateFormat("yyyyMMdd-HHmmss").format(Date())
        messages.studId = presenter.getStudId()
    }
}
