public class Teste {

    public String getSwappedString(String s)
    {
        char[] ac = s.toCharArray();
        for(int i = 0; i < s.length(); i++)
        {
            if(ac[i] == 'H')
                ac[i] = 'W';
            else if(ac[i] == 'W')
                ac[i] = 'H'; 
        }
        
        s = new String(ac);
        return s;
    }
}