package otus.gpb.homework.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ActivityA : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            setContentView(R.layout.activity_a)
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.containerA)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
            if (savedInstanceState == null) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.containerA, FragmentA.newInstance())
                    .commit()
            }
    }
    companion object {
            fun newIntent(context: Context): Intent {
                return Intent(context, ActivityA::class.java)
            }
       }
}
