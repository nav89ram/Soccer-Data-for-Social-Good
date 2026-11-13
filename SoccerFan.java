import java.util.Scanner;

public class SoccerFan  {
  /* Uses an array to store information about the soccer teams
      After every data type, a pair of [] is needed to indicate there is an array being created */
  String[] teamNames;
  String[] awayTeamNames;
  int[] scores;
  int[] attendance;

  /* Non parameterized constructor which sets
  the data to the prefound data set which we got */
  
  public SoccerFan() {
    teamNames = FileReader.toStringArray("team_name.txt");
    awayTeamNames = FileReader.toStringArray("away_team.txt");
    scores = FileReader.toIntArray("score.txt");
    attendance = FileReader.toIntArray("attendance.txt");
  }
  /* Parameterized constructor where the user
  passes text tiles to modify the variables we have as arguments */
  public SoccerFan(String teamNameFile, String awayTeamFile, String scoreFile, String attendanceFile) {
    this.teamNames = FileReader.toStringArray(teamNameFile);
    this.awayTeamNames = FileReader.toStringArray(awayTeamFile);
    this.scores = FileReader.toIntArray(scoreFile);
    this.attendance = FileReader.toIntArray(attendanceFile);
  }

  // Acessor method to return team names
  public String[] getTeamNames() {
    return teamNames;
  }

  
  // Acessor method to return away teams
  public String[] getAwayTeamNames() {
    return awayTeamNames;
  }
  // Accessor method to get the scores
  public int[] getScores() {
    return scores;
  }
  // Accessor method to get the attendance
  public int[] getAttendance() {
    return attendance;
  }

  /* Uses a new variable set to the first element of 
  the attendance length, then iterates through the second
  to last element and checks if the element is larger than
  the variable set, if it is the variable is set to the
  element and it is returned at the end */
  public int getMostAttendance() {
    int max = attendance[0];
    for(int i=1;i<attendance.length;i++) {
      if(attendance[i] > max) {
        max = attendance[i];
      }
    }
    return max;
  }

  /* Sets a new variable, total, to 0 and a new variable of average
  which then an enhanced for loop is used to iterate through the attendance
  list and adds the people to the total. Then the average variable is set to the
  total divided by the length of attendance and the average variable is returned */
  public double averageAttendance() {
    int total = 0;
    double average;
    for(int people : attendance) {
      total = total + people;
    }
    average = total/attendance.length;
    return average;
  }
/* Sets the new variable equal to the scores array first element and then 
  a for loop is iterated starting from the second element and checks 
  using an if statement if the highest variable is less than the element in the list being iterated
  and if it is, the highest variable is then set to the element in the for loop. The highest
  variable is then returned */
  public int getHighestScore() {
    int highest = scores[0];
    for(int i=1;i<scores.length;i++) {
      if(scores[i]>highest) {
        highest = scores[i];
      }
    }
    return highest;
  }

  /* A new integer variable is declared and a new double variable is declared to 
  represent the average. Then an enhanced for loop is used which adds the scores
  to the new integer variable, totalTwo. After this the average, avg, data variable
  is then set to the totalTwo variable dividd by the length of scores. The
  average variable, avg, is then returned */
  public double averageGoalsScored() {
    int totalTwo = 0;
    double avg;
    for(int score: scores) {
      totalTwo += score;
    }
    avg = totalTwo/scores.length;
    return avg;
  }

  
/* A new average double variable is decalred with calling the averageAttendance method, and a new
  integer variable count is created. An enhanced for loop is created which checks if the teams
  attendance is greater than the average attendance variable. A new string array is created with the
  length of the count of teams above the average attendance. A new index variable is then created. After that
  a for loop is used to check if the attendance element is greater than the average. Then the team that is
  greater, than the matches list that is created then gets the team name element added and the index increases.
  After this a new string variable is created. An enhanced for loop is then created which iterates through the matches list
  and adds the team to the string and a new line. The string is then returned. */
  public String numberOfTeamsAttendanceAboveAvg() {
    double avge = averageAttendance();
    int count = 0;
    for(int ppl : attendance) {
      if(ppl > avge) {
        count++;
      }
    }
    String[] matches = new String[count];
    int index = 0;
    for(int i=0;i<attendance.length;i++) {
      if(attendance[i] > avge) {
        matches[index] = teamNames[i];
        index++;
      }
    }

    String result = "";
    for(String team: matches) {
      result += team + "\n";
    }
    return result;
  }


/* A to string method which returns a concatenation of information calling methods and using new 
  lines to display information about the teams and the data set. */
  public String toString() {
    return "Soccer Stats \n" + "Number of Matches Played: " + scores.length + "\n" + "Get Highest Score: " + getHighestScore() + "\n" + "Average Score: " + averageGoalsScored() + "\n" + "Most Attended Games: " + getMostAttendance() + "\n" + "Average Attended Games: " + averageAttendance() + "\n" + "Teams Which Has Higher than Average Attendance: \n" + numberOfTeamsAttendanceAboveAvg();
  }
}