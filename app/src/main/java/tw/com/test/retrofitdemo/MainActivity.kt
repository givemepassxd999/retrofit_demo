package tw.com.test.retrofitdemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tv = findViewById<TextView>(R.id.info)
        val info = findViewById<Button>(R.id.send_data)
        info.setOnClickListener {
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
                    tv.text = sb.toString()
                }

                override fun onFailure(call: Call<List<Posts>>, t: Throwable) {

                }
            })
        }
    }
}
