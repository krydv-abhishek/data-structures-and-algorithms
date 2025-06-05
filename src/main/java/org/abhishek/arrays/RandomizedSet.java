package org.abhishek.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

class RandomizedSet {

    private Map<Integer, Integer> positionValueMap;
    private List<Integer> valueList;
    private Random random;

    public RandomizedSet() {
        positionValueMap = new HashMap<>();
        valueList = new ArrayList<>();
        random = new Random();

    }

    public boolean insert(int val) {
        if (!positionValueMap.containsKey(val)) {
            int size = valueList.size();
            valueList.add(val);
            positionValueMap.put(val, size);

            return true;
        }
        return false;

    }

    public boolean remove(int val) {
        if (positionValueMap.containsKey(val)) {
            int indexToBeDeleted = positionValueMap.get(val);
            if (indexToBeDeleted < valueList.size() - 1) {
                valueList.set(indexToBeDeleted, valueList.get( valueList.size() - 1));
                valueList.remove( valueList.size() - 1);
                positionValueMap.remove(val);
                positionValueMap.put(valueList.get(indexToBeDeleted), indexToBeDeleted);
            } else {
                valueList.remove( valueList.size() - 1);
                positionValueMap.remove(val);
            }
            return true;
        }
        return false;

    }

    public int getRandom() {

        return valueList.get(random.nextInt(valueList.size()));

    }

    public static void main(String[] args) {

        RandomizedSet obj = new RandomizedSet();

        // insert
        boolean insertFlag = obj.insert(4);
        System.out.println(insertFlag);

        insertFlag = obj.insert(9);
        System.out.println(insertFlag);

        insertFlag = obj.insert(13);
        System.out.println(insertFlag);

        // should return false
        insertFlag = obj.insert(13);
        System.out.println(insertFlag);

        insertFlag = obj.insert(7);
        System.out.println(insertFlag);

        insertFlag = obj.insert(6);
        System.out.println(insertFlag);

        // remove
        boolean deleteFlag = obj.remove(4);
        System.out.println(deleteFlag);

        deleteFlag = obj.remove(9);
        System.out.println(deleteFlag);

        deleteFlag = obj.remove(13);
        System.out.println(deleteFlag);

        // should return false
        deleteFlag = obj.remove(13);
        System.out.println(deleteFlag);

        deleteFlag = obj.remove(6);
        System.out.println(deleteFlag);

        deleteFlag = obj.remove(7);
        System.out.println(deleteFlag);

        insertFlag = obj.insert(12);
        System.out.println(insertFlag);

        insertFlag = obj.insert(13);
        System.out.println(insertFlag);

        insertFlag = obj.insert(7);
        System.out.println(insertFlag);

        insertFlag = obj.insert(6);
        System.out.println(insertFlag);
        // getRandom

        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());

    }
}
