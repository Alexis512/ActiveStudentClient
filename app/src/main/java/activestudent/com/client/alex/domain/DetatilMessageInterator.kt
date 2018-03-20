package activestudent.com.client.alex.domain

import activestudent.com.client.alex.model.student.MessagesStudents
import activestudent.com.client.alex.presentation.mvp.presenterImpl.DetailMessagePresenterImpl
import android.util.Log
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * Created by alex on 17.03.2018.
 */
class DetatilMessageInterator @Inject constructor(val retrofit: Retrofit) {

    private var detailPresenter: DetailMessagePresenterImpl? = null

    fun setPresenterListener(pres: DetailMessagePresenterImpl) {
        detailPresenter = pres
    }

    fun deleteMessage(id: String?) {
        var delMessage = retrofit.create(MessagesStudents::class.java)
        delMessage.deleteMessage(id!!)
                .enqueue(object : Callback<Void> {
                    override fun onFailure(call: Call<Void>?, t: Throwable?) {
                        Log.d("Error", t.toString())
                        detailPresenter?.onFailure()
                    }

                    override fun onResponse(call: Call<Void>?, response: Response<Void>?) {
                        detailPresenter?.onSeccess()
                    }

                })
    }

    fun changeStatusProc(idMessage: String?) {
        var status = retrofit.create(MessagesStudents::class.java)
        status.changeStatusProc(idMessage!!)
                .enqueue(object : Callback<Void> {
                    override fun onFailure(call: Call<Void>?, t: Throwable?) {
                        detailPresenter?.onFaliureUpdateStatus()
                    }

                    override fun onResponse(call: Call<Void>?, response: Response<Void>?) {
                        if (response?.isSuccessful!!)
                            detailPresenter?.onSuccessUpdateStatus()
                    }

                })
    }
}