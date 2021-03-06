
DROP TABLE IF EXISTS `User`;


-- 系统用户
CREATE TABLE User(
Sacc CHAR(20) PRIMARY KEY,-- 登录名
Spwd CHAR(20) NOT NULL-- 密码
);

INSERT INTO `User` VALUES (123,123456),(1234567,123456);

DROP TABLE IF EXISTS `ExhibitionInfo`;
DROP TABLE IF EXISTS `Reserve`;
DROP TABLE IF EXISTS `Artist`;
DROP TABLE IF EXISTS `TradeInfo`;
DROP TABLE IF EXISTS `Exhibition`;
DROP TABLE IF EXISTS `Artwork`;
DROP TABLE IF EXISTS `Hall`;
DROP TABLE IF EXISTS `Ticket`;
DROP VIEW IF EXISTS `v_reserve`;
DROP VIEW IF EXISTS `v_ticket`;
DROP VIEW IF EXISTS `v_TradeInfo`;
DROP VIEW IF EXISTS `v_exhibitionInfo`;


-- 艺术家表
CREATE TABLE Artist(
Ano INT PRIMARY KEY,-- 艺术家编号
Aname CHAR(20) NOT NULL,-- 姓名
Aid CHAR(18) NOT NULL UNIQUE,-- 身份证号
Amajor CHAR(20),-- 专业
Aworkplace CHAR(20),-- 工作单位
Atel CHAR(11)-- 手机号
);

INSERT INTO `Artist` VALUES (1,'牛伟明','233233200001011010','书法家','HIT',18888888888);

-- 艺术品表
CREATE TABLE Artwork(
AWno INT PRIMARY KEY,-- 艺术品编号
AWname CHAR(20),-- 艺术品名称
AWkind CHAR(10),-- 类别
AWprice INT CHECK (AWprice >= 0),-- 售价
AWsold TINYINT CHECK (AWsold IN (0, 1))-- 售出状态
);

INSERT INTO `Artwork` VALUES (1,'龙飞凤舞','书法',100,0),(2,'天道酬勤','书法',200,0);

-- 展厅表
CREATE TABLE Hall(
Hno INT PRIMARY KEY,-- 展厅编号
Hname CHAR(20),-- 展厅名称
Harea INT,-- 面积
Hadd CHAR(20),-- 地址
Hperpson CHAR(20),-- 负责人
Hnum INT-- 展位数
);

INSERT INTO `Hall` VALUES (1,'梅',50,'黄河路1号','Adam',1000),(2,'兰',50,'黄河路3号','张六',1000);
INSERT INTO `Hall` VALUES (3,'竹',70,'黄河路5号','王科',1000),(0,'菊',80,'黄河路7号','李达',1000);

CREATE TABLE Exhibition(
Eno INT PRIMARY KEY,-- 艺术展编号
Ename CHAR(20),-- 艺术展名称
Etime DATE-- 举办时间
);

INSERT INTO `Exhibition` VALUES (1,'哈尔滨书法绘画大会','2020-04-10'),(2,'山水之美','2020-05-10');
INSERT INTO `Exhibition` VALUES (3,'石头之美','2020-06-10'),(4,'生活中的艺术','2020-07-10');

-- 艺术展信息表
CREATE TABLE ExhibitionInfo(
EIno INT PRIMARY KEY,-- 信息编号
Ano INT,-- 艺术家编号
AWno INT,-- 艺术品编号
Hno INT,-- 展厅编号
Eno INT,-- 艺术展编号
EItime DATE,-- 时间
FOREIGN KEY(Ano) REFERENCES Artist(Ano),
FOREIGN KEY(AWno) REFERENCES ArtWork(AWno),
FOREIGN KEY(Hno) REFERENCES Hall(Hno),
FOREIGN KEY(Eno) REFERENCES Exhibition(Eno)
);

INSERT INTO `ExhibitionInfo` VALUES (1,1,2,1,1,'2020-04-10');

-- 门票预定表
CREATE TABLE Ticket(
Tno CHAR(6) PRIMARY KEY,-- 取票码
Tname CHAR(20),-- 姓名
Tsex CHAR(5) CHECK (Tsex IN ('男','女')),-- 性别
Twork CHAR(10),-- 职业
Tprice INT, -- 价格
Eno INT-- 艺术展编号
);

-- 购买信息表
CREATE TABLE TradeInfo(
TIno INT PRIMARY KEY,-- 订单编号
TIname CHAR(20),-- 姓名
TItime DATE,-- 采购时间
AWno INT,-- 艺术品编号
FOREIGN KEY(AWno) REFERENCES Artwork(AWno)
);

-- 展厅预定表
CREATE TABLE Reserve(
Rno INT PRIMARY KEY,-- 订单编号
Hno INT,-- 展厅编号
Ano INT,-- 艺术家编号
Rtime DATE NOT NULL,-- 时间
Rnum INT NOT NULL,-- 展位数
FOREIGN KEY(Hno) REFERENCES Hall(Hno),
FOREIGN KEY(Ano) REFERENCES Artist(Ano)
);

-- 创建视图
CREATE VIEW v_ticket(Tno,Tname,Tsex,Twork,Eno,Tprice) AS SELECT Tno,Tname,Tsex,Twork,ExhibitionInfo.Eno,Ticket.Tprice FROM Ticket,ExhibitionInfo WHERE Ticket.Eno = ExhibitionInfo.Eno;

CREATE VIEW v_TradeInfo (TIno,TIname,TItime,AWname,AWkind,AWprice) AS SELECT TradeInfo.TIno,TradeInfo.TIname,TradeInfo.TItime,Artwork.AWname,Artwork.AWkind,Artwork.AWprice FROM  TradeInfo,Artwork WHERE TradeInfo.AWno = Artwork.AWno;

CREATE VIEW v_reserve(Rno,Hname,Aname,Rtime,Rnum) AS SELECT Reserve.Rno,Hall.Hname,Artist.Aname,Reserve.Rtime,Reserve.Rnum FROM Artist,Hall,Reserve WHERE Artist.Ano = Reserve.Ano and Hall.Hno = Reserve.Hno;

CREATE VIEW v_exhibitionInfo(EIno,Aname,AWname,Hname,Ename,EItime,AWkind,AWprice) AS SELECT EIno,Artist.Aname,Artwork.AWname,Hall.Hname,Exhibition.Ename,EItime,Artwork.AWkind,Artwork.AWprice FROM Artist,Artwork,Hall,Exhibition,ExhibitionInfo WHERE ExhibitionInfo.Ano = Artist.Ano and ExhibitionInfo.AWno = Artwork.AWno and ExhibitionInfo.Hno = Hall.Hno and ExhibitionInfo.Eno = Exhibition.Eno; 

CREATE INDEX i_name on Artist (Aname);

CREATE INDEX i_kind on Artwork (AWkind);

CREATE INDEX i_price on Artwork (AWprice);