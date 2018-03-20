package activestudent.com.client.alex.domain

import activestudent.com.client.alex.model.Messages
import activestudent.com.client.alex.model.UserData
import activestudent.com.client.alex.model.student.MessagesStudents
import activestudent.com.client.alex.presentation.mvp.presenterImpl.MyMessagesPresenterImpl
import activestudent.com.client.alex.presentation.views.MyMessagesActivity
import android.content.Context
import android.util.Log
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * Created by alex on 20.02.2018.
 */
class MessagesStudIteractor @Inject constructor(private val retrofit: Retrofit,
                                                private val context: Context) {

    private var msgPresenter: MyMessagesPresenterImpl? = null
    fun setPreseter(presenter: MyMessagesPresenterImpl) {
        msgPresenter = presenter
    }

    fun allMessages() {
        val messages = retrofit.create(MessagesStudents::class.java)
        messages.allMessegesStudent(UserData(context).loadId())
                .enqueue(object : Callback<ArrayList<Messages>> {
                    override fun onFailure(call: Call<ArrayList<Messages>>?, t: Throwable?) {
                        Log.e("Error", t.toString())
                    }

                    override fun onResponse(call: Call<ArrayList<Messages>>?, response: Response<ArrayList<Messages>>?) {
                        msgPresenter?.onSuccess(response?.body()!!)
                    }
                })
    }

}