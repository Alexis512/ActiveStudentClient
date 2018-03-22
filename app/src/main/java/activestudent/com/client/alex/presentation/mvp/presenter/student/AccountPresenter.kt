package activestudent.com.client.alex.presentation.mvp.presenter.student

import activestudent.com.client.alex.presentation.mvp.presenter.BaseMvpPresenter
import activestudent.com.client.alex.presentation.mvp.view.student.AccountView

/**
 * Created by alex on 20.02.2018.
 */
interface AccountPresenter : BaseMvpPresenter<AccountView> {
    fun allMessagesStudent()

}
