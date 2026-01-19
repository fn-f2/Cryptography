public class CaesarCipher
{    
    public static void main(String[] args)
    {
        System.out.println(encode("I'm super cool", 1));
        System.out.println(decode(encode("I'm super cool", 1), 1));
    }
    
    public static String encode(String plainText, int key)
    {
        String outp = "";
        
        for (int i = 0; i < plainText.length(); i++) //iterate through input text
        {
            char originalChar = plainText.charAt(i);
            
            int lower = 0;
            if (Character.isLowerCase(originalChar)) lower = 32; //set case
            
            char newChar = (char) (((originalChar - 65 - lower) + key) % 26 + 65 + lower); //calc new char, offset by case
            
            if (Character.isLetter(originalChar)) outp += newChar; //add new char to output string if char is letter
            else outp += originalChar; //keep original char if symbol
        }
        
        return outp;
    }
    
    public static String decode(String plainText, int key)
    {
        String outp = "";
        
        for (int i = 0; i < plainText.length(); i++)
        {
            char originalChar = plainText.charAt(i);
            
            int lower = 0;
            if (Character.isLowerCase(originalChar)) lower = 32;
            char newChar = (char) (((originalChar - 65 - lower) + 26 - key) % 26 + 65 + lower);
            
            if (Character.isLetter(originalChar)) outp += newChar;
            else outp += originalChar;
        }
        
        return outp;
    }
}


