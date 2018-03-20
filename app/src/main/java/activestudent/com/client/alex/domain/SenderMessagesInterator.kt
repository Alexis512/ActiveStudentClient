package activestudent.com.client.alex.domain

import activestudent.com.client.alex.model.Messages
import activestudent.com.client.alex.model.student.MessagesStudents
import activestudent.com.client.alex.presentation.mvp.presenterImpl.CreatureViolationsPresenterImpl
import android.util.Log

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * Created by alex on 17.03.2018.
 */
class SenderMessagesInterator @Inject constructor(val retrofit: Retrofit,
                                                  val messages : Messages) {

    private var creaturePresenter : CreatureViolationsPresenterImpl? = null

    fun setPresenterListener(pres : CreatureViolationsPresenterImpl) {
        creaturePresenter = pres
    }
    fun sendMessage() {
        val sender = retrofit.create(MessagesStudents::class.java)
        sender.addMessage(messages).enqueue(object : Callback<Void> {
            override fun onFailure(call: Call<Void>?, t: Throwable?) {
                Log.e("Error", t.toString())
            }

            override fun onResponse(call: Call<Void>?, response: Response<Void>?) {
                if (response?.isSuccessful!!) {
                    creaturePresenter?.onSuccess()

                }
            }
        })
    }
}