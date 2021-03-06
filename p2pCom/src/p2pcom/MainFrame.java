/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2pcom;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cmglz
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        //开启接收消息线程
        new Thread(new Runnable(){
            @Override
            public void run() {
                while(true){
                    List<String> res=ComTool.receMessage();
                    if(null!=res){
                        try {
                            //数据校验
                            String receMessage_tmp=
                                    new String(RSAEncrypt.decrypt(RSAEncrypt.loadPrivateKeyByStr(Config.rece_r), Base64.decode(res.get(1))));
                            String receMessage=
                                    new String(RSAEncrypt.decrypt(RSAEncrypt.loadPublicKeyByStr(Config.rece_p), Base64.decode(receMessage_tmp)));
                            
                            //test
                            //System.out.println("result:"+receMessage);
                            //显示接收到的数据
                            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            area_message.append(res.get(0)+"  ("+sdf.format(new Date())+") :\n"
                                    +receMessage+"\n"
                                            +"=======================================================\n");
                        } catch (Exception ex) {
                            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
            
        }).start();
        //刷新ip
        label_ipaddress.setText(IpTool.getLocalIp());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        label_ipaddress = new javax.swing.JLabel();
        btn_refresh = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        text_ipaddress = new javax.swing.JTextField();
        label_state = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        area_message = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        area_send = new javax.swing.JTextArea();
        btn_send = new javax.swing.JButton();
        btn_reset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("您的IP:");

        label_ipaddress.setText("获取失败");

        btn_refresh.setText("刷新");
        btn_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshActionPerformed(evt);
            }
        });

        jLabel2.setText("目标IP:");

        text_ipaddress.setText("127.0.0.1");

        label_state.setText("创建完毕");

        area_message.setEditable(false);
        area_message.setColumns(20);
        area_message.setLineWrap(true);
        area_message.setRows(5);
        jScrollPane1.setViewportView(area_message);

        area_send.setColumns(20);
        area_send.setLineWrap(true);
        area_send.setRows(5);
        jScrollPane2.setViewportView(area_send);

        btn_send.setText("发送");
        btn_send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sendActionPerformed(evt);
            }
        });

        btn_reset.setText("重置");
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(text_ipaddress, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                    .addComponent(label_ipaddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(label_state, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btn_reset)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_send))
                            .addComponent(btn_refresh, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(label_ipaddress)
                    .addComponent(btn_refresh))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(text_ipaddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_state)
                    .addComponent(btn_send)
                    .addComponent(btn_reset))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed
        //刷新ip
        label_ipaddress.setText(IpTool.getLocalIp());
    }//GEN-LAST:event_btn_refreshActionPerformed

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        area_send.setText("");
    }//GEN-LAST:event_btn_resetActionPerformed

    private void btn_sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sendActionPerformed
        try {
            //检测发送内容是否为空
            if(area_send.getText().equals("")){
                label_state.setForeground(Color.red);
                label_state.setText("发送内容不能为空");
                return;
            }
            //检测ip地址是否正确
            if(!IpTool.isValidIP(text_ipaddress.getText())){
                label_state.setForeground(Color.red);
                label_state.setText("ip地址格式错误");
                return;
            }
            if(!IpTool.isPing(text_ipaddress.getText())){
                label_state.setForeground(Color.red);
                label_state.setText("ip地址无法访问");
                return;
            }
            
            //数据处理
            String sendMessage_tmp=
                    Base64.encode(RSAEncrypt.encrypt(RSAEncrypt.loadPrivateKeyByStr(Config.send_r), area_send.getText().getBytes()));
            String sendMessage=
                    Base64.encode(RSAEncrypt.encrypt(RSAEncrypt.loadPublicKeyByStr(Config.send_p),sendMessage_tmp.getBytes()));
            
            //test
            //System.out.println("result:"+sendMessage);
            
            //测试篡改
            //sendMessage=sendMessage.replace('a', 'b');
            
            //发送数据
            if(ComTool.sendMessage(sendMessage, text_ipaddress.getText())){
                area_send.setText("");
                label_state.setForeground(Color.green);
                label_state.setText("发送成功");
            }
            else{
                label_state.setForeground(Color.red);
                label_state.setText("发送失败");
            }
        } catch (Exception ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_sendActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea area_message;
    private javax.swing.JTextArea area_send;
    private javax.swing.JButton btn_refresh;
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_send;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label_ipaddress;
    private javax.swing.JLabel label_state;
    private javax.swing.JTextField text_ipaddress;
    // End of variables declaration//GEN-END:variables
}
