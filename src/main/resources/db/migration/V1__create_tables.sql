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


CREATE TABLE public.bj_products (
     id SERIAL PRIMARY KEY,
     inner_id integer UNIQUE,
     articul character varying(50) NOT NULL UNIQUE,
     product_name character varying(255) NOT NULL,
     product_alias character varying(255) NOT NULL,
     price integer,
     product_order integer DEFAULT 999999,
     action_id integer,
     active boolean DEFAULT true
);

CREATE TABLE public.products_groups (
     id SERIAL PRIMARY KEY,
     product_id integer NOT NULL,
     group_id integer NOT NULL
);