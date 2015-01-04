package com.SpurFlys.pocketscout.model;

public class Team {
	private long id;
	private String teamNumber;
	private String auton;
	private String chassis;
	private String arm;
	private String intake;
	private String other;

	public Team(String teamNumber) {
		this.setTeamNumber(teamNumber);	
	}
	
	public Team(String teamNumber,String auton,String chassis,String arm,String intake,String other){
		this.setTeamNumber(teamNumber);
		this.setAuton(auton);
		this.setChassis(chassis);
		this.setArm(arm);
		this.setIntake(intake);
		this.setOther(other);
		
	}

	public String getAuton() {
		return auton;
	}

	public void setAuton(String auton) {
		this.auton = auton;
	}

	public String getChassis() {
		return chassis;
	}

	public void setChassis(String chassis) {
		this.chassis = chassis;
	}

	public String getArm() {
		return arm;
	}

	public void setArm(String arm) {
		this.arm = arm;
	}

	public String getIntake() {
		return intake;
	}

	public void setIntake(String intake) {
		this.intake = intake;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getTeamNumber() {
		return teamNumber;
	}

	public void setTeamNumber(String teamNumber) {
		this.teamNumber = teamNumber;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
	

}
