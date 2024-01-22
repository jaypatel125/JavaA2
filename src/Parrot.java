//Author: Jay Patel, 000881881
public class Parrot {
    //default values
    String name = "Julius";
    int health = 3;
    double crumbs = 0.1;
    String tamed = "untamed";
    String alive = "alive";
    String position = "flying";

    public String getName() {
        return name;
    }
    //defining get and set methods for all variables.
    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public double getCrumbs() {
        return crumbs;
    }

    public void setCrumbs(double crumbs) {
        this.crumbs = crumbs;
    }

    public String getTamed() {
        return tamed;
    }

    public void setTamed(String tamed) {
        this.tamed = tamed;
    }

    public String getAlive() {
        return alive;
    }

    public void setAlive(String alive) {
        this.alive = alive;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }


    public String feed(double food) {
        String value = "";
        if (this.alive == "alive") {
            //parrot's health will increase by 1 (maximum 3) and crumbs depends on the amount you feed
            this.crumbs += food;
            this.health = Math.min(this.health + 1, 3);

            //by feeding parrot chances of become tamed is 20%
            double chance = food * 20;
            if (chance > 50.0) {
                this.tamed = "tamed";
            }

            if (this.crumbs > 2.5) {
                //if it eats to much than it can be sick and health goes to 0(min)
                this.health = Math.max(0, this.health - 2);

                if (this.health > 0) {
                    value = "Parrot is sick because of eating too much food";

                }
                //if it's health goes to 0 by eating too much than it will die as well
                if (this.health == 0) {
                    this.alive = "dead";
                    value = "Parrot is no more";
                }
            } else {
                value = this.name + " ate!";
            }
        } else {
            value = "You can not feed dead parrot.";
        }
        return value +"\n";
    }

    public String command(String gesture){
        //gesture will save the input that user enters as a command
        String value = "";
        if (this.alive=="dead"){
            value = "You can not give command to dead parrot.";
            this.position="stay";
        }
        else {
            if (this.tamed=="untamed"){
                value = "Untamed parrot do not obey. Sorry";
            }
            else{
                if (gesture=="fly"){
                    this.position="flying";
                    value = "Parrot is flying in the sky";
                }
                else{
                    this.position="stay";
                    value="As per your command parrot is sitting in the corner! lol";
                }
            }
        }
        return value +"\n";
    }

    public String play(Parrot p){
        //Parrot p is other parrot that will play with main parrot
        String value= "";
        value="Both parorts having fun and chilling with each other.";
        if (p.getTamed()=="tamed" && this.tamed=="tamed"){
            p.setTamed("untamed");
            this.tamed="untamed";
            return value +"\n";
        }
        else {
            value="To play with each other both parrots should be tamed.";
            return value +"\n";
        }
    }

    public String hit(){
        //if parrot get hurt than its health will decrease byb 1and will be untamed
        String value="";
        if (this.alive=="dead" || this.health==1){
            value="Please do not hit dead parrot";
            this.health=0;
            this.alive="dead";
        }
        else{
            if (this.health==0){
                this.alive="dead";

            }
            else {
                this.health = Math.max(0, this.health - 1);
                this.tamed="untamed";
                this.position="flying";
                value = "Parrot left and no more tamed.";
            }
        }

        return value +"\n";
    }

    //final outcome
    public String toString(){
        return this.tamed +" "+ this.alive + " Parrot " + this.name + " is "+ this.position +" : "+ this.crumbs +" KG crumbs, "+this.health +" hearts.";
    }

}