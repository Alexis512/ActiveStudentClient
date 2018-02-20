package activestudent.com.client.alex.presentation.mvp.presenter

import activestudent.com.client.alex.presentation.mvp.view.CreatureViolationsView

/**
 * Created by alex on 19.02.2018.
 */
interface CreatureViolationsPresenter : BaseMvpPresenter<CreatureViolationsView> {

    fun getStudId() : String
    fun sendMessage()
}