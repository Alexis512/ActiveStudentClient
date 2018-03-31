package activestudent.com.client.alex.presentation.views.student.activites

import activestudent.com.client.alex.App
import activestudent.com.client.alex.R
import activestudent.com.client.alex.R.id.*
import activestudent.com.client.alex.model.Message
import activestudent.com.client.alex.presentation.mvp.presenterImpls.student.DetailMessagePresenterImpl
import activestudent.com.client.alex.presentation.mvp.view.student.DetailMessageView
import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.detail_message.*
import kotlinx.android.synthetic.main.my_toolbar.*
import org.jetbrains.anko.*
import javax.inject.Inject

class DetailMessageActivity : AppCompatActivity(), DetailMessageView {


    @Inject
    lateinit var detailPresenter: DetailMessagePresenterImpl

    private var progressDialog: ProgressDialog? = null
    private var msg: Message? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_message)
        App.component.inject(this)
        detailPresenter.attachView(this)
        setSupportActionBar(my_toolbar)
        my_toolbar.setNavigationIcon(R.drawable.ic_back)
        my_toolbar.setNavigationOnClickListener({
            onBackPressed()
        })
        setOnClickListener()
        msg = intent.getParcelableExtra("message")
        detailPresenter.onInitViews()
    }

    override fun onRestart() {
        tvDescription.text = msg?.description
        tvAddress.text = msg?.location
        super.onRestart()
    }

    override fun onDestroy() {
        super.onDestroy()
        detailPresenter.detachView()
        if (progressDialog != null)
            progressDialog!!.dismiss()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        if (msg?.status != "done")
            menuInflater.inflate(R.menu.message_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onFailureUpdateStatus() {
        toast("В ходе отправки сообщения произошел сбой")
    }

    override fun onSuccessUpdateStatus() {
        toast("Сообщение отправлено на дополнительное рассмотрение")
        tvStatus.text = "Модерация"
        btnDone.visibility = View.GONE
    }

    override fun showProgressDialog(description: String) {
        progressDialog = indeterminateProgressDialog(description)
        progressDialog!!.show()
    }

    override fun hideProgressDialog(description: String) {
        progressDialog!!.hide()
    }

    override fun onSuccessDeleteMessage() {
        finish()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            delete -> detailPresenter.onShowAlertDialog()
            edit -> startActivityForResult(intentFor<EditMessageActivity>("message" to msg), 1)
        }
        return true
    }

    override fun initTextViews() {
        tvHeader.text = msg?.categoryWork
        tvTimeState.text = detailPresenter.convertTime(msg?.time_state!!)
        if (msg?.time_impl == null) {
            tvTimeImpl.text = "-"
            tvExecutor.text = "-"
        } else {
            tvTimeImpl.text = detailPresenter.convertTime(msg?.time_impl!!)
            tvExecutor.text = msg?.executor
        }
        tvAddress.text = msg?.location
        tvStatus.text = detailPresenter.convertStatus(msg?.status!!)
        tvDescription.text = msg?.description
        tvNumMessage.text = msg?.numMessage
        if (msg?.status == "done") {
            btnDone.visibility = View.VISIBLE
        }
    }

    override fun showAlertDialog() {
        alert("Вы действительно хотите удалить сообщение?", "Удаление") {
            yesButton {
                detailPresenter.onDeleteMessage(msg?._id)
            }
            cancelButton { "Отмена" }
        }.show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK)
            if (requestCode == 1) {
                if (data != null) {
                    val newData = data?.getStringArrayListExtra("dataArray")
                    msg?.description = newData[1]
                    msg?.location = newData[0]
                }
            }
    }

    private fun setOnClickListener() {
        btnDone.setOnClickListener({ onClickBtnDone() })
    }

    private fun onClickBtnDone() {
        detailPresenter.onUpdateStatus(msg?._id)
    }


}
