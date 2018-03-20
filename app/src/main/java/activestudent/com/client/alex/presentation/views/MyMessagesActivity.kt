package activestudent.com.client.alex.presentation.views

import activestudent.com.client.alex.App
import activestudent.com.client.alex.R
import activestudent.com.client.alex.model.Messages
import activestudent.com.client.alex.presentation.mvp.presenterImpl.MyMessagesPresenterImpl
import activestudent.com.client.alex.presentation.mvp.view.MyMessagesView
import activestudent.com.client.alex.presentation.views.recyclerView.adapters.MyMessagesAdapter
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_messages.*
import kotlinx.android.synthetic.main.my_toolbar.*
import org.jetbrains.anko.startActivity
import javax.inject.Inject


class MyMessagesActivity : AppCompatActivity(), MyMessagesView {

    override fun onShowProgressBar() {
        pbLoadingMessages.visibility = View.VISIBLE
    }

    override fun onHideProgressBar() {
        pbLoadingMessages.visibility = View.GONE
    }

    @Inject
    lateinit var msgPresener: MyMessagesPresenterImpl

    override fun getRecyclerMyMessages(messages: ArrayList<Messages>) {
        msgPresener.hideProgressbar()
        recyclerAllMessages.adapter = MyMessagesAdapter(messages) {
            startActivity<DetailMessageActivity>("message" to it)
        }
        recyclerAllMessages.adapter!!.notifyDataSetChanged()
    }

    fun initRecyclerAllMessages() {
        recyclerAllMessages.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        recyclerAllMessages.hasFixedSize()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_messages)
        setSupportActionBar(my_toolbar)
        App.component.inject(this)
        msgPresener.attachView(this)
        initRecyclerAllMessages()
        msgPresener.loadAllMessages()
    }

    override fun onRestart() {
        super.onRestart()
        msgPresener.loadAllMessages()
    }

    override fun onDestroy() {
        super.onDestroy()
        msgPresener.detachView()
    }
}
