package cinema;

public class SeatingArrangement {
    private Seat[][] arrangement;
    private int rows;
    private int seats;

    private final int FRONT_ROW_PRICE = 10;
    private final int BACK_ROW_PRICE = 8;

    public SeatingArrangement(int rows, int seats) {
        this.rows = rows;
        this.seats = seats;
        arrangement = generateSeatingArrangement();
    }

    public int calculateSeatPrice(int row, int seat) {

        int price = 0;
        int front_row_limit;
        int back_row_limit;

        if (rows * seats <= 60) {
            price = FRONT_ROW_PRICE;
        }

        if (rows * seats > 60) {
            front_row_limit = rows / 2;
            back_row_limit = rows - front_row_limit;
            price = row <= front_row_limit ? FRONT_ROW_PRICE : BACK_ROW_PRICE;
        }
        return price;
    }

    public void bookSeat(int row, int seat) {
        int price = calculateSeatPrice(row, seat);
        Seat seatToBook = arrangement[row -1][seat - 1];
        if(seatToBook.getStatus() == 'B'){
            System.out.println("Seat already booked!");
            return;
        }
        arrangement[row - 1][seat - 1] = new Seat('B', price);
        System.out.println("Ticket price: $" + price);
    }

    public void printArrangement() {
        System.out.println("Cinema:");
        for (int i = 0; i <= seats; i++) {
            if (i == 0) {
                System.out.print("  ");
            }

            if (i > 0) {
                System.out.print(i + " ");
            }
        }

        System.out.println();
        for (int i = 0; i < rows; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < seats; j++) {
                System.out.print(arrangement[i][j].getStatus() + " ");
            }

            System.out.println();
        }

    }

    public Seat[][] generateSeatingArrangement() {
        Seat[][] arrangement = new Seat[rows][seats];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seats; j++) {
                int price = calculateSeatPrice(i, j);
                arrangement[i][j] = new Seat('S', price);
            }
        }
        return arrangement;
    }

    public void calculateSeatingProfit() {
        int profit = 0;
        int FRONT_ROW_PRICE = 10;
        int BACK_ROW_PRICE = 8;

        if (rows * seats <= 60) {
            profit = rows * seats * FRONT_ROW_PRICE;
        }

        if (rows * seats > 60) {
            int frontRows = rows / 2;
            int backRows = rows % 2 == 0 ? rows / 2 : (int) Math.ceil((double) rows / 2);
            profit = (frontRows * seats * FRONT_ROW_PRICE) + (backRows * seats * BACK_ROW_PRICE);
        }

        System.out.println("Total income:");
        System.out.printf("$" + profit);
    }
}
