package activestudent.com.client.alex.presentation.mvp.presenter.student

import activestudent.com.client.alex.presentation.mvp.presenter.BaseMvpPresenter
import activestudent.com.client.alex.presentation.mvp.view.student.CreatureViolationsView

/**
 * Created by alex on 19.02.2018.
 */
interface CreatureViolationsPresenter : BaseMvpPresenter<CreatureViolationsView> {

    fun getStudId() : String
    fun sendMessage()
    fun onSuccess()
    fun onFailure()
}