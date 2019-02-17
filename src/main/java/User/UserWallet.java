package User;

class UserWallet implements Wallet{
    private double cashAmount;

    public UserWallet() {
        cashAmount = 0;
    }

    public double getCashAmount() {
        return cashAmount;
    }
    public void setCashAmount(double amount){
        cashAmount = amount;
    }
    public void addCash(double amount) {
        cashAmount += amount;
    }
}