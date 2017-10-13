 package tanvir.floatingactinbuttonwithanimation;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import static tanvir.floatingactinbuttonwithanimation.R.id.activity_main_co;

 public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab_note,fab_check,fab_plus;
    Animation fabOpen,fabClose,fabRotateClockWise,fabRotateAntiClockwise;
     boolean isOpen = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        fab_plus= (FloatingActionButton) findViewById(R.id.fab_plus);
        fab_note= (FloatingActionButton) findViewById(R.id.fab_Note);
        fab_check= (FloatingActionButton) findViewById(R.id.fab_check);
        fabOpen= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_open);
        fabClose= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_close);
        fabRotateClockWise= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_clockwise);
        fabRotateAntiClockwise= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_anti_clockwise);

        fab_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isOpen)
                {
                    fab_note.startAnimation(fabClose);
                    fab_check.startAnimation(fabClose);
                    fab_plus.startAnimation(fabRotateAntiClockwise);
                    fab_note.setClickable(false);
                    fab_check.setClickable(false);
                    isOpen=false;
                }
                else
                {
                    fab_note.startAnimation(fabOpen);
                    fab_check.startAnimation(fabOpen);
                    fab_plus.startAnimation(fabRotateClockWise);
                    fab_note.setClickable(true);
                    fab_check.setClickable(true);
                    isOpen=true;

                }
            }
        });


        fab_note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ///Toast.makeText(MainActivity.this, "Fuck", Toast.LENGTH_SHORT).show();
                /*Snackbar snackbar = Snackbar.make(findViewById(R.id.activity_main_co),
                        "This is a snack",Snackbar.LENGTH_LONG);
                snackbar.show();*/

                Intent intent = new Intent(getApplicationContext(),NoteEdit.class);
                startActivity(intent);
            }
        });



    }
}
