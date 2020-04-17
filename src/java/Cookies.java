
import javax.servlet.http.Cookie;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RoshDaboss
 */
public class Cookies {
static Cookie cook[] = new Cookie[9999];
static int ccount = 0;
    Cookies(){
        
    }
    public static void inputC(Cookie cooks){
        cook[ccount] = cooks;
        ccount++;
    }
    public static Cookie getC(int index){
        if(index<ccount){
            return cook[index];
        }
        else{
            return cook[0];
        }
    }
    public static void printC(){
        for(int i =0;i<ccount;i++){
            System.out.println(cook[i]);
        }
    }
    
}
