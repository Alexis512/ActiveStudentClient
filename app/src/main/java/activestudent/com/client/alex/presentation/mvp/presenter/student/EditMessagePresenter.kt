package activestudent.com.client.alex.presentation.mvp.presenter.student

import activestudent.com.client.alex.model.Message
import activestudent.com.client.alex.presentation.mvp.presenter.BaseMvpPresenter
import activestudent.com.client.alex.presentation.mvp.view.student.EditMessageView

/**
 * Created by alex on 19.03.2018.
 */
interface EditMessagePresenter : BaseMvpPresenter<EditMessageView> {

    fun onInitLocationField(): String?
    fun onInitDescriptionField(): String?
    fun onSuccess()
    fun onFailure()
    fun setMessages(msg: Message)
    fun onUpdateMessage()
}