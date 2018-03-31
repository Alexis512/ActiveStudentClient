package activestudent.com.client.alex.presentation.mvp.presenterImpls.student

import activestudent.com.client.alex.model.UserData
import activestudent.com.client.alex.presentation.mvp.presenter.student.MainActivityPresenter
import activestudent.com.client.alex.presentation.mvp.presenterImpls.BaseMvpPresenterImpl
import activestudent.com.client.alex.presentation.mvp.view.student.MainView
import javax.inject.Inject

/**
 * Created by alex on 13.02.2018.
 */
class MainActivityPresenterImpl @Inject constructor(private val sPref: UserData)
    : BaseMvpPresenterImpl<MainView>(), MainActivityPresenter {


    override fun saveUserData(name: String, value: String) = sPref.saveUserdata(name, value)
}