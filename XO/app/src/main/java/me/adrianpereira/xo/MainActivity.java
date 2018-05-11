package me.adrianpereira.xo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private String currPlayer,s1,s2,s3,s4,s5,s6,s7,s8,s9;
    private Button b1,b2,b3,b4,b5,b6,b7,b8,b9;
    private TextView lbl_winner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        currPlayer = "X";
        setTitle("Current Player "+currPlayer);

        b1 = findViewById(R.id.btn1);
        b2 = findViewById(R.id.btn2);
        b3 = findViewById(R.id.btn3);
        b4 = findViewById(R.id.btn4);
        b5 = findViewById(R.id.btn5);
        b6 = findViewById(R.id.btn6);
        b7 = findViewById(R.id.btn7 );
        b8 = findViewById(R.id.btn8);
        b9 = findViewById(R.id.btn9);
        lbl_winner = findViewById(R.id.winner);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.restart){
            reset();
        } else if (id == R.id.settings){

        }
        return true;
    }

    public void btnOnClick(View view) {
        int id = view.getId();
        Button button = findViewById(id);
//        Toast.makeText(this, ""+id, Toast.LENGTH_SHORT).show();
        if (button.getText().toString()==""){
            button.setText(currPlayer);
            testWinner(currPlayer);
            if (currPlayer=="X"){
                currPlayer="O";
                setTitle("Current Player "+currPlayer);
            } else if (currPlayer=="O"){
                currPlayer="X";
                setTitle("Current Player "+currPlayer);
            }
        }
    }

    public void testWinner(String winner){
        s1 = b1.getText().toString();
        s2 = b2.getText().toString();
        s3 = b3.getText().toString();
        s4 = b4.getText().toString();
        s5 = b5.getText().toString();
        s6 = b6.getText().toString();
        s7 = b7.getText().toString();
        s8 = b8.getText().toString();
        s9 = b9.getText().toString();

        if (s1==s2&&s2==s3&&s3!="" || s4==s5&&s5==s6&&s6!="" || s7==s8&&s8==s9&&s9!="" || s1==s4&&s4==s7&&s7!="" || s2==s5&&s5==s8&&s8!="" || s3==s6&&s6==s9&&s9!="" || s1==s5&&s5==s9&&s9!="" || s3==s5&&s5==s7&&s7!=""){
            Toast.makeText(this, "Player "+winner+" Won!", Toast.LENGTH_LONG).show();
            b1.setEnabled(false);
            b2.setEnabled(false);
            b3.setEnabled(false);
            b4.setEnabled(false);
            b5.setEnabled(false);
            b6.setEnabled(false);
            b7.setEnabled(false);
            b8.setEnabled(false);
            b9.setEnabled(false);
            setTitle("Current Player "+winner);
            lbl_winner.setText("Winner\n Player "+winner);
        }else if (s1!="" && s2!="" && s3!="" && s4!="" && s5!="" && s6!="" && s7!="" && s8!="" && s9!=""){
            Toast.makeText(this, "Draw!", Toast.LENGTH_LONG).show();
            b1.setEnabled(false);
            b2.setEnabled(false);
            b3.setEnabled(false);
            b4.setEnabled(false);
            b5.setEnabled(false);
            b6.setEnabled(false);
            b7.setEnabled(false);
            b8.setEnabled(false);
            b9.setEnabled(false);
            setTitle("Current Player "+winner);
            lbl_winner.setText("Draw!");
        }
    }

    public void reset(){
        lbl_winner.setText("Game In Progress");
        setTitle("Current Player X");
        currPlayer = "X";
        b1.setEnabled(true);
        b2.setEnabled(true);
        b3.setEnabled(true);
        b4.setEnabled(true);
        b5.setEnabled(true);
        b6.setEnabled(true);
        b7.setEnabled(true);
        b8.setEnabled(true);
        b9.setEnabled(true);
        b1.setText("");
        b2.setText("");
        b3.setText("");
        b4.setText("");
        b5.setText("");
        b6.setText("");
        b7.setText("");
        b8.setText("");
        b9.setText("");
    }

}
