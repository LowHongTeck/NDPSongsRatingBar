package sg.edu.rp.c346.id20043679.ndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class EditActivity extends AppCompatActivity {

    EditText etTitle, etSingers, etYear;
    RadioGroup radioGroup;
    Button btnUpdate, btnDelete, btnCancel;
    Song data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        etTitle = findViewById(R.id.etTitle);
        etSingers = findViewById(R.id.etSingers);
        etYear = findViewById(R.id.etYear);

        radioGroup = findViewById(R.id.rGroup);

        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        btnCancel = findViewById(R.id.btnCancel);

        Intent i = getIntent();
        data = (Song) i.getSerializableExtra("data");

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = etTitle.getText().toString();
                String singers = etSingers.getText().toString();
                int year = Integer.parseInt(etYear.getText().toString());

                int rGSelected = radioGroup.getCheckedRadioButtonId();
                int stars = 0;

                if (rGSelected == R.id.oneStar){
                    stars = 1;
                } else if (rGSelected == R.id.twoStar){
                    stars = 2;
                } else if (rGSelected == R.id.threeStar){
                    stars = 3;
                } else if (rGSelected == R.id.fourStar){
                    stars = 4;
                } else if (rGSelected == R.id.fiveStar){
                    stars = 5;
                }
                data.setTitle(title);
                data.setSingers(singers);
                data.setStars(stars);
                data.setYear(year);
                DBHelper dbh = new DBHelper(EditActivity.this);
                dbh.updateSong(data);

                finish();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(EditActivity.this);
                dbh.deleteSong(data.getId());

                finish();
            }
        });




    }
}