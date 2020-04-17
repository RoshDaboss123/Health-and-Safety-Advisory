/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RoshDaboss
 */
public class AccountInfo {
static String[]usernames = new String[9999];
static String[]passwords = new String[9999];
static int maxCount = 0;
    AccountInfo(){
    }
    public void input(String name,String pass){
        usernames[maxCount] = name;
        passwords[maxCount] = pass;
        maxCount++;
    }
    public String[] getUsername(){
        String[]user = new String[maxCount];
        for(int i =0;i<maxCount;i++){
            user[i] = usernames[i];
        }
        return user;
    }
    public String[] getPassword(){
        String[]pass = new String[maxCount];
        for(int i=0;i<maxCount;i++){
            pass[i] = passwords[i];
        }
        return pass;
    }
}
