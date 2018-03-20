package activestudent.com.client.alex.presentation.mvp.presenter

import activestudent.com.client.alex.presentation.mvp.view.AccountView

/**
 * Created by alex on 20.02.2018.
 */
interface AccountPresenter : BaseMvpPresenter<AccountView> {
    fun allMessagesStudent()

}
