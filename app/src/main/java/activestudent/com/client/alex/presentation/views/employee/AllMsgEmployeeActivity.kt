package activestudent.com.client.alex.presentation.views.employee

import activestudent.com.client.alex.App
import activestudent.com.client.alex.R
import activestudent.com.client.alex.model.Message
import activestudent.com.client.alex.presentation.mvp.presenterImpls.employee.AllMsgEmployeePresenterImpl
import activestudent.com.client.alex.presentation.mvp.view.employee.AllMsgEmployeeView
import activestudent.com.client.alex.presentation.views.recyclerView.adapters.LoadMessagesAdapter
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_msg_employee.*
import kotlinx.android.synthetic.main.my_toolbar.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import javax.inject.Inject

class AllMsgEmployeeActivity : AppCompatActivity(), AllMsgEmployeeView {

    @Inject
    lateinit var allMsgEmployeePresenter: AllMsgEmployeePresenterImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_msg_employee)
        setSupportActionBar(my_toolbar)
        my_toolbar.setNavigationIcon(R.drawable.ic_back)
        my_toolbar.setNavigationOnClickListener({
            onBackPressed()
        })
        App.component.inject(this)
        allMsgEmployeePresenter.attachView(this)
        recyclerMessagesEmployee.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        recyclerMessagesEmployee.hasFixedSize()
        allMsgEmployeePresenter.onLoadMessages("Слесарь")
    }

    override fun onDestroy() {
        super.onDestroy()
        allMsgEmployeePresenter.detachView()
    }

    override fun onFailGetAllMessages() {
        pbLoadMessages.visibility = View.GONE
        toast("При загрузке сообщений произошла ошибка")
    }

    override fun onSuccessGetAllMessages(messages: ArrayList<Message>) {
        pbLoadMessages.visibility = View.GONE
        if (messages.size == 0) {
            recyclerMessagesEmployee.visibility = View.GONE
            tvNoNewMessages.visibility = View.VISIBLE
        } else {
            recyclerMessagesEmployee.adapter = LoadMessagesAdapter(messages) {
                startActivity<DetailMsgEmployeeActivity>("message" to it)
            }
            recyclerMessagesEmployee.adapter!!.notifyDataSetChanged()
        }
    }

}
