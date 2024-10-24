package com.example.task02;

public class Task02Main {

    private static final Item ITEM1 = new Item("Товар 1", 10);
    private static final Item ITEM2 = new Item("Товар 2", 20);
    private static final Item ITEM3 = new Item("Товар 3", 30);
    private static final Item ITEM4 = new Item("Товар 4", 40);
    private static final Item ITEM5 = new Item("Товар 5", 50);
    private static final Item ITEM6 = new Item("Товар 6", 60);

    public static void main(String[] args) {
        Bill bill = new Bill();

        bill.add(ITEM1, 10);
        bill.add(ITEM3, 3);
        bill.add(ITEM6, 1);
        System.out.println(bill);
        bill.add(ITEM3, 3);
        System.out.println(bill);

        DiscountBill discountBill = new DiscountBill(50);

        discountBill.add(ITEM1, 10);
        discountBill.add(ITEM3, 3);
        discountBill.add(ITEM6, 1);
        System.out.println(discountBill);
        discountBill.add(ITEM3, 3);

        System.out.println("getDiscount() = " + discountBill.getDiscount());
        System.out.println("%%%%%%%%%%%% = " + discountBill.getPercentDiscount() + "%");
        System.out.println("getAbsDiscount() = " + discountBill.getAbsoluteDiscount());

        System.out.println(discountBill);
    }
}
