package movie.wd.com.wdmovie_kotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_register.*
import movie.wd.com.wdmovie_kotlin.bean.LoginBean
import movie.wd.com.wdmovie_kotlin.bean.RegisterBean
import movie.wd.com.wdmovie_kotlin.bean.YYBean
import movie.wd.com.wdmovie_kotlin.contract.LoginContract
import movie.wd.com.wdmovie_kotlin.presenter.LoginPresenter
import movie.wd.com.wdmovie_kotlin.utils.EncryptUtil

class RegisterActivity : RxAppCompatActivity(), View.OnClickListener, LoginContract.ILoginView {


    lateinit var loginPresenter: LoginPresenter
    lateinit var xingbie : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        initView()
        initData()

    }
    private fun initData() {
        loginPresenter= LoginPresenter()

    }

    private fun initView() {
        register.setOnClickListener(this)
    }
    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.register ->register()
        }
    }
    fun register(){
        val name_register = findViewById<EditText>(R.id.name_register)
        val sex_register = findViewById<EditText>(R.id.sex_register)
        val birthday_register=findViewById<EditText>(R.id.birthday_register)
        val phone_register = findViewById<EditText>(R.id.phone_register)
        val mail_register = findViewById<EditText>(R.id.mail_register)
        val pwd_register=findViewById<EditText>(R.id.pwd_register)
        val pwds_register=findViewById<EditText>(R.id.pwds_register)

        if (name_register !=null &&!name_register.equals("")){
            if(sex_register !=null &&!sex_register.equals("")){

                val name_register = name_register.text.toString()
                val sex_register = sex_register .text.toString()
                val birthday_register = birthday_register.text.toString()
                val phone_register = phone_register .text.toString()
                val mail_register = mail_register.text.toString()
                val pwd_register = pwd_register .text.toString()
                val pwds_register = pwds_register.text.toString()
                val pwd = EncryptUtil.encrypt(pwd_register)
                val pwds = EncryptUtil.encrypt(pwds_register)
                if (sex_register.equals("男")){
                    xingbie="1"
                }else{
                    xingbie="2"
                }
                if(pwd_register!=pwds_register){
                    Toast.makeText(this,"两次密码输入不一致", Toast.LENGTH_SHORT).show();

                }else{
                    var map=HashMap<String,String>()
                    map.put("nickName",name_register+"")
                    map.put("sex",xingbie+"")
                    map.put("birthday",birthday_register+"")
                    map.put("phone",phone_register+"")
                    map.put("email",mail_register+"")
                    map.put("pwd",pwd+"")
                    map.put("pwd2",pwds+"")

                    loginPresenter.attach(this)
                    loginPresenter.register(map,this)
                }

            }else{
                Toast.makeText(this,"性别为空", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this,"姓名为空", Toast.LENGTH_SHORT).show();
        }

    }

    override fun success(loginBean: LoginBean) {

    }
    override fun success(yyBean: YYBean) {

    }
    override fun success(registerBean: RegisterBean) {
        Toast.makeText(this,"注册成功", Toast.LENGTH_SHORT).show();
        val intent= Intent()
        intent.setClass(this,MainActivity::class.java)
        startActivity(intent)
    }

    override fun failue(string: String) {

    }
}
