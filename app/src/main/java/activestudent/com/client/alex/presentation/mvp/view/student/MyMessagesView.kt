package activestudent.com.client.alex.presentation.mvp.view.student

import activestudent.com.client.alex.model.Message
import activestudent.com.client.alex.presentation.mvp.view.BaseMvpView

/**
 * Created by alex on 12.03.2018.
 */
interface MyMessagesView : BaseMvpView {
    fun getRecyclerMyMessages(messages: ArrayList<Message>)
    fun onShowProgressBar()
    fun onHideProgressBar()
}