package com.SpurFlys.pocketscout;

import com.SpurFlys.pocketscout.model.Team;
import com.SpurFlys.pocketscout.model.Tournament;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TeamSelection extends Activity {

    private String tournamentName;
    Tournament tournament = new Tournament(); 
	EditText mEdit1;
	EditText mEdit2;
	EditText mEdit3;
	EditText mEdit4;
	EditText mEdit5;
	EditText mEdit6;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_team_selection);
		
		Intent intent = getIntent();
		tournamentName = intent.getExtras().getString("tournamentName");
		tournament.setName(tournamentName);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.team_selection, menu);
		return true;
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

	public void addTeam(View view){
		mEdit1 = (EditText)findViewById(R.id.team);
		mEdit2 = (EditText)findViewById(R.id.editText2);
		mEdit3 = (EditText)findViewById(R.id.editText3);
		mEdit4 = (EditText)findViewById(R.id.editText4);
		mEdit5 = (EditText)findViewById(R.id.editText5);
		mEdit6 = (EditText)findViewById(R.id.editText6);
		String teamNumber = mEdit1.getText().toString();
		String auton = mEdit2.getText().toString();
		String chassis = mEdit3.getText().toString();
		String arm = mEdit4.getText().toString();
		String intake = mEdit5.getText().toString();
		String other = mEdit6.getText().toString();
		if(teamNumber.trim().equals("")){
			Toast.makeText(this, "Blank is not a valid team number.", Toast.LENGTH_LONG).show();
		}
		else{
//			tournament.createTeam(teamNumber, auton, chassis, arm, intake, other);
			mEdit1.setText("");
			mEdit2.setText("");
			mEdit3.setText("");
			mEdit4.setText("");
			mEdit5.setText("");
			mEdit6.setText("");
		}
	}
	
	public void findTeam(View view){
		mEdit1 = (EditText)findViewById(R.id.team);
		String teamNumber = mEdit1.getText().toString();
//		if(tournament.teams.containsKey(teamNumber)){
//			Team tempTeam = tournament.getTeam(teamNumber);
//			mEdit2.setText(tempTeam.getAuton());
//			mEdit3.setText(tempTeam.getChassis());
//			mEdit4.setText(tempTeam.getArm());
//			mEdit5.setText(tempTeam.getIntake());
//			mEdit6.setText(tempTeam.getOther());
//		}
//		else {
			Toast.makeText(this, "This team does not yet exist.", Toast.LENGTH_LONG).show();
//		}
	}
}