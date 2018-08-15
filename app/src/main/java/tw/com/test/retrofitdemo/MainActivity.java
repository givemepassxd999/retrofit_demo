package tw.com.test.retrofitdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView tv = findViewById(R.id.info);
        Button info = findViewById(R.id.send_data);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PostApi postApi = AppClientManager.getClient().create(PostApi.class);
                postApi.index().enqueue(new Callback<List<Posts>>() {
                    @Override
                    public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {
                        StringBuffer sb = new StringBuffer();
                        List<Posts> list = response.body();
                        for(Posts p : list){
                            sb.append(p.getBody());
                            sb.append("\n");
                            sb.append("---------------------\n");
                        }
                        tv.setText(sb.toString());
                    }

                    @Override
                    public void onFailure(Call<List<Posts>> call, Throwable t) {

                    }
                });
           }
        });
    }
}
