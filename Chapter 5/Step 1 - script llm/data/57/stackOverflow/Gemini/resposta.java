import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Seat {

    int row;
    int col;
    char type;

    Seat(int row, int col, char type){
        this.row = row;
        this.col = col;
        this.type = type;
    }

    String printSeat(){
        return "(" + row + ", " + col + ", " + type + ")";
    }



    public static void main(String[] args) {

        LinkedList<Seat> list = new LinkedList<>();


        Scanner scr = new Scanner(System.in);
        System.out.print("Enter Seat Row number to delete: ");
        int row = scr.nextInt();

        for (Iterator<Seat> iter = list.iterator(); iter.hasNext();) {

            Seat data = iter.next();

            if (data.row == row) {
                iter.remove();
            }
        }
    }    

}
