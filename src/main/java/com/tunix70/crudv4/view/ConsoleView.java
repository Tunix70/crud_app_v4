package com.tunix70.crudv4.view;

import java.util.Scanner;

public class ConsoleView {
    private static Scanner scanner;
    private static RegionView regionView = new RegionView();
    private static WriterView writerView = new WriterView();
    private static PostView postView = new PostView();


       public static void startApp(){
           mainMenu();
           selectMenu();
       }

       private static void mainMenu(){
           System.out.println("\n*** MAIN MENU ***");
           System.out.println(" ================================= ");
           System.out.println("Choose next action:");
           System.out.println("1. WRITER\n2. POST\n3. REGION\n4. EXIT");
       }

       private static void selectMenu(){
           String input;
           scanner = new Scanner(System.in);
           while (true){
               input = scanner.nextLine();
               if(input.equals("1")){
                   writerView.runner();
                   break;
               }else if(input.equals("2")){
                   postView.runner();
                   break;
               }else if(input.equals("3")){
                   regionView.runner();
                   break;
               }else if(input.equals("4")){
                   System.out.println("*** Thanks for using our program ***");
                   break;
               }else{
                   System.out.println("Please, enter numbers from 1 to 4");
                   mainMenu();
               }
           }
       }

}
