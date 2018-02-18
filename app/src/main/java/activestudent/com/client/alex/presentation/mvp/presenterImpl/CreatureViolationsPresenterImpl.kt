package activestudent.com.client.alex.presentation.mvp.presenterImpl

import activestudent.com.client.alex.model.UserData
import activestudent.com.client.alex.presentation.mvp.presenter.CreatureViolationsPresenter
import activestudent.com.client.alex.presentation.mvp.view.CreatureViolationsView
import javax.inject.Inject

/**
 * Created by alex on 19.02.2018.
 */
class CreatureViolationsPresenterImpl @Inject constructor(private val sPref: UserData)
    : BaseMvpPresenterImpl<CreatureViolationsView>(), CreatureViolationsPresenter {

    override fun getStudId() = sPref.loadUserData()
}