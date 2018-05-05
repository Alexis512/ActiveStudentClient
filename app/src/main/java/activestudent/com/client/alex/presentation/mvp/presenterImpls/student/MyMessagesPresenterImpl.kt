package activestudent.com.client.alex.presentation.mvp.presenterImpls.student

import activestudent.com.client.alex.domain.student.MessagesStudIteractor
import activestudent.com.client.alex.model.Message
import activestudent.com.client.alex.presentation.mvp.presenter.student.MyMessagesPresenter
import activestudent.com.client.alex.presentation.mvp.presenterImpls.BaseMvpPresenterImpl
import activestudent.com.client.alex.presentation.mvp.view.student.MyMessagesView
import javax.inject.Inject

/**
 * Created by alex on 12.03.2018.
 */
class MyMessagesPresenterImpl @Inject constructor(
        private val iteractor: MessagesStudIteractor)
    : BaseMvpPresenterImpl<MyMessagesView>(), MyMessagesPresenter {

    init {
        iteractor.setPreseter(this)
    }

    override fun showProgressBar() {
        mView?.onShowProgressBar()
    }

    override fun hideProgressbar() {
        mView?.onHideProgressBar()
    }

    override fun onSuccess(itemsMessages: ArrayList<Message>) {
        mView?.getRecyclerMyMessages(itemsMessages)
    }

     override fun loadAllMessages() {
        iteractor.allMessages()
    }
}
