package academy.mindswap;


import static academy.mindswap.Messages.*;

public class Client {

    private int tableNumber = -1;
    private Restaurant restaurant;

    public void order(String dish){

        if(!checkRestaurantPresence()){
            System.out.println(NEED_RESTAURANT);
           return;
        }

        if(tableNumber < 0){
            System.out.println(NEED_TABLE_2);
            return;
        }

        restaurant.order(dish, tableNumber);
    }

    public void askForTable(){

        if(tableNumber > -1){
            System.out.println(ALREADY_HAVE_TABLE);
            return;
        }

        tableNumber = restaurant.findTable();
    }

    public void pay(){
       if(checkRestaurantPresence()){
           restaurant.freeTable(tableNumber);
           tableNumber = -1;
       }
    }

    public void setRestaurant(Restaurant restaurant){
        this.restaurant = restaurant;
    }

    private boolean checkRestaurantPresence(){

        if(this.restaurant != null){
            return true;
        }

        return false;
    }
}
