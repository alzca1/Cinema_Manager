package cinema;

public class Seat {
    private char seatStatus;
    private int seatPrice;

    public Seat(char seatStatus, int seatPrice){
        this.seatStatus = seatStatus;
        this.seatPrice = seatPrice;
    }

    public int showPrice(){
        return seatPrice;
    }

    public char getStatus(){
        return seatStatus;
    }



}
