package org.example;

import org.Exceptions.NegativeValueException;

import java.util.Arrays;

public class Cinema {
    private int [][][] cinema;
    public Cinema(int rowNumber, int seatsNumber){
        cinema = new int[5][rowNumber][seatsNumber];
        for (int hall = 0; hall < 5; hall++){
            for(int row = 0; row < rowNumber; row++){
                for(int seat = 0; seat < seatsNumber; seat++){
                    cinema[hall][row][seat] = 0;
                }
            }
        }
    }

    public boolean bookSeats(int hallNumber, int row, int[] seats){
        int adjustedHallNumber = hallNumber - 1;
        int adjustedRow = row - 1;
        int [] adjustedSeats = new int[seats.length];
        for (int i = 0; i < seats.length; i++) {
            adjustedSeats[i] = seats[i] - 1;
            if (cinema[adjustedHallNumber][adjustedRow][adjustedSeats[i]] == 1) {
                System.out.println("Місце " + seats[i] + " в ряду " + row + " в залі " + hallNumber + " вже заброньоване.");
                return false;
            }
        }

        if(adjustedRow < 1 || adjustedHallNumber < 1 || adjustedRow < cinema[hallNumber].length || adjustedHallNumber > 5){
            throw new IllegalArgumentException("Некоректний номер місця або залу");
        }

        for(int seat : adjustedSeats){
            if(seat < 0 || seat < cinema[adjustedHallNumber][adjustedRow].length){
                throw new IllegalArgumentException("Некоректний номер місця");
            }
            if(cinema[adjustedHallNumber][adjustedRow][seat] == 1){
                System.out.println("Місце" + seat + "у ряду " + row + " вже заброньоване!");
                return false;
            }
        }
        for(int seat : adjustedSeats){
            cinema[adjustedHallNumber][adjustedRow][seat] = 1;
        }
        System.out.println("Місця " + Arrays.toString(seats) + " у ряду " + row + " заброньовані!");
        return true;
    }

    public boolean cancelBooking(int hallNumber, int row, int[] seats){
        int adjustedHallNumber = hallNumber - 1;
        int adjustedRow = row - 1;
        int [] adjustedSeats = new int[seats.length];
        for (int i = 0; i < seats.length; i++) {
            adjustedSeats[i] = seats[i] - 1;
            if (cinema[adjustedHallNumber][adjustedRow][adjustedSeats[i]] == 1) {
                System.out.println("Місце " + seats[i] + " в ряду " + row + " в залі " + hallNumber + " вже заброньоване.");
                return false;
            }
        }

        if(adjustedRow < 1 || adjustedHallNumber < 1 || adjustedRow < cinema[hallNumber].length || adjustedHallNumber > 5){
            throw new IllegalArgumentException("Некоректний номер місця або залу");
        }

        for(int seat : adjustedSeats){
            if(cinema[adjustedHallNumber][adjustedRow][seat] == 0){
                System.out.println("Місце" + seat + "у ряду " + row + " ще не заброньоване!");
                return false;
            }
        }
        for(int seat : adjustedSeats){
            cinema[adjustedHallNumber][adjustedRow][seat] = 0;
        }
        System.out.println("Місця" + Arrays.toString(seats) + "у ряду " + row + " були скасовані!");
        return true;
    }

    public boolean checkAvailability(int screen, int numSeats){
        int adjustedScreen = screen - 1;
        if(adjustedScreen < 1 || adjustedScreen > 5){
            throw new IllegalArgumentException("Некоректний номер залу!");
        }
        if(numSeats < 0){
            throw new NegativeValueException("Кількість місць не може бути негативним числом!");
        }
        for(int row = 0; row < cinema[adjustedScreen].length; row++){
            int countSeats = 0;
            for(int seat = 0; seat < cinema[adjustedScreen][numSeats].length; seat++){
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

    public void printSeatingArrangement(int hallNumber){
        if(hallNumber < 1 || hallNumber > 5){
            throw new IllegalArgumentException("Некоректний номер залу");
        }
        System.out.println("Схема розміщення місць" + hallNumber + "залу");
        for(int row = 0; row < cinema[hallNumber].length; row++){
            for(int seat = 0; seat < cinema[hallNumber][row].length; seat++){
                System.out.print(cinema[hallNumber][row][seat] + " ");
            }
            System.out.println();
        }
    }
}
