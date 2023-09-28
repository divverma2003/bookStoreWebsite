package psu.edu.BookStoreWebpage.Model;


public class DateTime {
    private String date;

    public DateTime(String date)
    {
        this.date = date;
    }

    public DateTime(){
        date = "1/1/2000";
    }
    public String getDate(){
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public static String dateValidator(String date){
        String[] dateSplit = date.split("/");
        int month = Integer.parseInt(dateSplit[0]);
        int day = Integer.parseInt(dateSplit[1]);
        int year = Integer.parseInt(dateSplit[2]);
        final int FINAL_YEAR = 2023;

        if(month < 1 || month > 12)
            return "Invalid month! Month must be in the range of 1 to 12.";
        if(day < 1 || day > 31)
            return "Invalid date! Day must be in the range of 1 to 31.";
        if(year > FINAL_YEAR)
            return String.format("Invalid year! Year can't be greater than %s.", FINAL_YEAR);

        return null;
    }

    public String toString(){
        return this.getDate();
    }
}
