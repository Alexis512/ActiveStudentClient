package activestudent.com.client.alex.presentation.mvp.presenterImpl.student

import activestudent.com.client.alex.domain.student.EditMessageIntetator
import activestudent.com.client.alex.model.Message
import activestudent.com.client.alex.presentation.mvp.presenter.student.EditMessagePresenter
import activestudent.com.client.alex.presentation.mvp.presenterImpl.BaseMvpPresenterImpl
import activestudent.com.client.alex.presentation.mvp.view.student.EditMessageView
import javax.inject.Inject

/**
 * Created by alex on 19.03.2018.
 */
class EditMessagePresenterImpl @Inject constructor(val editMessage: EditMessageIntetator) : BaseMvpPresenterImpl<EditMessageView>(), EditMessagePresenter {

    init {
        editMessage.setPresenterListener(this)
    }

    override fun onSuccess() {
        mView?.hideProgressDialog()
        mView?.onSuccess()
    }

    override fun onFailure() {
        mView?.hideProgressDialog()
        mView?.onFailure()
    }

    private var message: Message? = null

    fun setMessages(msg: Message) {
        message = msg
    }

    override fun onInitLocationField() = message?.location

    override fun onInitDescriptionField() = message?.description

    override fun onUpdateMessage() {
        mView?.showProgressDialog()
        editMessage.updateMessage(message?._id!!, mView?.getLocation(), mView?.getDescription())
    }
}