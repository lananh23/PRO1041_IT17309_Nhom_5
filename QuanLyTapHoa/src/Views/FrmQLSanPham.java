package Views;

import Services.IManageLoaiSanPhamService;
import Services.IManageSanPhamService;
import ServiceImpl.ManageLoaiSanPhamService;
import ServiceImpl.ManageSanPhamService;
import ViewModels.QLLoaiSanPham;
import ViewModels.QLSanPham;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmQLSanPham extends javax.swing.JFrame implements Runnable, ThreadFactory {

    private IManageSanPhamService sanPhamService;
    private IManageLoaiSanPhamService loaiSanPhamService;
    private Webcam webcam = null;
    private WebcamPanel panel = null;
    private Executor executor = Executors.newSingleThreadExecutor(this);

    public FrmQLSanPham() {
        initComponents();
        initwebcam();
        this.sanPhamService = new ManageSanPhamService();
        this.loaiSanPhamService = new ManageLoaiSanPhamService();
        List<QLLoaiSanPham> dsLSP = loaiSanPhamService.ALL();
        this.cboMaLSP.getModel();
        String[] sp = new String[dsLSP.size()];
        for (int i = 0; i < dsLSP.size(); i++) {
            sp[i] = dsLSP.get(i).getMaLSP();
        }
        cboMaLSP.setModel(new DefaultComboBoxModel(sp));

        cboLocTheoMaLoaiSanPham.setModel(new DefaultComboBoxModel(sp));
        List<QLSanPham> dsSPl = sanPhamService.ALL();
        this.cboLocTheoMaLoaiSanPham.getModel();
        String[] spl = new String[dsSPl.size()];
        for (int i = 0; i < dsSPl.size(); i++) {
            spl[i] = dsSPl.get(i).getMaSP();
        }
        cboLocTheoMaLoaiSanPham.setModel(new DefaultComboBoxModel(spl));
        this.loadTable();
    }

    /*public static void closeCam() {
        if (webcam == null) {
            return;
        }
        webcam.close();
    }*/
    public void loadTable() {
        DefaultTableModel dtm = (DefaultTableModel) this.tbl_SP.getModel();
        dtm.setRowCount(0);
        for (QLSanPham sp : this.sanPhamService.ALL()) {
            Object[] rowData = {
                sp.getMaSP(),
                sp.getMaLSP(),
                sp.getTenSP(),
                sp.getSoLuong(),
                sp.getGiaNhap(),
                sp.getGiaBan(),
                sp.getHanSuDung(),};
            dtm.addRow(rowData);
        }
    }

    public void clearForm() {
        this.txtMaSP.setText("");
        this.cboMaLSP.setSelectedIndex(0);
        this.txtTenSP.setText("");
        this.txtSoluong.setText("");
        this.txtGiaNhap.setText("");
        this.txtGiaBan.setText("");
        this.txtHanSuDung.setText("");
    }

    public static Date toDate(String s) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("yyyy-mm-dd");
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
        String maLSP = (String) this.cboMaLSP.getSelectedItem();
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
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("yyyy-mm-dd");
        Date d;
        try {
            d = sdf.parse(hanSuDung);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Sai định dạng ngày sinh");
            return null;
        }
        String maQR = this.result_field.getText().trim();

        QLSanPham s = new QLSanPham(maSP, maLSP, tenSP, soLuong, giaNhap, giaBan, d, maQR);
        return s;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
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
        txtTenSP = new javax.swing.JTextField();
        txtSoluong = new javax.swing.JTextField();
        txtGiaBan = new javax.swing.JTextField();
        txtHanSuDung = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cboLocTheoMaLoaiSanPham = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtGiaNhap = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        result_field = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel49.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel49.setText("Quản lý sản phẩm");

        jLabel21.setText("Mã SP");

        jLabel50.setText("Mã LSP");

        jLabel52.setText("Tên SP");

        jLabel54.setText("Số lượng SP");

        jLabel56.setText("Giá bán");

        jLabel57.setText("Hạn sử dụng");

        btnThem.setText("Thêm ");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnTim.setText("Tìm kiếm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        btnSua.setText("Cập nhật");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        tbl_SP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Mã LSP", "Tên SP", "Số lượng", "Giá Nhập", "Giá bán", "Hạn sử dụng"
            }
        ));
        tbl_SP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_SPMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tbl_SP);

        cboMaLSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtHanSuDung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHanSuDungActionPerformed(evt);
            }
        });

        jLabel1.setText("Lọc:");

        cboLocTheoMaLoaiSanPham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboLocTheoMaLoaiSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLocTheoMaLoaiSanPhamActionPerformed(evt);
            }
        });

        jLabel3.setText("Giá nhập");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 337, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 231, Short.MAX_VALUE)
        );

        jLabel4.setText("RESULT");

        jButton1.setText("Mã QR");

        btnHuy.setText("Hủy");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(283, 283, 283)
                        .addComponent(jLabel49))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel50)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel52))
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
                                .addComponent(btnTim)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboLocTheoMaLoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTenSP, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtMaSP)
                                    .addComponent(cboMaLSP, 0, 165, Short.MAX_VALUE))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addGap(127, 127, 127)
                                        .addComponent(jLabel57))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(135, 135, 135)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel54)
                                            .addComponent(jLabel56)
                                            .addComponent(jLabel3))))
                                .addGap(45, 45, 45)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtSoluong)
                                    .addComponent(txtGiaBan)
                                    .addComponent(txtHanSuDung, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                                    .addComponent(txtGiaNhap, javax.swing.GroupLayout.Alignment.TRAILING))))))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jButton1)
                        .addGap(66, 66, 66)
                        .addComponent(btnHuy)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(result_field, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(23, 23, 23))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel49)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel54)
                            .addComponent(txtSoluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel50)
                            .addComponent(cboMaLSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel56, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel57)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel52)
                                .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtHanSuDung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(result_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnTim)
                            .addComponent(btnXoa)
                            .addComponent(btnSua)
                            .addComponent(btnThem)
                            .addComponent(jLabel1)
                            .addComponent(cboLocTheoMaLoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)
                            .addComponent(btnHuy))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1101, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 6, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 7, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 546, Short.MAX_VALUE)
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
        QLSanPham sp = this.getFormData();
        if (sp == null) {
            return;
        }
        this.sanPhamService.insert(sp);
        this.loadTable();
        this.clearForm();
        JOptionPane.showMessageDialog(this, "thêm thành công");
    }//GEN-LAST:event_btnThemActionPerformed

    private void tbl_SPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_SPMouseClicked
        int row = this.tbl_SP.getSelectedRow();
        if (row == -1) {
            return;
        }
        String maSP = this.tbl_SP.getValueAt(row, 0).toString();
        String maLSP = this.tbl_SP.getValueAt(row, 1).toString();
        String tenSP = this.tbl_SP.getValueAt(row, 2).toString();
        String soLuong = this.tbl_SP.getValueAt(row, 3).toString();
        String giaNhap = this.tbl_SP.getValueAt(row, 4).toString();
        String giaBan = this.tbl_SP.getValueAt(row, 5).toString();
        String hanSuDung = this.tbl_SP.getValueAt(row, 6).toString();

        this.txtMaSP.setText(maSP);
        this.cboMaLSP.setSelectedItem(maLSP);
        this.txtTenSP.setText(tenSP);
        this.txtSoluong.setText(soLuong);
        this.txtGiaNhap.setText(giaNhap);
        this.txtGiaBan.setText(giaBan);
        this.txtHanSuDung.setText(hanSuDung);
    }//GEN-LAST:event_tbl_SPMouseClicked

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        QLSanPham sp = this.getFormData();
        if (sp == null) {
            return;
        }
        String maSP = this.txtMaSP.getText();
        this.sanPhamService.update(maSP, sp);
        this.loadTable();
        this.clearForm();
        JOptionPane.showMessageDialog(this, "Cập nhật thành công");
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int row = this.tbl_SP.getSelectedRow();
        if (row == -1) {
            return;
        }
        int cofirm = JOptionPane.showConfirmDialog(this, "bạn muốn xóa không");
        if (cofirm != JOptionPane.YES_OPTION) {
            return;
        }
        String id = this.tbl_SP.getValueAt(row, 0).toString();
        this.sanPhamService.delete(id);
        this.loadTable();
        this.clearForm();
        JOptionPane.showMessageDialog(this, "Xóa thành công");
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        String maSP = this.txtMaSP.getText();
        List<QLSanPham> ds = this.sanPhamService.ALL();
        int check = 0;
        if (maSP.trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "Không được để trống mã sản phẩm");
            return;
        } else {
            for (QLSanPham sp : ds) {
                if (sp.getMaSP().equalsIgnoreCase(txtMaSP.getText())) {
                    check++;
                    this.txtMaSP.setText(sp.getMaSP());
                    this.cboMaLSP.setSelectedItem(sp.getMaLSP());
                    this.txtTenSP.setText(sp.getTenSP());
                    this.txtSoluong.setText(String.valueOf(sp.getSoLuong()));
                    this.txtGiaNhap.setText(String.valueOf(sp.getGiaNhap()));
                    this.txtGiaBan.setText(String.valueOf(sp.getGiaBan()));
                    this.txtHanSuDung.setText(String.valueOf(sp.getHanSuDung()));

                    JOptionPane.showMessageDialog(this, "Tìm thấy sản phẩm");
                    //this.tblSPL.getSelectedRow();
                    return;
                }
            }
        }
        if (check == 0) {
            this.clearForm();
            JOptionPane.showMessageDialog(this, "Không tìm thấy sản phẩm");

        }

    }//GEN-LAST:event_btnTimActionPerformed

    private void cboLocTheoMaLoaiSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboLocTheoMaLoaiSanPhamActionPerformed

        String ma = (String) this.cboLocTheoMaLoaiSanPham.getSelectedItem();
        List<QLSanPham> ds = this.sanPhamService.ALL();
        int check = 0;
        DefaultTableModel dtm = (DefaultTableModel) this.tbl_SP.getModel();
        dtm.setRowCount(0);
        for (QLSanPham sp : ds) {
            if (sp.getMaSP().equalsIgnoreCase(ma)) {
                check++;
                Object[] rowData = {
                    sp.getMaSP(),
                    sp.getMaLSP(),
                    sp.getTenSP(),
                    sp.getSoLuong(),
                    sp.getGiaNhap(),
                    sp.getGiaBan(),
                    sp.getHanSuDung()
                };
                dtm.addRow(rowData);
            }
        }
        if (check == 0) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy sản phẩm");
            return;
        } else {
            JOptionPane.showMessageDialog(this, "Tìm thấy sản phẩm");
            return;
        }
    }//GEN-LAST:event_cboLocTheoMaLoaiSanPhamActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        /*if (webcam == null) {
            return;
        }
        webcam.close();
        this.dispose();*/
    }//GEN-LAST:event_btnHuyActionPerformed

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

    private void initwebcam() {
        Dimension size = WebcamResolution.QQVGA.getSize();
        webcam = Webcam.getWebcams().get(0);
        webcam.setViewSize(size);
        panel = new WebcamPanel(webcam);
        panel.setPreferredSize(size);
        panel.setFPSDisplayed(true);

        jPanel4.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 300));
        executor.execute(this);

    }

    @Override
    public void run() {
        do {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }
            Result result = null;
            BufferedImage image = null;
            if (webcam.isOpen()) {
                if ((image = webcam.getImage()) == null) {
                    continue;
                }
            }
            LuminanceSource soure = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(soure));
            try {
                result = new MultiFormatReader().decode(bitmap);
            } catch (Exception e) {
            }
            if (result != null) {
                result_field.setText(result.getText());
            }

        } while (true);
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "My Thread");
        t.setDaemon(true);
        return t;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cboLocTheoMaLoaiSanPham;
    private javax.swing.JComboBox<String> cboMaLSP;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextField result_field;
    private javax.swing.JTable tbl_SP;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtGiaNhap;
    private javax.swing.JTextField txtHanSuDung;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtSoluong;
    private javax.swing.JTextField txtTenSP;
    // End of variables declaration//GEN-END:variables

}
