package activestudent.com.client.alex.presentation.mvp.presenter

import activestudent.com.client.alex.presentation.mvp.view.MainView

/**
 * Created by alex on 13.02.2018.
 */
interface MainActivityPresenter: BaseMvpPresenter<MainView> {

    fun saveUserData(name : String, value : String)
}