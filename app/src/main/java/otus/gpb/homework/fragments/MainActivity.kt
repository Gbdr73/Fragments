package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import otus.gpb.homework.fragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.activityA.setOnClickListener(){
            val intent = ActivityA.newIntent(this)
            startActivity(intent)
        }
        binding.activityB.setOnClickListener(){
            val intent = ActivityB.newIntent(this)
            startActivity(intent)
        }
    }
}