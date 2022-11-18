package Views;

import Services.IManageSanPhamService;
import ServiceImpl.ManageSanPhamService;
import ViewModels.QLSanPham;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmQLSanPham extends javax.swing.JFrame {

    private IManageSanPhamService sanPhamService;

    public FrmQLSanPham() {
        initComponents();
        this.sanPhamService = new ManageSanPhamService();
        
//        List<QLSanPham> dsSP = sanPhamService.ALL();
//        this.cboMaLSP.getModel();
//        String[] sp = new String[dsSP.size()];
//        for (int i = 0; i < dsSP.size(); i++) {
//            sp[i] = dsSP.get(i).getIdLSP();
//        }
//        cboMaLSP.setModel(new DefaultComboBoxModel(sp));
//        List<QLSanPham> dsNPP = sanPhamService.ALL();
//        this.cboMaNPP.getModel();
//        String[] npp = new String[dsNPP.size()];
//        for (int j = 0; j < dsNPP.size(); j++) {
//            npp[j] = dsSP.get(j).getIdNPP();
//        }
//        cboMaNPP.setModel(new DefaultComboBoxModel(npp));
        
        this.loadTable();
    }

    public void loadTable() {
        DefaultTableModel dtm = (DefaultTableModel) this.tbl_SP.getModel();
        dtm.setRowCount(0);
        for (QLSanPham sp : this.sanPhamService.ALL()) {
            Object[] rowData = {
                sp.getMaSP(),
                sp.getIdLSP(),
                sp.getIdNPP(),
                sp.getTenSP(),
                sp.getSoLuong(),
                sp.getGiaNhap(),
                sp.getGiaBan(),
                sp.getHanSuDung(),
                sp.getMoTa()
            };
            dtm.addRow(rowData);
        }
    }

    public void clearForm() {

    }

    public static Date toDate(String s) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("dd/MM/yyyy");
        Date d = null;
        try {
            d = sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
            throw e;
        }
        return d;
    }

    private QLSanPham getFormData() {
        String maSP = this.txtMaSP.getText().trim();
        String idLSP = (String) this.cboMaLSP.getSelectedItem();
        String idNPP = (String) this.cboMaNPP.getSelectedItem();
        String tenSP = this.txtTenSP.getText().trim();
        String soLuongStr = this.txtSoluong.getText().trim();
        int soLuong;
        try {
            soLuong = Integer.parseInt(soLuongStr);
            if (soLuong < 0) {
                JOptionPane.showMessageDialog(this, "So luong khong duoc am");
                return null;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "So luong phai la so");
            return null;
        }
        String giaNhapStr = this.txtGiaNhap.getText().trim();
        float giaNhap;
        try {
            giaNhap = Float.parseFloat(giaNhapStr);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Sai dinh dang cua gia nhap");
            return null;
        }
        String giaBanStr = this.txtGiaBan.getText().trim();
        float giaBan;
        try {
            giaBan = Float.parseFloat(giaBanStr);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Sai dinh dang gia ban");
            return null;
        }
        String hanSuDung = this.txtHanSuDung.getText().trim();
        Date d;
        try {
            d = toDate(hanSuDung);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Sai định dạng ngày sinh");
            return null;
        }
        String moTa = this.txtMota.getText().trim();

        QLSanPham s = new QLSanPham(maSP, idLSP, idNPP, tenSP, soLuong, giaNhap, giaBan, d, moTa);
        return s;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnTim = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbl_SP = new javax.swing.JTable();
        txtMaSP = new javax.swing.JTextField();
        cboMaLSP = new javax.swing.JComboBox<>();
        cboMaNPP = new javax.swing.JComboBox<>();
        txtTenSP = new javax.swing.JTextField();
        jScrollPane10 = new javax.swing.JScrollPane();
        txtMota = new javax.swing.JTextArea();
        txtSoluong = new javax.swing.JTextField();
        txtGiaNhap = new javax.swing.JTextField();
        txtGiaBan = new javax.swing.JTextField();
        txtHanSuDung = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel49.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel49.setText("Quản lý sản phẩm");

        jLabel21.setText("Mã SP");

        jLabel50.setText("Mã LSP");

        jLabel51.setText("Mã NPP");

        jLabel52.setText("Tên SP");

        jLabel53.setText("Mô tả");

        jLabel54.setText("Số lượng SP");

        jLabel55.setText("Giá nhập");

        jLabel56.setText("Giá bán");

        jLabel57.setText("Hạn sử dụng");

        btnThem.setText("Thêm ");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");

        btnTim.setText("Tìm kiếm");

        btnSua.setText("Cập nhật");

        tbl_SP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Mã LSP", "Mã NPP", "Tên SP", "Số lượng", "Giá nhập", "Giá bán", "Hạn sử dụng", "Mô tả"
            }
        ));
        tbl_SP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_SPMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tbl_SP);

        cboMaLSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboMaNPP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtMota.setColumns(20);
        txtMota.setRows(5);
        jScrollPane10.setViewportView(txtMota);

        txtHanSuDung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHanSuDungActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(283, 283, 283)
                        .addComponent(jLabel49))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel50)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel51)
                                    .addComponent(jLabel52)
                                    .addComponent(jLabel53))
                                .addGap(94, 94, 94))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnThem)
                                .addGap(34, 34, 34)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(btnSua)
                                .addGap(56, 56, 56)
                                .addComponent(btnXoa)
                                .addGap(61, 61, 61)
                                .addComponent(btnTim))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(txtTenSP, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtMaSP)
                                    .addComponent(cboMaLSP, 0, 165, Short.MAX_VALUE)
                                    .addComponent(cboMaNPP, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(135, 135, 135)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel54)
                                            .addComponent(jLabel55)
                                            .addComponent(jLabel56)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addGap(127, 127, 127)
                                        .addComponent(jLabel57)))
                                .addGap(45, 45, 45)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtSoluong)
                                    .addComponent(txtGiaNhap)
                                    .addComponent(txtGiaBan)
                                    .addComponent(txtHanSuDung, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))))))
                .addContainerGap(378, Short.MAX_VALUE))
            .addComponent(jScrollPane6)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel49)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel54, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel21)
                        .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSoluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(jLabel55)
                    .addComponent(cboMaLSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel56, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel51)
                        .addComponent(cboMaNPP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel57)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel52)
                            .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtHanSuDung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel53)
                        .addGap(192, 273, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnTim)
                                    .addComponent(btnXoa)
                                    .addComponent(btnSua)
                                    .addComponent(btnThem))
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1083, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 497, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtHanSuDungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHanSuDungActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHanSuDungActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemActionPerformed

    private void tbl_SPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_SPMouseClicked
        int row = this.tbl_SP.getSelectedRow();
        if (row == -1) {
            return;
        }
        String maSP = this.tbl_SP.getValueAt(row, 0).toString();
        String idLSP = this.tbl_SP.getValueAt(row, 1).toString();
        String idNPP = this.tbl_SP.getValueAt(row, 2).toString();
        String tenSP = this.tbl_SP.getValueAt(row, 3).toString();
        String soLuong = this.tbl_SP.getValueAt(row, 4).toString();
        String giaNhap = this.tbl_SP.getValueAt(row, 5).toString();
        String giaBan = this.tbl_SP.getValueAt(row, 6).toString();
        String hanSuDung = this.tbl_SP.getValueAt(row, 7).toString();
        String moTa = this.tbl_SP.getValueAt(row, 8).toString();

        this.txtMaSP.setText(maSP);
        this.cboMaLSP.setSelectedItem(idLSP);
        this.cboMaNPP.setSelectedItem(maSP);
        this.txtTenSP.setText(tenSP);
        this.txtSoluong.setText(soLuong);
        this.txtGiaNhap.setText(giaNhap);
        this.txtGiaBan.setText(giaBan);
        this.txtHanSuDung.setText(hanSuDung);
        this.txtMota.setText(moTa);
    }//GEN-LAST:event_tbl_SPMouseClicked

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
            java.util.logging.Logger.getLogger(FrmQLSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmQLSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmQLSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmQLSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmQLSanPham().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cboMaLSP;
    private javax.swing.JComboBox<String> cboMaNPP;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable tbl_SP;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtGiaNhap;
    private javax.swing.JTextField txtHanSuDung;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextArea txtMota;
    private javax.swing.JTextField txtSoluong;
    private javax.swing.JTextField txtTenSP;
    // End of variables declaration//GEN-END:variables
}
