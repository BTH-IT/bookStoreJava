/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

/**
 *
 * @author Hung
 */

import DTO.PhieuNhapDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PhieuNhapDAL implements DALInterface<PhieuNhapDTO>{
    
    public static PhieuNhapDAL getInstance() {
        return new PhieuNhapDAL();
    }

    public int insert(int maNhanVien, Date ngayLap, double tongTien) {
        boolean result = false;
        int auto_id = -1;
        //Bước 1: tạo kết nối với sql
        Connection connect = ConnectDatabase.openConnection();
        if (connect != null) {
            try {
                String sql = "INSERT into phieunhap "
                        + "(maNhanVien, ngayLap, tongTien) "
                        + "VALUES (?, ?, ?)";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); 
                stmt.setInt(1, maNhanVien);
                stmt.setDate(2, ngayLap);
                stmt.setDouble(3, tongTien);

                result = stmt.executeUpdate()>=1;
                
                if (result) {
                    ResultSet rs = stmt.getGeneratedKeys();
                    rs.next();
                    auto_id = rs.getInt(1);
                }
            } catch (SQLException ex) {
                Logger.getLogger(PhieuNhapDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectDatabase.closeConnection(connect);
            }
        }
        
        return auto_id;
    }

    @Override
    public boolean update(PhieuNhapDTO t) {
        boolean result = false;
        //Bước 1: tạo kết nối với sql
        Connection connect = ConnectDatabase.openConnection();
        
        if (connect != null) {
            try {
                String sql = "UPDATE phieunhap SET "
                        + "maNhanVien=?, ngayLap=? "
                        + "WHERE maPhieuNhap=?";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql); 
                stmt.setInt(1, t.getMaNhanVien());
                stmt.setDate(2, t.getNgayLap());
                stmt.setInt(3, t.getMaPhieuNhap());

                result = stmt.executeUpdate()>=1;
            } catch (SQLException ex) {
                Logger.getLogger(PhieuNhapDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectDatabase.closeConnection(connect);
            }
        }
        
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        //Bước 1: tạo kết nối với sql
        Connection connect = ConnectDatabase.openConnection();
        if (connect != null) {
            try {
                String sql = "UPDATE phieunhap SET hienThi=0 "
                        + "WHERE maPhieuNhap=?";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql); 
                stmt.setInt(1, id); 

                result = stmt.executeUpdate()>=1;
                
                if (result) {
                    sql = "UPDATE chitietphieunhap SET hienThi=0 "
                        + "WHERE maPhieuNhap=?";

                    //Bước 2: tạo đối tượng preparedStatement
                    stmt = connect.prepareStatement(sql); 
                    stmt.setInt(1, id); 

                    result = stmt.executeUpdate()>=1;
                }
            } catch (SQLException ex) {
                Logger.getLogger(PhieuNhapDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectDatabase.closeConnection(connect);
            }
        }
        
        return result;
    }

    @Override
    public ArrayList<PhieuNhapDTO> getAll() {
        ArrayList<PhieuNhapDTO> result = new ArrayList<>();
        
        Connection connect = ConnectDatabase.openConnection();
        if (connect != null) {
            
            try {
                String sql = "SELECT * FROM phieunhap WHERE hienThi=1";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql);  

                ResultSet rs = stmt.executeQuery();
                
                //Bước 3: lấy dữ liệu
                while(rs.next()) {
                    int maPhieuNhap = rs.getInt("maPhieuNhap");
                    int maNhanVien = rs.getInt("maNhanVien");
                    Date ngayLap = rs.getDate("ngayLap");
                    double tongTien = rs.getInt("tongTien");
                    
                    PhieuNhapDTO pn = new PhieuNhapDTO(maPhieuNhap, maNhanVien, ngayLap, tongTien);
                 
                    result.add(pn);
                }
            } catch (SQLException ex) {
                Logger.getLogger(PhieuNhapDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectDatabase.closeConnection(connect);
            }
        }
        
        return result;
    }

    @Override
    public PhieuNhapDTO getById(int id) {
        PhieuNhapDTO result = null;
        
        Connection connect = ConnectDatabase.openConnection();
        if (connect != null) {
            try {
                String sql = "SELECT * FROM phieunhap WHERE maPhieuNhap=? AND hienThi=1";

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql); 
                stmt.setInt(1, id);
                
                ResultSet rs = stmt.executeQuery();
                
                //Bước 3: lấy dữ liệu
                while(rs.next()) {
                    int maPhieuNhap = rs.getInt("maPhieuNhap");
                    int maNhanVien = rs.getInt("maNhanVien");
                    Date ngayLap = rs.getDate("ngayLap");
                    double tongTien = rs.getInt("tongTien");
                    
                    PhieuNhapDTO pn = new PhieuNhapDTO(maPhieuNhap, maNhanVien, ngayLap, tongTien);
                }
            } catch (SQLException ex) {
                Logger.getLogger(PhieuNhapDAL.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectDatabase.closeConnection(connect);
            }
        }
        
        return result;
    }

    @Override
    public ArrayList<PhieuNhapDTO> getByCondition(String condition) {
        ArrayList<PhieuNhapDTO> result = new ArrayList<>();
        
        Connection connect = ConnectDatabase.openConnection();
        if (connect != null) {
            
            try {
                String sql = "SELECT * FROM phieunhap WHERE hienThi=1 AND " + condition;

                //Bước 2: tạo đối tượng preparedStatement
                PreparedStatement stmt = connect.prepareStatement(sql);  

                ResultSet rs = stmt.executeQuery();
                
                //Bước 3: lấy dữ liệu
                while(rs.next()) {
                    int maPhieuNhap = rs.getInt("maPhieuNhap");
                    int maNhanVien = rs.getInt("maNhanVien");
                    Date ngayLap = rs.getDate("ngayLap");
                    double tongTien = rs.getInt("tongTien");
                    
                    PhieuNhapDTO pn = new PhieuNhapDTO(maPhieuNhap, maNhanVien, ngayLap, tongTien);
                 
                    result.add(pn);
                }
            } catch (SQLException ex) {
                Logger.getLogger(PhieuNhapDAL.class.getName()).log(Level.SEVERE, null, ex);
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
    public boolean insert(PhieuNhapDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public PhieuNhapDTO getById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
