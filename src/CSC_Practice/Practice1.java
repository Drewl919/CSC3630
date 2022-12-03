//package CSC_Practice;
//
//import java.util.ArrayList;
//
//public class Practice1 {
//    public static void main(String[] args) {
//        ArrayList<String> inData = getData();
//        ArrayList<ArrayList<String>> data = transferData(inData);
//
//        // given the inData show a count of the number of people
//        // who failed each unique class. Output the list in alphabetical
//        // order. For example CSC1700 5
//        outputFailurePerCourse(inData);
//        // 1. Write this method:
//        //     outputFailurePerCourse( someDataStructure)
//        //     where someDataStructure is a data structure you create
//        //          output: is count of fails per course  in alphabetical orderE.g.,
//        //              CSC1700 5
//        //              CSC2660 3
//        //  2. write this method
//        //          showPermFails( someDataStructure)
//        //   where someDataStructure is a data structure you create
//        //                 output: is list of students who got an F but never got a
//        //                      higher grade in the class
//        //                E.g., Jimmy CSC1700
//    }
//
//    private static ArrayList<String> getData() {
//        ArrayList<String> rows = new ArrayList<>();
//        rows.add( "01,Jan,CSC1700,B");
//        rows.add( "02,Jimmy,CSC1700,F");
//        rows.add( "03,Jackson,CSC3660,B");
//        rows.add( "04,Jimmy,CSC1700,F");
//        rows.add( "03,Jackson,CSC1700,A");
//        rows.add( "05,Jill,CSC1700,B");
//        rows.add( "06,Jeff,CSC1700,F");
//        rows.add( "06,Jeff,CSC1700,A");
//        rows.add( "01,Jan,CSC2660,F");
//        rows.add( "02,Jimmy,CSC2660,F");
//        rows.add( "02,Jimmy,CSC1700,F");
//        rows.add( "02,Jimmy,CSC3650,F");
//        rows.add( "02,Jimmy,CSC4350,F");
//        rows.add( "03,Jackson,CSC1700,B");
//        rows.add( "10,James,CSC2660,B");
//        rows.add( "11,Johnson,CSC1700,F");
//        rows.add( "12,Jimmy,CSC2660,F");
//        rows.add( "01,Jan,CSC1700,F");
//        return rows;
//    }
//}
//
