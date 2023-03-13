/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

/**
 *
 * @author Hung
 */

import DTO.SachDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SachDAL implements DALInterface<SachDTO>{
    
    public static SachDAL getInstance() {
        return new SachDAL();
    }

    @Override
    public boolean insert(SachDTO t) {
        boolean result = false;
        //Bước 1: tạo kết nối với sql
        Connection connect = ConnectDatabase.openConnection();
        if (connect != null) {
            try {
                String sql = "INSERT into sach "
                        + "(maSach, tenSach, maTheLoai, maTacGia, maNhaXuatBan, soLuongConLai, giaBan, giaNhap, namXuatBan) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql); 
                stmt.setString(1, t.getMaSach());
                stmt.setString(2, t.getTenSach());
                stmt.setString(3, t.getMaTheLoai());
                stmt.setString(4, t.getMaTacGia());
                stmt.setString(5, t.getMaNhaXuatBan());
                stmt.setInt(6, t.getSoLuongConLai());
                stmt.setLong(7, t.getGiaBan());
                stmt.setLong(8, t.getGiaNhap());
                stmt.setInt(9, t.getNamXuatBan());

                result = stmt.executeUpdate()>=1;
            } catch (SQLException ex) {
                Logger.getLogger(SachDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectDatabase.closeConnection(connect);
            }
        }
        
        return result;
    }

    public boolean update(SachDTO t, String maSach) {
        boolean result = false;
        //Bước 1: tạo kết nối với sql
        Connection connect = ConnectDatabase.openConnection();
        
        if (connect != null) {
            try {
                String sql = "UPDATE sach SET "
                        + "maSach=?, tenSach=?, maTheLoai=?, maTacGia=?, maNhaXuatBan=?, soLuongConLai=?, giaBan=?, giaNhap=?, namXuatBan=? "
                        + "WHERE maSach=?";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql); 
                stmt.setString(1, t.getMaSach());
                stmt.setString(2, t.getTenSach());
                stmt.setString(3, t.getMaTheLoai());
                stmt.setString(4, t.getMaTacGia());
                stmt.setString(5, t.getMaNhaXuatBan());
                stmt.setInt(6, t.getSoLuongConLai());
                stmt.setLong(7, t.getGiaBan());
                stmt.setLong(8, t.getGiaNhap());
                stmt.setInt(9, t.getNamXuatBan());
                stmt.setString(10, maSach);

                result = stmt.executeUpdate()>=1;
            } catch (SQLException ex) {
                Logger.getLogger(SachDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectDatabase.closeConnection(connect);
            }
        }
        
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        //Bước 1: tạo kết nối với sql
        Connection connect = ConnectDatabase.openConnection();
        if (connect != null) {
            try {
                String sql = "DELETE FROM sach "
                        + "WHERE maSach=?";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql); 
                stmt.setString(1, id); 

                result = stmt.executeUpdate()>=1;
            } catch (SQLException ex) {
                Logger.getLogger(SachDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectDatabase.closeConnection(connect);
            }
        }
        
        return result;
    }

    @Override
    public ArrayList<SachDTO> getAll() {
        ArrayList<SachDTO> result = new ArrayList<>();
        
        Connection connect = ConnectDatabase.openConnection();
        if (connect != null) {
            
            try {
                String sql = "SELECT * FROM sach";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql);  

                ResultSet rs = stmt.executeQuery();
                
                //Bước 3: lấy dữ liệu
                while(rs.next()) {
                    String maSach = rs.getString("maSach");
                    String tenSach = rs.getString("tenSach");
                    String maTheLoai = rs.getString("maTheLoai");
                    String maTacGia = rs.getString("maTacGia");
                    String maNhaXuatBan = rs.getString("maNhaXuatBan");
                    int soLuongConLai = rs.getInt("soLuongConLai");
                    long giaBan = rs.getLong("giaBan");
                    long giaNhap = rs.getLong("giaNhap");
                    int namXuatBan = rs.getInt("namXuatBan");
                    
                    SachDTO s = new SachDTO(maSach, tenSach, maTheLoai, maTacGia, maNhaXuatBan, soLuongConLai, giaBan, giaNhap, namXuatBan);
                 
                    result.add(s);
                }
            } catch (SQLException ex) {
                Logger.getLogger(SachDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectDatabase.closeConnection(connect);
            }
        }
        
        return result;
    }

    @Override
    public SachDTO getById(String id) {
        SachDTO result = null;
        
        Connection connect = ConnectDatabase.openConnection();
        if (connect != null) {
            try {
                String sql = "SELECT * FROM sach WHERE maSach=\'" + id + "\'";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql); 

                ResultSet rs = stmt.executeQuery();
                
                //Bước 3: lấy dữ liệu
                while(rs.next()) {
                    String maSach = rs.getString("maSach");
                    String tenSach = rs.getString("tenSach");
                    String maTheLoai = rs.getString("maTheLoai");
                    String maTacGia = rs.getString("maTacGia");
                    String maNhaXuatBan = rs.getString("maNhaXuatBan");
                    int soLuongConLai = rs.getInt("soLuongConLai");
                    long giaBan = rs.getLong("giaBan");
                    long giaNhap = rs.getLong("giaNhap");
                    int namXuatBan = rs.getInt("namXuatBan");
                    
                    result = new SachDTO(maSach, tenSach, maTheLoai, maTacGia, maNhaXuatBan, soLuongConLai, giaBan, giaNhap, namXuatBan);
                }
            } catch (SQLException ex) {
                Logger.getLogger(SachDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectDatabase.closeConnection(connect);
            }
        }
        
        return result;
    }

    @Override
    public ArrayList<SachDTO> getByCondition(String condition) {
        ArrayList<SachDTO> result = new ArrayList<>();
        
        Connection connect = ConnectDatabase.openConnection();
        if (connect != null) {
            
            try {
                String sql = "SELECT * FROM sach WHERE " + condition;

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql);  

                ResultSet rs = stmt.executeQuery();
                
                //Bước 3: lấy dữ liệu
                while(rs.next()) {
                    String maSach = rs.getString("maSach");
                    String tenSach = rs.getString("tenSach");
                    String maTheLoai = rs.getString("maTheLoai");
                    String maTacGia = rs.getString("maTacGia");
                    String maNhaXuatBan = rs.getString("maNhaXuatBan");
                    int soLuongConLai = rs.getInt("soLuongConLai");
                    long giaBan = rs.getLong("giaBan");
                    long giaNhap = rs.getLong("giaNhap");
                    int namXuatBan = rs.getInt("namXuatBan");
                    
                    SachDTO s = new SachDTO(maSach, tenSach, maTheLoai, maTacGia, maNhaXuatBan, soLuongConLai, giaBan, giaNhap, namXuatBan);
                 
                    result.add(s);
                }
            } catch (SQLException ex) {
                Logger.getLogger(SachDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectDatabase.closeConnection(connect);
            }
        }
        
        return result;
    }

    @Override
    public boolean update(SachDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
