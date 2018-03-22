package activestudent.com.client.alex.presentation.mvp.presenter.employee

import activestudent.com.client.alex.presentation.mvp.presenter.BaseMvpPresenter
import activestudent.com.client.alex.presentation.mvp.view.employee.DetailMsgEmployeeView

/**
 * Created by alex on 22.03.2018.
 */
interface DetailMsgEmployeePresenter : BaseMvpPresenter<DetailMsgEmployeeView> {
    fun convertTime(oldtime: String): String
    fun convertStatus(status: String): String
    fun onTaskComplete()
}