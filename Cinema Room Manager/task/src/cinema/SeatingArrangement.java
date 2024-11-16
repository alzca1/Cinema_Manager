package cinema;

public class SeatingArrangement {
    int rows;
    int seats;

    public SeatingArrangement(int rows, int seats) {
        this.rows = rows ;
        this.seats = seats ;
    }

    public void generateSeatingArrangement() {
        char[][] arrangement = new char[rows +1 ][seats +1];
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= seats; j++) {
                if (i == 0 && j < 1) {
                    arrangement[i][j] = ' ';
                }
                if (i == 0 && j > 0) {
                    arrangement[i][j] = (char) (j + '0');
                }

                if (i > 0 && j == 0) {
                    arrangement[i][j] = (char) (i + '0');
                }

                if (i > 0 && j > 0) {
                    arrangement[i][j] = 'S';
                }
            }
        }

        System.out.print("Cinema:");
        for (int i = 0; i <= rows; i++) {
            System.out.println();
            for (int j = 0; j <= seats; j++) {
                System.out.print(arrangement[i][j] + " ");
            }
        }
    }
}
