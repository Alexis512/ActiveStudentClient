package activestudent.com.client.alex.domain

import activestudent.com.client.alex.model.Messages
import activestudent.com.client.alex.model.UserData
import activestudent.com.client.alex.model.student.MessagesStudents
import android.content.Context
import android.util.Log
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
                                                private val messages: Messages,
                                                private val context: Context) {

    fun sendMessage() {
        val sender = retrofit.create(MessagesStudents::class.java)
        sender.addMessage(messages).enqueue(object : Callback<Void> {
            override fun onFailure(call: Call<Void>?, t: Throwable?) {
                Log.d("Fail", t.toString())
                context.toast("Сообщене не отправлено!")
            }

            override fun onResponse(call: Call<Void>?, response: Response<Void>?) {
                if (response?.isSuccessful!!) {
                    context.toast("Сообщение успешно отправлено!")
                }
            }
        })
    }

    fun allMessages() {
        val messages = retrofit.create(MessagesStudents::class.java)

        messages.allMessegesStudent(UserData(context).loadId())
                .enqueue(object : Callback<ArrayList<Messages>> {
                    override fun onFailure(call: Call<ArrayList<Messages>>?, t: Throwable?) {
                        Log.d("err", t.toString())
                    }

                    override fun onResponse(call: Call<ArrayList<Messages>>?, response: Response<ArrayList<Messages>>?) {
                        if (response?.isSuccessful!!)
                            Log.d("MESSAGES", response.body().toString())
                    }
                })
    }

    fun changeStatusProc(idMessage: String) {
        var status = retrofit.create(MessagesStudents::class.java)
        status.changeStatusProc(idMessage)
                .enqueue(object : Callback<Void> {
                    override fun onFailure(call: Call<Void>?, t: Throwable?) {
                        Log.d("Error", t.toString())
                    }

                    override fun onResponse(call: Call<Void>?, response: Response<Void>?) {
                        if (response?.isSuccessful!!)
                            context.toast("Статус успешно изменен!")
                    }

                })
    }
}