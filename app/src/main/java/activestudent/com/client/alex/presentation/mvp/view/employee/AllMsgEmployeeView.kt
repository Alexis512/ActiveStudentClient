package activestudent.com.client.alex.presentation.mvp.view.employee

import activestudent.com.client.alex.model.Message
import activestudent.com.client.alex.presentation.mvp.view.BaseMvpView

/**
 * Created by alex on 22.03.2018.
 */
interface AllMsgEmployeeView: BaseMvpView {

    fun onSuccessGetAllMessages(messages: ArrayList<Message>)
    fun onFailGetAllMessages()
}