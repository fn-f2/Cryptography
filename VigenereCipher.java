public class VigenereCipher
{    
    public static void main(String[] args)
    {
        System.out.println("encoded: " + encode("Attack at dawn!!!!", "lEmOn"));
        System.out.println("decoded: " + decode(encode("Attack at dawn!!!!", "LEMON"), "lemon"));
    }
    
    public static String encode(String plainText, String keyword)
    {
        String outp = "";

        int nonLs = 0;
        
        for (int i = 0; i < plainText.length(); i++)
        {
            char originalChar = plainText.charAt(i);
            
            int keyCharInt = (int) Character.toLowerCase(keyword.charAt((i-nonLs)%keyword.length()))-97;
            if (!Character.isLetter(originalChar)) nonLs++;
            
            int lower = 0;
            if (Character.isLowerCase(originalChar)) lower = 32;
            
            char newChar = (char) (((originalChar - 65 - lower) + keyCharInt) % 26 + 65 + lower);
            
            if (Character.isLetter(originalChar)) outp += newChar;
            else outp += originalChar;
        }
        
        return outp;
    }
    public static String decode(String plainText, String keyword)
    {
        String outp = "";
                    
        int nonLs = 0;
            
        for (int i = 0; i < plainText.length(); i++)
        {
            char originalChar = plainText.charAt(i);
            
            int keyCharInt = (int) keyword.charAt((i-nonLs)%keyword.length())-97;
            if (!Character.isLetter(originalChar)) nonLs++;
            
            int lower = 0;
            if (Character.isLowerCase(originalChar)) lower = 32;
            
            char newChar = (char) (((originalChar - 65 - lower) + 26 - keyCharInt) % 26 + 65 + lower);
            
            if (Character.isLetter(originalChar)) outp += newChar;
            else outp += originalChar;
        }
        
        return outp;
    }
}


