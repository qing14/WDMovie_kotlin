package movie.wd.com.wdmovie_kotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import movie.wd.com.wdmovie_kotlin.R.id.login
import movie.wd.com.wdmovie_kotlin.bean.LoginBean
import movie.wd.com.wdmovie_kotlin.bean.RegisterBean
import movie.wd.com.wdmovie_kotlin.bean.YYBean
import movie.wd.com.wdmovie_kotlin.contract.LoginContract
import movie.wd.com.wdmovie_kotlin.presenter.LoginPresenter

class MainActivity : RxAppCompatActivity(),View.OnClickListener,LoginContract.ILoginView {
    override fun success(yyBean: YYBean) {

    }

    override fun success(registerBean: RegisterBean) {
   }

    lateinit var loginPresenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
           initView()
           initData()

    }

    private fun initData() {
        loginPresenter=LoginPresenter()

    }

    private fun initView() {
    login.setOnClickListener(this)
        go_register.setOnClickListener(this)
    }
    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.login -> login()
            R.id.go_register ->register()
        }
    }

    fun login(){
        val phone = findViewById<EditText>(R.id.phone_login)
        val pwd = findViewById<EditText>(R.id.pwd_login)
        if (phone !=null &&!phone.equals("")){
            if(pwd !=null&&!pwd.equals("")){

                val phonetext = phone.text.toString()
                val pwdtext = pwd .text.toString()

                var map=HashMap<String,String>()
                map.put("phone",phonetext+"")
                map.put("pwd",pwdtext+"")
                loginPresenter.attach(this)
                loginPresenter.login(map,this)
            }else{
                Toast.makeText(this,"密码为空",Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this,"账号为空",Toast.LENGTH_SHORT).show();
        }

    }
    fun register(){
        val intent=Intent()
        intent.setClass(this,RegisterActivity().javaClass)
        startActivity(intent)
    }


    override fun success(loginBean: LoginBean) {
        if (loginBean.status.equals("0000")){
            val intent=Intent()
            intent.setClass(this,SYActivity().javaClass)
            startActivity(intent)
        }

       }

    override fun failue(string: String) {

     }
}
