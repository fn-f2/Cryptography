import java.util.Scanner;

public class CaesarCipher
{
    Scanner in = new Scanner(System.in);
    
    public static void main(String[] args)
    {
        System.out.println(decode(encode("ABCDEZ.WOWOWOW", 1), 1));
    }
    
    public static String encode(String plainText, int key)
    {
        String outp = "";
        
        for (int i = 0; i < plainText.length(); i++)
        {
            char originalChar = plainText.charAt(i);
            char newChar = (char) (((originalChar - 65) + key) % 26 + 65);
            
            if (Character.isLetter(plainText.charAt(i))) outp += newChar;
            else outp += originalChar;
        }
        
        return outp;
    }
    
    public static String decode(String plainText, int key)
    {
        String outp = "";
        
        for (int i = 0; i < plainText.length(); i++)
        {
            char originalChar = plainText.charAt(i);
            char newChar = (char) (((originalChar - 65) + 26 - key) % 26 + 65);
            
            if (Character.isLetter(plainText.charAt(i))) outp += newChar;
            else outp += originalChar;
        }
        
        return outp;
    }
}


