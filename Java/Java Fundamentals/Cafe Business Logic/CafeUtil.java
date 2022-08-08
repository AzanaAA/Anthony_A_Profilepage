import java.util.ArrayList;

public class CafeUtil {

    public int getStreakGoal(){
        int sum = 0;
        for(int week = 1; week <=10; week++){
            sum+= week;
        }
        return sum;
    }

    public double getOrderTotal(double[] lineItems){
        double sum = 0;
        for (double price: lineItems){
            sum+= price;
        }
        return sum;
    }


    public void displayMenu(ArrayList<String> menuItems){
        for (int id = 0; id < menuItems.size(); id++){
            System.out.printf("%s %s \n", id, menuItems.get(id));
        }
    }


        public void addCustomer(ArrayList<String> customerList) {
        System.out.println("Please enter your name:");
        String userName = System.console().readLine();
        System.out.printf("Hello, %s! ", userName);
        System.out.printf("There are %s people ahead of you.\n", customerList.size());
        customerList.add(userName);
        System.out.println(customerList);
    }





    


    }

