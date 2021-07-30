package sg.edu.rp.c346.id20043679.ndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RatingBar;

public class MainActivity extends AppCompatActivity {

    EditText etTitle, etSingers, etYear;
    //RadioGroup radioGroup;
    Button btnInsert, btnShowList;
    RatingBar ratings;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTitle = findViewById(R.id.etTitle);
        etSingers = findViewById(R.id.etSingers);
        etYear = findViewById(R.id.etYear);

        //radioGroup = findViewById(R.id.rGroup);
        ratings = findViewById(R.id.ratingBar);

        btnInsert = findViewById(R.id.btnUpdate);
        btnShowList = findViewById(R.id.btnDelete);

        ratings.setMax(5);



        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = etTitle.getText().toString();
                String singers = etSingers.getText().toString();
                int year = Integer.parseInt(etYear.getText().toString());

                //int rGSelected = radioGroup.getCheckedRadioButtonId();
                float numOfStars = ratings.getRating();
//                int stars = 0;
//
//                if (rGSelected == R.id.oneStar){
//                    stars = 1;
//                } else if (rGSelected == R.id.twoStar){
//                    stars = 2;
//                } else if (rGSelected == R.id.threeStar){
//                    stars = 3;
//                } else if (rGSelected == R.id.fourStar){
//                    stars = 4;
//                } else if (rGSelected == R.id.fiveStar){
//                    stars = 5;
//                }


                DBHelper dbh = new DBHelper(MainActivity.this);
                dbh.insertSong(title, singers, year, numOfStars);
            }
        });

        btnShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowListActivity.class);
                startActivity(intent);
            }
        });




    }
}