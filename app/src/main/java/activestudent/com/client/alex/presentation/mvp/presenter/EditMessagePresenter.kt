package activestudent.com.client.alex.presentation.mvp.presenter

import activestudent.com.client.alex.presentation.mvp.view.EditMessageView

/**
 * Created by alex on 19.03.2018.
 */
interface EditMessagePresenter : BaseMvpPresenter<EditMessageView> {

    fun onInitLocationField(): String?
    fun onInitDescriptionField(): String?
    fun onSuccess()
    fun onFailure()
    fun onUpdateMessage()
}