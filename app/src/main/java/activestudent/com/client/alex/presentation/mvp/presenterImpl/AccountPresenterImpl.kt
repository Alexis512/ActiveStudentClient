package activestudent.com.client.alex.presentation.mvp.presenterImpl

import activestudent.com.client.alex.domain.MessagesStudIteractor
import activestudent.com.client.alex.presentation.mvp.presenter.AccountPresenter
import activestudent.com.client.alex.presentation.mvp.view.AccountView
import javax.inject.Inject

/**
 * Created by alex on 20.02.2018.
 */
class AccountPresenterImpl @Inject constructor(private val interactorMsgStudent: MessagesStudIteractor)
    : BaseMvpPresenterImpl<AccountView>(), AccountPresenter {

    override fun allMessagesStudent() {
        interactorMsgStudent.allMessages()
    }

    override fun updateStutus() {
        interactorMsgStudent.changeStatusProc("5a8c7cb8242e340004b3b595")
    }
}