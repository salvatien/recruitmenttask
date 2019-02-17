package User;

public class User {
    private Wallet wallet;
    private String username;
    private String firstName;
    private String lastName;
    private int lives;

    public User(String username, String firstName, String lastName) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.wallet = new UserWallet();
        this.lives = 1;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getLives() {
        return lives;
    }

    public void setWallet(Wallet value){
        wallet = value;
    }

    public void setUsername(String value){
        username = value;
    }

    public void setFirstName(String value){
        firstName = value;
    }

    public void setLastName(String value){
        lastName = value;
    }

    public void setLives(int value){
        lives = value;
    }

    public void addToWallet(double amount) {
        wallet.addCash(amount);
    }

    public void addLife() {
        lives++;
    }

    public void removeLife() {
        lives--;
    }

    public void resetWallet() {
        wallet.setCashAmount(0);
    }
}
