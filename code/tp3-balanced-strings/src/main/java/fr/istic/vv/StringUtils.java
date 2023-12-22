package fr.istic.vv;

import java.util.ArrayList;
import java.util.List;

public class StringUtils {

    private StringUtils() {}

    public static boolean isBalanced(String str) {

        List<Character> list=new ArrayList<Character>();
        char stri[]=str.toCharArray();
        for(int i=0;i<stri.length;i++){
            if(stri[i]=='['||stri[i]=='('||stri[i]=='{'){
                list.add(stri[i]);
            }
            else if(stri[i]==']'||stri[i]=='}'||stri[i]==')'){
                if(list.size()==0)return false;
                if(stri[i]==']'){
                    if(list.get(list.size()-1)!='['){
                        return false;
                    }
                    else{
                        list.remove(list.size()-1);
                    }
                }
                else if(stri[i]==')'){
                    if(list.get(list.size()-1)!='('){
                        return false;
                    }
                    else{
                        list.remove(list.size()-1);
                    }
                }
                else if(stri[i]=='}'){
                    if(list.get(list.size()-1)!='{'){
                        return false;
                    }
                    else{
                        list.remove(list.size()-1);
                    }
                }
            }
        }
        if (list.size()==0) return true;
        else return false;
    }

}
