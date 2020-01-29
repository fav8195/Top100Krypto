package by.fav8195.top100krypto.activities

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.fav8195.top100krypto.R
import com.google.android.gms.ads.AdRequest
import kotlinx.android.synthetic.main.activity_about.*

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)//Привязываем стрелку возврата из этого активити в родительское

        //слушатель кнопки, который открывает рейтинг приложения в плеймаркете
        buttonRateApp.setOnClickListener {
            startActivity(Intent(
                Intent.ACTION_VIEW,
                Uri.parse("market://details?id=${applicationContext.packageName}")))//"info.fandroid.topcrypts"//Имя пакета приложения
        }

        //Инициализация баннера
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)

    }


}
