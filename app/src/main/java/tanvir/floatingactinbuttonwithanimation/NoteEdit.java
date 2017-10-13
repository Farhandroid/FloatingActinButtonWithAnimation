package tanvir.floatingactinbuttonwithanimation;

import android.app.Service;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

public class NoteEdit extends AppCompatActivity {

    InputMethodManager imm;
    EditText titleET,bodyET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_edit);

        titleET = (EditText) findViewById(R.id.titleET);
        bodyET = (EditText) findViewById(R.id.body);

        /*imm= (InputMethodManager)this.getSystemService(Service.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(titleET.getWindowToken(), 0);
        imm.hideSoftInputFromWindow(bodyET.getWindowToken(), 0);*/
        ///titleET.setClickable(false);
        ///bodyET.setClickable(false);
        titleET.setInputType(InputType.TYPE_NULL);
        bodyET.setInputType(InputType.TYPE_NULL);


    }

    public void body(View view) {
        Toast.makeText(this, "Alue", Toast.LENGTH_SHORT).show();
        titleET.setClickable(true);
        bodyET.setClickable(true);

        titleET.setInputType(InputType.TYPE_CLASS_TEXT);
        bodyET.setInputType(InputType.TYPE_CLASS_TEXT);

        titleET.requestFocus();
        bodyET.requestFocus();

        InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.showSoftInput(titleET, InputMethodManager.SHOW_IMPLICIT);
    }

    public static class LineEditText extends EditText {
        // we need this constructor for LayoutInflater
        public LineEditText(Context context, AttributeSet attrs) {
            super(context, attrs);
            mRect = new Rect();
            mPaint = new Paint();
            mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
            mPaint.setColor(Color.BLACK);
        }

        private Rect mRect;
        private Paint mPaint;

        @Override
        protected void onDraw(Canvas canvas) {

            int height = getHeight();
            int line_height = getLineHeight();

            int count = height / line_height;

            if (getLineCount() > count)
                count = getLineCount();

            Rect r = mRect;
            Paint paint = mPaint;
            int baseline = getLineBounds(0, r);

            for (int i = 0; i < count; i++) {

                canvas.drawLine(r.left, baseline + 1, r.right, baseline + 1, paint);
                baseline += getLineHeight();

                super.onDraw(canvas);
            }

        }
    }
}
