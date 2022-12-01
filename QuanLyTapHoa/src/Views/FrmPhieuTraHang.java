/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import ServiceImpl.ManagePhieuTraHangCTService;
import ServiceImpl.ManagePhieuTraHangService;
import Services.IManagePhieuTraHangCTService;
import Services.IManagePhieuTraHangService;
import ViewModels.ManagePhieuTraHang;
import ViewModels.ManagePhieuTraHangCT;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lanan
 */
public class FrmPhieuTraHang extends javax.swing.JFrame {

    private IManagePhieuTraHangService traHangService;
    private IManagePhieuTraHangCTService traHangCTService;
    
    public FrmPhieuTraHang() {
        initComponents();
        this.traHangService = new ManagePhieuTraHangService();
        this.traHangCTService = new ManagePhieuTraHangCTService();
        this.setLocationRelativeTo(null);
        this.loadTableTH();
    }

    public void clearForm(){
        
    }
    public void loadTableTH() {
        DefaultTableModel dtm = (DefaultTableModel) this.tblTraHang.getModel();
        dtm.setRowCount(0);
        for (ManagePhieuTraHang sp : this.traHangService.ALL()) {
            Object[] rowData = {
                sp.getMaPTH(),
                sp.getMaHD(),
                sp.getMaND(),
                sp.getMaKH(),
                sp.getNgayTra(),
                sp.getTienTraLaiKhach(),
                sp.getLyDoTra()
            };
            dtm.addRow(rowData);
        }
    }
    public void loadTableCT() {
        DefaultTableModel dtm = (DefaultTableModel) this.tblTraHangCT.getModel();
        dtm.setRowCount(0);
        for (ManagePhieuTraHangCT sp : this.traHangCTService.ALL()) {
            Object[] rowData = {
                sp.getMaSP(),
                sp.getSoLuong(),
                sp.getDonGia(),
                sp.getSoLuong()
            };
            dtm.addRow(rowData);
        }
    }
    public void loadTableHD() {
        DefaultTableModel dtm = (DefaultTableModel) this.tblCTHD.getModel();
        dtm.setRowCount(0);
        for (ManagePhieuTraHangCT sp : this.traHangCTService.ALL()) {
            Object[] rowData = {
                sp.getMaSP(),
                sp.getSoLuong(),
                sp.getDonGia(),
                sp.getSoLuong()
            };
            dtm.addRow(rowData);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        PaneDS = new javax.swing.JTabbedPane();
        jPanel24 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblCTHD = new javax.swing.JTable();
        jPanel19 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        btnHoanTra = new javax.swing.JButton();
        lblMaKH = new javax.swing.JLabel();
        lblMaNV = new javax.swing.JLabel();
        lblMaHDct = new javax.swing.JLabel();
        rdoLoiSP = new javax.swing.JRadioButton();
        rdoMuaSai = new javax.swing.JRadioButton();
        lblTienTraLai = new javax.swing.JLabel();
        txtNgayTra = new javax.swing.JTextField();
        txtMaPhieuTra = new javax.swing.JTextField();
        jPanel18 = new javax.swing.JPanel();
        txtSoLuong = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        btnXoa = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnLuuTam = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable9 = new javax.swing.JTable();
        jLabel92 = new javax.swing.JLabel();
        lblMaHD = new javax.swing.JLabel();
        lblMaSP = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        txtMaHDTim = new javax.swing.JTextField();
        btnTimKiemMaHD = new javax.swing.JButton();
        jLabel77 = new javax.swing.JLabel();
        txtMaSPTim = new javax.swing.JTextField();
        btnTimMaSP = new javax.swing.JButton();
        jPanel25 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jTextField43 = new javax.swing.JTextField();
        jButton38 = new javax.swing.JButton();
        jScrollPane15 = new javax.swing.JScrollPane();
        tblTraHang = new javax.swing.JTable();
        jPanel26 = new javax.swing.JPanel();
        jLabel79 = new javax.swing.JLabel();
        jTextField44 = new javax.swing.JTextField();
        jButton39 = new javax.swing.JButton();
        jScrollPane18 = new javax.swing.JScrollPane();
        tblTraHangCT = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã HD", "Mã NV", "Mã KH", "Ngày tạo", "Tổng tiền", "Trạng thái"
            }
        ));
        jScrollPane7.setViewportView(jTable7);

        tblCTHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ));
        jScrollPane8.setViewportView(tblCTHD);

        jPanel19.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel30.setText("Mã phiếu trả");

        jLabel31.setText("Mã KH");

        jLabel32.setText("Mã NV");

        jLabel33.setText("Mã HD");

        jLabel34.setText("Ngày trả");

        jLabel35.setText("Tiền trả lại");

        jLabel36.setText("Lý do hoàn trả");

        btnHoanTra.setText("Hoàn trả");

        lblMaKH.setText("--");

        lblMaNV.setText("--");

        lblMaHDct.setText("--");

        buttonGroup1.add(rdoLoiSP);
        rdoLoiSP.setText("Sản phẩm lỗi");

        buttonGroup1.add(rdoMuaSai);
        rdoMuaSai.setText("Mua sai");

        lblTienTraLai.setText("--");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addGap(18, 18, 18)
                        .addComponent(rdoLoiSP)
                        .addGap(18, 18, 18)
                        .addComponent(rdoMuaSai))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30)
                            .addComponent(jLabel31)
                            .addComponent(jLabel32)
                            .addComponent(jLabel33)
                            .addComponent(jLabel34)
                            .addComponent(jLabel35))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTienTraLai, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMaHDct, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgayTra)
                            .addComponent(txtMaPhieuTra, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))))
                .addContainerGap(74, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnHoanTra)
                .addGap(147, 147, 147))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(txtMaPhieuTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(lblMaKH))
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(lblMaNV))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(lblMaHDct))
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(txtNgayTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(lblTienTraLai))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(rdoLoiSP)
                    .addComponent(rdoMuaSai))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnHoanTra)
                .addContainerGap())
        );

        jPanel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel28.setText("Mã SP");

        jLabel29.setText("Số lượng");

        btnXoa.setText("Xóa");

        btnCapNhat.setText("Cập nhật");

        btnLuuTam.setText("Lưu tạm");

        jTable9.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ));
        jScrollPane9.setViewportView(jTable9);

        jLabel92.setText("Mã HD");

        lblMaHD.setText("--");

        lblMaSP.setText("--");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addGap(18, 18, 18)
                        .addComponent(lblMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addComponent(jLabel29)
                        .addGap(54, 54, 54)
                        .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(btnLuuTam)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCapNhat)
                                .addGap(27, 27, 27)
                                .addComponent(btnXoa))
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(jLabel92)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel92)
                    .addComponent(lblMaHD))
                .addGap(24, 24, 24)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29)
                    .addComponent(jLabel28)
                    .addComponent(lblMaSP))
                .addGap(16, 16, 16)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLuuTam)
                    .addComponent(btnCapNhat)
                    .addComponent(btnXoa))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel75.setText("Mã HD");

        btnTimKiemMaHD.setText("Tìm kiếm");
        btnTimKiemMaHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemMaHDActionPerformed(evt);
            }
        });

        jLabel77.setText("Mã SP");

        txtMaSPTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaSPTimActionPerformed(evt);
            }
        });

        btnTimMaSP.setText("Tìm kiếm");

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(jLabel75)
                        .addGap(18, 18, 18)
                        .addComponent(txtMaHDTim, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnTimKiemMaHD)))
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel77)
                        .addGap(29, 29, 29)
                        .addComponent(txtMaSPTim, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTimMaSP)))
                .addContainerGap(127, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel75)
                    .addComponent(txtMaHDTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiemMaHD)
                    .addComponent(jLabel77)
                    .addComponent(txtMaSPTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimMaSP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29))
        );

        PaneDS.addTab("Trả hàng", jPanel24);

        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel37.setText("Mã PTH");

        jButton38.setText("Tìm kiếm");

        tblTraHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã PTH", "Mã HD", "Mã ND", "Mã KH", "Ngày trả", "Tiền trả lại", "Lý do trả"
            }
        ));
        jScrollPane15.setViewportView(tblTraHang);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel37)
                .addGap(30, 30, 30)
                .addComponent(jTextField43, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton38)
                .addContainerGap(83, Short.MAX_VALUE))
            .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(jTextField43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton38))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        jPanel26.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel79.setText("Mã SP");

        jButton39.setText("Tìm kiếm");

        tblTraHangCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ));
        jScrollPane18.setViewportView(tblTraHangCT);

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel79)
                .addGap(36, 36, 36)
                .addComponent(jTextField44, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jButton39)
                .addGap(58, 58, 58))
            .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel79)
                    .addComponent(jTextField44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton39))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane18, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        PaneDS.addTab("DS phiếu trả hàng", jPanel25);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(PaneDS, javax.swing.GroupLayout.PREFERRED_SIZE, 899, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PaneDS, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaSPTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaSPTimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaSPTimActionPerformed

    private void btnTimKiemMaHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemMaHDActionPerformed
        String maHD = this.txtMaHDTim.getText();
//        List<ManageSanPhamLoi> ds = this.sanPhamLoiService.ALL();
//        int check = 0;
//        if (maSPL.trim().length() == 0) {
//            JOptionPane.showMessageDialog(this, "Không được để trống mã sản phẩm lỗi");
//            return;
//        } else {
//            for (ManageSanPhamLoi sp : ds) {
//                if (sp.getMaSPL().equalsIgnoreCase(txtMaSPL.getText())) {
//                    check++;
//                    this.txtMaSPL.setText(sp.getMaSPL());
//                    this.lblMaSP.setText(sp.getMaSP());
//                    this.txtLyDoLoi.setText(sp.getLyDoLoi());
//                    JOptionPane.showMessageDialog(this, "Tìm thấy sản phẩm lỗi");
//                    this.tblSPL.getSelectedRow();
//                    return;
//                }
//            }
//        }
//        if (check == 0) {
//            this.clearForm();
//            JOptionPane.showMessageDialog(this, "Không tìm thấy sản phẩm lỗi");
//
//        }
    }//GEN-LAST:event_btnTimKiemMaHDActionPerformed

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
            java.util.logging.Logger.getLogger(FrmPhieuTraHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPhieuTraHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPhieuTraHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPhieuTraHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPhieuTraHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane PaneDS;
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnHoanTra;
    private javax.swing.JButton btnLuuTam;
    private javax.swing.JButton btnTimKiemMaHD;
    private javax.swing.JButton btnTimMaSP;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jTable7;
    private javax.swing.JTable jTable9;
    private javax.swing.JTextField jTextField43;
    private javax.swing.JTextField jTextField44;
    private javax.swing.JLabel lblMaHD;
    private javax.swing.JLabel lblMaHDct;
    private javax.swing.JLabel lblMaKH;
    private javax.swing.JLabel lblMaNV;
    private javax.swing.JLabel lblMaSP;
    private javax.swing.JLabel lblTienTraLai;
    private javax.swing.JRadioButton rdoLoiSP;
    private javax.swing.JRadioButton rdoMuaSai;
    private javax.swing.JTable tblCTHD;
    private javax.swing.JTable tblTraHang;
    private javax.swing.JTable tblTraHangCT;
    private javax.swing.JTextField txtMaHDTim;
    private javax.swing.JTextField txtMaPhieuTra;
    private javax.swing.JTextField txtMaSPTim;
    private javax.swing.JTextField txtNgayTra;
    private javax.swing.JTextField txtSoLuong;
    // End of variables declaration//GEN-END:variables
}
