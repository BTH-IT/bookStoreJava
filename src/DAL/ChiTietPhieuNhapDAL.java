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
<<<<<<< HEAD
                stmt.setInt(1, t.getMaPhieuNhap());
                stmt.setInt(2, t.getMaSach());
=======
                stmt.setString(1, t.getMaPhieuNhap());
                stmt.setString(2, t.getMaSach());
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c
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

<<<<<<< HEAD
    @Override
    public boolean update(ChiTietPhieuNhapDTO t) {
=======
    public boolean update(ChiTietPhieuNhapDTO t, String maPhieuNhap, String maSach) {
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c
        boolean result = false;
        //Bước 1: tạo kết nối với sql
        Connection connect = ConnectDatabase.openConnection();
        
        if (connect != null) {
            try {
                String sql = "UPDATE chitietphieunhap SET "
<<<<<<< HEAD
                        + "soLuong=?, donGia=? "
=======
                        + "maPhieuNhap=?, maSach=?, soLuong=?, donGia=? "
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c
                        + "WHERE maPhieuNhap=? AND maSach=?";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql); 
<<<<<<< HEAD
                stmt.setInt(1, t.getSoLuong());
                stmt.setLong(2, t.getDonGia());
                stmt.setInt(3, t.getMaPhieuNhap());
                stmt.setInt(4, t.getMaSach());
=======
                stmt.setString(1, t.getMaPhieuNhap());
                stmt.setString(2, t.getMaSach());
                stmt.setInt(3, t.getSoLuong());
                stmt.setLong(4, t.getDonGia());
                stmt.setString(5, maPhieuNhap);
                stmt.setString(6, maSach);
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c
                
                result = stmt.executeUpdate()>=1;
            } catch (SQLException ex) {
                Logger.getLogger(ChiTietPhieuNhapDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectDatabase.closeConnection(connect);
            }
        }
        
        return result;
    }

<<<<<<< HEAD
    public boolean delete(int maPhieuNhap, int maSach) {
=======
    public boolean delete(String maPhieuNhap, String maSach) {
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c
        boolean result = false;
        //Bước 1: tạo kết nối với sql
        Connection connect = ConnectDatabase.openConnection();
        if (connect != null) {
            try {
<<<<<<< HEAD
                String sql = "UPDATE chitietphieunhap SET hienThi=0 "
=======
                String sql = "DELETE FROM chitietphieunhap "
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c
                        + "WHERE maPhieuNhap=? AND maSach=?";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql); 
<<<<<<< HEAD
                stmt.setInt(1, maPhieuNhap);
                stmt.setInt(2, maSach);
=======
                stmt.setString(1, maPhieuNhap);
                stmt.setString(2, maSach);
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c

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
<<<<<<< HEAD
                String sql = "SELECT * FROM chitietphieunhap WHERE hienThi=1";
=======
                String sql = "SELECT * FROM chitietphieunhap";
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql);  

                ResultSet rs = stmt.executeQuery();
                
                //Bước 3: lấy dữ liệu
                while(rs.next()) {
<<<<<<< HEAD
                    int maPhieuNhap = rs.getInt("maPhieuNhap");
                    int maSach = rs.getInt("maSach");
=======
                    String maPhieuNhap = rs.getString("maPhieuNhap");
                    String maSach = rs.getString("maSach");
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c
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

<<<<<<< HEAD
    public ArrayList<ChiTietPhieuNhapDTO> getByPNId(int id) {
=======
    public ArrayList<ChiTietPhieuNhapDTO> getByPNId(String id) {
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c
        ArrayList<ChiTietPhieuNhapDTO> result = new ArrayList<>();
        
        Connection connect = ConnectDatabase.openConnection();
        if (connect != null) {
            try {
<<<<<<< HEAD
                String sql = "SELECT * FROM chitietphieunhap WHERE hienThi=1 AND maPhieuNhap=" + id;
=======
                String sql = "SELECT * FROM chitietphieunhap WHERE maPhieuNhap='" + id + "'";
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql); 

                ResultSet rs = stmt.executeQuery();
                
                //Bước 3: lấy dữ liệu
                while(rs.next()) {
<<<<<<< HEAD
                    int maPhieuNhap = rs.getInt("maPhieuNhap");
                    int maSach = rs.getInt("maSach");
=======
                    String maPhieuNhap = rs.getString("maPhieuNhap");
                    String maSach = rs.getString("maSach");
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c
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
<<<<<<< HEAD
                String sql = "SELECT * FROM chitietphieunhap WHERE hienThi=1 AND " + condition;
=======
                String sql = "SELECT * FROM chitietphieunhap WHERE " + condition;
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql);  

                ResultSet rs = stmt.executeQuery();
                
                //Bước 3: lấy dữ liệu
                while(rs.next()) {
<<<<<<< HEAD
                    int maPhieuNhap = rs.getInt("maPhieuNhap");
                    int maSach = rs.getInt("maSach");
=======
                    String maPhieuNhap = rs.getString("maPhieuNhap");
                    String maSach = rs.getString("maSach");
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c
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
<<<<<<< HEAD
=======
    public boolean update(ChiTietPhieuNhapDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c
    public boolean delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ChiTietPhieuNhapDTO getById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
<<<<<<< HEAD

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ChiTietPhieuNhapDTO getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
=======
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c
}
