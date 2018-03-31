package activestudent.com.client.alex.presentation.views.student.activites

import activestudent.com.client.alex.App
import activestudent.com.client.alex.R
import activestudent.com.client.alex.model.Message
import activestudent.com.client.alex.presentation.mvp.presenterImpls.student.MyMessagesPresenterImpl
import activestudent.com.client.alex.presentation.mvp.view.student.MyMessagesView
import activestudent.com.client.alex.presentation.views.recyclerView.adapters.LoadMessagesAdapter
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_messages.*
import kotlinx.android.synthetic.main.my_toolbar.*
import org.jetbrains.anko.startActivity
import javax.inject.Inject


class MessagesActivity : AppCompatActivity(), MyMessagesView {

    @Inject
    lateinit var msgPresenter: MyMessagesPresenterImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_messages)
        setSupportActionBar(my_toolbar)
        my_toolbar.setNavigationIcon(R.drawable.ic_back)
        my_toolbar.setNavigationOnClickListener({
            onBackPressed()
        })
        App.component.inject(this)
        msgPresenter.attachView(this)
        initRecyclerAllMessages()
        msgPresenter.loadAllMessages()
    }

    override fun onRestart() {
        super.onRestart()
        msgPresenter.loadAllMessages()
    }

    override fun onDestroy() {
        super.onDestroy()
        msgPresenter.detachView()
    }

    override fun onShowProgressBar() {
        pbLoadingMessages.visibility = View.VISIBLE
    }

    override fun onHideProgressBar() {
        pbLoadingMessages.visibility = View.GONE
    }

    override fun getRecyclerMyMessages(messages: ArrayList<Message>) {
        msgPresenter.hideProgressbar()
        if (messages.size == 0) {
            recyclerAllMessages.visibility = View.GONE
            tvMyMessages.visibility = View.VISIBLE
        }
        recyclerAllMessages.adapter = LoadMessagesAdapter(messages) {
            startActivity<DetailMessageActivity>("message" to it)
        }
        recyclerAllMessages.adapter!!.notifyDataSetChanged()
    }

    private fun initRecyclerAllMessages() {
        recyclerAllMessages.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        recyclerAllMessages.hasFixedSize()
    }

}
