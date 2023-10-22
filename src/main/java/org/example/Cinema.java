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
                System.out.println("Місце" + seat + "у ряду " + row + " вже заброньоване!");
                return false;
            }
        }
        for(int seat : seats){
            cinema[hallNumber][row][seat] = 1;
        }
        System.out.println("Місця " + Arrays.toString(seats) + " у ряду " + row + " заброньовані!");
        return true;
    }

    public boolean cancelBooking(int hallNumber, int row, int[] seats){
        for(int seat : seats){
            if(cinema[hallNumber][row][seat] == 0){
                System.out.println("Місце" + seat + "у ряду " + row + " ще не заброньоване!");
                return false;
            }
        }
        for(int seat : seats){
            cinema[hallNumber][row][seat] = 0;
        }
        System.out.println("Місця" + Arrays.toString(seats) + "у ряду " + row + " були скасовані!");
        return true;
    }

    public boolean checkAvailability(int screen, int numSeats){
        for(int row = 0; row < cinema[screen].length; row++){
            int countSeats = 0;
            for(int seat = 0; seat < cinema[screen][numSeats].length; seat++){
                if(cinema[screen][row][seat] == 0){
                    countSeats++;
                    if(countSeats == numSeats){
                        System.out.println(numSeats + " вільних місць є у ряду " + row);
                        return true;
                    }
                } else {
                    countSeats = 0;
                }
            }
        }
        System.out.println("Зазначена кількість місць не доступна в залі " + screen + "!");
        return false;
    }
}
