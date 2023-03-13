/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

/**
 *
 * @author Hung
 */

import DTO.ChiTietPhieuNhapDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChiTietPhieuNhapDAL implements DALInterface<ChiTietPhieuNhapDTO>{
    
    public ChiTietPhieuNhapDAL() {
    }
    
    public static ChiTietPhieuNhapDAL getInstance() {
        return new ChiTietPhieuNhapDAL();
    }

    @Override
    public boolean insert(ChiTietPhieuNhapDTO t) {
        boolean result = false;
        //Bước 1: tạo kết nối với sql
        Connection connect = ConnectDatabase.openConnection();
        if (connect != null) {
            try {
                String sql = "INSERT into chitietphieunhap "
                        + "(maPhieuNhap, maSach, soLuong, donGia) "
                        + "VALUES (?, ?, ?, ?)";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql); 
                stmt.setString(1, t.getMaPhieuNhap());
                stmt.setString(2, t.getMaSach());
                stmt.setInt(3, t.getSoLuong());
                stmt.setLong(4, t.getDonGia());
                
                result = stmt.executeUpdate()>=1;
            } catch (SQLException ex) {
                Logger.getLogger(ChiTietPhieuNhapDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectDatabase.closeConnection(connect);
            }
        }
        
        return result;
    }

    public boolean update(ChiTietPhieuNhapDTO t, String maPhieuNhap, String maSach) {
        boolean result = false;
        //Bước 1: tạo kết nối với sql
        Connection connect = ConnectDatabase.openConnection();
        
        if (connect != null) {
            try {
                String sql = "UPDATE chitietphieunhap SET "
                        + "maPhieuNhap=?, maSach=?, soLuong=?, donGia=? "
                        + "WHERE maPhieuNhap=? AND maSach=?";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql); 
                stmt.setString(1, t.getMaPhieuNhap());
                stmt.setString(2, t.getMaSach());
                stmt.setInt(3, t.getSoLuong());
                stmt.setLong(4, t.getDonGia());
                stmt.setString(5, maPhieuNhap);
                stmt.setString(6, maSach);
                
                result = stmt.executeUpdate()>=1;
            } catch (SQLException ex) {
                Logger.getLogger(ChiTietPhieuNhapDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectDatabase.closeConnection(connect);
            }
        }
        
        return result;
    }

    public boolean delete(String maPhieuNhap, String maSach) {
        boolean result = false;
        //Bước 1: tạo kết nối với sql
        Connection connect = ConnectDatabase.openConnection();
        if (connect != null) {
            try {
                String sql = "DELETE FROM chitietphieunhap "
                        + "WHERE maPhieuNhap=? AND maSach=?";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql); 
                stmt.setString(1, maPhieuNhap);
                stmt.setString(2, maSach);

                result = stmt.executeUpdate()>=1;
            } catch (SQLException ex) {
                Logger.getLogger(ChiTietPhieuNhapDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectDatabase.closeConnection(connect);
            }
        }
        
        return result;
    }

    @Override
    public ArrayList<ChiTietPhieuNhapDTO> getAll() {
        ArrayList<ChiTietPhieuNhapDTO> result = new ArrayList<>();
        
        Connection connect = ConnectDatabase.openConnection();
        if (connect != null) {
            
            try {
                String sql = "SELECT * FROM chitietphieunhap";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql);  

                ResultSet rs = stmt.executeQuery();
                
                //Bước 3: lấy dữ liệu
                while(rs.next()) {
                    String maPhieuNhap = rs.getString("maPhieuNhap");
                    String maSach = rs.getString("maSach");
                    int soLuong = rs.getInt("soLuong");
                    long donGia = rs.getLong("donGia");
                    
                    ChiTietPhieuNhapDTO ctpn = new ChiTietPhieuNhapDTO(maPhieuNhap, maSach, soLuong, donGia);
                 
                    result.add(ctpn);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ChiTietPhieuNhapDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectDatabase.closeConnection(connect);
            }
        }
        
        return result;
    }

    public ArrayList<ChiTietPhieuNhapDTO> getByPNId(String id) {
        ArrayList<ChiTietPhieuNhapDTO> result = new ArrayList<>();
        
        Connection connect = ConnectDatabase.openConnection();
        if (connect != null) {
            try {
                String sql = "SELECT * FROM chitietphieunhap WHERE maPhieuNhap='" + id + "'";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql); 

                ResultSet rs = stmt.executeQuery();
                
                //Bước 3: lấy dữ liệu
                while(rs.next()) {
                    String maPhieuNhap = rs.getString("maPhieuNhap");
                    String maSach = rs.getString("maSach");
                    int soLuong = rs.getInt("soLuong");
                    long donGia = rs.getLong("donGia");
                    
                    ChiTietPhieuNhapDTO ctpn = new ChiTietPhieuNhapDTO(maPhieuNhap, maSach, soLuong, donGia);
                    
                    result.add(ctpn);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ChiTietPhieuBanDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectDatabase.closeConnection(connect);
            }
        }
        
        return result;
    }

    @Override
    public ArrayList<ChiTietPhieuNhapDTO> getByCondition(String condition) {
        ArrayList<ChiTietPhieuNhapDTO> result = new ArrayList<>();
        
        Connection connect = ConnectDatabase.openConnection();
        if (connect != null) {
            
            try {
                String sql = "SELECT * FROM chitietphieunhap WHERE " + condition;

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql);  

                ResultSet rs = stmt.executeQuery();
                
                //Bước 3: lấy dữ liệu
                while(rs.next()) {
                    String maPhieuNhap = rs.getString("maPhieuNhap");
                    String maSach = rs.getString("maSach");
                    int soLuong = rs.getInt("soLuong");
                    long donGia = rs.getLong("donGia");
                    
                    ChiTietPhieuNhapDTO ctpn = new ChiTietPhieuNhapDTO(maPhieuNhap, maSach, soLuong, donGia);
                 
                    result.add(ctpn);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ChiTietPhieuNhapDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectDatabase.closeConnection(connect);
            }
        }
        
        return result;
    }

    @Override
    public boolean update(ChiTietPhieuNhapDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ChiTietPhieuNhapDTO getById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
