package Farm;

public class Farm {
    int coins;
    int wheat;
    int rice;
    int millet;
    int cows;
    int muttons;
    int horses;

    public void constructFarm(int coins, int wheat, int rice, int millet, int cows, int muttons, int horses) {
        this.coins = coins;
        this.wheat = wheat;
        this.rice = rice;
        this.millet = millet;
        this.cows = cows;
        this.muttons = muttons;
        this.horses = horses;
    }

    public void constructFarm() {
        this.coins = 500;
        this.wheat = 0;
        this.rice = 0;
        this.millet = 0;
        this.cows = 0;
        this.muttons = 0;
        this.horses = 0;
    }

    public void getAll() {
        System.out.println("Coins: " + coins + "\nWheat: " + wheat + "\nRice: " + rice + "\nMillet: " + millet + "\nCows: " + cows + "\nMuttons: " + muttons + "\nHorses: " + horses);
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

    public int getMuttons() {
        return muttons;
    }

    public int getHorses() {
        return horses;
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

    public void addMuttons(int muttons) {
        this.muttons += muttons;
    }

    public void addHorses(int horses) {
        this.horses += horses;
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

    public void removeMuttons(int muttons) {
        this.muttons -= muttons;
    }

    public void removeHorses(int horses) {
        this.horses -= horses;
    }


}

