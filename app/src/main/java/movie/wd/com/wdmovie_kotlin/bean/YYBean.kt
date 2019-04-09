package movie.wd.com.wdmovie_kotlin.bean

data class YYBean(
    val message: String,
    val result: List<Result>,
    val status: String
) { data class Result(
    val followMovie: Boolean,
    val id: Int,
    val imageUrl: String,
    val name: String,
    val rank: Int,
    val summary: String
)}
