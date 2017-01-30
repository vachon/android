package timothee.lambert.channelmessaging;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by vachonn on 30/01/2017.
 */
public class ChannelListActivity extends AppCompatActivity {


    private ListView lvChannel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channellist);
        Log.d("myTag", "This is my message number10");

        lvChannel = (ListView) findViewById(R.id.listView);

    }
}
