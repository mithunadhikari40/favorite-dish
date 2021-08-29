package np.com.mithunadhikari.favoritedish

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowInsets
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import np.com.mithunadhikari.favoritedish.databinding.ActivitySplashScreenAcitivityBinding


class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val splashBinding: ActivitySplashScreenAcitivityBinding  =ActivitySplashScreenAcitivityBinding.inflate(layoutInflater)
        setContentView(splashBinding.root)

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        }else{
            @Suppress("DEPRECATION")
            window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)

        }

        val splashAnimation = AnimationUtils.loadAnimation(this@SplashScreenActivity, R.anim.splash_anim)
        splashBinding.tvAppName.animation = splashAnimation
        splashAnimation.setAnimationListener(object: Animation.AnimationListener{
            override fun onAnimationStart(p0: Animation?) {
            }

            override fun onAnimationEnd(p0: Animation?) {

                val intent = Intent(this@SplashScreenActivity,MainActivity::class.java)
                Handler(Looper.getMainLooper()).postDelayed({
                    startActivity(intent)
                },1000)

            }

            override fun onAnimationRepeat(p0: Animation?) {
            }

        } )
    }
}