//Team 4
// Author Jessica Smither

package HarryPotter;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.*;
import java.lang.Math;

//package HarryPotter;
/**
 *
 * @author jessicasmither
 */
public class Permutations {
    
    static int getNumber(ArrayList<Integer> v) {
        int n = v.size();
        int index = (int) (Math.random() * n);
        int number = v.get(index);
        v.set(index, v.get(n-1));
        v.remove(n-1);
        return number;
    }
    
    // generates a permutation of the first "n" intergers
    public static int[] generateRandom(int n) {
        int[] res = new int[n];
        ArrayList<Integer> v = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            v.add(i + 1);
        }
        
        int ct = 0;
        while(v.size() > 0) {
            res[ct] = getNumber(v);
            ct++;
        }
        
        for(int k = 0; k < res.length; k++){
            res[k]--;
        }
        return res;
    }
}


//Tutorial for Permutations in Java
//https://www.geeksforgeeks.org/generate-a-random-permutation-of-1-to-n/amp/

