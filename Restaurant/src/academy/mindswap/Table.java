package academy.mindswap;

public class Table {

    private boolean free;
    private String order;

    public Table(){
        order = null;
        free = true;
    }

    public void cleanOrder(){
        this.order = null;
    }

    public String getOrder(){ return this.order; }

    public void saveOrder(String order){

        if(this.order != null){
            return;
        }

        this.order = order;
    }

    public boolean isFree(){ return free; }

    public void occupy(){ this.free = false; }

    public void unoccupy(){
        this.free = true;
    }
}
