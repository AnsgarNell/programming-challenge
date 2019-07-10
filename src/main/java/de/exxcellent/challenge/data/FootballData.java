package de.exxcellent.challenge.data;

public final class FootballData {
	
	private String team;
	private int goals;
	private int goalsAllowed;
	private int distance = 0;
	
	public FootballData() {
		this.team = "";
		this.goals = 0;
		this.goals = 0;
	}
	
	public FootballData(String team, int goals, int goalsAllowed) {
		this.team = team;
		this.goals = goals;
		this.goalsAllowed = goalsAllowed;
	}
	
	public int getGoals() {
		return goals;
	}
	public void setGoals(int goals) {
		this.goals = goals;
	}
	public int getGoalsAllowed() {
		return goalsAllowed;
	}
	public void setGoalsAllowed(int goalsAllowed) {
		this.goalsAllowed = goalsAllowed;
	}
	
	public int getDistance() {
		return distance;
	}
	
	public void calculateDistance() {
		this.distance = Math.abs(this.goals - this.goalsAllowed);
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

}
