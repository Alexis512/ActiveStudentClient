package activestudent.com.client.alex.domain.student

import activestudent.com.client.alex.model.Message
import activestudent.com.client.alex.model.UserData
import activestudent.com.client.alex.model.student.ApiRequestServerStudent
import activestudent.com.client.alex.presentation.mvp.presenterImpls.student.MyMessagesPresenterImpl
import android.content.Context
import android.util.Log
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
        val messages = retrofit.create(ApiRequestServerStudent::class.java)
        messages.allMessegesStudent(UserData(context).loadId())
                .enqueue(object : Callback<ArrayList<Message>> {
                    override fun onFailure(call: Call<ArrayList<Message>>?, t: Throwable?) {
                        Log.e("Error", t.toString())
                    }

                    override fun onResponse(call: Call<ArrayList<Message>>?, response: Response<ArrayList<Message>>?) {
                        msgPresenter?.onSuccess(response?.body()!!)
                    }
                })
    }

}