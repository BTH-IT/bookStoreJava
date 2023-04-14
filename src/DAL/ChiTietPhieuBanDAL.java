/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

/**
 *
 * @author Hung
 */

import DTO.ChiTietPhieuBanDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChiTietPhieuBanDAL implements DALInterface<ChiTietPhieuBanDTO>{
    
    public static ChiTietPhieuBanDAL getInstance() {
        return new ChiTietPhieuBanDAL();
    }

    @Override
    public boolean insert(ChiTietPhieuBanDTO t) {
        boolean result = false;
        //Bước 1: tạo kết nối với sql
        Connection connect = ConnectDatabase.openConnection();
        if (connect != null) {
            try {
                String sql = "INSERT into chitietphieuban "
                        + "(maPhieuBan, maSach, soLuong, donGia) "
                        + "VALUES (?, ?, ?, ?)";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql); 
<<<<<<< HEAD
                stmt.setInt(1, t.getMaPhieuBan());
                stmt.setInt(2, t.getMaSach());
=======
                stmt.setString(1, t.getMaPhieuBan());
                stmt.setString(2, t.getMaSach());
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c
                stmt.setInt(3, t.getSoLuong());
                stmt.setLong(4, t.getDonGia());

                result = stmt.executeUpdate()>=1;
            } catch (SQLException ex) {
                Logger.getLogger(ChiTietPhieuBanDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectDatabase.closeConnection(connect);
            }
        }
        
        return result;
    }

    public boolean update(ChiTietPhieuBanDTO t, String maPhieuBan, String maSach) {
        boolean result = false;
        //Bước 1: tạo kết nối với sql
        Connection connect = ConnectDatabase.openConnection();
        
        if (connect != null) {
            try {
                String sql = "UPDATE chitietphieuban SET "
                        + "maPhieuBan=?, maSach=?, soLuong=?, donGia=? "
                        + "WHERE maPhieuBan=? AND maSach=?";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql); 
<<<<<<< HEAD
                stmt.setInt(1, t.getMaPhieuBan());
                stmt.setInt(2, t.getMaSach());
=======
                stmt.setString(1, t.getMaPhieuBan());
                stmt.setString(2, t.getMaSach());
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c
                stmt.setInt(3, t.getSoLuong());
                stmt.setLong(4, t.getDonGia());
                stmt.setString(5, maPhieuBan);
                stmt.setString(6, maSach);

                result = stmt.executeUpdate()>=1;
            } catch (SQLException ex) {
                Logger.getLogger(ChiTietPhieuBanDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectDatabase.closeConnection(connect);
            }
        }
        
        return result;
    }

<<<<<<< HEAD
    public boolean delete(int mapPhieuBan, int maSach) {
=======
    public boolean delete(String mapPhieuBan, String maSach) {
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c
        boolean result = false;
        //Bước 1: tạo kết nối với sql
        Connection connect = ConnectDatabase.openConnection();
        if (connect != null) {
            try {
<<<<<<< HEAD
                String sql = "UPDATE chitietphieuban SET hienThi=0 "
=======
                String sql = "DELETE FROM chitietphieuban "
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c
                        + "WHERE maPhieuBan=? AND maSach=?";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql); 
<<<<<<< HEAD
                stmt.setInt(1, mapPhieuBan);
                stmt.setInt(2, maSach);
=======
                stmt.setString(1, mapPhieuBan);
                stmt.setString(2, maSach);
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c

                result = stmt.executeUpdate()>=1;
            } catch (SQLException ex) {
                Logger.getLogger(ChiTietPhieuBanDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectDatabase.closeConnection(connect);
            }
        }
        
        return result;
    }

    @Override
    public ArrayList<ChiTietPhieuBanDTO> getAll() {
        ArrayList<ChiTietPhieuBanDTO> result = new ArrayList<>();
        
        Connection connect = ConnectDatabase.openConnection();
        if (connect != null) {
            
            try {
<<<<<<< HEAD
                String sql = "SELECT * FROM chitietphieuban WHERE hienThi=1";
=======
                String sql = "SELECT * FROM chitietphieuban";
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql);  

                ResultSet rs = stmt.executeQuery();
                
                //Bước 3: lấy dữ liệu
                while(rs.next()) {
<<<<<<< HEAD
                    int maPhieuBan = rs.getInt("maPhieuBan");
                    int maSach = rs.getInt("maSach");
=======
                    String maPhieuBan = rs.getString("maPhieuBan");
                    String maSach = rs.getString("maSach");
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c
                    int soLuong = rs.getInt("soLuong");
                    long donGia = rs.getLong("donGia");
                    
                    ChiTietPhieuBanDTO ctpb = new ChiTietPhieuBanDTO(maPhieuBan, maSach, soLuong, donGia);
                 
                    result.add(ctpb);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ChiTietPhieuBanDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectDatabase.closeConnection(connect);
            }
        }
        
        return result;
    }

<<<<<<< HEAD
    public ArrayList<ChiTietPhieuBanDTO> getByPBId(int id) {
=======
    public ArrayList<ChiTietPhieuBanDTO> getByPBId(String id) {
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c
        ArrayList<ChiTietPhieuBanDTO> result = new ArrayList<>();
        
        Connection connect = ConnectDatabase.openConnection();
        if (connect != null) {
            try {
<<<<<<< HEAD
                String sql = "SELECT * FROM chitietphieuban WHERE hienThi=1 AND maPhieuBan=" + id;
=======
                String sql = "SELECT * FROM chitietphieuban WHERE maPhieuBan='" + id + "'";
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql); 

                ResultSet rs = stmt.executeQuery();
                
                //Bước 3: lấy dữ liệu
                while(rs.next()) {
<<<<<<< HEAD
                    int maPhieuBan = rs.getInt("maPhieuBan");
                    int maSach = rs.getInt("maSach");
=======
                    String maPhieuBan = rs.getString("maPhieuBan");
                    String maSach = rs.getString("maSach");
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c
                    int soLuong = rs.getInt("soLuong");
                    long donGia = rs.getLong("donGia");
                    
                    ChiTietPhieuBanDTO ctpb = new ChiTietPhieuBanDTO(maPhieuBan, maSach, soLuong, donGia);
                 
                    result.add(ctpb);
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
    public ArrayList<ChiTietPhieuBanDTO> getByCondition(String condition) {
        ArrayList<ChiTietPhieuBanDTO> result = new ArrayList<>();
        
        Connection connect = ConnectDatabase.openConnection();
        if (connect != null) {
            
            try {
<<<<<<< HEAD
                String sql = "SELECT * FROM chitietphieuban WHERE hienThi=1 AND " + condition;
=======
                String sql = "SELECT * FROM chitietphieuban WHERE " + condition;
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql);  

                ResultSet rs = stmt.executeQuery();
                
                //Bước 3: lấy dữ liệu
                while(rs.next()) {
<<<<<<< HEAD
                    int maPhieuBan = rs.getInt("maPhieuBan");
                    int maSach = rs.getInt("maSach");
=======
                    String maPhieuBan = rs.getString("maPhieuBan");
                    String maSach = rs.getString("maSach");
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c
                    int soLuong = rs.getInt("soLuong");
                    long donGia = rs.getLong("donGia");
                    
                    ChiTietPhieuBanDTO ctpb = new ChiTietPhieuBanDTO(maPhieuBan, maSach, soLuong, donGia);
                 
                    result.add(ctpb);
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
    public boolean delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ChiTietPhieuBanDTO getById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(ChiTietPhieuBanDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
<<<<<<< HEAD

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ChiTietPhieuBanDTO getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
=======
>>>>>>> 334d53b34ae63bc371cd59fac28dbbbb8c81302c
}
