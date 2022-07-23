package academy.mindswap;

import static academy.mindswap.Messages.*;

public class Restaurant {

    private boolean fullCapacity;
    private int numberOfOccupiedTables;
    private Table[] tables;

    public Restaurant(int numberOfNeededTables){
        fullCapacity = false;
        numberOfOccupiedTables = 0;
        tables = new Table[numberOfNeededTables];
    }

    public int findTable(){

        int tableNumber = 0;

        if(fullCapacity){
            System.out.println(FULL_CAPACITY);
            tableNumber = -1;
        }

        for(int i = 0; i < tables.length; i++){
            if(tables[i] == null){
                tables[i] = new Table();
                System.out.println(WELCOME + (i+1));
                occupyTable(i);
                tableNumber = i;
                break;
            }

            if(tables[i].isFree()){
                occupyTable(i);
                tableNumber = i;
                System.out.println(WELCOME + (i+1));
                break;
            }
        }

        return tableNumber;
    }

    private void occupyTable(int index){

        numberOfOccupiedTables++;
        tables[index].occupy();

        if(numberOfOccupiedTables == tables.length){
            fullCapacity = true;
            return;
        }
    }

    public void order(String dish, int tableNumber){

        if(tables[tableNumber].getOrder() != null){
            System.out.println(ALREADY_HAVE_ORDER);
            return;
        }

        tables[tableNumber].saveOrder(dish);
        System.out.printf("Here's a hot plate of %s!%n",dish);
    }

     public int freeTable(int tableNumber){

        if(!checkIfTableCanBeFreed(tableNumber)){
            return tableNumber;
        }

        tables[tableNumber].unoccupy();
        tables[tableNumber].cleanOrder();
        numberOfOccupiedTables--;
        fullCapacity = false;
         System.out.println(TIP);
        return -1;
     }

    private boolean checkIfTableCanBeFreed(int tableNumber){

        if(tableNumber == -1){
            System.out.println(NEED_TABLE);
            return false;
        }

        if(tables[tableNumber].getOrder() == null){
            System.out.println(ORDER_BEFORE_LEAVING);
            return false;
        }

        return true;
    }
}
