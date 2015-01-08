package com.SpurFlys.pocketscout.dbhelper;

import com.SpurFlys.pocketscout.model.Team;
import com.SpurFlys.pocketscout.model.Tournament;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper{
	
	// Logcat Tag
	private static final String LOG = "DBHelper";
	
	// Database Name
	private static final String DATABASE_NAME = "scout.db";
	
	// Database Version
	private static final int DATABASE_VERSION = 1;
	
	// Table Names
	private static final String TABLE_TOURNAMENTS = "tournaments";
	private static final String TABLE_TEAMS = "teams";
	private static final String TABLE_TOURNAMENT_TEAM = "tournaemt_team";
	
	// Common Column Names
	private static final String KEY_ID = "id";
	
	// Tournament column names
	private static final String KEY_VEXID = "vexid";
	private static final String KEY_NAME = "name";
	private static final String KEY_DATE = "date";
	private static final String KEY_ADDRESS = "address";
	private static final String KEY_CITY = "city";
	private static final String KEY_STATE = "state";
	private static final String KEY_COUNTRY = "country";
	private static final String KEY_POSTALCODE = "postalcode";
	
	// Team column Names
	private static final String KEY_TEAMNUMBER = "teamnumber";
	private static final String KEY_AUTON = "auton";
	private static final String KEY_CHASSIS = "chassis";
	private static final String KEY_ARM = "arm";
	private static final String KEY_INTAKE = "intake";
	private static final String KEY_OTHER = "other";
	
	// Tournament_Team column names
	private static final String KEY_TOURNAMENT_ID = "tournament_id";
	private static final String KEY_TEAM_ID = "team_id";
	
	// Table Create Statments
	// Tournament Table Create Statments
	private static final String CREATE_TABLE_TOURNAMENT = "CREATE TABLE " 
			+ TABLE_TOURNAMENTS + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_VEXID
			+ " TEXT," + KEY_NAME + " TEXT," + KEY_DATE + " DATETIME," + KEY_ADDRESS + " TEXT,"
			+ KEY_CITY + " TEXT," + KEY_STATE + " TEXT," + KEY_COUNTRY + " TEXT," 
			+ KEY_POSTALCODE + " TEXT" + ")";
	
	// Team Table Create Statments
	private static final String CREATE_TABLE_TEAM = "CREATE TABLE " 
			+ TABLE_TEAMS + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_TEAMNUMBER
			+ " TEXT," + KEY_AUTON + " TEXT," + KEY_CHASSIS + " TEXT," + KEY_ARM + " TEXT,"
			+ KEY_INTAKE + " TEXT," + KEY_OTHER + " TEXT" + ")";
		
	// Tournament Team Table Create Statments
	private static final String CREATE_TABLE_TOURNAMENT_TEAM = "CREATE TABLE " 
			+ TABLE_TOURNAMENT_TEAM + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_TOURNAMENT_ID
			+ " INTEGER," + KEY_TEAM_ID + " INTEGER" + ")";
	
	public DBHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// creating required tables
		db.execSQL(CREATE_TABLE_TEAM);
		db.execSQL(CREATE_TABLE_TOURNAMENT);
		db.execSQL(CREATE_TABLE_TOURNAMENT_TEAM);		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// on upgrade drop older tables
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_TOURNAMENTS);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_TEAMS);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_TOURNAMENT_TEAM);
		
		// create new tables
		onCreate(db);
	}
	
	// creating a tournament
	public void createTournament(Tournament tournament){
		SQLiteDatabase db = this.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		values.put(KEY_VEXID, tournament.getVexid());
		values.put(KEY_NAME, tournament.getName());
		values.put(KEY_DATE, tournament.getDate());
		values.put(KEY_ADDRESS, tournament.getAddress());
		values.put(KEY_CITY, tournament.getCity());
		values.put(KEY_STATE, tournament.getState());
		values.put(KEY_COUNTRY, tournament.getCountry());
		values.put(KEY_POSTALCODE, tournament.getPostalCode());
		
		// insert row
		long tournament_id = db.insert(TABLE_TOURNAMENTS, null, values);
		
		//put the tournament id back in the tournament
		tournament.setId(tournament_id);	
	}
	
	// creating a team
	public void createTeam(Team team, Tournament tournament){
		SQLiteDatabase db = this.getWritableDatabase();
			
		ContentValues values = new ContentValues();
		values.put(KEY_TEAMNUMBER, team.getTeamNumber());
		values.put(KEY_AUTON, team.getAuton());
		values.put(KEY_CHASSIS, team.getChassis());
		values.put(KEY_ARM, team.getArm());
		values.put(KEY_INTAKE, team.getIntake());
		values.put(KEY_OTHER, team.getOther());
		
		// insert row
		long team_id = db.insert(TABLE_TEAMS, null, values);
		
		//put the team id back in the team
		team.setId(team_id);	
		
		values = new ContentValues();
		values.put(KEY_TOURNAMENT_ID, tournament.getId());
		values.put(KEY_TEAM_ID, team_id);
		
		// insert row
		db.insert(TABLE_TOURNAMENT_TEAM, null, values);
	}
		
	//getting a single tournament
	public Tournament getTournament(long tournament_id){
		SQLiteDatabase db = this.getReadableDatabase();
		
		String selectQuery = "SELECT  * FROM " + TABLE_TOURNAMENTS + " WHERE "+ KEY_ID + " = " 
			+ tournament_id;
		
		Log.e(LOG, selectQuery);
		
		Cursor c = db.rawQuery(selectQuery, null);
		
		if (c != null){
			c.moveToFirst();
		}
		
		Tournament tournament = new Tournament();
		tournament.setId(c.getInt(c.getColumnIndex(KEY_ID)));
		tournament.setVexid(c.getString(c.getColumnIndex(KEY_VEXID)));
		tournament.setName(c.getString(c.getColumnIndex(KEY_NAME)));
		tournament.setDate(c.getString(c.getColumnIndex(KEY_DATE)));
		tournament.setAddress(c.getString(c.getColumnIndex(KEY_ADDRESS)));
		tournament.setCity(c.getString(c.getColumnIndex(KEY_CITY)));
		tournament.setState(c.getString(c.getColumnIndex(KEY_STATE)));
		tournament.setCountry(c.getString(c.getColumnIndex(KEY_COUNTRY)));
		tournament.setPostalCode(c.getString(c.getColumnIndex(KEY_POSTALCODE)));
		
		return tournament;
	}

    //getting a single team
    public Team getTeam(long team_id){
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TABLE_TEAMS + " WHERE "+ KEY_ID + " = "
                + team_id;

        Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null){
            c.moveToFirst();
        }

        Team team = new Team(KEY_TEAM_ID);
        team.setId(c.getInt(c.getColumnIndex(KEY_ID)));
        team.setAuton(c.getString(c.getColumnIndex(KEY_AUTON)));
        team.setChassis(c.getString(c.getColumnIndex(KEY_CHASSIS)));
        team.setArm(c.getString(c.getColumnIndex(KEY_ARM)));
        team.setIntake(c.getString(c.getColumnIndex(KEY_INTAKE)));
        team.setOther(c.getString(c.getColumnIndex(KEY_OTHER)));

        return team;
    }
}
