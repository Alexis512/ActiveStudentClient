package activestudent.com.client.alex.presentation.mvp.presenter


import activestudent.com.client.alex.model.Messages
import activestudent.com.client.alex.presentation.mvp.view.MyMessagesView

/**
 * Created by alex on 12.03.2018.
 */
interface MyMessagesPresenter: BaseMvpPresenter<MyMessagesView> {

    fun onSuccess(itemsMessages : ArrayList<Messages>)
    fun showProgressBar()
    fun hideProgressbar()


}