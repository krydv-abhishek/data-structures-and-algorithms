package org.abhishek.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Trade {
    int capital;
    int profit;

    public Trade(int capital, int profit) {
        this.capital = capital;
        this.profit = profit;
    }
}

public class IPO {
    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        List<Trade> tradeList = new ArrayList<>();
        for (int i = 0; i < profits.length; i++) {
            tradeList.add(new Trade(capital[i], profits[i]));
        }

        tradeList.sort(Comparator.comparing(trade -> trade.capital));

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        int tradeItr = 0;

        while (k > 0) {
            while (tradeItr < tradeList.size()) {
                Trade trade = tradeList.get(tradeItr);
                if (w >= trade.capital) {
                    pq.add(trade.profit);
                    tradeItr++;
                } else {
                    break;
                }
            }
            if(!pq.isEmpty()) {
                w+=pq.poll();
            } else {
                break;
            }
            k--;
        }
        return w;

    }

    public static void main(String[] args) {

        int[] capital = {7, 4, 0, 1, 2, 4, 5, 6};
        int[] profits = {9, 6, 1, 2, 3, 7, 6, 5};

        System.out.println(findMaximizedCapital(4, 0, profits, capital));

    }


}
