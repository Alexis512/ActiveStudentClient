package activestudent.com.client.alex.presentation.mvp.presenter.student

import activestudent.com.client.alex.presentation.mvp.presenter.BaseMvpPresenter
import activestudent.com.client.alex.presentation.mvp.view.student.SchenduleView

/**
 * Created by alex on 28.03.2018.
 */
interface SchendulePresenter : BaseMvpPresenter<SchenduleView> {

    fun loadSchendule()
}