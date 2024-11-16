package cinema;

public class Cinema {


    private final InputHelper inputHelper;


    // leemos dos numeros (rows y seats);
    // determinamos precio ticket => seats <= 60 then price = $10;
    // if seats > 60 then:
    // seating / 2 => front rows price =  $10, back rows price = $8;
    // calculate income frontSeats * 10 + backSeats * 8 = income;

    public Cinema(){
        this.inputHelper = new InputHelper();
    }




    public static void main(String[] args) {
        // Write your code here
        Cinema cinema = new Cinema();
        int rows = cinema.inputHelper.getInt("Enter the number of rows:");
        int seats = cinema.inputHelper.getInt("Enter the number of seats in each row:");
        SeatingArrangement seatingArrangement = new SeatingArrangement(rows, seats);
        seatingArrangement.calculateSeatingProfit();

    }
}