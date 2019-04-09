package movie.wd.com.wdmovie_kotlin.model

import android.content.Context
import com.kotlinframework.net.network.*
import movie.wd.com.wdmovie_kotlin.Apis
import movie.wd.com.wdmovie_kotlin.BaseApis
import movie.wd.com.wdmovie_kotlin.bean.LoginBean
import movie.wd.com.wdmovie_kotlin.bean.RegisterBean
import movie.wd.com.wdmovie_kotlin.bean.YYBean
import movie.wd.com.wdmovie_kotlin.contract.LoginContract
import java.util.*

class LoginModel:LoginContract.ILoginModel {
    override fun YPGET(context: Context, hashMap: HashMap<String, String>, modelCallback: IModelCallback<YYBean>) {
        RetrofitManager.instance.createService(BaseApis::class.java).ypget(Apis.YP_PATH,hashMap)
                .compose(NetScheduler.compose())
                .subscribe(object : NetResponseObserver<YYBean>(context){
                    override fun success(data :YYBean) {
                        modelCallback?.sucess(data)
                    }

                    override fun failure(statusCode: Int, apiErrorModel: ApiErrorModel) {
                        modelCallback ?. failure(apiErrorModel.message)
                    }

                })
           }

    override fun register(context: Context, hashMap: HashMap<String, String>, modelCallback: IModelCallback<RegisterBean>) {
        RetrofitManager.instance.createService(BaseApis::class.java).register(Apis.REGISTER_PATH,hashMap)
                .compose(NetScheduler.compose())
                .subscribe(object : NetResponseObserver<RegisterBean>(context){
                    override fun success(data: RegisterBean) {
                            modelCallback ?. sucess(data)
                        }

                    override fun failure(statusCode: Int, apiErrorModel: ApiErrorModel) {
                            modelCallback ?. failure(apiErrorModel.message)
                     }

                })
    }

    override fun login(context: Context, hashMap: HashMap<String, String>, modelCallback: IModelCallback<LoginBean>) {
        RetrofitManager.instance.createService(BaseApis::class.java).login(Apis.LOGIN_PATH,hashMap)
                .compose(NetScheduler.compose())
                .subscribe(object  : NetResponseObserver<LoginBean>(context){
                    override fun success(data: LoginBean) {
                        modelCallback ?. sucess(data)
                    }

                    override fun failure(statusCode: Int, apiErrorModel: ApiErrorModel) {
                        modelCallback ?. failure(apiErrorModel.message)
                    }

                })
    }

}