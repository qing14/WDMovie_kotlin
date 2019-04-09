package movie.wd.com.wdmovie_kotlin.utils

import android.app.Application
import com.kotlinframework.net.network.RetrofitManager
import movie.wd.com.wdmovie_kotlin.Apis
import retrofit2.Retrofit

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        RetrofitManager.instance.init(Apis.BASE_URL)
    }
}