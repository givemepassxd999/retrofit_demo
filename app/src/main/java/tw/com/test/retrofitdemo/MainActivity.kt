package tw.com.test.retrofitdemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        send_data.setOnClickListener {
            val apiService = AppClientManager.client.create(ApiService::class.java)
            apiService.index().enqueue(object : Callback<List<Posts>> {
                override fun onResponse(call: Call<List<Posts>>, response: Response<List<Posts>>) {
                    val sb = StringBuffer()
                    val list = response.body()
                    for (p in list!!) {
                        sb.append(p.body)
                        sb.append("\n")
                        sb.append("---------------------\n")
                    }
                    info.text = sb.toString()
                }

                override fun onFailure(call: Call<List<Posts>>, t: Throwable) {

                }
            })
        }
    }
}
