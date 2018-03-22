package activestudent.com.client.alex.presentation.views.employee

import activestudent.com.client.alex.App
import activestudent.com.client.alex.R
import activestudent.com.client.alex.model.Message
import activestudent.com.client.alex.presentation.mvp.presenterImpl.employee.DetailMsgEmployeePresenterImpl
import activestudent.com.client.alex.presentation.mvp.view.employee.DetailMsgEmployeeView
import android.app.ProgressDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detatil_msg_employee.*
import kotlinx.android.synthetic.main.detail_message.*
import kotlinx.android.synthetic.main.my_toolbar.*
import org.jetbrains.anko.clearTop
import org.jetbrains.anko.indeterminateProgressDialog
import org.jetbrains.anko.intentFor
import javax.inject.Inject

class DetailMsgEmployeeActivity : AppCompatActivity(), DetailMsgEmployeeView {

    @Inject
    lateinit var detailMsgPresenter: DetailMsgEmployeePresenterImpl
    private var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detatil_msg_employee)
        setSupportActionBar(my_toolbar)
        my_toolbar.setNavigationIcon(R.drawable.ic_back)
        my_toolbar.setNavigationOnClickListener({
            onBackPressed()
        })
        App.component.inject(this)
        detailMsgPresenter.attachView(this)
        detailMsgPresenter.message = intent.getParcelableExtra("message")
        initTextViews(detailMsgPresenter.message)
        setOnClickListener()
    }

    override fun onDestroy() {
        super.onDestroy()
        detailMsgPresenter.detachView()
        if (progressDialog != null)
            progressDialog?.dismiss()
    }

    override fun onSuccessUpdateStatus() {
        progressDialog?.hide()
        startActivity(intentFor<AllMsgEmployeeActivity>().clearTop())
    }

    override fun onFailureUpdateStatus() {
        progressDialog?.hide()
    }

    private fun setOnClickListener() {
        btnTaskComplete.setOnClickListener({
            progressDialog = indeterminateProgressDialog("Обновление статуса сообщения")
            progressDialog?.show()
            detailMsgPresenter.onTaskComplete()
        })
    }

    private fun initTextViews(msg: Message?) {
        tvHeader.text = msg?.categoryWork
        tvTimeState.text = detailMsgPresenter.convertTime(msg?.time_state!!)
        if (msg?.time_impl == null) {
            tvTimeImpl.text = "-"
            tvExecutor.text = "-"
        } else {
            tvTimeImpl.text = detailMsgPresenter.convertTime(msg?.time_impl!!)
            tvExecutor.text = msg?.executor
        }

        tvAddress.text = msg?.location
        tvStatus.text = detailMsgPresenter.convertStatus(msg?.status!!)
        tvDescription.text = msg?.description
        tvNumMessage.text = msg?.numMessage
    }
}
