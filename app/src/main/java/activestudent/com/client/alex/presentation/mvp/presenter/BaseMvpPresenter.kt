package activestudent.com.client.alex.presentation.mvp.presenter

import activestudent.com.client.alex.presentation.mvp.view.BaseMvpView

/**
 * Created by alex on 06.02.2018.
 */
interface BaseMvpPresenter<in V : BaseMvpView> {

    fun attachView(mvpView : V)
    fun detachView()
}