package activestudent.com.client.alex.domain.student

import activestudent.com.client.alex.model.Message
import activestudent.com.client.alex.model.student.ApiRequestServerStudent
import activestudent.com.client.alex.presentation.mvp.presenterImpls.student.CreatureViolationsPresenterImpl
import android.util.Log

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import java.util.*
import javax.inject.Inject

/**
 * Created by alex on 17.03.2018.
 */
class SenderMessagesInterator @Inject constructor(val retrofit: Retrofit) {

    private var creaturePresenter: CreatureViolationsPresenterImpl? = null

    fun setPresenterListener(pres: CreatureViolationsPresenterImpl) {
        creaturePresenter = pres
    }

    fun sendMessage(message: Message) {
        val sender = retrofit.create(ApiRequestServerStudent::class.java)
        sender.addMessage(message).enqueue(object : Callback<Void> {

            override fun onFailure(call: Call<Void>?, t: Throwable?) {
                Log.e("Error", t.toString())
            }

            override fun onResponse(call: Call<Void>?, response: Response<Void>?) {
                Log.e("Error", response?.toString())
                if (response?.isSuccessful!!) {
                    creaturePresenter?.onSuccess()

                }
            }
        })
    }
}