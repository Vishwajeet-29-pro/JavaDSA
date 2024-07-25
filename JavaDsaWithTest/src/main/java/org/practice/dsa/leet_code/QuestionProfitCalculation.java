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
        if (prices == null || prices.length < 2) {
            return 0; // No profit can be made with fewer than 2 prices
        }

        // Initialize variables
        int minPrice = Integer.MAX_VALUE; // Start with the maximum possible value
        int maxProfit = 0; // Start with zero profit

        // Iterate through each price
        for (int price : prices) {
            // Update the minimum price encountered so far
            minPrice = Math.min(minPrice, price);

            // Calculate potential profit with the current price
            int profit = price - minPrice;

            // Update the maximum profit if the current profit is greater
            maxProfit = Math.max(maxProfit, profit);
        }

        // Return the maximum profit found
        return maxProfit;
    }
}
