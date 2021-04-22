package hr.ferit.sandroblavicki.rma_lv3_zad1

import android.content.Context
import androidx.core.content.ContextCompat

class PreferenceManager {

    companion object {
        const val PREFS_FILE = "MyPreferences"
        const val PREFS_KEY_BIRD_COUNTER = 0
        const val PREFS_KEY_BIRD_COLOR = R.color.white
    }

    fun countBird(color: Int) {
        val sharedPreferences = BirdCounterApp.ApplicationContext.getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE)
        var birdCounter = sharedPreferences.getInt(PREFS_KEY_BIRD_COUNTER.toString(), 0)
        birdCounter++
        val editor = sharedPreferences.edit()

        editor.putInt(PREFS_KEY_BIRD_COLOR.toString(), color)
        editor.putInt(PREFS_KEY_BIRD_COUNTER.toString(), birdCounter)
        editor.apply()
    }

    fun retrieveBirdColor(): Int? {
        val sharedPreferences = BirdCounterApp.ApplicationContext.getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE)
        return sharedPreferences.getInt(PREFS_KEY_BIRD_COLOR.toString(), R.color.white)
    }

    fun retrieveBirdCount(): Int {
        val sharedPreferences = BirdCounterApp.ApplicationContext.getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE)
        return sharedPreferences.getInt(PREFS_KEY_BIRD_COUNTER.toString(), 0)
    }

    fun resetValues() {
        val sharedPreferences = BirdCounterApp.ApplicationContext.getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putInt(PREFS_KEY_BIRD_COUNTER.toString(), 0)
        editor.putInt(PREFS_KEY_BIRD_COLOR.toString(), ContextCompat.getColor(BirdCounterApp.ApplicationContext, R.color.white))
        editor.apply()
    }
}