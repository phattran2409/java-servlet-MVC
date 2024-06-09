CREATE TABLE tbl_Mobile (
	mobileId VARCHAR(10) PRIMARY KEY,
    description VARCHAR(250) NOT NULL,
    price FLOAT,
    mobileName VARCHAR(20) NOT NULL,
    yearOfProduction INT,
    quantity INT,
    notSale BIT,
	
);

CREATE TABLE  tbl_User (
	userID varchar(20) Primary key, 
	password int NOT NULL , 
	fullName  varchar(50) NOT NULL,
	role  int
);

CREATE TABLE tbl_wishList (
	WID int not null IDENTITY (1,1) PRIMARY KEY ,
	userID varchar(20) not null ,
	mobileID varchar(10) not null,
	FOREIGN KEY (userID) references tbl_User(userID), 
	FOREIGN KEY (mobileID) references tbl_Mobile(mobileId) 
	
); 

INSERT INTO tbl_Mobile(mobileId, description, price, mobileName, yearOfProduction, quantity, notSale)
VALUES
('MOB001', 'A smartphone with a high-resolution display and fast processor', 700, 'SuperPhone X', 2022, 50, 0),
('MOB002', 'A budget-friendly phone with long battery life', 200, 'EcoPhone Lite', 2021, 100, 0),
('MOB003', 'A mid-range phone with excellent camera quality', 400, 'CapturePro Max', 2022, 75, 0),
('MOB004', 'A premium phone with 5G connectivity and sleek design', 1000, 'UltraPhone Z', 2023, 25, 1),
('MOB005', 'A compact phone with robust features', 299.99, 'MiniPhone S', 2020, 60, 0),
('MOB006', 'A durable phone with water resistance', 499.99, 'ToughPhone G', 2019, 40, 0),
('MOB007', 'An entry-level phone with all essential features', 149.99, 'BasicPhone Y', 2021, 80, 0),
('MOB008', 'A gaming phone with high refresh rate display', 799.99, 'GamePhone V', 2022, 30, 1),
('MOB009', 'A stylish phone with customizable covers', 249.99, 'StylePhone C', 2020, 55, 0),
('MOB010', 'A phone with advanced security features', 899.99, 'SecurePhone T', 2023, 20, 1);


INSERT INTO tbl_User VALUES ('Bao',1,'Hoang Bao',2);
INSERT INTO tbl_User VALUES ('Thinh',1,'Tri Thinh',1);
INSERT INTO tbl_User VALUES ('Hoa',123,'Hoang Bao',0);
INSERT INTO tbl_User VALUES ('Long',123,'Nguyen Long',0);
INSERT INTO tbl_User VALUES ('Thien',123,'The Thien',0);
INSERT INTO tbl_User VALUES ('Hung',123,'Hong Hung',0);


--INSERT tbl_wishList 
INSERT INTO tbl_wishList(userID,mobileID) VALUES ('Bao' ,'MOB001' );
INSERT INTO tbl_wishList(userID,mobileID) VALUES ('Thinh' ,'MOB002' );
INSERT INTO tbl_wishList(userID,mobileID) VALUES ('Thinh' ,'MOB001' );
INSERT INTO tbl_wishList(userID,mobileID) VALUES ('Bao' ,'MOB001' );

SELECT userID , fullName , password , role  FROM  tbl_User where userID = 'Bao' AND password = 1

SELECT mobileId , mobileName , description , price , yearOfProduction , quantity , notSale from tbl_Mobile

-- SELECT tbl_wishList 

SELECT M.mobileId , M.mobileName , M.quantity , M.price    from tbl_wishList  W  join tbl_Mobile  M  ON W.mobileID = M.mobileId  WHERE w.userID = 'Hoa'

SELECT  FROM tbl_wishList where    userID = 'Bao' AND mobileID ='mobileID'
select * from tbl_wishList where userID ='Hoa'

SELECT * FROM  tbl_wishList where mobileID= 'MOB004'

select * from tbl_wishList
select FOUND_ROWS()
--  `
DROP  TABLE tbl_wishList


-- DELETE column tbl_wishList 
DELETE from  tbl_wishList where userID ='Hoa' AND mobileID = 'MOB004'

--- \
select *  from tbl_Mobile 
ORDER BY mobileId
OFFSET 0 ROWS FETCH  NEXT 3 ROWS ONLY;

select * from tbl_Mobile


-- 3 page
select count(*) from tbl_Mobile

