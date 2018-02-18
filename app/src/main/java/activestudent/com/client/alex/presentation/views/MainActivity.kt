package activestudent.com.client.alex.presentation.views

import activestudent.com.client.alex.App
import activestudent.com.client.alex.R
import activestudent.com.client.alex.presentation.mvp.presenterImpl.MainActivityPresenterImpl
import activestudent.com.client.alex.presentation.mvp.view.MainView
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainView {

    @Inject
    lateinit var mPresenter : MainActivityPresenterImpl

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

    fun setListener(){
        btnLogin.setOnClickListener {
            mPresenter.saveUserData("login", edLogin.text.toString())
            mPresenter.saveUserData("password", edPassword.text.toString())
//            startActivity<StudentRoleActivity>()
        startActivity<ViolationsActivity>()
        }
    }
}
