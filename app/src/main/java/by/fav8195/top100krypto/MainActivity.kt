package by.fav8195.top100krypto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import by.fav8195.top100krypto.activities.AboutActivity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd

class MainActivity : AppCompatActivity() {

    private lateinit var mInterstitialAd: InterstitialAd//межстраничный баннер

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //инициализация межстраничного баннера
        mInterstitialAd = InterstitialAd(this)
        mInterstitialAd.adUnitId = "ca-app-pub-4333726404613823/7147934847"
        mInterstitialAd.loadAd(AdRequest.Builder().build())
    }

    //Переопределение при создании меню
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    //Обработчик нажатия на меню
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item!!.itemId){
            R.id.action_about ->{
                //Если это элемент action_about, то откроем новое активити
                val intent = Intent (this,AboutActivity::class.java)
                startActivity(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    //Функция показа баннера при возврате назад
    private fun showAd() {
        if (mInterstitialAd.isLoaded) {
            mInterstitialAd.show()
        }
    }

    //Переопредеелние функции нажатия на кнопку возврата назад
    override fun onBackPressed() {
        super.onBackPressed()
        showAd()
    }

}

//Баннеры AdMob
//ca-app-pub-4333726404613823~8353205302 adMob
//ca-app-pub-4333726404613823/9614509609 banner
//ca-app-pub-4333726404613823/7147934847 inner