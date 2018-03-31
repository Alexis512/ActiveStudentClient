package activestudent.com.client.alex.presentation.views

import activestudent.com.client.alex.App
import activestudent.com.client.alex.R
import activestudent.com.client.alex.presentation.mvp.presenterImpls.student.MainActivityPresenterImpl
import activestudent.com.client.alex.presentation.mvp.view.student.MainView
import activestudent.com.client.alex.presentation.views.employee.AccountEmployeeActivity
import activestudent.com.client.alex.presentation.views.student.activites.AccountStudent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainView {

    @Inject
    lateinit var mPresenter: MainActivityPresenterImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.component.inject(this)
        setContentView(R.layout.activity_main)
        setListener()
        mPresenter.attachView(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }

    fun setListener() {
        btnLogin.setOnClickListener {
            mPresenter.saveUserData("login", edLogin.text.toString())
            mPresenter.saveUserData("id", "5a6b9c5e79693800045c3f7a")
            if (edLogin.text.toString() != "stud")
                startActivity<AccountStudent>()
            else startActivity<AccountEmployeeActivity>()
        }
    }
}
