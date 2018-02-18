package activestudent.com.client.alex.model

/**
 * Created by alex on 18.02.2018.
 */

data class Messages(var studId: String?,
                    var photo: String?,
                    var address: String?,
                    var timeState: String?,
                    var timeImpl: String?,
                    var worker: String?,
                    var description: String?) {
    //отправка сообщения на сервер
}