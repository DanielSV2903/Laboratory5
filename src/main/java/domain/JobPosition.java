package domain;

public class JobPosition {

    private int id;
    private String description;
    private double hourlyWage;
    private static int autoID;

    public JobPosition(int id, String description, double hourlyWage) {
//        autoID++;
        this.id = id;
        this.description = description;
        this.hourlyWage = hourlyWage;
    }

    public JobPosition(String description, double hourlyWage) {
        this.id= ++autoID;
        this.description = description;
        this.hourlyWage = hourlyWage;
    }

    public JobPosition(int id) {
//        autoID++;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    public static int getAutoID() {
        return autoID;
    }

    public static void setAutoID(int autoID) {
        JobPosition.autoID = autoID;
    }
    private double getSalary(double n){
        return n*hourlyWage;
    }


    @Override
    public String toString() {
        return "(ID)"+id+"/(Job Position)"+description +" /(Hourly Wage)"+ hourlyWage;
    }
}
