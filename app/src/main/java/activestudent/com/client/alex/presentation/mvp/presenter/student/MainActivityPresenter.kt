package activestudent.com.client.alex.presentation.mvp.presenter.student

import activestudent.com.client.alex.presentation.mvp.presenter.BaseMvpPresenter
import activestudent.com.client.alex.presentation.mvp.view.student.MainView

/**
 * Created by alex on 13.02.2018.
 */
interface MainActivityPresenter: BaseMvpPresenter<MainView> {

    fun saveUserData(name : String, value : String)
}