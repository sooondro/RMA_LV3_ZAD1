package hr.ferit.sandroblavicki.rma_lv3_zad1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import hr.ferit.sandroblavicki.rma_lv3_zad1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpUi()
    }

    private fun setUpUi() {
        binding.bBlueBird.setOnClickListener { countBird(ContextCompat.getColor(applicationContext, R.color.blue)) }
        binding.bGreenBird.setOnClickListener { countBird(ContextCompat.getColor(applicationContext, R.color.green)) }
        binding.bYellowBird.setOnClickListener { countBird(ContextCompat.getColor(applicationContext, R.color.yellow)) }
        binding.bRedBird.setOnClickListener { countBird(ContextCompat.getColor(applicationContext, R.color.red)) }
        binding.bReset.setOnClickListener { resetValues() }
    }

    private fun resetValues() {
        val preferenceManager = PreferenceManager()
        preferenceManager.resetValues()
        displayBirdCounter()
    }

    override fun onResume() {
        super.onResume()
        displayBirdCounter()
    }

    private fun displayBirdCounter() {
        val color = PreferenceManager().retrieveBirdColor()
        val counter = PreferenceManager().retrieveBirdCount().toString()
        binding.tvBirdCounter.text = counter
        color?.let { binding.tvBirdCounter.setBackgroundColor(it) }
    }

    private fun countBird(s: Int) {
        val preferenceManager = PreferenceManager()
        preferenceManager.countBird(s)
        displayBirdCounter()
    }
}