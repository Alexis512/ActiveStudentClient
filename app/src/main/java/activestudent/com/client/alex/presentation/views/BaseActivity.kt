package activestudent.com.client.alex.presentation.views

import activestudent.com.client.alex.presentation.mvp.presenter.BaseMvpPresenter
import activestudent.com.client.alex.presentation.mvp.view.BaseMvpView
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import javax.inject.Inject

/**
 * Created by alex on 03.05.2018.
 */
abstract class BaseActivity<V : BaseMvpView, P : BaseMvpPresenter<V>> : AppCompatActivity(), BaseMvpView {


    @Inject
    lateinit var mvpPresenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mvpPresenter.attachView((this as V))
    }

    override fun onDestroy() {
        mvpPresenter.detachView()
        super.onDestroy()
    }
}