package org.practice.dsa.leet_code;

public class QuestionProfitCalculation {
    /*
    * You are given an array prices where prices[i] is the price of a given stock on the ith day.
    * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the
    * future to sell that stock.
    * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit,
    * return 0.
    * */
    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            }
            int profit = price - minPrice;

            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }
        return maxProfit;
    }
}
