package activestudent.com.client.alex.domain

import activestudent.com.client.alex.model.Message

/**
 * Created by alex on 22.03.2018.
 */
interface InteractorListener {

    fun onSuccessGetAllMessages(messages: ArrayList<Message>)
    fun onFailureGetAllMessages()

    fun onSuccessUpdateSratusDone()
    fun onFailureUpdateSratusDone()
}