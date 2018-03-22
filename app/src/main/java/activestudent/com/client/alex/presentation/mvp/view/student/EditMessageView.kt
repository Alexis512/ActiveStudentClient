package activestudent.com.client.alex.presentation.mvp.view.student

import activestudent.com.client.alex.presentation.mvp.view.BaseMvpView

/**
 * Created by alex on 19.03.2018.
 */
interface EditMessageView : BaseMvpView {
    fun onSuccess()
    fun onFailure()
    fun getDescription() : String
    fun getLocation() : String
    fun showProgressDialog()
    fun hideProgressDialog()
}