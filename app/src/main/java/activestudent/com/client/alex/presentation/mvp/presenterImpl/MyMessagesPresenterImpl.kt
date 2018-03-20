package activestudent.com.client.alex.presentation.mvp.presenterImpl

import activestudent.com.client.alex.domain.MessagesStudIteractor
import activestudent.com.client.alex.model.Messages
import activestudent.com.client.alex.presentation.mvp.presenter.MyMessagesPresenter
import activestudent.com.client.alex.presentation.mvp.view.MyMessagesView
import javax.inject.Inject

/**
 * Created by alex on 12.03.2018.
 */
class MyMessagesPresenterImpl @Inject constructor(
        private val iteractor: MessagesStudIteractor)
    : BaseMvpPresenterImpl<MyMessagesView>(), MyMessagesPresenter {
    override fun showProgressBar() {
        mView?.onShowProgressBar()
    }

    override fun hideProgressbar() {
        mView?.onHideProgressBar()
    }

    init {
        iteractor.setPreseter(this)
    }

    override fun onSuccess(itemsMessages: ArrayList<Messages>) {
        mView?.getRecyclerMyMessages(itemsMessages)
    }

    fun loadAllMessages() {
        iteractor.allMessages()
    }
}
