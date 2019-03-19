package upc.dsa.tutorialapiandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SegundoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);

        Intent adapter = getIntent();
        TextView text = (TextView) findViewById(R.id.singerTextView);
        text.setText(adapter.getStringExtra("trackId"));
    }
}
