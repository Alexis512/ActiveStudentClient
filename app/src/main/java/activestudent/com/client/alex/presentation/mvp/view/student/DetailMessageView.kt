package activestudent.com.client.alex.presentation.mvp.view.student

import activestudent.com.client.alex.presentation.mvp.view.BaseMvpView

/**
 * Created by alex on 15.03.2018.
 */
interface DetailMessageView : BaseMvpView {
    fun initTextViews()
    fun showAlertDialog()
    fun showProgressDialog(description : String)
    fun hideProgressDialog(description : String)
    fun onSuccessUpdateStatus()
    fun onFailureUpdateStatus()
    fun onSuccessDeleteMessage()
}