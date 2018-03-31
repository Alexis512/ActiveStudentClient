package activestudent.com.client.alex.domain

import activestudent.com.client.alex.model.Schendule

interface SchenduleLisctenerInteractor {
    fun onSuccessLoadSchendule(schendule: Schendule)
    fun onFailureLoadSchendule()
}