package movie.wd.com.wdmovie_kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import movie.wd.com.wdmovie_kotlin.bean.LoginBean
import movie.wd.com.wdmovie_kotlin.bean.RegisterBean
import movie.wd.com.wdmovie_kotlin.bean.YYBean
import movie.wd.com.wdmovie_kotlin.contract.LoginContract

class SYActivity : RxAppCompatActivity(), View.OnClickListener, LoginContract.ILoginView  {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sy)

        


    }
    override fun onClick(p0: View?) {
     }

    override fun success(loginBean: LoginBean) { }

    override fun success(registerBean: RegisterBean) {}

    override fun success(yyBean: YYBean) {

   }

    override fun failue(string: String) {
   }
}
