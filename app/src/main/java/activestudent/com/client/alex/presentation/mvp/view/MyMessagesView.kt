package activestudent.com.client.alex.presentation.mvp.view

import activestudent.com.client.alex.model.Messages
import android.support.v7.widget.RecyclerView
import dagger.Module
import dagger.Provides

/**
 * Created by alex on 12.03.2018.
 */
interface MyMessagesView : BaseMvpView {
    fun getRecyclerMyMessages(messages: ArrayList<Messages>)
    fun onShowProgressBar()
    fun onHideProgressBar()
}