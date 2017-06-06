/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2pcom;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Cmglz
 */
public class IpTool {
    //获取本机ip
    public static String getLocalIp(){
        String str_ip_address="获取失败";
        try
        { 
//            str_ip_address=InetAddress.getLocalHost().toString();
            Enumeration allNetInterfaces = NetworkInterface.getNetworkInterfaces();
            InetAddress ip = null;
            while (allNetInterfaces.hasMoreElements())
            {
                NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
                System.out.println(netInterface.getName());
                Enumeration addresses = netInterface.getInetAddresses();
                while (addresses.hasMoreElements())
                {
                    ip = (InetAddress) addresses.nextElement();
                    if (ip != null && ip instanceof Inet4Address && !ip.isLoopbackAddress())
                    {
//                        System.out.println("本机的IP = " + ip.getHostAddress());
                        str_ip_address=ip.getHostAddress();
                    } 
                }
            }
        } catch (Exception e)
        { 
            str_ip_address="获取失败";
        }
        return str_ip_address;
    }
    
    //检测IP连通性
    public static boolean isPing(String ip)  
    {  
        boolean status = false;  
        if(ip != null)  
        {  
            try  
            {  
                status = InetAddress.getByName(ip).isReachable(Config.timeOut);  
            }  
            catch(Exception e)  
            {  
                  
            }  
        }  
         return status;  
    }  
    
    //检测ip地址格式是否正确
    public static boolean isValidIP(String ipAddress)   
    {   
        String ip = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}";    
        Pattern pattern = Pattern.compile(ip);    
        Matcher matcher = pattern.matcher(ipAddress);    
        return matcher.matches();    
    } 
}
