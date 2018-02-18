package activestudent.com.client.alex.presentation.mvp.presenterImpl

import activestudent.com.client.alex.presentation.mvp.presenter.BaseMvpPresenter
import activestudent.com.client.alex.presentation.mvp.view.BaseMvpView

/**
 * Created by alex on 07.02.2018.
 */
open class BaseMvpPresenterImpl<V : BaseMvpView> : BaseMvpPresenter<V> {

    protected var mView : V? = null

    override fun attachView(mvpView: V) {
        mView = mvpView
    }

    override fun detachView() {
        mView = null
    }
}