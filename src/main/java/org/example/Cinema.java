package org.example;

import java.util.Arrays;

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

    public boolean bookSeats(int hallNumber, int row, int[] seats){
        for(int seat : seats){
            if(cinema[hallNumber][row][seat] == 1){
                System.out.println("Місце" + seat + "у ряді" + row + " вже заброньоване!");
                return false;
            }
        }
        for(int seat : seats){
            cinema[hallNumber][row][seat] = 1;
        }
        System.out.println("Місця " + Arrays.toString(seats) + " у ряді" + row +" заброньовані!");
        return true;
    }

    public boolean cancelBooking(int hallNumber, int row, int[] seats){
        for(int seat : seats){
            if(cinema[hallNumber][row][seat] == 0){
                System.out.println("Місце" + seat + "у ряді" + row + " ще не заброньоване!");
                return false;
            }
        }
        for(int seat : seats){
            cinema[hallNumber][row][seat] = 0;
        }
        System.out.println("Місця" + Arrays.toString(seats) + "у ряді" + row + " були скасовані!");
        return true;
    }
}
