package com.ssu.artemiy_dobrynin.java.task2;

import com.ssu.artemiy_dobrynin.java.task2.controller.DinnerIO;
import com.ssu.artemiy_dobrynin.java.task2.model.EmployeeOrderGenerator;
import com.ssu.artemiy_dobrynin.java.task2.model.KitchenOrderGenerator;
import com.ssu.artemiy_dobrynin.java.task2.model.Menu;

/**
 * Created by DobryninAM on 28.09.2016.
 */
public class DinnerDelivery { //Task 2 by Artemiy Dobrynin

    public static Menu MENU = new DinnerIO().menuRead();

    public static void main(String[] args) {
        DinnerDelivery app = new DinnerDelivery();
        app.startApplication();
    }

    public void startApplication() {
        DinnerIO io = new DinnerIO();
        EmployeeOrderGenerator generator = io.orderRead();
        io.employeeOrderWrite(generator);
        KitchenOrderGenerator kitchenOrderGenerator = new KitchenOrderGenerator();
        kitchenOrderGenerator.generateKitchenOrderFromEmployeeOrder(generator, MENU);
        io.kitchenOrderWrite(kitchenOrderGenerator);

       /* HashMap<String, Dish> Menu = new HashMap<>();
        Menu orders = new Menu();
        ArrayList<Order> employees = new ArrayList<>();
        String line;

        try(BufferedReader fs = new BufferedReader(new FileReader("C\\Users\\DobryninAM\\Documents\\TextFiles\\Menu.txt"))){
            while((line = fs.readLine()) != null){
                String[] mas = line.split("-");
                Menu.put(mas[0], new Dish(mas[0], Integer.parseInt(mas[1]), Integer.parseInt(mas[2])));

            }
        }
        catch(IOException exc1){
            System.out.println("Error in reading file!");
        }

        try(BufferedReader fs = new BufferedReader(new FileReader("C\\Users\\DobryninAM\\Documents\\TextFiles\\Orders.txt"))){
            while((line = fs.readLine()) != null){
                String[] mas = line.split("|");
                String[] menuMas = mas[1].split(", ");
                Menu tmpmenu = new Menu();

                for (String dish : menuMas) {
                    orders.addDish(Menu.get(menuMas));
                }

                orders.addMenu(tmpmenu);
                Order tmp = new Order(mas[0], tmpmenu);
                employees.add(tmp);
            }
        }
        catch(IOException exc1){
            System.out.println("Error in reading file!");
        }

        orders.printMenu();
        System.out.println(orders.calculateOverallPrice());
        for (Order employee : employees){
            employee.printOrder();
        }*/

        //Ввод с потока
        //Сериализация
        //Exception`ы

    }
}