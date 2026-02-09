public class TimeCalculator{
    public static void main(String[] args){
        double homeworkTime = 3.99;
        double lectureTime = 1.25;
        int numLectures = 4;
        double breakTime = 0.53;
        double travelAdjustment = 0.08;
        double timeTotal = 0.0;

        timeTotal += homeworkTime / 2.0;
        timeTotal += lectureTime * numLectures;
        timeTotal -= (breakTime * 3);
        timeTotal *= (1 + travelAdjustment);

        double timeTmp = timeTotal * 100.0;
        int time100Tmp = (int)timeTmp;
        double timeTotalTrunc = time100Tmp / 100.0;

        System.out.println("You're busy for " + timeTotalTrunc + " hours.");

        int totalHours = 24;
        totalHours -= timeTotalTrunc;

        System.out.println("You have " + totalHours + " hours remaining in the day.");
    }
}