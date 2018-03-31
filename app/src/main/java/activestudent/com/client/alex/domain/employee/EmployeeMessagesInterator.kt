package activestudent.com.client.alex.domain.employee

import activestudent.com.client.alex.domain.InteractorListener
import activestudent.com.client.alex.model.Message
import activestudent.com.client.alex.model.employee.ApiRequestServerEmplyee
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * Created by alex on 21.03.2018.
 */
class EmployeeMessagesInterator @Inject constructor(val retrofit: Retrofit) {

    private var presenterListener: InteractorListener? = null

    fun setPresenterListener(presenter: InteractorListener) {
        presenterListener = presenter
    }

    fun getAllMessages(typeWork: String) {
        var messages = retrofit.create(ApiRequestServerEmplyee::class.java)
        messages.getMessagesEmployee(typeWork)
                .enqueue(object : Callback<ArrayList<Message>> {
                    override fun onResponse(call: Call<ArrayList<Message>>?, response: Response<ArrayList<Message>>?) {
                        presenterListener?.onSuccessGetAllMessages(response?.body()!!)
                    }

                    override fun onFailure(call: Call<ArrayList<Message>>?, t: Throwable?) {
                        presenterListener?.onFailureGetAllMessages()
                    }

                })
    }

    fun updateStatusDone(id: String, timeImpl: String, executor: String) {
        var message = retrofit.create(ApiRequestServerEmplyee::class.java)
        message.updateStatusDone(id, timeImpl, executor)
                .enqueue(object : Callback<Void> {
                    override fun onFailure(call: Call<Void>?, t: Throwable?) {
                        presenterListener?.onFailureUpdateSratusDone()
                    }

                    override fun onResponse(call: Call<Void>?, response: Response<Void>?) {
                        presenterListener?.onSuccessUpdateSratusDone()
                    }
                })
    }
}