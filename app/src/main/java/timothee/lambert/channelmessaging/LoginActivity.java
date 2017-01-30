package timothee.lambert.channelmessaging;


import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, OnDownloadCompleteListener {

    private Button btValider;
    private TextView txtId;
    private TextView txtMdp;
    private EditText edId;
    private EditText edMdp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.d("myTag", "This is my message number10");
        btValider = (Button) findViewById(R.id.btnValidate);
        btValider.setOnClickListener(this);

        txtId = (TextView) findViewById(R.id.txtId);
        txtMdp = (TextView) findViewById(R.id.txtMdp);

        edId = (EditText) findViewById(R.id.edId);
        edMdp = (EditText) findViewById(R.id.edMdp);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == btValider.getId())
        {
            HashMap<String, String> connectInfo = new HashMap<>();
            connectInfo.put("username", edId.getText().toString());
            connectInfo.put("password", edMdp.getText().toString());
            Async Async = new Async(getApplicationContext(), connectInfo);
            Async.setOnDownloadCompleteListener(this);
            Async.execute();
        }

    }

    @Override
    public void onDownloadComplete(String result) {

        Gson gson = new Gson();


        Callback r = gson.fromJson(result, Callback.class);
        Log.d("yOLO",r.toString());
        if(r.code==200){
            Toast.makeText(this, "Vous êtes connecté ! ", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this, ChannelListActivity.class);
            startActivity(intent);


        }
        else{
            Toast.makeText(this, "Erreur de connexion", Toast.LENGTH_SHORT).show();
        }
    }
}

