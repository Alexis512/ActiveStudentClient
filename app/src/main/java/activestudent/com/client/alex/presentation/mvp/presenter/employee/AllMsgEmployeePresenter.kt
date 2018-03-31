package activestudent.com.client.alex.presentation.mvp.presenter.employee

import activestudent.com.client.alex.presentation.mvp.presenter.BaseMvpPresenter
import activestudent.com.client.alex.presentation.mvp.view.employee.AllMsgEmployeeView

/**
 * Created by alex on 22.03.2018.
 */
interface AllMsgEmployeePresenter : BaseMvpPresenter<AllMsgEmployeeView> {

    fun onLoadMessages(typeWork: String)
}