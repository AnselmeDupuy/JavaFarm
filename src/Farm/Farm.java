package Farm;

import java.util.ArrayList;

public class Farm {
    static int coins;
    static int wheat;
    static int rice;
    static int millet;
    static int muttons;
    static int horses;
    static int cows;
    static int wheatSeeds;
    static int riceSeeds;
    static int milletSeeds;
    private int total;

    public void constructFarm(int coins, int wheat, int rice, int millet, int cows, int wheatSeeds, int riceSeeds, int milletSeeds) {
        this.coins = coins;
        this.wheat = wheat;
        this.rice = rice;
        this.millet = millet;
        this.cows = cows;
        this.muttons = muttons;
        this.horses = horses;
        this.wheatSeeds = wheatSeeds;
        this.riceSeeds = riceSeeds;
        this.milletSeeds = milletSeeds;
    }

    public void constructFarm() {
        this.coins = 500;
        this.wheat = 0;
        this.rice = 0;
        this.millet = 0;
        this.cows = 0;
        this.muttons = 0;
        this.horses = 0;
        this.wheatSeeds = 10;
        this.riceSeeds = 0;
        this.milletSeeds = 0;
    }

    public void getAll() {
        this.getCoins();
        this.getWheat();
        this.getRice();
        this.getMillet();
        this.getCows();
        this.getWheatSeeds();
        this.getRiceSeeds();
        this.getMilletSeeds();
    }

    public int seedsNumber(){
        return total = wheatSeeds + riceSeeds + milletSeeds;
    }

    public int getWheatSeeds() {
        return wheatSeeds;
    }

    public void addWheatSeeds(int seeds) {
        this.wheatSeeds += wheatSeeds;
    }

    public int getRiceSeeds() {
        return riceSeeds;
    }

    public void addRiceSeeds(int seeds) {
        this.riceSeeds += riceSeeds;
    }

    public int getMilletSeeds() {
        return milletSeeds;
    }

    public void addMilletSeeds(int seeds) {
        this.milletSeeds += milletSeeds;
    }

    public int getCoins() {
        return coins;
    }

    public int getWheat() {
        return wheat;
    }

    public int getRice() {
        return rice;
    }

    public int getMillet() {
        return millet;
    }

    public int getCows() {
        return cows;
    }

    public void addCoins(int coins) {
        this.coins += coins;
    }

    public void addWheat(int wheat) {
        this.wheat += wheat;
    }

    public void addRice(int rice) {
        this.rice += rice;
    }

    public void addMillet(int millet) {
        this.millet += millet;
    }

    public void addCows(int cows) {
        this.cows += cows;
    }

    public void removeCoins(int coins) {
        this.coins -= coins;
    }

    public void removeWheat(int wheat) {
        this.wheat -= wheat;
    }

    public void removeRice(int rice) {
        this.rice -= rice;
    }

    public void removeMillet(int millet) {
        this.millet -= millet;
    }

    public void removeCows(int cows) {
        this.cows -= cows;
    }

    public void addCow(int cows) {
        this.cows += cows;
    }

    public void removeCow(){
        this.cows = 0;
    }


}

