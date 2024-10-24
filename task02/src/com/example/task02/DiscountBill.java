package com.example.task02;

public class DiscountBill extends Bill{
    private float discount;

    public DiscountBill(float discount){
        this.discount = discount;
    }
    public DiscountBill(int percent){
        discount = percent * 0.01f;
    }

    @Override
    public long getPrice() {
        long defaultPrice = super.getPrice();
        double difference = defaultPrice  * discount;
        return Math.round(defaultPrice - difference);
    }

    public float getDiscount(){ return discount; }

    public int getPercentDiscount(){
        return (int)(discount * 100);
    }

    // разница между суммой и суммой со скидкой
    public long getAbsoluteDiscount(){
        long defaultPrice = super.getPrice();
        double difference = defaultPrice  * discount;
        return Math.round(difference);
    }
}
