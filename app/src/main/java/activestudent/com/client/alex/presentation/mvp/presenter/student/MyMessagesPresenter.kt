package activestudent.com.client.alex.presentation.mvp.presenter.student


import activestudent.com.client.alex.model.Message
import activestudent.com.client.alex.presentation.mvp.presenter.BaseMvpPresenter
import activestudent.com.client.alex.presentation.mvp.view.student.MyMessagesView

/**
 * Created by alex on 12.03.2018.
 */
interface MyMessagesPresenter: BaseMvpPresenter<MyMessagesView> {

    fun onSuccess(itemsMessages : ArrayList<Message>)
    fun showProgressBar()
    fun hideProgressbar()


}