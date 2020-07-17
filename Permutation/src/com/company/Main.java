package com.company;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static List<List<Integer>> toReturn = new ArrayList<List<Integer>>();
    static int flag = 1;
    public static void main(String[] args) {
	// write your code here
        permute(new int[]{1,2,3,4});
        for(int i=0;i<toReturn.size();i++)
        {
            System.out.print(i+" ");
            for(int j=0;j<toReturn.get(i).size();j++)
            {
                System.out.print(toReturn.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        if(nums.length == 0)
            return toReturn;
        List<Integer> available = new ArrayList<Integer>();
        List<Integer> used = new ArrayList<>();
        for(int i=0; i<nums.length;i++)
        {
            available.add(nums[i]);
        }
        computePermutations(available, used);

        return toReturn;
    }

    public static void computePermutations(List<Integer> available, List<Integer> used)
    {
        if(available.size() == 0)
        {
            List<Integer> listToAdd = new ArrayList<Integer>();
            for(int i=0; i<used.size();i++)
            {
                listToAdd.add(used.get(i));
            }
            toReturn.add(listToAdd);
            used.remove(used.size()-1);
            return;
        }
        List<Integer> listToPass = new ArrayList<Integer>();
        for(int j=0; j<available.size();j++)
        {
            listToPass.add(available.get(j));
        }
        flag = 0;
        for(int i =0; i<available.size(); i++)
        {
            if(flag == 1)
            {
                listToPass = new ArrayList<Integer>();
                for(int j=0; j<available.size();j++)
                {
                    listToPass.add(available.get(j));
                }
                flag = 0;
            }
            int toAdd = 0;
            toAdd = listToPass.remove(i);
            used.add(toAdd);
            List<Integer> newAvailable = new ArrayList<Integer>();
            for(int j=0; j<listToPass.size();j++)
            {
                newAvailable.add(listToPass.get(j));
            }

            computePermutations(newAvailable, used);

        }
        if(used.size()>0)
        {
            flag = 1;
            used.remove(used.size()-1);

        }
        return;
    }
}
