
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
DROP TABLE IF EXISTS `Artwork`;
DROP TABLE IF EXISTS `Hall`;
DROP TABLE IF EXISTS `Ticket`;
DROP VIEW IF EXISTS `v_reserve`;
DROP VIEW IF EXISTS `v_ticket`;
DROP VIEW IF EXISTS `v_TradeInfo`;


-- 艺术家表
CREATE TABLE Artist(
Ano INT PRIMARY KEY,-- 展商编号
Aname CHAR(20) NOT NULL,-- 姓名
Aid CHAR(18) NOT NULL UNIQUE,-- 身份证号
Amajor CHAR(20),-- 专业
Aworkplace CHAR(20),-- 工作单位
Atel CHAR(11)-- 手机号
);

INSERT INTO `Artist` VALUES (1,'牛伟明','233233200001011010','书法家','HIT',18888888888);

-- 艺术品表
CREATE TABLE Artwork(
AWno INT PRIMARY KEY,-- 展品编号
AWname CHAR(20),-- 展品名称
AWkind CHAR(10),-- 类别
AWprice INT,-- 售价
AWSold TINYINT -- 售出状态
);

INSERT INTO `Artwork` VALUES (1,'龙飞凤舞','书法',100,0),(2,'天道酬勤','书法',200,0);

-- 展厅表
CREATE TABLE Hall(
Hno INT PRIMARY KEY,-- 展馆编号
Hname CHAR(20),-- 展厅名称
Harea INT,-- 面积
Hadd CHAR(20),-- 地址
Hperpson CHAR(20),-- 负责人
Hnum INT-- 展位数
);

INSERT INTO `Hall` VALUES (1,'梅',50,'画廊1楼东','Adam',10),(2,'兰',50,'画廊1楼西','张六',10);


-- 门票预定表
CREATE TABLE Ticket
(Tno CHAR(6) PRIMARY KEY,-- 取票码
Tname CHAR(20),-- 姓名
Tsex CHAR(5) CHECK (Tsex IN ('男','女')),-- 性别
Twork CHAR(10),-- 职业
Tprice INT, -- 价格
Ename CHAR(10)-- 展会名称
);

-- 展会信息表
CREATE TABLE ExhibitionInfo
(EIno INT PRIMARY KEY,-- 信息编号
Ename CHAR(20),-- 展会名称
Ano INT,-- 艺术家编号
AWno INT,-- 艺术品编号
Hno INT,-- 展馆编号
Mtime DATE,-- 时间
FOREIGN KEY(Ano) REFERENCES Artist(Ano),
FOREIGN KEY(AWno) REFERENCES ArtWork(AWno));

INSERT INTO `ExhibitionInfo` VALUES (1,'书法大展',1,1,1,'2019-06-01');

-- 购买信息表
CREATE TABLE TradeInfo
(TIno INT PRIMARY KEY,-- 订单编号
TIname CHAR(20),-- 姓名
AWno INT,-- 艺术品编号
TItime DATE,-- 采购时间
FOREIGN KEY(AWno) REFERENCES ArtWork(AWno));

-- 展馆预定表
CREATE TABLE Reserve
(Rno INT PRIMARY KEY,-- 订单编号
Hno INT,-- 展馆编号
Ano INT,-- 艺术家编号
Aname CHAR(20),-- 艺术家姓名
Rtime DATE NOT NULL,-- 时间
Rnum INT NOT NULL,-- 展位数
FOREIGN KEY(Hno) REFERENCES Hall(Hno),
FOREIGN KEY(Ano) REFERENCES Artist(Ano));

-- 创建视图
CREATE VIEW v_reserve(no,h_name,name,time,num) AS SELECT Reserve.Rno,Hall.Hname,Reserve.Aname,Reserve.Rtime,Reserve.Rnum FROM Reserve,Hall WHERE Hall.Hno = Reserve.Hno;

CREATE VIEW v_ticket(no,t_name,sex,work,e_name,H_name,price) AS SELECT Tno,Tname,Tsex,Twork,ExhibitionInfo.Ename,Hname,Ticket.Tprice FROM Ticket,ExhibitionInfo,Hall WHERE Ticket.Ename = ExhibitionInfo.Ename and ExhibitionInfo.Hno = Hall.Hno;

CREATE VIEW v_TradeInfo (no,T_name,aw_name,kind,time,price) AS SELECT TradeInfo.TIno,TradeInfo.TIname,Artwork.AWname,Artwork.AWkind,TradeInfo.TItime,Artwork.AWprice FROM  TradeInfo,Artwork WHERE TradeInfo.AWno = Artwork.AWno;