CREATE TABLE public.bj_groups (
    id SERIAL PRIMARY KEY,
    group_name character varying(50) NOT NULL,
    group_id integer NOT NULL UNIQUE,
    group_order integer NOT NULL,
    active boolean DEFAULT true
);
-- Создаем отдельную SEQUENCE для поля `group_order`
CREATE SEQUENCE group_order_seq;

-- Устанавливаем дефолтное значение для `group_order`
ALTER TABLE public.bj_groups
    ALTER COLUMN group_order SET DEFAULT nextval('group_order_seq');

-- Опционально: связываем SEQUENCE с таблицей (чтобы она удалялась при DROP TABLE)
ALTER SEQUENCE group_order_seq OWNED BY public.bj_groups.group_order;


CREATE TABLE public.bj_goods (
     id SERIAL PRIMARY KEY,
     inner_id integer UNIQUE,
     articul character varying(50) NOT NULL UNIQUE,
     good_name character varying(255) NOT NULL,
     good_alias character varying(255) NOT NULL,
     price integer,
     good_order integer DEFAULT 999999,
     action_id integer,
     active boolean DEFAULT true
);

CREATE TABLE public.goods_groups (
     id SERIAL PRIMARY KEY,
     good_id integer NOT NULL,
     group_id integer NOT NULL
);