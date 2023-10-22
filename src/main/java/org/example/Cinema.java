package org.example;

public class Cinema {
    private int [][][] cinema;
    public Cinema(int hallNumber, int rowNumber, int seatsNumber){
        cinema = new int[hallNumber][rowNumber][seatsNumber];
        for (int hall = 0; hall < hallNumber; hall++){
            for(int row = 0; row < rowNumber; row++){
                for(int seat = 0; seat < seatsNumber; seat++){
                    cinema[hall][row][seat] = 0;
                }
            }
        }
    }
}
