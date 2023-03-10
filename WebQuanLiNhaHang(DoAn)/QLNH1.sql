USE [QLNhaHang]
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Ban](
	[BanID] [int] IDENTITY(1,1) NOT NULL,
	[KhuVucID] [int] NULL,
	[TenBan] [nvarchar](250) NULL,
	[TrangThai] [int] NULL,
 CONSTRAINT [PK_Ban] PRIMARY KEY CLUSTERED 
(
	[BanID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHoaDon](
	[ChiTietHoaDonID] [int] IDENTITY(1,1) NOT NULL,
	[MatHangID] [int] NULL,
	[HoaDonID] [uniqueidentifier] NULL,
	[KhuyenMaiID] [int] NULL,
	[SoLuong] [float] NULL,
	[Gia] [float] NULL,
	[ThanhTien] [float] NULL,
	[PhanTramKM] [int] NULL,
 CONSTRAINT [PK_ChiTietHoaDon] PRIMARY KEY CLUSTERED 
(
	[ChiTietHoaDonID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChucNang](
	[ChucNangID] [int] IDENTITY(1,1) NOT NULL,
	[MaChucNang] [nvarchar](50) NOT NULL,
	[TenChucNang] [nvarchar](100) NOT NULL,
	[NoiDung] [nvarchar](max) NULL,
 CONSTRAINT [PK_ChucNang] PRIMARY KEY CLUSTERED 
(
	[ChucNangID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChucNang_NhomQuyen](
	[NhomQuyenID] [int] NOT NULL,
	[ChucNangID] [int] NOT NULL,
	[Xem] [int] NULL,
	[Them] [int] NULL,
	[Sua] [int] NULL,
	[Xoa] [int] NULL,
 CONSTRAINT [PK_ChucNang_NhomQuyen] PRIMARY KEY CLUSTERED 
(
	[NhomQuyenID] ASC,
	[ChucNangID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[HoaDonID] [uniqueidentifier] NOT NULL,
	[BanID] [int] NULL,
	[NguoiDungID] [int] NULL,
	[TongTien] [float] NULL,
	[DaThanhToan] [int] NULL,
	[GiamTien] [float] NULL,
	[ThanhToan] [float] NULL,
	[HuyBan] [int] NULL,
	[NgayTao] [datetime] NULL,
 CONSTRAINT [PK_HoaDon_1] PRIMARY KEY CLUSTERED 
(
	[HoaDonID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhuVuc](
	[KhuVucID] [int] IDENTITY(1,1) NOT NULL,
	[TenKhuVuc] [nvarchar](250) NULL,
	[Anh] [nvarchar](max) NULL,
 CONSTRAINT [PK_KhuVuc] PRIMARY KEY CLUSTERED 
(
	[KhuVucID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhuyenMai](
	[KhuyenMaiID] [int] IDENTITY(1,1) NOT NULL,
	[MatHangID] [int] NULL,
	[TrangThai] [int] NULL,
	[PhanTramKM] [int] NULL,
	[TuNgay] [datetime] NULL,
	[DenNgay] [datetime] NULL,
 CONSTRAINT [PK_KhuyenMai] PRIMARY KEY CLUSTERED 
(
	[KhuyenMaiID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiHang](
	[LoaiHangID] [int] IDENTITY(1,1) NOT NULL,
	[TenLoaiHang] [nvarchar](250) NULL,
 CONSTRAINT [PK_LoaiHang] PRIMARY KEY CLUSTERED 
(
	[LoaiHangID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MatHang](
	[MatHangID] [int] IDENTITY(1,1) NOT NULL,
	[LoaiHangID] [int] NULL,
	[TenMatHang] [nvarchar](250) NOT NULL,
	[Gia] [float] NULL,
	[FileAnh] [nvarchar](max) NULL,
 CONSTRAINT [PK_MatHang] PRIMARY KEY CLUSTERED 
(
	[MatHangID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NguoiDung](
	[NguoiDungID] [int] IDENTITY(1,1) NOT NULL,
	[HoTen] [nvarchar](250) NULL,
	[GioiTinh] [int] NULL,
	[NgaySinh] [datetime] NULL,
	[DiaChi] [nvarchar](500) NULL,
	[SoDienThoai] [nvarchar](50) NULL,
	[Email] [nvarchar](250) NULL,
	[CMND] [nvarchar](50) NULL,
	[TenDangNhap] [nvarchar](250) NULL,
	[MatKhau] [nvarchar](250) NULL,
	[NhomQuyenID] [int] NULL,
	[AnhDaiDien] [nvarchar](max) NULL,
 CONSTRAINT [PK_NguoiDung] PRIMARY KEY CLUSTERED 
(
	[NguoiDungID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhomQuyen](
	[NhomQuyenID] [int] IDENTITY(1,1) NOT NULL,
	[TenNhomQuyen] [nvarchar](50) NULL,
	[NoiDung] [nvarchar](max) NULL,
 CONSTRAINT [PK_NhomQuyen] PRIMARY KEY CLUSTERED 
(
	[NhomQuyenID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET IDENTITY_INSERT [dbo].[Ban] ON 

INSERT [dbo].[Ban] ([BanID], [KhuVucID], [TenBan], [TrangThai]) VALUES (1, 1, N'Bàn 1', 0)
INSERT [dbo].[Ban] ([BanID], [KhuVucID], [TenBan], [TrangThai]) VALUES (2, 2, N'Bàn 2', 0)
INSERT [dbo].[Ban] ([BanID], [KhuVucID], [TenBan], [TrangThai]) VALUES (3, 1, N'Bàn 3', 1)
INSERT [dbo].[Ban] ([BanID], [KhuVucID], [TenBan], [TrangThai]) VALUES (4, 1, N'Bàn 4', 1)
INSERT [dbo].[Ban] ([BanID], [KhuVucID], [TenBan], [TrangThai]) VALUES (5, 2, N'Bàn 5', 1)
INSERT [dbo].[Ban] ([BanID], [KhuVucID], [TenBan], [TrangThai]) VALUES (6, 2, N'Bàn 6', 1)
SET IDENTITY_INSERT [dbo].[Ban] OFF
SET IDENTITY_INSERT [dbo].[ChiTietHoaDon] ON 

INSERT [dbo].[ChiTietHoaDon] ([ChiTietHoaDonID], [MatHangID], [HoaDonID], [KhuyenMaiID], [SoLuong], [Gia], [ThanhTien], [PhanTramKM]) VALUES (66, 2, N'6a1480e9-f040-410a-bf22-55948d32244b', NULL, 1, 200000, 200000, NULL)
INSERT [dbo].[ChiTietHoaDon] ([ChiTietHoaDonID], [MatHangID], [HoaDonID], [KhuyenMaiID], [SoLuong], [Gia], [ThanhTien], [PhanTramKM]) VALUES (67, 3, N'6a1480e9-f040-410a-bf22-55948d32244b', NULL, 1, 50000, 50000, NULL)
INSERT [dbo].[ChiTietHoaDon] ([ChiTietHoaDonID], [MatHangID], [HoaDonID], [KhuyenMaiID], [SoLuong], [Gia], [ThanhTien], [PhanTramKM]) VALUES (68, 2, N'0937143a-9b78-4cbe-ba45-d2cd797c5e44', NULL, 1, 200000, 200000, NULL)
INSERT [dbo].[ChiTietHoaDon] ([ChiTietHoaDonID], [MatHangID], [HoaDonID], [KhuyenMaiID], [SoLuong], [Gia], [ThanhTien], [PhanTramKM]) VALUES (69, 3, N'0937143a-9b78-4cbe-ba45-d2cd797c5e44', NULL, 3, 50000, 150000, NULL)
INSERT [dbo].[ChiTietHoaDon] ([ChiTietHoaDonID], [MatHangID], [HoaDonID], [KhuyenMaiID], [SoLuong], [Gia], [ThanhTien], [PhanTramKM]) VALUES (70, 1, N'0937143a-9b78-4cbe-ba45-d2cd797c5e44', NULL, 1, 189000, 189000, NULL)
INSERT [dbo].[ChiTietHoaDon] ([ChiTietHoaDonID], [MatHangID], [HoaDonID], [KhuyenMaiID], [SoLuong], [Gia], [ThanhTien], [PhanTramKM]) VALUES (78, 3, N'a6b45782-e018-4c76-b6d5-8ec6e23c11bb', NULL, 23, 50000, 1150000, NULL)
INSERT [dbo].[ChiTietHoaDon] ([ChiTietHoaDonID], [MatHangID], [HoaDonID], [KhuyenMaiID], [SoLuong], [Gia], [ThanhTien], [PhanTramKM]) VALUES (82, 3, N'9b19aa5e-d23a-4100-91a9-516002d43398', NULL, 25, 50000, 1250000, NULL)
INSERT [dbo].[ChiTietHoaDon] ([ChiTietHoaDonID], [MatHangID], [HoaDonID], [KhuyenMaiID], [SoLuong], [Gia], [ThanhTien], [PhanTramKM]) VALUES (83, 1, N'9b19aa5e-d23a-4100-91a9-516002d43398', 1, 7, 189000, 1323000, 10)
INSERT [dbo].[ChiTietHoaDon] ([ChiTietHoaDonID], [MatHangID], [HoaDonID], [KhuyenMaiID], [SoLuong], [Gia], [ThanhTien], [PhanTramKM]) VALUES (86, 2, N'0e0c7820-a9d7-489b-899e-f06ee89dff44', NULL, 1, 200000, 200000, NULL)
INSERT [dbo].[ChiTietHoaDon] ([ChiTietHoaDonID], [MatHangID], [HoaDonID], [KhuyenMaiID], [SoLuong], [Gia], [ThanhTien], [PhanTramKM]) VALUES (87, 1, N'a6b45782-e018-4c76-b6d5-8ec6e23c11bb', 1, 4, 189000, 756000, 10)
SET IDENTITY_INSERT [dbo].[ChiTietHoaDon] OFF
SET IDENTITY_INSERT [dbo].[ChucNang] ON 

INSERT [dbo].[ChucNang] ([ChucNangID], [MaChucNang], [TenChucNang], [NoiDung]) VALUES (1, N'QLHangHoa', N'Quản lý hàng hóa', NULL)
INSERT [dbo].[ChucNang] ([ChucNangID], [MaChucNang], [TenChucNang], [NoiDung]) VALUES (2, N'QLHoaDon', N'Quản lý hóa đơn', NULL)
SET IDENTITY_INSERT [dbo].[ChucNang] OFF
INSERT [dbo].[HoaDon] ([HoaDonID], [BanID], [NguoiDungID], [TongTien], [DaThanhToan], [GiamTien], [ThanhToan], [HuyBan], [NgayTao]) VALUES (N'8e929df9-34d8-4db8-a560-1d0f6dc5c6de', 1, 1, 7147000, 1, 10, 6432300, 0, CAST(N'2022-07-03 14:23:24.337' AS DateTime))
INSERT [dbo].[HoaDon] ([HoaDonID], [BanID], [NguoiDungID], [TongTien], [DaThanhToan], [GiamTien], [ThanhToan], [HuyBan], [NgayTao]) VALUES (N'1f23600f-7f5a-406a-993e-2271fe044db7', 1, 1, NULL, 1, NULL, NULL, 0, CAST(N'2022-07-03 15:24:25.800' AS DateTime))
INSERT [dbo].[HoaDon] ([HoaDonID], [BanID], [NguoiDungID], [TongTien], [DaThanhToan], [GiamTien], [ThanhToan], [HuyBan], [NgayTao]) VALUES (N'2ef15754-480f-45ba-bb5b-25ecf77d9188', 3, 1, NULL, 1, NULL, NULL, 0, CAST(N'2022-07-03 14:49:29.723' AS DateTime))
INSERT [dbo].[HoaDon] ([HoaDonID], [BanID], [NguoiDungID], [TongTien], [DaThanhToan], [GiamTien], [ThanhToan], [HuyBan], [NgayTao]) VALUES (N'511839e3-414a-4821-adc4-2fa1e5ae8479', 1, 1, NULL, 1, NULL, NULL, 0, CAST(N'2022-07-03 11:27:09.437' AS DateTime))
INSERT [dbo].[HoaDon] ([HoaDonID], [BanID], [NguoiDungID], [TongTien], [DaThanhToan], [GiamTien], [ThanhToan], [HuyBan], [NgayTao]) VALUES (N'f5a42f7d-fb8b-4e97-acfe-340c7be9c235', 1, 1, NULL, 1, NULL, NULL, 0, CAST(N'2022-07-03 15:00:59.927' AS DateTime))
INSERT [dbo].[HoaDon] ([HoaDonID], [BanID], [NguoiDungID], [TongTien], [DaThanhToan], [GiamTien], [ThanhToan], [HuyBan], [NgayTao]) VALUES (N'b3069d23-59ef-41ed-b8a9-4773d915a410', 1, 1, NULL, 1, NULL, NULL, 0, CAST(N'2022-07-03 11:28:14.487' AS DateTime))
INSERT [dbo].[HoaDon] ([HoaDonID], [BanID], [NguoiDungID], [TongTien], [DaThanhToan], [GiamTien], [ThanhToan], [HuyBan], [NgayTao]) VALUES (N'9b19aa5e-d23a-4100-91a9-516002d43398', 5, 1, 539000, 0, NULL, NULL, 0, CAST(N'2022-07-03 15:04:33.450' AS DateTime))
INSERT [dbo].[HoaDon] ([HoaDonID], [BanID], [NguoiDungID], [TongTien], [DaThanhToan], [GiamTien], [ThanhToan], [HuyBan], [NgayTao]) VALUES (N'6a1480e9-f040-410a-bf22-55948d32244b', 1, 1, 250000, 1, 10, 225000, 0, CAST(N'2022-07-03 23:24:36.270' AS DateTime))

SET IDENTITY_INSERT [dbo].[KhuVuc] ON 

INSERT [dbo].[KhuVuc] ([KhuVucID], [TenKhuVuc], [Anh]) VALUES (1, N'Khu A', NULL)
INSERT [dbo].[KhuVuc] ([KhuVucID], [TenKhuVuc], [Anh]) VALUES (2, N'Khu B', NULL)
INSERT [dbo].[KhuVuc] ([KhuVucID], [TenKhuVuc], [Anh]) VALUES (3, N'Khu C', NULL)
SET IDENTITY_INSERT [dbo].[KhuVuc] OFF
SET IDENTITY_INSERT [dbo].[KhuyenMai] ON 

INSERT [dbo].[KhuyenMai] ([KhuyenMaiID], [MatHangID], [TrangThai], [PhanTramKM], [TuNgay], [DenNgay]) VALUES (1, 1, 1, 10, CAST(N'2018-07-11 00:00:00.000' AS DateTime), CAST(N'2018-07-17 00:00:00.000' AS DateTime))
SET IDENTITY_INSERT [dbo].[KhuyenMai] OFF
SET IDENTITY_INSERT [dbo].[LoaiHang] ON 

INSERT [dbo].[LoaiHang] ([LoaiHangID], [TenLoaiHang]) VALUES (1, N'Thịt')
INSERT [dbo].[LoaiHang] ([LoaiHangID], [TenLoaiHang]) VALUES (2, N'Cá')
INSERT [dbo].[LoaiHang] ([LoaiHangID], [TenLoaiHang]) VALUES (3, N'Rau')
SET IDENTITY_INSERT [dbo].[LoaiHang] OFF
SET IDENTITY_INSERT [dbo].[MatHang] ON 

INSERT [dbo].[MatHang] ([MatHangID], [LoaiHangID], [TenMatHang], [Gia], [FileAnh]) VALUES (1, 1, N'Thịt Hun Khói', 189000, NULL)
INSERT [dbo].[MatHang] ([MatHangID], [LoaiHangID], [TenMatHang], [Gia], [FileAnh]) VALUES (2, 2, N'Cá Hấp', 200000, NULL)
INSERT [dbo].[MatHang] ([MatHangID], [LoaiHangID], [TenMatHang], [Gia], [FileAnh]) VALUES (3, 3, N'Bí Xào', 50000, NULL)
SET IDENTITY_INSERT [dbo].[MatHang] OFF
SET IDENTITY_INSERT [dbo].[NguoiDung] ON 

INSERT [dbo].[NguoiDung] ([NguoiDungID], [HoTen], [GioiTinh], [NgaySinh], [DiaChi], [SoDienThoai], [Email], [CMND], [TenDangNhap], [MatKhau], [NhomQuyenID], [AnhDaiDien]) VALUES (1, N'admin', 1, CAST(N'1995-12-29 00:00:00.000' AS DateTime), NULL, NULL, NULL, NULL, N'admin', N'ad', 4, N'/FileUpload/0-3282f7fa-5474-46e4-9db6-31a2720a6cba.jpg')
SET IDENTITY_INSERT [dbo].[NguoiDung] OFF
SET IDENTITY_INSERT [dbo].[NhomQuyen] ON 

INSERT [dbo].[NhomQuyen] ([NhomQuyenID], [TenNhomQuyen], [NoiDung]) VALUES (1, N'Administrator', N'Quản trị viên')
INSERT [dbo].[NhomQuyen] ([NhomQuyenID], [TenNhomQuyen], [NoiDung]) VALUES (2, N'Giám đốc', NULL)
INSERT [dbo].[NhomQuyen] ([NhomQuyenID], [TenNhomQuyen], [NoiDung]) VALUES (3, N'Quản lý', NULL)
INSERT [dbo].[NhomQuyen] ([NhomQuyenID], [TenNhomQuyen], [NoiDung]) VALUES (4, N'Nhân viên', NULL)
SET IDENTITY_INSERT [dbo].[NhomQuyen] OFF
