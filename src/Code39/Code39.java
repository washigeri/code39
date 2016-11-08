package Code39;


public class Code39 {
    static String mise_enforme_code39(String input){
        char c;
        char b=0;
        boolean flag = false;
        String temp = "*";
        int len = input.length();
        for(int i = 0; i<len; i++){
            c = input.charAt(i);
            int test = (int) c;
            if(test==32 || (test<=47 && test>=45) || test==36 || test==37 || test==43 || (test>=48 && test<=57 ) ){
                b = c;
                flag = true;
            }
            if ((test>=65 && test<=90) || (test>=97 && test<=122)){
                b = Character.toUpperCase(c);
                flag = true;
            }
            if (flag){
                temp += b;
                flag = false;
            }
        }
        temp+="*";
        return temp;

    }



    static char calcul_modulo43(String code39){
        String dict = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%";
        int res = 0;
        for(int i = 1; i < code39.length() - 1  ; i++){
            res += dict.indexOf(code39.charAt(i));
        }
        return dict.charAt(res%43);
    }

    private static String add_modulo(String code39){
        code39 += calcul_modulo43(code39);
        return code39;
    }


    static String set_code39(String input){
        input = Code39.mise_enforme_code39(input);
        input = Code39.add_modulo(input);
        return input;
    }



    public static void main(String[] args){
        String test = "abc";
        System.out.print(Code39.set_code39(test)+"\n");
        test = "**";
        System.out.print(Code39.set_code39(test));
    }


}
