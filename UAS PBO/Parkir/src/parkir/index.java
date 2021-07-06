/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkir;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.Timer;
/**
 *
 * @author Firdaus Fieri Andrian Al Irsyads
 */

public class index extends javax.swing.JFrame {
    konfig konek = new konfig();
    public void tanggal(){
        Date ys = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
	tgl.setText(s.format(ys));
    }
    public void waktu(){
        ActionListener taskPerformer = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
        
                String nol_jam="", nol_menit="",nol_detik="";
                java.util.Date dateTime=new java.util.Date();
                int nilai_jam = dateTime.getHours();
                int nilai_menit = dateTime.getMinutes();
                int nilai_detik = dateTime.getSeconds();
        
                if (nilai_jam <=9) nol_jam="0";
                if (nilai_menit <=9) nol_menit="0";
                if (nilai_detik <=9) nol_detik="0";
        
                String jam = nol_jam + Integer.toString(nilai_jam);
                String menit = nol_menit + Integer.toString(nilai_menit);
                String detik = nol_detik + Integer.toString(nilai_detik);
        
                wkt.setText(jam + ":"+ menit + ":" + detik + "");
            }
    };
    new Timer(1000,taskPerformer).start();
    }
    private void tampil(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("No Pol");
        model.addColumn("Tanggal");
        model.addColumn("Jam Masuk");
        model.addColumn("Jam Keluar");
        model.addColumn("Biaya");
        model.addColumn("Jenis Kendaraan");
        
        try{
            
            String sql="SELECT * FROM parkir";
            java.sql.Connection conn=(Connection)konfig.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            
            while(res.next()){
                model.addRow(new Object[]{res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7)});
                
            }
            tabelparkir.setModel(model);
        }catch(SQLException e){
            System.out.println("Error : "+ e.getMessage());
        }
    }

    /**
     * Creates new form index
     */
    public index() {
        initComponents();
        tampil();
        tanggal();
        waktu();
     
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNoPol = new javax.swing.JTextField();
        cbjenis = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelparkir = new javax.swing.JTable();
        btnSimpan = new javax.swing.JButton();
        btKeluar = new javax.swing.JButton();
        btEdit = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();
        tgl = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        wkt = new javax.swing.JLabel();
        lblbiaya = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Parkir");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Sistem Parkir PT XYZ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 60, -1, -1));

        jLabel2.setText("Tanggal :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 117, 53, 25));

        jLabel3.setText("Jam :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, 46, -1));

        jLabel4.setText("No. Polisi");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 173, -1, -1));

        jLabel5.setText("Jenis Kendaraan");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 211, -1, -1));

        txtNoPol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNoPolActionPerformed(evt);
            }
        });
        getContentPane().add(txtNoPol, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 170, 116, -1));

        cbjenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Motor", "Mobil", "Truk" }));
        getContentPane().add(cbjenis, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 208, 116, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Biaya :");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Rp");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 208, -1, -1));

        tabelparkir.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabelparkir);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 335, 613, 99));

        btnSimpan.setText("Jam Masuk");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        getContentPane().add(btnSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 274, 93, -1));

        btKeluar.setText("Jam Keluar");
        btKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btKeluarActionPerformed(evt);
            }
        });
        getContentPane().add(btKeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 274, 93, -1));

        btEdit.setText("Edit");
        btEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditActionPerformed(evt);
            }
        });
        getContentPane().add(btEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 274, 92, -1));

        btDelete.setText("Delete");
        getContentPane().add(btDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(422, 274, 92, -1));

        tgl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(tgl, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 100, 20));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, -1, -1));

        wkt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(wkt, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, 80, 20));

        lblbiaya.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblbiaya, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 170, 110, 20));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNoPolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNoPolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNoPolActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        if (txtNoPol.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nomor polisi belum diisi!");
        } else if (cbjenis.getSelectedItem().equals("-Pilih Jenis Kendaraan-")) {
            JOptionPane.showMessageDialog(this, "Jenis kendaraan belum dipilih");
        } else {
            String nopol, tipe, sql;
            nopol = txtNoPol.getText();
            tipe = cbjenis.getSelectedItem().toString();

            sql = "INSERT INTO parkir(nopol,tipe,tanggal,jam_masuk)"
                    + "VALUES('"+nopol+"','"+tipe+"',CURDATE(),CURTIME())";
            try{
                konek.st = konek.conn.createStatement();
                konek.st.execute(sql);
            }
            catch (SQLException e){
                JOptionPane.showMessageDialog(this, "Data gagal disimpan"+e);
                return;
            }
            JOptionPane.showMessageDialog(this, "Data berhasil disimpan");
        }
        resetAll();
        tampil_masuk();
        tampil_keluar();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btEditActionPerformed

    private void btKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btKeluarActionPerformed
        // TODO add your handling code here:
        if(txtNoPol.getText().isEmpty())
            JOptionPane.showMessageDialog(this, "Data kosong!");
        else {
            int biaya = Integer.parseInt(lblbiaya.getText());
            String sql, id;
            
            
            sql = "UPDATE parkir SET tanggal=CURDATE(), jam_keluar=CURTIME(), biaya_parkir='"+biaya+"' "
                    + "WHERE id='""'";
                try{
                    konek.st = konek.conn.createStatement();
                    konek.st.execute(sql);
                }
                catch (SQLException e){
                    JOptionPane.showMessageDialog(this, "Data gagal disimpan"+e);
                    return;
                }
                JOptionPane.showMessageDialog(this, "Data berhasil diperbaharui");
            
            resetAll();
            tampil_masuk();
            tampil_keluar();
        }
    }//GEN-LAST:event_btKeluarActionPerformed

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
            java.util.logging.Logger.getLogger(index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new index().setVisible(true);
            }
        });
       
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btEdit;
    private javax.swing.JButton btKeluar;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JComboBox<String> cbjenis;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblbiaya;
    private javax.swing.JTable tabelparkir;
    private javax.swing.JLabel tgl;
    private javax.swing.JTextField txtNoPol;
    private javax.swing.JLabel wkt;
    // End of variables declaration//GEN-END:variables
}
