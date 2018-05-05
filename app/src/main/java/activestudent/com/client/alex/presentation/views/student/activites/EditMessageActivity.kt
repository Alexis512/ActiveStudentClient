package activestudent.com.client.alex.presentation.views.student.activites

import activestudent.com.client.alex.App
import activestudent.com.client.alex.R
import activestudent.com.client.alex.presentation.mvp.presenter.student.EditMessagePresenter
import activestudent.com.client.alex.presentation.mvp.presenterImpls.student.EditMessagePresenterImpl
import activestudent.com.client.alex.presentation.mvp.view.student.EditMessageView
import activestudent.com.client.alex.presentation.views.BaseActivity
import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_edit.*
import kotlinx.android.synthetic.main.include_layout.*
import kotlinx.android.synthetic.main.my_toolbar.*
import org.jetbrains.anko.indeterminateProgressDialog
import org.jetbrains.anko.toast
import javax.inject.Inject

class EditMessageActivity : BaseActivity<EditMessageView, EditMessagePresenter>(), EditMessageView {


    private var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        App.component.inject(this)
        super.onCreate(savedInstanceState)
        setSupportActionBar(my_toolbar)
        setContentView(R.layout.activity_edit)
        my_toolbar.setNavigationIcon(R.drawable.ic_back)
        my_toolbar.setNavigationOnClickListener({
            onBackPressed()
        })
        setClickListener()
        mvpPresenter.setMessages(intent.getParcelableExtra("message"))
        description.setText(mvpPresenter.onInitDescriptionField())
        numRoom.setText(mvpPresenter.onInitLocationField())

    }

    override fun onDestroy() {
        super.onDestroy()
        if (progressDialog != null)
            progressDialog?.dismiss()
    }

    override fun onSuccess() {
        toast("Сообщение успешно обновлено")
        finish()

    }

    override fun finish() {
        intent.putExtra("dataArray", arrayListOf(numRoom.text.toString(), description.text.toString()))
        setResult(RESULT_OK, intent)
        super.finish()
    }

    override fun getDescription() = description.text.toString()

    override fun getLocation() = numRoom.text.toString()

    override fun onFailure() {
        toast("Сообщение не обновлено")
        finish()
    }

    override fun showProgressDialog() {
        progressDialog = indeterminateProgressDialog("Отправка сообщения")
        progressDialog!!.show()
    }

    override fun hideProgressDialog() {
        progressDialog!!.hide()
    }

    private fun setClickListener() {
        btnSaveEdit.setOnClickListener({ onClickBtnSaveEdit() })
    }

    private fun onClickBtnSaveEdit() {

        mvpPresenter.onUpdateMessage()
    }


}
