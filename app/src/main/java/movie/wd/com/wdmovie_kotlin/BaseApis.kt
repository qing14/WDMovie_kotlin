package movie.wd.com.wdmovie_kotlin

import io.reactivex.Observable
import movie.wd.com.wdmovie_kotlin.bean.LoginBean
import movie.wd.com.wdmovie_kotlin.bean.RegisterBean
import movie.wd.com.wdmovie_kotlin.bean.YYBean
import retrofit2.http.*
import java.util.*

interface BaseApis{

    @POST
    @FormUrlEncoded
    fun login(@Url string: String, @FieldMap hashMap: HashMap<String, String>):Observable<LoginBean>
    @POST
    @FormUrlEncoded
    fun register(@Url string: String, @FieldMap hashMap: HashMap<String, String>):Observable<RegisterBean>
    @GET
    fun ypget(@Url string: String, @QueryMap hashMap: HashMap<String, String>):Observable<YYBean>

}
