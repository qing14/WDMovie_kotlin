package movie.wd.com.wdmovie_kotlin.contract

import android.content.Context
import com.kotlinframework.net.network.IModelCallback
import movie.wd.com.wdmovie_kotlin.bean.LoginBean
import movie.wd.com.wdmovie_kotlin.bean.RegisterBean
import movie.wd.com.wdmovie_kotlin.bean.YYBean
import java.util.*

interface LoginContract {

    interface LoginPresenter{
        fun login(hashMap: HashMap<String,String>,context: Context)
        fun register(hashMap: HashMap<String, String>, context: Context)
        fun YPGET(hashMap: HashMap<String, String>, context: Context)
    }
    interface ILoginModel{
        fun login(context: Context, hashMap: HashMap<String, String>, modelCallback: IModelCallback<LoginBean>)
        fun register(context: Context,hashMap: HashMap<String, String>,modelCallback: IModelCallback<RegisterBean>)
        fun YPGET(context: Context,hashMap: HashMap<String, String>,modelCallback: IModelCallback<YYBean>)
    }
    interface ILoginView{
        fun success(loginBean: LoginBean)
        fun success(registerBean: RegisterBean)
        fun success(yyBean: YYBean)
        fun failue(string : String)
    }


}