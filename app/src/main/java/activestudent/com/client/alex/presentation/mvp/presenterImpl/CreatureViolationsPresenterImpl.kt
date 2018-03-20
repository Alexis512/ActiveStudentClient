package activestudent.com.client.alex.presentation.mvp.presenterImpl

import activestudent.com.client.alex.domain.MessagesStudIteractor
import activestudent.com.client.alex.domain.SenderMessagesInterator
import activestudent.com.client.alex.model.UserData
import activestudent.com.client.alex.presentation.mvp.presenter.CreatureViolationsPresenter
import activestudent.com.client.alex.presentation.mvp.view.CreatureViolationsView
import javax.inject.Inject

/**
 * Created by alex on 19.02.2018.
 */
class CreatureViolationsPresenterImpl @Inject constructor(private val sPref: UserData,
                                                          private val senderInterator: SenderMessagesInterator)
    : BaseMvpPresenterImpl<CreatureViolationsView>(), CreatureViolationsPresenter {

    init {
        senderInterator.setPresenterListener(this)
    }

    override fun onFailure() {
        mView?.hideProgressDialog()
        mView?.onFailure()
    }

    override fun onSuccess() {
        mView?.hideProgressDialog()
        mView?.onSuccess()
    }

    override fun sendMessage() {
        mView?.showProgressDialog()
        senderInterator.sendMessage()
    }

    override fun getStudId() = sPref.loadId()
}