/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import DomainModels.HoaDon;
import DomainModels.KhachHang;
import ViewModels.ManageHoaDonChiTiet;
import ViewModels.QLSanPham;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;

import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class hoaDonPDF {

    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
    /**
     *
     * @author acer
     */
    public static void xuatHoaDon(HoaDon hd, KhachHang kh, List<ManageHoaDonChiTiet> listGioHang,
            float tongTien) throws Exception {
        Document document = new Document() {
        };

        try {
            // khởi tạo một PdfWriter truyền vào document và FileOutputStream
            PdfWriter.getInstance(document, new FileOutputStream("..//QuanLyTapHoa//FilePDF//"
                    + "HoaDon" + hd.getMaHD() + ".pdf"));

            // mở file để thực hiện viết
            document.open();
            //Tiêu đề
            Font f = new Font();
            f.setColor(21, 76, 121);
            f.setSize(20);
            f.setStyle(Font.BOLD);
            Paragraph paragraph = new Paragraph("-----BEE MARK-----", f);
            paragraph.setAlignment(Element.ALIGN_CENTER);
            document.add(paragraph);
            Font fdiaChi = new Font();
            fdiaChi.setColor(21, 76, 121);
            fdiaChi.setSize(15);
            Paragraph paraDiaChi = new Paragraph("----- Dia chi: Trinh Van Bo - Bac Tu Liem - Ha Noi -----", fdiaChi);
            paraDiaChi.setAlignment(Element.ALIGN_CENTER);
            document.add(paraDiaChi);
            //Mã hóa đơn
            Font fHoaDon = new Font();
            fHoaDon.setColor(50, 72, 78);
            fHoaDon.setSize(15);
            fHoaDon.setStyle(Font.BOLD);
            Paragraph paraHoaDon = new Paragraph("Mã HD: " + hd.getMaHD() + "\nNgày mua:  " + hd.getNgayTao());
//            Paragraph paraHoaDon = new Paragraph("So HD: " + hd.getMaHD() + "\nNgày mua:  " + hd.getNgayTao(), fHoaDon);
            document.add(paraHoaDon);
            //Thông tin khách hàng
            Font f1 = new Font();
            f1.setColor(50, 72, 78);
            f1.setSize(15);
            f1.setStyle(Font.BOLD);
            String thongTin = "Mã KH: " + kh.getMaKH()+ "\nTên khách hàng: " + kh.getTenKH();
                   
            Paragraph paragraph1 = new Paragraph(thongTin, f1);
            document.add(paragraph1);
            //Thông tin  sản phẩm đã mua
            Font fThongTinSP = new Font();
            fThongTinSP.setColor(50, 72, 78);
            fThongTinSP.setSize(15);
            fThongTinSP.setStyle(Font.BOLD);
            String thongTinSPTT = "\n" + "So luong" + "                     " + "Don gia" + "                                     "
                    + "Thanh tien";
            Paragraph paragrapThongTinSP = new Paragraph(thongTinSPTT, fThongTinSP);
            document.add(paragrapThongTinSP);
            for (ManageHoaDonChiTiet chonViewModel : listGioHang) {
                Font fSanPham = new Font();
                fSanPham.setSize(12);
                String sanPham = "\nTên sản phẩm: " + chonViewModel.getTenSP()
                        + "\n" + chonViewModel.getSoLuong() + "                                         "
                        + DBConnection.chuyenDoiTien(chonViewModel.getGiaBan())
                        + "                                     " + DBConnection.chuyenDoiTien(chonViewModel.getThanhTien())
                        + "\n-------------------------------------------------------------------------------------------------------"
                        + "----------------------";
                Paragraph paragraphSanPham = new Paragraph(sanPham, fSanPham);
                document.add(paragraphSanPham);
            }
//            TongTien
            Font fThongTinTongTien = new Font();
            fThongTinTongTien.setColor(50, 72, 78);
            fThongTinTongTien.setSize(15);
            fThongTinTongTien.setStyle(Font.BOLD);
            String thongTinTongTien = "\nTong tien:" + DBConnection.chuyenDoiTien(tongTien);
            Paragraph paragrapThongTinTongTien = new Paragraph(thongTinTongTien, fThongTinTongTien);
            paragrapThongTinTongTien.setAlignment(Element.ALIGN_LEFT);
            document.add(paragrapThongTinTongTien);
            //Cảm ơn
            Font fCamOn = new Font();
            fCamOn.setSize(19);
            fCamOn.setStyle(Font.ITALIC);
            Paragraph paraCamOn = new Paragraph("\n\n Hen gap lai quy khach ", fCamOn);
            paraCamOn.setAlignment(Element.ALIGN_CENTER);
            document.add(paraCamOn);
            // đóng file
            document.close();

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        try {
//            List<ManageHoaDonChiTiet> list = new ArrayList<>();
//            ManageHoaDonChiTiet mhdct1 = new ManageHoaDonChiTiet("HDCT00241", "DH001", "sp001", 23, 50000, 50000 * 23, "");
//            list.add(mhdct1);
//            ManageHoaDonChiTiet mhdct2 = new ManageHoaDonChiTiet("HDCT00241", "DH001", "sp001", 23, 50000, 50000 * 23, "");
//            list.add(mhdct2);
//            ManageHoaDonChiTiet mhdct3 = new ManageHoaDonChiTiet("HDCT00241", "DH001", "sp001", 23, 50000, 50000 * 23, "");
//            list.add(mhdct3);
//            ManageHoaDonChiTiet mhdct4 = new ManageHoaDonChiTiet("HDCT00241", "DH001", "sp001", 23, 50000, 50000 * 23, "");
//            list.add(mhdct4);
//            ManageHoaDonChiTiet mhdct5 = new ManageHoaDonChiTiet("HDCT00241", "DH001", "sp001", 23, 50000, 50000 * 23, "");
//            list.add(mhdct5);
//            xuatHoaDon(new HoaDon("DH001"),new KhachHang("KH01","0123456789"), list,9000);
//        } catch (Exception ex) {
//            Logger.getLogger(hoaDonPDF.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
}
