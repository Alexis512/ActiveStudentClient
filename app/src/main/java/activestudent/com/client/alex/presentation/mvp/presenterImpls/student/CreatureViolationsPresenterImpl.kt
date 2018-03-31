package activestudent.com.client.alex.presentation.mvp.presenterImpls.student

import activestudent.com.client.alex.domain.student.SenderMessagesInterator
import activestudent.com.client.alex.model.Message
import activestudent.com.client.alex.model.UserData
import activestudent.com.client.alex.presentation.mvp.presenter.student.CreatureViolationsPresenter
import activestudent.com.client.alex.presentation.mvp.presenterImpls.BaseMvpPresenterImpl
import activestudent.com.client.alex.presentation.mvp.view.student.CreatureViolationsView
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

    override fun sendMessage(message : Message) {
        mView?.showProgressDialog()
        senderInterator.sendMessage(message)
    }

    override fun getStudId() = sPref.loadId()
}