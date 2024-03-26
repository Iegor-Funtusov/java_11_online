package ua.com.alevel.print;

import org.apache.commons.lang3.StringUtils;

public class PrintMessage
{
    public void print(String msg)
    {
        System.out.println(msg);
        System.out.println(StringUtils.lowerCase(msg));
//        System.out.println(org.apache.commons.lang3.StringUtils.upperCase(msg));
    }
}
