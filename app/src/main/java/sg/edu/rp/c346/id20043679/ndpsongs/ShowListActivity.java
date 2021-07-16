package sg.edu.rp.c346.id20043679.ndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class ShowListActivity extends AppCompatActivity {

    ArrayList<Song> al;
    ArrayAdapter<Song> aa;
    ListView lv;
    Button filter;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_list);

        filter = findViewById(R.id.filter);

        al = new ArrayList<Song>();
        aa = new ArrayAdapter<Song>(this, android.R.layout.simple_list_item_1, al);
        lv = findViewById(R.id.lv);
        lv.setAdapter(aa);

        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                al.clear();
                DBHelper dbh = new DBHelper(ShowListActivity.this);
                al.addAll(dbh.get5StarSong());
                aa.notifyDataSetChanged();
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ShowListActivity.this, EditActivity.class);
                intent.putExtra("data", al.get(position));
                startActivity(intent);
            }
        });

    }
    @Override
    protected void onResume(){
        super.onResume();
        DBHelper dbh = new DBHelper(ShowListActivity.this);
        al.clear();
        al.addAll(dbh.getAllSongs());
        aa.notifyDataSetChanged();

    }



}