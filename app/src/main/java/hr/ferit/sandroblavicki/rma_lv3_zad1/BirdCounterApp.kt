package hr.ferit.sandroblavicki.rma_lv3_zad1

import android.app.Application
import android.content.Context

class BirdCounterApp: Application() {

    companion object {
        lateinit var ApplicationContext: Context
        private set
    }

    override fun onCreate() {
        super.onCreate()
        ApplicationContext = this
    }
}