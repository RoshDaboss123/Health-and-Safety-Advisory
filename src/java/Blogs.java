/**
 *
 * @author RoshDaboss
 */
public class Blogs {
static String[][] conversations = new String[100][100000];
    Blogs(){
    }
    public void inputConversation(int zipCode,String Convo){
        for(int i =0;i<100;i++){
            if(conversations[i][zipCode]==null){
                String s = Convo;
                conversations[i][zipCode] = s;        
                break;
            }
        }
    }
    
    
    public String [] getConversation(int zipCode){
        String[]conversation = new String[100];
        int ccount = 0;
        for(int i =0;i<100;i++){
            if(conversations[i][zipCode] != null){
                conversation[ccount] = conversations[i][zipCode];
                ccount++;
            }
        }
        return conversation;
    }
}
