## SpringMyBatisProject

#### git 주소
https://github.com/kimsunbal/SpringMyBatisProject

#### Main 화면
![메인화면](https://user-images.githubusercontent.com/50560637/70209604-0b36b000-1774-11ea-98b9-9e3d58b58ac8.png)

#### My sql 사용자 생성, 데이터베이스 생성 및 테이블 생성
1. 사용자 생성 및 데이터베이스 생성
```sql
create user 'mbatis'@'%' identified by 'bitc5600';
grant all privileges on *.* to 'mbatis'@'%';
create database mbatis;
use mbatis;
show tables;
```
2. 테이블 생성
```sql
create table user(
	id int AUTO_INCREMENT PRIMARY KEY,
    username varchar(50) UNIQUE KEY,
    password varchar(50),
    email varchar(50)
    ) engine=InnoDB default charset=utf8;
```

```sql
CREATE TABLE board (
  id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  title varchar(100) NOT NULL,
  content longtext,
  userId int,
  createDate timestamp,
  readCount int DEFAULT 0
) engine=InnoDB default charset=utf8;
```
