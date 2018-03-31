package activestudent.com.client.alex.presentation.mvp.presenterImpls.student

import activestudent.com.client.alex.domain.student.MessagesStudIteractor
import activestudent.com.client.alex.presentation.mvp.presenter.student.AccountPresenter
import activestudent.com.client.alex.presentation.mvp.presenterImpls.BaseMvpPresenterImpl
import activestudent.com.client.alex.presentation.mvp.view.student.AccountView
import javax.inject.Inject

/**
 * Created by alex on 20.02.2018.
 */
class AccountPresenterImpl @Inject constructor(private val interactorMsgStudent: MessagesStudIteractor)
    : BaseMvpPresenterImpl<AccountView>(), AccountPresenter {

    override fun allMessagesStudent() {
       // interactorMsgStudent.allMessages()
    }


}