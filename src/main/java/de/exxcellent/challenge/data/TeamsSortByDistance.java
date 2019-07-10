package de.exxcellent.challenge.data;

import java.util.Comparator;

public class TeamsSortByDistance implements Comparator<FootballData>{

	@Override
	public int compare(FootballData arg0, FootballData arg1) {
        return Double.compare(arg0.getDistance(), arg1.getDistance());
	}

}
