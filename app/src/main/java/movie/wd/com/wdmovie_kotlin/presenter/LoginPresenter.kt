package movie.wd.com.wdmovie_kotlin.presenter

import android.content.Context
import com.kotlinframework.net.network.IModelCallback
import movie.wd.com.wdmovie_kotlin.bean.LoginBean
import movie.wd.com.wdmovie_kotlin.bean.RegisterBean
import movie.wd.com.wdmovie_kotlin.bean.YYBean
import movie.wd.com.wdmovie_kotlin.contract.LoginContract
import movie.wd.com.wdmovie_kotlin.model.LoginModel
import java.util.*

class LoginPresenter :LoginContract.LoginPresenter{


    lateinit var loginModel: LoginModel
    lateinit var iLoginView: LoginContract.ILoginView
    fun attach(iLoginView: LoginContract.ILoginView){
        this.iLoginView=iLoginView
        loginModel= LoginModel()

    }
    override fun login(hashMap: HashMap<String, String>, context: Context) {
        loginModel.login(context,hashMap,object :IModelCallback<LoginBean>{
            override fun failure(string: String) {
                iLoginView ?. failue(string)
            }
            override fun sucess(data: LoginBean) {
                iLoginView ?. success(data)
            }
        })
    }

    override fun register(hashMap: HashMap<String, String>, context: Context) {
           loginModel.register(context,hashMap,object : IModelCallback<RegisterBean>{
               override fun failure(string: String) {
                   iLoginView ?.failue(string)
               }

               override fun sucess(data: RegisterBean) {
                    iLoginView ?.success(data)
               }

           })
    }
    override fun YPGET(hashMap: HashMap<String, String>, context: Context) {
        loginModel.YPGET(context,hashMap,object : IModelCallback<YYBean>{
            override fun failure(string: String) {
                iLoginView ?.failue(string)
            }

            override fun sucess(data: YYBean) {
                iLoginView ?.success(data)
            }

        })
    }
    fun detach(){
        if (iLoginView!=null){
            iLoginView==null
        }
    }
}