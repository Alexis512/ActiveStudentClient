package activestudent.com.client.alex.presentation.mvp.presenterImpls.employee

import activestudent.com.client.alex.domain.InteractorListener
import activestudent.com.client.alex.domain.employee.EmployeeMessagesInterator
import activestudent.com.client.alex.model.Message
import activestudent.com.client.alex.presentation.mvp.presenter.employee.AllMsgEmployeePresenter
import activestudent.com.client.alex.presentation.mvp.presenterImpls.BaseMvpPresenterImpl
import activestudent.com.client.alex.presentation.mvp.view.employee.AllMsgEmployeeView
import javax.inject.Inject

/**
 * Created by alex on 22.03.2018.
 */
class AllMsgEmployeePresenterImpl @Inject constructor(private val emlpoyeeMessageInteractor: EmployeeMessagesInterator)
    : BaseMvpPresenterImpl<AllMsgEmployeeView>(), AllMsgEmployeePresenter, InteractorListener {

    init {
        emlpoyeeMessageInteractor.setPresenterListener(this)
    }

    override fun onSuccessUpdateSratusDone() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onFailureUpdateSratusDone() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSuccessGetAllMessages(messages: ArrayList<Message>) {
        mView?.onSuccessGetAllMessages(messages)
    }

    override fun onFailureGetAllMessages() {
        mView?.onFailGetAllMessages()
    }

    override fun onLoadMessages(typeWork: String) {
        emlpoyeeMessageInteractor.getAllMessages(typeWork)
    }


}