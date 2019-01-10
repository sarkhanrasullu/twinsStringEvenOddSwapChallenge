import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Tester {
	
    /**
     * Complete the function below.
     * DO NOT MODIFY anything outside this method. 
     */
    static boolean[] twins(String[] a, String[] b) {
        boolean flag = false;
        int a_len = a.length;
        int b_len = b.length;

        if (a_len != b_len) {
            throw new IllegalArgumentException("array index count mismatched!");
        }
        boolean[] result = new boolean[a.length];
        for (int i = 0; i < a_len; i++) {
            String a_val = a[i];
            String b_val = b[i];
            char[] a_val_arr = a_val.toCharArray();
            char[] b_val_arr = b_val.toCharArray();

            flag = false;
            for (int key = 0; key < a_val_arr.length; key++) {
                char val = a_val_arr[key];
                int b_key = -1;
                for (int bKeyIndex = 0; bKeyIndex < b_val_arr.length; bKeyIndex++) {
                    char bb = b_val_arr[bKeyIndex];
                    if (bb == val) {
                        b_key = bKeyIndex;
                        break;
                    }
                }

                if ((key % 2 == 0 && b_key % 2 == 0) || (key % 2 != 0 && b_key % 2 != 0)) {
                    flag = true;
                } else if ((key % 2 == 0 && b_key % 2 != 0) || (key % 2 != 0 && b_key % 2 == 0)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result[i] = true;
            } else {
                result[i] = false;
            }
            if (a_val_arr.length != b_val_arr.length) {
                result[i] = false;
            }
        }
        return result;
    }

    /**
     * DO NOT MODIFY THIS METHOD!
     */
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        
        int n = Integer.parseInt(in.nextLine().trim());
        String[] a = new String[n];
        for(int i = 0; i < n; i++) {
            a[i] = in.nextLine();
        }
        
        int m = Integer.parseInt(in.nextLine().trim());
        String[] b = new String[m];
        for(int i = 0; i < m; i++) {
            b[i] = in.nextLine();
        }
        
        // call twins function
        boolean[] results = twins(a, b);
        
        for(int i = 0; i < results.length; i++) {
            System.out.println(results[i]? "Yes" : "No");
        }
    }
}