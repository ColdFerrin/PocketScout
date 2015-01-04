package com.SpurFlys.pocketscout;

import com.SpurFlys.pocketscout.model.Tournament;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
//import android.widget.EditText;
import android.widget.Toast;

public class TournamentCreation extends Activity {
	
	Tournament tournament;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tournament_creation);
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
	
/*	public void toTournamentSearch(View view){
		Intent intent = new Intent(this, TournamentSearch.class);
		startActivity(intent);
	}*/
	
	public void toTeamSelection(View view){
		String tournamentName;
		EditText mEdit = (EditText)findViewById(R.id.tournamentid);
		tournamentName = mEdit.getText().toString();
		if(tournamentName.trim().equals("")){
			Toast.makeText(this, "Blank is not a valid tournament name.", Toast.LENGTH_LONG).show();
		}
		else{
			Intent teamSelection = new Intent(this, TeamSelection.class);
			teamSelection.putExtra("tournamentName", tournamentName);
			startActivity(teamSelection);
		}
	}
}
