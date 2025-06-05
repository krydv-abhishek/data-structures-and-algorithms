package org.abhishek.arrays;

public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {

        int index = -1;
        int gasLeft = 0;
        int steps = 0;
        int size = gas.length;
        for (int i = 0; i < 2 * size; i++) {

            if (i >= size && index == -1) {
                return index;
            }

            if (steps == size) {
                return index;
            }
            gasLeft = gasLeft + gas[i % size];
            if (gasLeft - cost[i % size] >= 0) {
                gasLeft = gasLeft - cost[i % size];
                if (steps == 0) {
                    index = i % size;
                }
                steps++;

            } else {
                steps = 0;
                index = -1;
                gasLeft = 0;
            }
        }

        return index;

    }

    // Easy solution

    // public int canCompleteCircuit(int[] gas, int[] cost) {
    //     int sumGas = 0;
    //     int sumCost = 0;
    //     for (int p : gas) {
    //         sumGas += p;
    //     }
    //     for (int p : cost) {
    //         sumCost += p;
    //     }
    //     if (sumGas < sumCost) {
    //         return -1;
    //     }
    //     int start = 0;
    //     int total = 0;
    //     for (int i = 0; i < gas.length; i++) {
    //         total += gas[i] - cost[i];
    //         if (total < 0) {
    //             total = 0;
    //             start = i + 1;
    //         }
    //     }
    //     return start;
    // }

    public static void main(String[] args) {

        GasStation obj = new GasStation();

        int[] gas = { 2, 3, 4 }, cost = { 3, 4, 3 };
        Integer index = obj.canCompleteCircuit(gas, cost);
        System.out.println(index);

        int[] gas1 = { 1, 2, 3, 4, 5 }, cost1 = { 3, 4, 5, 1, 2 };
        index = obj.canCompleteCircuit(gas1, cost1);
        System.out.println(index);

        int[] gas2 = { 3 }, cost2 = { 2 };
        index = obj.canCompleteCircuit(gas2, cost2);
        System.out.println(index);
    }

}
