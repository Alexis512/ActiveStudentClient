package activestudent.com.client.alex.presentation.views.student.activites

import activestudent.com.client.alex.App
import activestudent.com.client.alex.R
import activestudent.com.client.alex.presentation.mvp.presenterImpls.student.AccountPresenterImpl
import activestudent.com.client.alex.presentation.mvp.view.student.AccountView
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_account.*
import kotlinx.android.synthetic.main.my_toolbar.*
import org.jetbrains.anko.startActivity
import javax.inject.Inject

class AccountStudent : AppCompatActivity(), AccountView {


    @Inject
    lateinit var accPresenter: AccountPresenterImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)
        App.component.inject(this)
        accPresenter.attachView(this)
        setSupportActionBar(my_toolbar)
        setListener()
    }

    override fun onDestroy() {
        super.onDestroy()
        accPresenter.detachView()
    }


    private fun setListener() {
        newMsg.setOnClickListener({ startActivity<ViolationsActivity>() })
        myMsg.setOnClickListener({ startActivity<MessagesActivity>() })
        btnSchendule.setOnClickListener({ startActivity<SchenduleActivity>() })

    }
}
