CREATE TABLE public.bj_groups (
    id SERIAL PRIMARY KEY,
    group_name character varying(50) NOT NULL,
    group_img_path character varying(20) NOT NULL,
    group_order integer NOT NULL,
    active boolean
);
-- Создаем отдельную SEQUENCE для поля `order_number`
CREATE SEQUENCE group_order_seq;

-- Устанавливаем дефолтное значение для `order_number`
ALTER TABLE public.bj_groups
    ALTER COLUMN group_order SET DEFAULT nextval('group_order_seq');

-- Опционально: связываем SEQUENCE с таблицей (чтобы она удалялась при DROP TABLE)
ALTER SEQUENCE group_order_seq OWNED BY public.bj_groups.group_order;


insert into bj_groups (group_name,group_img_path,active) VALUES('серьги Люкс','1418.jpg','true');
insert into bj_groups (group_name,group_img_path,active) VALUES('кольца Люкс','1419.jpg','true');
insert into bj_groups (group_name,group_img_path,active) VALUES('кресты декоративные','1420.jpg','true');
insert into bj_groups (group_name,group_img_path,active) VALUES('браслеты кожаные','1421.jpg','true');
insert into bj_groups (group_name,group_img_path,active) VALUES('серьги','1422.jpg','true');
insert into bj_groups (group_name,group_img_path,active) VALUES('кольца','1423.jpg','true');
insert into bj_groups (group_name,group_img_path,active) VALUES('колье, цепи','1424.jpg','true');
insert into bj_groups (group_name,group_img_path,active) VALUES('браслеты','1425.jpg','true');
insert into bj_groups (group_name,group_img_path,active) VALUES('браслеты на ногу','1426.jpg','true');
insert into bj_groups (group_name,group_img_path,active) VALUES('броши','1427.jpg','true');
insert into bj_groups (group_name,group_img_path,active) VALUES('колье, подвески Люкс','1428.jpg','true');
insert into bj_groups (group_name,group_img_path,active) VALUES('коллекция "Дерзская"','1430.jpg','true');