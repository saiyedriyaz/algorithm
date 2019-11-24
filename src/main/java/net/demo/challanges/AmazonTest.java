package net.demo.challanges;

public class AmazonTest {

    public static void main(String[] args) {

    }
}
/**

    Given a rectangular map of a Amazon warehouse (represented as char[][]) with box and floor tiles,
return the largest group of boxes on that map

// B..
// B..        =4
// BB.

// BBB..
// B.B..
// .B.BB      =5
// B..BB
// .B...

        BBB
        BBB  = 9
        BBB

        BBB
        B.B  = 5
        ...
        .BB


        int getLargestBox(char[][] warehouse) {

        for(int i =0;i<warehouse.length;i++) {

        for(int j=0;j<warehouse[i].length;j++) {

        if(j< warehouse[i].length && warehouse[j][j] == warehouse[j][j+1]) {



        }
        //check right
        if(isConnected(warehouse[j][j], warehouse[j][j+1])
        //check above
        || isConnected(warehouse[i][j], warehouse[i-1][j])) {

        //checl left
        || isConnected(warehouse[i-1][j], warehouse[i][j])

        connected++;
        }


        //check down

        }
        }
        }

        int boolean isConnected(char one, char two) {
        if(one == two) {
        return true
        }
        return false;
        }

*/