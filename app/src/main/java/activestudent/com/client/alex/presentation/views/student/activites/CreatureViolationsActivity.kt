package activestudent.com.client.alex.presentation.views.student.activites

import activestudent.com.client.alex.App
import activestudent.com.client.alex.R
import activestudent.com.client.alex.model.Message
import activestudent.com.client.alex.presentation.mvp.presenterImpls.student.CreatureViolationsPresenterImpl
import activestudent.com.client.alex.presentation.mvp.view.student.CreatureViolationsView
import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_creature_violations.*
import kotlinx.android.synthetic.main.include_layout.*
import kotlinx.android.synthetic.main.include_layout.view.*
import kotlinx.android.synthetic.main.my_toolbar.*
import org.jetbrains.anko.*
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject


class CreatureViolationsActivity : AppCompatActivity(), CreatureViolationsView {


    @Inject
    lateinit var presenter: CreatureViolationsPresenterImpl

    private var message: Message? = null
    private var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_creature_violations)
        App.component.inject(this)
        presenter.attachView(this)
        setSupportActionBar(my_toolbar)
        my_toolbar.setNavigationIcon(R.drawable.ic_back)
        my_toolbar.setNavigationOnClickListener({
            onBackPressed()
        })
        setListener()
        val intentArray = intent.getStringArrayListExtra("typeWork")
        message = Message(categoryWork = intentArray[1], type_work = intentArray[0])
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
        if (progressDialog != null)
            progressDialog!!.dismiss()
    }

    override fun showProgressDialog() {
        progressDialog = indeterminateProgressDialog("Отправка сообщения")
        progressDialog!!.show()
    }

    override fun onFailure() {
        toast("Сообщение не отправлено")
        startActivity(intentFor<AccountStudent>().clearTop())
    }

    override fun onSuccess() {
        toast("Сообщение успешно отправлено")
        startActivity(intentFor<AccountStudent>().clearTop())
    }


    override fun hideProgressDialog() {
        progressDialog!!.hide()
    }

    private fun setListener() {
        btnSend.setOnClickListener({ onClickBtnSend() })
    }

    private fun onClickBtnSend() {
        if (formCreature.numRoom.text.length == 0)
            toast("Укажите адрес")
        else {
            message?.location = numRoom.text.toString()
            message?.time_state = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").format(Date())
            message?.description = description.text.toString()
            message?.id_stud = presenter.getStudId()
            presenter.sendMessage(message!!)
        }
    }
}
