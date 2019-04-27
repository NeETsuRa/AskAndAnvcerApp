package vprasaj.odgovori;

import java.util.Random;
import android.app.*;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class VprasajinodgovoriActivity extends Activity {
    /** Called when the activity is first created. */
	private static final int DIALOG_DA = 1;
	private static final int DIALOG_NE = 2;
	String Ime;
	String Vprasanje;
	private TextView myText = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button btnP = (Button)findViewById(R.id.buttonP);
        btnP.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		EditText txt = (EditText)findViewById(R.id.editText1);
        		Vprasanje = txt.getText().toString();
        		EditText txt1 = (EditText)findViewById(R.id.editText2);
        		Ime = txt1.getText().toString();
        		startActivity(new Intent ("vprasaj.odgovori.DRUGI"));
        	}
        	});
        
    }
    
    public void Start(){
    	setContentView(R.layout.druga);
    	//LinearLayout lView = new LinearLayout(this);
    	//myText = new TextView(this);
    	//myText.setText(Ime+Vprasanje);
    	//lView.addView(myText);

    	//setContentView(lView);
    	TextView besedilo = (TextView) findViewById(R.id.editText1);
    	besedilo.setText(Ime + ", " +  Vprasanje + "?");
    	
    	Button DA = (Button)findViewById(R.id.buttonD); 
    		DA.setOnClickListener(new OnClickListener() {
    		public void onClick(View v) {
    		showDialog(DIALOG_DA);
    		}
    		});
    	Button NE = (Button)findViewById(R.id.buttonN); 
    		NE.setOnClickListener(new OnClickListener() {
    		public void onClick(View v) {
    		showDialog(DIALOG_NE);
    		}
    		});
    	
    }
    
    public Dialog onCreateDialog(int id){
    	switch (id) {
    	
    	case DIALOG_DA:
    	return new AlertDialog.Builder(this)
    	.setTitle("LEPO")
    	.setMessage("Me veseli da je tako")
    	//.setPositiveButton("Da", new Dialog.OnClickListener() {
    	//public void onClick(DialogInterface dlg, int x){
    	//onStart();
    	//}
    	//})
    	.setNegativeButton("oglasi se še kaj", new Dialog.OnClickListener() {
    	public void onClick(DialogInterface dlg, int x){
    	finish();
    	}
    	})
    	.create();
    	
    	
    	case DIALOG_NE:
        	return new AlertDialog.Builder(this)
        	.setTitle("Pa daj no!")
        	.setMessage("Saj bo! Boš poskusil s drugim?")
        	.setPositiveButton("Da", new Dialog.OnClickListener() {
        	public void onClick(DialogInterface dlg, int x){
        	onStart();
        	}
        	})
        	.setNegativeButton("Ne", new Dialog.OnClickListener() {
        	public void onClick(DialogInterface dlg, int x){
        	finish();
        	}
        	})
        	
        	
        	.create();
    	}
    	return null;
    	}
}