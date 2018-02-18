package activestudent.com.client.alex.presentation.mvp.presenterImpl

import activestudent.com.client.alex.model.UserData
import activestudent.com.client.alex.presentation.mvp.presenter.MainActivityPresenter
import activestudent.com.client.alex.presentation.mvp.view.MainView
import javax.inject.Inject

/**
 * Created by alex on 13.02.2018.
 */
class MainActivityPresenterImpl @Inject constructor(private val sPref: UserData)
    : BaseMvpPresenterImpl<MainView>(), MainActivityPresenter {


    override fun saveUserData(name: String, value: String) = sPref.saveUserdata(name, value)
}