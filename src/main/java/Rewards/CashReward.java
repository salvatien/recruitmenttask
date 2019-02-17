package Rewards;

public class CashReward implements Reward{
    private double cashAmount;

    public CashReward(double cashAmount) {
        this.cashAmount = cashAmount;
    }
    public double getCashAmount(){
        return cashAmount;
    }
    public void setCashAmount(double value){
        cashAmount = value;
    }
}
