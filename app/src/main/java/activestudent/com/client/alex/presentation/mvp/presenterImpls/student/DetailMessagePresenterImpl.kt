package activestudent.com.client.alex.presentation.mvp.presenterImpls.student

import activestudent.com.client.alex.domain.student.DetatilMessageInterator
import activestudent.com.client.alex.presentation.mvp.presenter.student.DetailMessagePresenter
import activestudent.com.client.alex.presentation.mvp.presenterImpls.BaseMvpPresenterImpl
import activestudent.com.client.alex.presentation.mvp.view.student.DetailMessageView
import activestudent.com.client.alex.utils.TimeUtils
import javax.inject.Inject

/**
 * Created by alex on 15.03.2018.
 */
class DetailMessagePresenterImpl @Inject constructor(val detailInterator: DetatilMessageInterator)
    : BaseMvpPresenterImpl<DetailMessageView>(), DetailMessagePresenter {

    override fun onUpdateStatus(id: String?) {
        mView?.showProgressDialog("Статус сообщения обновляется")
        detailInterator.changeStatusProc(id)
    }

    init {
        detailInterator.setPresenterListener(this)
    }

    override fun onSeccess() {
        mView?.hideProgressDialog("Удаление сообщения")
        mView?.onSuccessDeleteMessage()
    }

    override fun onDeleteMessage(id: String?) {
        mView?.showProgressDialog("Удаление сообщения")
        detailInterator.deleteMessage(id!!)
    }

    override fun onShowAlertDialog() {
        mView?.showAlertDialog()
    }

    override fun onInitViews() {
        mView?.initTextViews()
    }

    override fun onSuccessUpdateStatus() {
        mView?.hideProgressDialog("Статус сообщения обновляется")
        mView?.onSuccessUpdateStatus()
    }

    override fun onFaliureUpdateStatus() {
        mView?.hideProgressDialog("Статус сообщения обновляется")
        mView?.onFailureUpdateStatus()
    }

    override fun onFailure() {
        mView?.hideProgressDialog("Удаление сообщения")
    }

    override fun convertTime(oldFormatTime: String): String {
        val time = TimeUtils()
        return time.formatData(oldFormatTime)
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