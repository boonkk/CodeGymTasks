package com.codegym.task.task36.task3611;

import java.util.HashSet;
import java.util.Set;

/* 
How many potential friends does a person have?

*/

public class Solution {
    private boolean[][] humanRelationships;

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.humanRelationships = generateRelationships();

        Set<Integer> allFriendsAndPotentialFriends = solution.getAllFriendsAndPotentialFriends(4, 2);
        System.out.println(allFriendsAndPotentialFriends);                              // Expected: [0, 1, 2, 3, 5, 7]
        Set<Integer> potentialFriends = solution.removeFriendsFromSet(allFriendsAndPotentialFriends, 4);
        System.out.println(potentialFriends);                                           // Expected: [2, 5, 7]
    }

    public Set<Integer> getAllFriendsAndPotentialFriends(int index, int deep) {
        HashSet<Integer> result = new HashSet<>();
        int i=index;
        int j=0;

        while(true) {
            if(i<=humanRelationships.length-1) {
                //System.out.println();
                if(humanRelationships[i][j]) {
                    if( i > index )
                        result.add(i);
                    if( j < index )
                        result.add(j);
                }
            }
            else break;

            if(j<index) {
                j++;
            } else if(j>=index && i<=humanRelationships.length-1) {
                i++;
            }
        }

        if (deep==1) {
            return result;
        } else {
            HashSet<Integer> tempSet = (HashSet) result.clone();

            for(int indexx : result) {
                tempSet.addAll(getAllFriendsAndPotentialFriends(indexx, deep - 1));
            }

            result.addAll(tempSet);
            result.remove(index);
            return result;
        }
    }

    // Remove from the set the people with whom you already have a relationship
    public Set<Integer> removeFriendsFromSet(Set<Integer> set, int index) {
        for (int i = 0; i < humanRelationships.length; i++) {
            if ((i < index) && (index < humanRelationships.length) && humanRelationships[index][i]) {
                set.remove(i);
            } else if ((i > index) && humanRelationships[i][index]) {
                set.remove(i);
            }
        }
        return set;
    }

    // Return test data
    private static boolean[][] generateRelationships() {
        return new boolean[][]{
                {true},                                                                 //0
                {true, true},                                                           //1
                {false, true, true},                                                    //2
                {false, false, false, true},                                            //3
                {true, true, false, true, true},                                        //4
                {true, false, true, false, false, true},                                //5
                {false, false, false, false, false, true, true},                        //6
                {false, false, false, true, false, false, false, true}                  //7
        };
    }
}