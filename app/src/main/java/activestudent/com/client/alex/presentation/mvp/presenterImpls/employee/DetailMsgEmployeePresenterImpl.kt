package activestudent.com.client.alex.presentation.mvp.presenterImpls.employee

import activestudent.com.client.alex.domain.InteractorListener
import activestudent.com.client.alex.domain.employee.EmployeeMessagesInterator
import activestudent.com.client.alex.model.Message
import activestudent.com.client.alex.presentation.mvp.presenter.employee.DetailMsgEmployeePresenter
import activestudent.com.client.alex.presentation.mvp.presenterImpls.BaseMvpPresenterImpl
import activestudent.com.client.alex.presentation.mvp.view.employee.DetailMsgEmployeeView
import activestudent.com.client.alex.utils.TimeUtils
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

/**
 * Created by alex on 22.03.2018.
 */
class DetailMsgEmployeePresenterImpl @Inject constructor(val employeeMesgInteractor: EmployeeMessagesInterator) : BaseMvpPresenterImpl<DetailMsgEmployeeView>(), DetailMsgEmployeePresenter, InteractorListener {

    init {
        employeeMesgInteractor.setPresenterListener(this)
    }

    var message: Message? = null

    override fun onSuccessUpdateSratusDone() {
        mView?.onSuccessUpdateStatus()
    }

    override fun onFailureUpdateSratusDone() {
        mView?.onFailureUpdateStatus()
    }

    override fun onSuccessGetAllMessages(messages: ArrayList<Message>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onFailureGetAllMessages() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTaskComplete() {
        var timeImpl = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").format(Date())
        employeeMesgInteractor.updateStatusDone(message?._id!!, timeImpl, "Иванов Иван Иванович")
    }

    override fun convertTime(oldtime: String): String {
        val timeUtils = TimeUtils()
        return timeUtils.formatData(oldtime)
    }

    override fun convertStatus(status: String): String {
        var cnvtStstus = ""
        when (status) {
            "proc" -> cnvtStstus = "Модерация"
            "exec" -> cnvtStstus = "В исполнении"
            "done" -> cnvtStstus = "Выполнено"
        }
        return cnvtStstus
    }
}