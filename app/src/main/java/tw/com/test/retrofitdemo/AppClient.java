package tw.com.test.retrofitdemo;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppClient {
    private OkHttpClient okHttpClient;
    public Retrofit getClient(){
        okHttpClient = new OkHttpClient();
        return new Retrofit.Builder()
                .baseUrl(Config.URL) //设置网络请求的Url地址
                .addConverterFactory(GsonConverterFactory.create()) //设置数据解析器
                .client(okHttpClient)
                .build();
    }
}
