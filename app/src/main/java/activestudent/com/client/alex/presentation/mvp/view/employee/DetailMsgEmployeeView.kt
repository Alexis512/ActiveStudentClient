package activestudent.com.client.alex.presentation.mvp.view.employee

import activestudent.com.client.alex.presentation.mvp.view.BaseMvpView

/**
 * Created by alex on 22.03.2018.
 */
interface DetailMsgEmployeeView : BaseMvpView {

    fun onSuccessUpdateStatus()
    fun onFailureUpdateStatus()
}