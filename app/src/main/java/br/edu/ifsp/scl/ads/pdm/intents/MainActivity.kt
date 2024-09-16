package br.edu.ifsp.scl.ads.pdm.intents

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.ifsp.scl.ads.pdm.intents.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val amb: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    companion object Constantes {
        const val PARAMETRO_EXTRA = "PARAMETRO_EXTRA"
        const val PARAMETRO_REQUEST_CODE = 0
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(amb.root)

        amb.entrarParametroBt.setOnClickListener {
            val parametroIntent = Intent(this, ParametroActivity::class.java)
            parametroIntent.putExtra(PARAMETRO_EXTRA, amb.parametroTv.text.toString())
            startActivityForResult(parametroIntent, PARAMETRO_REQUEST_CODE)

            Intent(this, ParametroActivity::class.java).apply {
                amb.parametroTv.text.toString().let{
                    putExtra(PARAMETRO_EXTRA, it)
                }
                startActivityForResult(parametroIntent, PARAMETRO_REQUEST_CODE)
            }
        }
    }
}