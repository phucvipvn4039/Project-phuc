raiserror('Creating CarStore database....',0,1)
SET NOCOUNT ON
GO
USE [master]
GO
CREATE DATABASE [CarStore]
GO
USE [CarStore]
GO
CREATE TABLE [dbo].[Category](
	[id] [int] IDENTITY(1,1) PRIMARY KEY NOT NULL,
	[name] [varchar](50) NOT NULL
)
GO
CREATE TABLE [dbo].[Product](
	[id] [int] IDENTITY(1,1) PRIMARY KEY NOT NULL,
	[description] [varchar](50) NOT NULL,
	[price] [float] NOT NULL,
	[discount] [float] NOT NULL,
	[categoryId] [int] references Category(id) NOT NULL
)
GO
CREATE TABLE [dbo].[Account](
	[id] [int] IDENTITY(1,1) PRIMARY KEY NOT NULL,
	[name] [varchar](50) NOT NULL,
	[address] [varchar](50) NOT NULL,
	[phone] [varchar](12) NOT NULL,
	[email] [varchar](30) NOT NULL,
	--password: default = 1
	[password] [char](64) NOT NULL default('6B86B273FF34FCE19D6B804EFF5A3F5747ADA4EAA22F1D49C01E52DDB7875B4B'),
	[enabled] [bit] NOT NULL default(1),
	[role] [varchar](255) NOT NULL
)
GO
CREATE TABLE [dbo].[Customer](
	[id] [int] PRIMARY KEY references [Account](id) NOT NULL,
	[category] varchar(50) NOT NULL CHECK([category] IN ('Gold','Silver','Copper')),
	[shipToAddress] [varchar](50) NOT NULL
)
GO
CREATE TABLE [dbo].[Employee](
	[id] [int] PRIMARY KEY references [Account](id) NOT NULL,
	[salary] [money] NOT NULL,
	[departmentId] [int] NOT NULL
)
GO
CREATE TABLE [dbo].[OrderHeader](
	[id] [int] IDENTITY(1,1) PRIMARY KEY NOT NULL,
	[date] [datetime] NOT NULL,
	[status] [varchar](30) NULL,
	[customerId] [int] references Customer(id) NOT NULL,
	[employeeId] [int] references Employee(id) NOT NULL
)
GO
CREATE TABLE [dbo].[OrderDetail](
	[id] [int] IDENTITY(1,1) PRIMARY KEY NOT NULL,
	[orderHeaderId] [int] references OrderHeader(id) NOT NULL,
	[productId] [int] references Product(id) NOT NULL,
	[quantity] [int] NOT NULL,
	[price] [float] NOT NULL,
	[discount] [float] NOT NULL
)
GO
SET IDENTITY_INSERT [dbo].[Category] ON 

INSERT [dbo].[Category] ([id], [name]) VALUES (1, N'SUV')
INSERT [dbo].[Category] ([id], [name]) VALUES (2, N'Sedan')
INSERT [dbo].[Category] ([id], [name]) VALUES (3, N'PickUpTruck')
SET IDENTITY_INSERT [dbo].[Category] OFF
SET IDENTITY_INSERT [dbo].[Product] ON 

INSERT [dbo].[Product] ([id], [description], [price], [discount], [categoryId]) VALUES (1, N'SUV 1', 42000, 0.1, 1)
INSERT [dbo].[Product] ([id], [description], [price], [discount], [categoryId]) VALUES (2, N'SUV 2', 40000, 0.05, 1)
INSERT [dbo].[Product] ([id], [description], [price], [discount], [categoryId]) VALUES (3, N'SUV 3', 41000, 0.05, 1)
INSERT [dbo].[Product] ([id], [description], [price], [discount], [categoryId]) VALUES (4, N'SUV 4', 43000, 0, 1)
INSERT [dbo].[Product] ([id], [description], [price], [discount], [categoryId]) VALUES (5, N'SUV 5', 45000, 0.15, 1)
INSERT [dbo].[Product] ([id], [description], [price], [discount], [categoryId]) VALUES (6, N'SUV 6', 45000, 0.1, 1)
INSERT [dbo].[Product] ([id], [description], [price], [discount], [categoryId]) VALUES (7, N'SUV 7', 46000, 0.1, 1)
INSERT [dbo].[Product] ([id], [description], [price], [discount], [categoryId]) VALUES (8, N'SUV 8', 47000, 0.1, 1)
INSERT [dbo].[Product] ([id], [description], [price], [discount], [categoryId]) VALUES (9, N'SUV 9', 39000, 0, 1)
INSERT [dbo].[Product] ([id], [description], [price], [discount], [categoryId]) VALUES (10, N'SUV 10', 50000, 0.1, 1)
INSERT [dbo].[Product] ([id], [description], [price], [discount], [categoryId]) VALUES (11, N'SUV 11', 45000, 0.05, 1)
INSERT [dbo].[Product] ([id], [description], [price], [discount], [categoryId]) VALUES (12, N'SUV 12', 46000, 0.15, 1)
INSERT [dbo].[Product] ([id], [description], [price], [discount], [categoryId]) VALUES (13, N'SUV 13', 47000, 0.05, 1)
INSERT [dbo].[Product] ([id], [description], [price], [discount], [categoryId]) VALUES (14, N'SUV 14', 43000, 0.05, 1)
INSERT [dbo].[Product] ([id], [description], [price], [discount], [categoryId]) VALUES (15, N'SUV 15', 41200, 0.1, 1)
INSERT [dbo].[Product] ([id], [description], [price], [discount], [categoryId]) VALUES (16, N'SUV 16', 45000, 0.05, 1)
INSERT [dbo].[Product] ([id], [description], [price], [discount], [categoryId]) VALUES (17, N'SUV 17', 47000, 0.1, 1)
INSERT [dbo].[Product] ([id], [description], [price], [discount], [categoryId]) VALUES (18, N'SUV 18', 48000, 0, 1)
INSERT [dbo].[Product] ([id], [description], [price], [discount], [categoryId]) VALUES (19, N'SUV 19', 49000, 0.15, 1)
INSERT [dbo].[Product] ([id], [description], [price], [discount], [categoryId]) VALUES (20, N'SUV 20', 200000, 0.05, 1)
INSERT [dbo].[Product] ([id], [description], [price], [discount], [categoryId]) VALUES (21, N'SUV 21', 260000, 0.05, 1)
INSERT [dbo].[Product] ([id], [description], [price], [discount], [categoryId]) VALUES (22, N'SUV 22', 270000, 0.05, 1)
INSERT [dbo].[Product] ([id], [description], [price], [discount], [categoryId]) VALUES (23, N'SUV 23', 215000, 0.1, 1)
INSERT [dbo].[Product] ([id], [description], [price], [discount], [categoryId]) VALUES (24, N'SUV 24', 200000, 0.05, 1)
INSERT [dbo].[Product] ([id], [description], [price], [discount], [categoryId]) VALUES (25, N'Sedan 25', 20000, 0.1, 2)
INSERT [dbo].[Product] ([id], [description], [price], [discount], [categoryId]) VALUES (26, N'Sedan 26', 25000, 0.1, 2)
INSERT [dbo].[Product] ([id], [description], [price], [discount], [categoryId]) VALUES (27, N'Sedan 27', 35000, 0.05, 2)
INSERT [dbo].[Product] ([id], [description], [price], [discount], [categoryId]) VALUES (28, N'Sedan 28', 32000, 0.05, 2)
INSERT [dbo].[Product] ([id], [description], [price], [discount], [categoryId]) VALUES (29, N'Sedan 29', 40000, 0, 2)
INSERT [dbo].[Product] ([id], [description], [price], [discount], [categoryId]) VALUES (30, N'Sedan 30', 31000, 0.05, 2)
INSERT [dbo].[Product] ([id], [description], [price], [discount], [categoryId]) VALUES (31, N'Sedan 31', 36000, 0.05, 2)
INSERT [dbo].[Product] ([id], [description], [price], [discount], [categoryId]) VALUES (32, N'Sedan 32', 32000, 0.05, 2)
INSERT [dbo].[Product] ([id], [description], [price], [discount], [categoryId]) VALUES (33, N'Sedan 33', 29000, 0.05, 2)
INSERT [dbo].[Product] ([id], [description], [price], [discount], [categoryId]) VALUES (34, N'Sedan 34', 28000, 0.1, 2)
INSERT [dbo].[Product] ([id], [description], [price], [discount], [categoryId]) VALUES (35, N'Sedan 35', 35000, 0.05, 2)
INSERT [dbo].[Product] ([id], [description], [price], [discount], [categoryId]) VALUES (36, N'Sedan 36', 38000, 0.05, 2)
INSERT [dbo].[Product] ([id], [description], [price], [discount], [categoryId]) VALUES (37, N'PickUpTruck 37', 30000, 0.05, 3)
INSERT [dbo].[Product] ([id], [description], [price], [discount], [categoryId]) VALUES (38, N'PickUpTruck 38', 35000, 0.1, 3)
INSERT [dbo].[Product] ([id], [description], [price], [discount], [categoryId]) VALUES (39, N'PickUpTruck 39', 28000, 0, 3)
INSERT [dbo].[Product] ([id], [description], [price], [discount], [categoryId]) VALUES (40, N'PickUpTruck 40', 29000, 0, 3)
INSERT [dbo].[Product] ([id], [description], [price], [discount], [categoryId]) VALUES (41, N'PickUpTruck 41', 34000, 0.1, 3)
INSERT [dbo].[Product] ([id], [description], [price], [discount], [categoryId]) VALUES (42,	N'PickUpTruck 42', 31000, 0.05, 3)
INSERT [dbo].[Product] ([id], [description], [price], [discount], [categoryId]) VALUES (43, N'PickUpTruck 43', 30000, 0.05, 3)
INSERT [dbo].[Product] ([id], [description], [price], [discount], [categoryId]) VALUES (44, N'PickUpTruck 44', 170000, 0, 3)
INSERT [dbo].[Product] ([id], [description], [price], [discount], [categoryId]) VALUES (45, N'PickUpTruck 45', 200000, 0.05, 3)
SET IDENTITY_INSERT [dbo].[Product] OFF

SET IDENTITY_INSERT [dbo].[Account] ON 
INSERT [dbo].[Account] ([id], [name], [address], [phone], [email], [role]) VALUES
(1, N'Admin', N'9652 Los Angeles', N'0123456789', N'a@petstore.com', 'ROLE_ADMIN'),
(2, N'Employee1', N'5747 Shirley Drive', N'1234567890', N'e1@petstore.com', 'ROLE_EMPLOYEE'),
(3, N'Employee2', N'3841 Silver Oaks Place', N'2345678901', N'e2@petstore.com', 'ROLE_EMPLOYEE'),
(4, N'Customer1', N'1873 Lion Circle', N'5678901234', N'c1@gmail.com','ROLE_CUSTOMER'),
(5, N'Customer2', N'5747 Shirley Drive', N'6789872314', N'c2@gmail.com', 'ROLE_CUSTOMER')
SET IDENTITY_INSERT [dbo].[Account] OFF

INSERT [dbo].[Customer] ([id], [category], [shipToAddress]) VALUES (4, 'Copper', N'1873 Lion Circle')
INSERT [dbo].[Customer] ([id], [category], [shipToAddress]) VALUES (5, 'Copper', N'5747 Shirley Drive')

INSERT [dbo].[Employee] ([id], [salary], [departmentId]) VALUES 
(1, 1200, 1),(2, 1000, 2),(3, 800, 2)
GO
SET NOCOUNT OFF
raiserror('The CarStore database in now ready for use.',0,1)
GO

