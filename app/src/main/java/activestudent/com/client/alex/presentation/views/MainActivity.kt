package activestudent.com.client.alex.presentation.views

import activestudent.com.client.alex.App
import activestudent.com.client.alex.R
import activestudent.com.client.alex.presentation.mvp.presenter.student.MainActivityPresenter
import activestudent.com.client.alex.presentation.mvp.presenterImpls.student.MainActivityPresenterImpl
import activestudent.com.client.alex.presentation.mvp.view.student.MainView
import activestudent.com.client.alex.presentation.views.employee.AccountEmployeeActivity
import activestudent.com.client.alex.presentation.views.student.activites.AccountStudent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import javax.inject.Inject

class MainActivity : BaseActivity<MainView, MainActivityPresenter>(), MainView {


    override fun onCreate(savedInstanceState: Bundle?) {
        App.component.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListener()
    }

    private fun setListener() {
        btnLogin.setOnClickListener {
            mvpPresenter.saveUserData("login", edLogin.text.toString())
            mvpPresenter.saveUserData("id", "stud070689")
            if (edLogin.text.toString() != "stud")
                startActivity<AccountStudent>()
            else startActivity<AccountEmployeeActivity>()
        }
    }
}
