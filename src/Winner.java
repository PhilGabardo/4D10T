package philgabardo.fourdigits10tries;


import java.util.ArrayList;


import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

public class Winner extends Activity {
	
	private static int digit1;
	private static int digit2;
	private static int digit3;
	private static int digit4;
	private static int guessesLeft;
	private static int correctDigits;
	private static int correctPlaces;
	public NumberPicker D1;
	private static NumberPicker D2;
	private static NumberPicker D3;
	private static NumberPicker D4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.winscreen);
        Intent intent = getIntent();
        String winningNumber = intent.getStringExtra("WinningNumber");
        TextView winningNumberTV = (TextView) findViewById(R.id.WinningNumber);
	    winningNumberTV.setText(winningNumber);
	    new Handler().postDelayed(new Runnable() {
	    	 
            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */
 
            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(Winner.this, MainActivity.class);
                startActivity(i);
 
                // close this activity
                finish();
            }
        }, 2000);
    
	    
	    
	    
	    
	    
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
