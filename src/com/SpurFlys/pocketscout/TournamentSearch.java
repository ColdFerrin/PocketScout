package com.SpurFlys.pocketscout;

import java.text.SimpleDateFormat;
import java.util.Date;
import android.app.Activity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

public class TournamentSearch extends Activity {
	
		private String country = " ";
		private String region = " ";
		private String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tournament_search);
		
		EditText countryText = (EditText)findViewById(R.id.tournamentid);
		EditText regionText = (EditText)findViewById(R.id.editText2);
		EditText dateText = (EditText)findViewById(R.id.editText3);
		
		country = countryText.getText().toString();
		region = regionText.getText().toString();
		date = dateText.getText().toString(); 
		
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void eventSearch(View view){
		EventSearch api = new EventSearch(country, region, date);
		System.out.print(api);
			
	}
	
	
}
