package activestudent.com.client.alex.presentation.mvp.view.student

import activestudent.com.client.alex.model.Schendule
import activestudent.com.client.alex.presentation.mvp.view.BaseMvpView


interface SchenduleView: BaseMvpView {

    fun onSuccessLoadSchendule(schendule: Schendule)
    fun onFailureLoadSchendule()
}