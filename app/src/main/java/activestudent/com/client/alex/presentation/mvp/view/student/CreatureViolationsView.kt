package activestudent.com.client.alex.presentation.mvp.view.student

import activestudent.com.client.alex.presentation.mvp.view.BaseMvpView

/**
 * Created by alex on 19.02.2018.
 */
interface CreatureViolationsView : BaseMvpView {
    fun onSuccess()
    fun onFailure()
    fun showProgressDialog()
    fun hideProgressDialog()
}