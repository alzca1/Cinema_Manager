package cinema;

public class Cinema {


    private final InputHelper inputHelper;
    private SeatingArrangement seatingArrangement;

    public Cinema(){
        this.inputHelper = new InputHelper();
    }

    public void buyTicket(){
        int rowNumber = inputHelper.getInt("Enter a row number:");
        int seatNumber = inputHelper.getInt("Enter a seat number in that row:");
        seatingArrangement.bookSeat(rowNumber, seatNumber);
        System.out.println();
        showMenu();
    }

    public void showSeats(){
        System.out.println(seatingArrangement);
        seatingArrangement.printArrangement();
        System.out.println();
        showMenu();
    }

    public void exitProgram(){
//        System.out.println("Exiting...");
        System.exit(0);
    }

    public void showStatistics(){
        seatingArrangement.getStatistics();
        System.out.println();
        showMenu();
    }

    public void showMenu(){
        int chosenOption;
        String menu = String.join("\n", "1. Show the seats", "2. Buy a ticket", "3. Statistics",  "0. Exit" );
        int option = inputHelper.getInt(menu);

        while(option != 0 && option != 1 && option != 2 && option != 3){
            option = inputHelper.getInt(menu); 
        }

        switch(option){
            case 0:
                exitProgram();
                break;
            case 1:
               showSeats();
                break;
            case 2:
                buyTicket();
                break;
            case 3:
                showStatistics();
                break;
            default:
                System.out.println("Invalid option! Please, choose another option");
                break;
        }
    }

    public static void main(String[] args) {
        // Write your code here
        Cinema cinema = new Cinema();
        int rows = cinema.inputHelper.getInt("Enter the number of rows:");
        int seats = cinema.inputHelper.getInt("Enter the number of seats in each row:");
         cinema.seatingArrangement = new SeatingArrangement(rows, seats);
        cinema.showMenu();
    }
}