package activestudent.com.client.alex.presentation.views

import activestudent.com.client.alex.App
import activestudent.com.client.alex.R
import activestudent.com.client.alex.presentation.mvp.presenterImpl.AccountPresenterImpl
import activestudent.com.client.alex.presentation.mvp.view.AccountView
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_account.*
import javax.inject.Inject

class AccountStudent : AppCompatActivity(), AccountView {


    @Inject
    lateinit var accPresenter: AccountPresenterImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)
        App.component.inject(this)
        accPresenter.attachView(this)
        setListener()
    }

    override fun onDestroy() {
        super.onDestroy()
        accPresenter.detachView()
    }


    fun setListener(){
        btnMessages.setOnClickListener({
            accPresenter.allMessagesStudent()
        })
    }
}
