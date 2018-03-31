package activestudent.com.client.alex.presentation.mvp.presenter.student

import activestudent.com.client.alex.presentation.mvp.presenter.BaseMvpPresenter
import activestudent.com.client.alex.presentation.mvp.view.student.DetailMessageView

/**
 * Created by alex on 15.03.2018.
 */
interface DetailMessagePresenter : BaseMvpPresenter<DetailMessageView> {

    fun convertTime(oldFormatTime: String): String
    fun onInitViews()
    fun onShowAlertDialog()
    fun onDeleteMessage(id: String?)
    fun onSeccess()
    fun onFailure()
    fun onSuccessUpdateStatus()
    fun onFaliureUpdateStatus()
    fun onUpdateStatus(id: String?)
}