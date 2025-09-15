# BonBonCoffee
Lebron Brand Coffee App

Literally what it is, yes. Coded in Netbeans and is connected to an SQL Database


Pretty dang cool

Here's the link to all the diagrams for this project: https://drive.google.com/file/d/17c8Nc03uZjd-ZBc57WcAlevTvrve23zp/view?usp=sharing

Use draw.io to see in more details
# How does it work?
# =====================================
# Programming Guidelines:
Feature Development
The project is developed in Java (NetBeans Maven project), using SQL Server.

The source code is organized according to the following structure:

- views: contains user interface forms (Swing)

- models: contains data classes (DTO)

- services: handles business logic and database queries

- images: contains image resources for the user interface

Adheres to the principle of separating the interface from business logic.
Variable names, classes, and methods must be clearly named; important code sections should include comments.
# Management:

- Invoices: (store invoices, print invoices, cancel invoices, manage the list of invoices).

- Orders: (view order list, update order status, cancel orders).

- Products & Menu: (add, edit, delete products in the menu, manage product categories).

- Customers: (manage customer information, manage membership cards, issue discount codes).

- Employees: (manage employee information, attendance tracking).

- Promotions & Discount Codes: (manage list of promotions, manage discount codes).

# Ordering & Payment at Counter:

- Employees place orders and process payments directly at the counter.

# Statistics:

- Revenue by day, month, year (total store revenue, revenue by product).

- Number of orders and customers over time (number of returning customers, orders during peak hours).

- Detailed invoice summaries and promotional programs (effectiveness of discount campaigns).

# Security:

- The software is designed for two types of users: managers and employees, with the following security requirements:

- All users must log in to use the system.

- Managers can perform all functions.

- Employees are not allowed to delete invoices or view revenue.

# Technology:

- The application must be developed on the Apache NetBeans platform.

- JDK: 23

- Database Management System: SQL Server 2022
# =====================================
# Interface design for functions:

- Load form:

   ![image alt](https://github.com/TingleDinkle/BonBonCoffee/blob/24bfb0f2aa0f41a82877751694f5b2ffe32042e5/unnamed.png)

- Introduction form:

   ![image alt](https://github.com/TingleDinkle/BonBonCoffee/blob/520546b1e2d7b98f0e6f863dd8ef2bbb5289f978/unnamed%20(1).png)

- Login Form:

  ![image alt](https://github.com/TingleDinkle/BonBonCoffee/blob/520546b1e2d7b98f0e6f863dd8ef2bbb5289f978/unnamed%20(2).png)
  
- Change Password Form:

   ![image alt](https://github.com/TingleDinkle/BonBonCoffee/blob/520546b1e2d7b98f0e6f863dd8ef2bbb5289f978/unnamed%20(3).png)

- Main Interface Form:

  ![image alt](https://github.com/TingleDinkle/BonBonCoffee/blob/520546b1e2d7b98f0e6f863dd8ef2bbb5289f978/unnamed%20(4).png)
  ![image alt](https://github.com/TingleDinkle/BonBonCoffee/blob/520546b1e2d7b98f0e6f863dd8ef2bbb5289f978/unnamed%20(5).png)
  ![image alt](https://github.com/TingleDinkle/BonBonCoffee/blob/520546b1e2d7b98f0e6f863dd8ef2bbb5289f978/unnamed%20(6).png)
  ![image alt](https://github.com/TingleDinkle/BonBonCoffee/blob/520546b1e2d7b98f0e6f863dd8ef2bbb5289f978/unnamed%20(7).png)
  ![image alt](https://github.com/TingleDinkle/BonBonCoffee/blob/520546b1e2d7b98f0e6f863dd8ef2bbb5289f978/unnamed%20(8).png)
  

- Employee Management Form:

  ![image alt](https://github.com/TingleDinkle/BonBonCoffee/blob/520546b1e2d7b98f0e6f863dd8ef2bbb5289f978/unnamed%20(9).png)

- Customer Management Form:

  ![image alt](https://github.com/TingleDinkle/BonBonCoffee/blob/520546b1e2d7b98f0e6f863dd8ef2bbb5289f978/unnamed%20(10).png)

- Order Management Form:

  ![image alt](https://github.com/TingleDinkle/BonBonCoffee/blob/520546b1e2d7b98f0e6f863dd8ef2bbb5289f978/unnamed%20(11).png)

- Products Management Form:

  ![image alt](https://github.com/TingleDinkle/BonBonCoffee/blob/520546b1e2d7b98f0e6f863dd8ef2bbb5289f978/unnamed%20(12).png)

- Storage Management Form:

  ![image alt](https://github.com/TingleDinkle/BonBonCoffee/blob/520546b1e2d7b98f0e6f863dd8ef2bbb5289f978/unnamed%20(13).png)

- Bill Management Form:

  ![image alt](https://github.com/TingleDinkle/BonBonCoffee/blob/520546b1e2d7b98f0e6f863dd8ef2bbb5289f978/unnamed%20(14).png)

- Bill Details Nanagement Form:

  ![image alt](https://github.com/TingleDinkle/BonBonCoffee/blob/520546b1e2d7b98f0e6f863dd8ef2bbb5289f978/unnamed%20(15).png)

- Revenual Statistics Form:

  ![image alt](https://github.com/TingleDinkle/BonBonCoffee/blob/520546b1e2d7b98f0e6f863dd8ef2bbb5289f978/unnamed%20(16).png)
# ===================================== 
# Creating Database:
Table User:
```bash
create table NguoiDung(
	MaND int not null primary key identity(1,1),
	TenDangNhap nvarchar(100) not null,
	MatKhau varchar(50) not null,
	VaiTro bit not null,
)
```
Table Customer:
```bash
create table KhachHang(
	MaKH char(5) not null primary key,
	TenKH nvarchar(100) not null,
	Tuoi int not null,
	GioiTinh bit not null,
	SDT char(10) not null,
)
```
Table Employee:
```bash
create table NhanVien(
	MaNV char(5) not null primary key,
	HoTenNV nvarchar(100) not null,
	VaiTro nvarchar(100) not null,
	Tuoi int not null,
	SDT char(10) not null,
	GioiTinh bit not null,
)
```
Table Storage:
```bash
create table Kho(
	MaNL char(5) not null primary key,
	TenNL nvarchar(100) not null,
	SoLuong float not null,
	DonVi nvarchar(100) not null,
)
```
Table Products:
```bash
create table SanPham(
	MaSP char(5) not null primary key,
	MaNL char(5) not null,
	TenSP nvarchar(100) not null,
	GiaTien money not null,
	MoTa nvarchar(100) not null,
	LoaiSP nvarchar(100) not null,
	CONSTRAINT fk_SanPham_Kho FOREIGN KEY (MaNL)REFERENCES Kho(MaNL),
)
```
Table Orders:
```bash
create table DonHang(
	MaDH char(5) not null primary key,
	MaNV char(5) not null,
	MaKH char(5) not null,
	MaSP char(5) not null,
	Size char(2) not null,
	SoLuong int not null,
	NgayDatHang date not null,
	HinhThucThanhToan nvarchar(100) not null,
	TongTien money not null,
	CONSTRAINT fk_DonHang_NhanVien FOREIGN KEY (MaNV)REFERENCES NhanVien(MaNV),
	CONSTRAINT fk_DonHang_KhachHang FOREIGN KEY (MaKH)REFERENCES KhachHang(MaKH),
	CONSTRAINT fk_DonHang_SanPham FOREIGN KEY (MaSP)REFERENCES SanPham(MaSP),
)
```
Table Bills:
```bash
create table HoaDon(
	MaHD char(5) not null primary key,
	MaNV char(5) not null,
	MaDH char(5) not null,
	NgayLapHD date not null,
	GiaTien money not null,
	CONSTRAINT fk_HoaDon_NhanVien FOREIGN KEY (MaNV)REFERENCES NhanVien(MaNV),
	CONSTRAINT fk_HoaDon_DonHang FOREIGN KEY (MaDH)REFERENCES DonHang(MaDH),
)
```
Table BillDetails:
```bash
create table HoaDonChiTiet(
	MaHDCT char(5) not null primary key,
	MaHD char(5) not null,
	MaSP char(5) not null,
	SoLuongMua int not null,
	TongTienThanhToan money not null,
	CONSTRAINT fk_HoaDonChiTiet_HoaDon FOREIGN KEY (MaHD)REFERENCES HoaDon(MaHD),
	CONSTRAINT fk_HoaDonChiTiet_SanPham FOREIGN KEY (MaSP)REFERENCES SanPham(MaSP),
)
```
Procedures for saving statistics:
```bash
CREATE PROCEDURE ThongKeDoanhThuTheoNam
    @Nam INT 
AS
BEGIN
    SELECT
        MONTH(HD.NgayLapHD) AS Thang,
        SP.LoaiSP AS LoaiSanPham,
        COUNT(DISTINCT HD.MaHD) AS SoLuongDonHang,
        CONCAT(FORMAT(SUM(HDCT.TongTienThanhToan), 'N0'), N' đồng') AS TongTienBanRa
    FROM HoaDonChiTiet HDCT
    JOIN HoaDon HD ON HDCT.MaHD = HD.MaHD
    JOIN SanPham SP ON HDCT.MaSP = SP.MaSP
    WHERE YEAR(HD.NgayLapHD) = @Nam 
    GROUP BY YEAR(HD.NgayLapHD), MONTH(HD.NgayLapHD), SP.LoaiSP
    ORDER BY Thang, LoaiSanPham;
END;
EXEC ThongKeDoanhThuTheoNam @Nam = ?;

```
# =====================================
# Source Code Directory Structure:

![image alt](https://github.com/TingleDinkle/BonBonCoffee/blob/32f0c85f779fdac8dddb29b0a582ae0d84e9f687/Screenshot%202025-09-15%20133758.png)

#Testings were conducted throughly, program works as expected. I won't provide the unit testings though.

