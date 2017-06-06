/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2pcom;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cmglz
 */
public class ComTool {
    //发送信息
    public static boolean sendMessage(String message,String targetIp){
        DatagramSocket sendSocket=null;
        try {
            sendSocket = new DatagramSocket(Config.sendPort);
            byte[] dataBuf = message.getBytes();
            DatagramPacket dataPack =   //数据打包  
            new DatagramPacket( dataBuf,  
                                dataBuf.length,  
                                InetAddress.getByName(targetIp), 
                                Config.receport //目标端口  
                          );  
        sendSocket.send(dataPack);  
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        finally{
            if(null!=sendSocket){
                sendSocket.close();
            }
        }
        return true;
    }
    
    //接收信息
    public static List<String> receMessage(){
        ArrayList<String> res=null;
        DatagramSocket receSocket=null;
        try {
            receSocket = new DatagramSocket(Config.receport);  //接收端
            
            byte[] dataBuf = new byte[1024];  
            DatagramPacket dataPack = new DatagramPacket(dataBuf,dataBuf.length);  
            receSocket.receive(dataPack);  //将获取的数据保存到指定的数据包  
            String ip = dataPack.getAddress().getHostAddress();  
            String data = new String(dataPack.getData(),0,dataPack.getLength());  
            
            res=new ArrayList<>();
            res.add(ip);
            res.add(data);
            
        } catch (Exception ex) {
            ex.printStackTrace();
            return res=null;
        }
        finally{
            if(null!=receSocket){
                receSocket.close();
            }
        }
        return res;
    }
}
