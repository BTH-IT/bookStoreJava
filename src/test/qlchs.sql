-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 21, 2023 at 06:19 AM
-- Server version: 8.0.31
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `qlchs`
--

-- --------------------------------------------------------

--
-- Table structure for table `chitietphieuban`
--

CREATE TABLE `chitietphieuban` (
  `maPhieuBan` int NOT NULL,
  `maSach` int NOT NULL,
  `soLuong` int NOT NULL,
  `donGia` bigint NOT NULL,
  `hienThi` tinyint DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `chitietphieuban`
--

INSERT INTO `chitietphieuban` (`maPhieuBan`, `maSach`, `soLuong`, `donGia`, `hienThi`) VALUES
(1, 2, 10, 9090909, 1),
(2, 1, 2, 100000, 1),
(3, 1, 2, 100000, 1),
(4, 1, 20, 100000, 1),
(5, 2, 1, 9090909, 1),
(6, 1, 5, 100000, 1);

-- --------------------------------------------------------

--
-- Table structure for table `chitietphieunhap`
--

CREATE TABLE `chitietphieunhap` (
  `maPhieuNhap` int NOT NULL,
  `maSach` int NOT NULL,
  `soLuong` int NOT NULL,
  `donGia` bigint NOT NULL,
  `hienThi` tinyint DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `chitietphieunhap`
--

INSERT INTO `chitietphieunhap` (`maPhieuNhap`, `maSach`, `soLuong`, `donGia`, `hienThi`) VALUES
(5, 3, 30, 32313, 1);

-- --------------------------------------------------------

--
-- Table structure for table `khachhang`
--

CREATE TABLE `khachhang` (
  `maKhachHang` int NOT NULL,
  `tenKhachHang` varchar(512) NOT NULL,
  `soDienThoai` varchar(11) NOT NULL,
  `gioiTinh` varchar(10) NOT NULL,
  `namSinh` int NOT NULL,
  `hienThi` tinyint DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `khachhang`
--

INSERT INTO `khachhang` (`maKhachHang`, `tenKhachHang`, `soDienThoai`, `gioiTinh`, `namSinh`, `hienThi`) VALUES
(1, 'hung', '0706092402', 'Nam', 123, 1),
(2, '123', '0706092403', 'Nam', 1233, 1);

-- --------------------------------------------------------

--
-- Table structure for table `khuyenmai`
--

CREATE TABLE `khuyenmai` (
  `maKhuyenMai` int NOT NULL,
  `tenKhuyenMai` varchar(256) DEFAULT NULL,
  `phanTram` int DEFAULT NULL,
  `ngayBatDau` date DEFAULT NULL,
  `ngayKetThuc` date DEFAULT NULL,
  `hienThi` tinyint DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `khuyenmai`
--

INSERT INTO `khuyenmai` (`maKhuyenMai`, `tenKhuyenMai`, `phanTram`, `ngayBatDau`, `ngayKetThuc`, `hienThi`) VALUES
(1, 'Test', 10, '2023-04-23', '2023-04-27', 1),
(2, 'tesd', 10, '2023-04-20', '2023-04-20', 1);

-- --------------------------------------------------------

--
-- Table structure for table `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `maNhaCungCap` int NOT NULL,
  `tenNhaCungCap` varchar(256) DEFAULT NULL,
  `diaChi` varchar(256) DEFAULT NULL,
  `soDienThoai` varchar(256) DEFAULT NULL,
  `hienThi` tinyint DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `nhacungcap`
--

INSERT INTO `nhacungcap` (`maNhaCungCap`, `tenNhaCungCap`, `diaChi`, `soDienThoai`, `hienThi`) VALUES
(1, 'test', '123123', '0709092403', 1),
(2, '312313', '123132', '0706092403', 1),
(3, 'hưadwadh', '123123', '0706092403', 1),
(4, 'Bien Thanh Hung', 'bienthanhhu123', '0909090900', 0);

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien`
--

CREATE TABLE `nhanvien` (
  `maNhanVien` int NOT NULL,
  `tenNhanVien` varchar(512) NOT NULL,
  `namSinh` int NOT NULL,
  `gioiTinh` varchar(10) NOT NULL,
  `soDienThoai` varchar(11) NOT NULL,
  `luong` bigint NOT NULL,
  `soNgayNghi` int NOT NULL,
  `vaiTro` varchar(256) NOT NULL,
  `hienThi` tinyint DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `nhanvien`
--

INSERT INTO `nhanvien` (`maNhanVien`, `tenNhanVien`, `namSinh`, `gioiTinh`, `soDienThoai`, `luong`, `soNgayNghi`, `vaiTro`, `hienThi`) VALUES
(1, 'Hung', 2003, 'Nam', '0706092403', 2000000, 3, 'Quản lý', 1),
(2, 'Huy', 2003, 'Nam', '0706092044', 200000, 1, 'Nhân viên bán hàng', 1);

-- --------------------------------------------------------

--
-- Table structure for table `nhaxuatban`
--

CREATE TABLE `nhaxuatban` (
  `maNhaXuatBan` int NOT NULL,
  `tenNhaXuatBan` varchar(512) NOT NULL,
  `diaChi` varchar(512) NOT NULL,
  `soDienThoai` varchar(11) NOT NULL,
  `hienThi` tinyint DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `nhaxuatban`
--

INSERT INTO `nhaxuatban` (`maNhaXuatBan`, `tenNhaXuatBan`, `diaChi`, `soDienThoai`, `hienThi`) VALUES
(1, 'hung', '123123', '0706092403', 1);

-- --------------------------------------------------------

--
-- Table structure for table `phieuban`
--

CREATE TABLE `phieuban` (
  `maPhieuBan` int NOT NULL,
  `maKhachHang` int DEFAULT NULL,
  `maNhanVien` int DEFAULT NULL,
  `ngayLap` date NOT NULL,
  `tongTien` double DEFAULT NULL,
  `maKhuyenMai` int DEFAULT NULL,
  `hienThi` tinyint DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `phieuban`
--

INSERT INTO `phieuban` (`maPhieuBan`, `maKhachHang`, `maNhanVien`, `ngayLap`, `tongTien`, `maKhuyenMai`, `hienThi`) VALUES
(1, 2, 2, '2023-04-17', 90909090, 0, 1),
(2, 1, 1, '2023-04-18', 200000, 0, 1),
(3, 1, 1, '2023-04-18', 200000, 0, 1),
(4, 1, 1, '2023-04-18', 2000000, 0, 1),
(5, 1, 1, '2023-04-18', 9090909, 0, 1),
(6, 1, 1, '2023-04-19', 500000, 0, 1);

-- --------------------------------------------------------

--
-- Table structure for table `phieunhap`
--

CREATE TABLE `phieunhap` (
  `maPhieuNhap` int NOT NULL,
  `maNhanVien` int NOT NULL,
  `maNhaCungCap` int DEFAULT NULL,
  `ngayLap` datetime NOT NULL,
  `tongTien` double NOT NULL,
  `hienThi` tinyint DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `phieunhap`
--

INSERT INTO `phieunhap` (`maPhieuNhap`, `maNhanVien`, `maNhaCungCap`, `ngayLap`, `tongTien`, `hienThi`) VALUES
(5, 2, 1, '2023-04-21 00:00:00', 969390, 1);

-- --------------------------------------------------------

--
-- Table structure for table `sach`
--

CREATE TABLE `sach` (
  `maSach` int NOT NULL,
  `tenSach` varchar(512) NOT NULL,
  `maTheLoai` int DEFAULT NULL,
  `maTacGia` int DEFAULT NULL,
  `maNhaXuatBan` int DEFAULT NULL,
  `soLuongConLai` int NOT NULL,
  `giaBan` bigint NOT NULL,
  `giaNhap` bigint NOT NULL,
  `namXuatBan` int NOT NULL,
  `hienThi` tinyint DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `sach`
--

INSERT INTO `sach` (`maSach`, `tenSach`, `maTheLoai`, `maTacGia`, `maNhaXuatBan`, `soLuongConLai`, `giaBan`, `giaNhap`, `namXuatBan`, `hienThi`) VALUES
(1, '123123', 1, 1, 1, 6, 100000, 90000, 1991, 1),
(2, '21142', 1, 1, 1, 12122, 9090909, 32313, 1323, 1),
(3, '123', 1, 1, 1, 123, 1231212, 123123, 123, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tacgia`
--

CREATE TABLE `tacgia` (
  `maTacGia` int NOT NULL,
  `tenTacGia` varchar(512) NOT NULL,
  `gioiTinh` varchar(10) NOT NULL,
  `namSinh` int NOT NULL,
  `hienThi` tinyint DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `tacgia`
--

INSERT INTO `tacgia` (`maTacGia`, `tenTacGia`, `gioiTinh`, `namSinh`, `hienThi`) VALUES
(1, '12123123', 'Nam', 1991, 1);

-- --------------------------------------------------------

--
-- Table structure for table `taikhoan`
--

CREATE TABLE `taikhoan` (
  `maNhanVien` int NOT NULL,
  `tenDangNhap` varchar(45) NOT NULL,
  `matKhau` varchar(20) NOT NULL,
  `hienThi` tinyint DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `taikhoan`
--

INSERT INTO `taikhoan` (`maNhanVien`, `tenDangNhap`, `matKhau`, `hienThi`) VALUES
(1, 'hung', '123', 1),
(2, 'nv', '123', 1);

-- --------------------------------------------------------

--
-- Table structure for table `theloai`
--

CREATE TABLE `theloai` (
  `maTheLoai` int NOT NULL,
  `tenTheLoai` varchar(512) NOT NULL,
  `hienThi` tinyint DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `theloai`
--

INSERT INTO `theloai` (`maTheLoai`, `tenTheLoai`, `hienThi`) VALUES
(1, '213123', 1),
(2, '21312312', 1),
(3, '1231321', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chitietphieuban`
--
ALTER TABLE `chitietphieuban`
  ADD PRIMARY KEY (`maPhieuBan`,`maSach`);

--
-- Indexes for table `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  ADD PRIMARY KEY (`maPhieuNhap`,`maSach`);

--
-- Indexes for table `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`maKhachHang`,`soDienThoai`);

--
-- Indexes for table `khuyenmai`
--
ALTER TABLE `khuyenmai`
  ADD PRIMARY KEY (`maKhuyenMai`);

--
-- Indexes for table `nhacungcap`
--
ALTER TABLE `nhacungcap`
  ADD PRIMARY KEY (`maNhaCungCap`);

--
-- Indexes for table `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`maNhanVien`);

--
-- Indexes for table `nhaxuatban`
--
ALTER TABLE `nhaxuatban`
  ADD PRIMARY KEY (`maNhaXuatBan`);

--
-- Indexes for table `phieuban`
--
ALTER TABLE `phieuban`
  ADD PRIMARY KEY (`maPhieuBan`);

--
-- Indexes for table `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD PRIMARY KEY (`maPhieuNhap`),
  ADD KEY `maNhanVien_idx` (`maNhanVien`);

--
-- Indexes for table `sach`
--
ALTER TABLE `sach`
  ADD PRIMARY KEY (`maSach`),
  ADD KEY `maTheLoai_idx` (`maTheLoai`);

--
-- Indexes for table `tacgia`
--
ALTER TABLE `tacgia`
  ADD PRIMARY KEY (`maTacGia`);

--
-- Indexes for table `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`tenDangNhap`),
  ADD KEY `maNhanVien_taikhoan_idx` (`maNhanVien`);

--
-- Indexes for table `theloai`
--
ALTER TABLE `theloai`
  ADD PRIMARY KEY (`maTheLoai`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `chitietphieuban`
--
ALTER TABLE `chitietphieuban`
  MODIFY `maPhieuBan` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  MODIFY `maPhieuNhap` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `khachhang`
--
ALTER TABLE `khachhang`
  MODIFY `maKhachHang` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `khuyenmai`
--
ALTER TABLE `khuyenmai`
  MODIFY `maKhuyenMai` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `nhacungcap`
--
ALTER TABLE `nhacungcap`
  MODIFY `maNhaCungCap` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `nhanvien`
--
ALTER TABLE `nhanvien`
  MODIFY `maNhanVien` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `nhaxuatban`
--
ALTER TABLE `nhaxuatban`
  MODIFY `maNhaXuatBan` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `phieuban`
--
ALTER TABLE `phieuban`
  MODIFY `maPhieuBan` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `phieunhap`
--
ALTER TABLE `phieunhap`
  MODIFY `maPhieuNhap` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `sach`
--
ALTER TABLE `sach`
  MODIFY `maSach` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `tacgia`
--
ALTER TABLE `tacgia`
  MODIFY `maTacGia` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `theloai`
--
ALTER TABLE `theloai`
  MODIFY `maTheLoai` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `sach`
--
ALTER TABLE `sach`
  ADD CONSTRAINT `pk_sach_tl` FOREIGN KEY (`maTheLoai`) REFERENCES `theloai` (`maTheLoai`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
