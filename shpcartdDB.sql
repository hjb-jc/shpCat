
create database ShpCartDB;

use ShpCartDB;

create table User
(
	u_id integer primary key,
    u_name varchar(10) not null,
    u_pwd varchar(10)
);

insert into User values(1,"admin",999);
insert into User values(2,"张三",333);
insert into User values(3,"李四",444);

select * from User; #查询


create table regInfo  #注册表
(				
	r_id integer auto_increment primary key ,
    r_number text not null,		#账号
    r_nubHpone text not null ,		#手机号码
    r_pwd varchar(20) not null,		#密码
    r_main text not null			#邮件
);
drop table regInfo;

insert into regInfo values(1,"123","12345678911","123","123");
insert into regInfo values(2,"123","12345678911","123","123");

create table typeProducts
(
	t_id integer auto_increment primary key,
    t_name text not null
);
insert into typeProducts values(1,"电脑");
insert into typeProducts(t_name) values("手机");
insert into typeProducts(t_name) values("家店");
insert into typeProducts(t_name) values("食品");
insert into typeProducts(t_name) values("汽车");
select * from typeProducts;

create table infoProducts
(
	i_id integer auto_increment primary key, -- 产品信息id
    t_id integer not null,
    foreign key(t_id)references typeProducts (t_id) on update cascade on delete cascade,
    i_name varchar(20) not null,
    i_price decimal not null,
    i_info text default null, 
    i_img text default null
);
insert into infoProducts values(1,1,"台式电脑",3430.00,"联想台式电脑扬天T4900D/启天M410/B415/M2601K/E75 主机全套整机","/img/1.jpg");
insert into infoProducts values(2,2,"手机",8028.00,"上海自提可闪送Apple/苹果 iPhone X 国行全网通苹果10手机A1865","/img/2.jpg");
insert into infoProducts values(3,3,"家店",648.00,"质鼎商用电饭锅饭店酒店公司食堂大容量大电饭煲13l16L升20-30人","/img/3.jpg");
insert into infoProducts values(4,4,"食品",54.05,"手工网红辣条9种 豆丝大辣片豆皮 儿时麻辣 小吃 零食湖南 重庆","/img/4.jpg");
insert into infoProducts values(5,5,"汽车",2680.00,"法拉利儿童车电动四轮带遥控男女宝宝小孩玩具汽车可坐人充电跑车
法拉利正版授权 原装皮座椅 高端烤漆","/img/5.jpg");
delete from infoProducts where i_id=2;
drop table infoProducts; 
select * from infoProducts;
select * from  typeProducts as t , infoProducts as i where t.t_id= i.t_id;

select * from typeProducts as t , infoProducts as i where t.t_id= i.t_id=1;

select * from infoProducts where t_id=(select t_id from typeProducts where t_name='电脑' ); 

select * from bank_branch_number where bankName like '%工商%' and provinceName like '%江苏%' and cityName like '%苏州%' and bankFullName like '%盛泽支行%' ;

select * from infoProducts where i_name like '%手%' or i_id like '%2%' or i_price like '%50%'; 

create table gatherCar	#购物车
(
	g_id integer auto_increment primary key ,
    i_id integer not null,	#商品信息id
    u_id integer not null, #用户id
    foreign key(i_id) references infoProducts(i_id) on update cascade on delete cascade,
    foreign key(u_id) references User(u_id) on update cascade on delete cascade,
    g_quantity int not null,  #数量
    g_amount decimal not null  #金额
);

drop table gatherCar;
delete from gatherCar where g_id=2;

select * from gatherCar;

insert into gatherCar values(1,1,1,1,3333.33);
insert into gatherCar values(2,2,2,2,6666.66);


select * from  User as u , infoProducts as i, gatherCar as g where u.t_id= i.t_id= g.g_id;





