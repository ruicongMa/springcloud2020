-- 登录 MySQL 服务器
mysql -hlocalhost -uroot -pma110

-- 创建数据库 coupon_data
CREATE DATABASE IF NOT EXISTS coupon_data;

-- 登录 MySQL 服务器, 并进入到 coupon_data 数据库中
mysql -hlocalhost -uroot -pma110 -Dcoupon_data
