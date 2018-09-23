/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autopartstore;

public class priceCal {
    
    private double sum; 
    
    // test array
    double[] sub = {5, 5, 8, 9, 15, 12};
    
    /* database connection that pulls the prices of each 
    item in the cart and fills the array
    */

    public double pcal() {
        int i = 0;
        while (i < sub.length) {
            sum += sub[i];
            i++;
        }
        sum = sum + (sum * .07);
        return sum;
    }
    public static void main(String[] args) {
       double total;

        priceCal bb = new priceCal();
        total = bb.pcal();
        System.out.println("$"+total);
    }

}
