--
-- PostgreSQL database dump
--

-- Dumped from database version 14.8 (Ubuntu 14.8-0ubuntu0.22.04.1)
-- Dumped by pg_dump version 14.8 (Ubuntu 14.8-0ubuntu0.22.04.1)

-- Started on 2023-06-19 23:05:34 MSK

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 209 (class 1259 OID 24929)
-- Name: cart_products; Type: TABLE; Schema: public; Owner: aidar
--

CREATE TABLE public.cart_products (
    cart_id bigint NOT NULL,
    product_id bigint NOT NULL
);


ALTER TABLE public.cart_products OWNER TO aidar;

--
-- TOC entry 210 (class 1259 OID 24932)
-- Name: carts; Type: TABLE; Schema: public; Owner: aidar
--

CREATE TABLE public.carts (
    id bigint NOT NULL
);


ALTER TABLE public.carts OWNER TO aidar;

--
-- TOC entry 211 (class 1259 OID 24935)
-- Name: carts_seq; Type: SEQUENCE; Schema: public; Owner: aidar
--

CREATE SEQUENCE public.carts_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.carts_seq OWNER TO aidar;

--
-- TOC entry 212 (class 1259 OID 24936)
-- Name: categories; Type: TABLE; Schema: public; Owner: aidar
--

CREATE TABLE public.categories (
    id bigint NOT NULL,
    name character varying(255),
    sub_category_id smallint
);


ALTER TABLE public.categories OWNER TO aidar;

--
-- TOC entry 213 (class 1259 OID 24939)
-- Name: categories_id_seq; Type: SEQUENCE; Schema: public; Owner: aidar
--

CREATE SEQUENCE public.categories_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.categories_id_seq OWNER TO aidar;

--
-- TOC entry 3610 (class 0 OID 0)
-- Dependencies: 213
-- Name: categories_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: aidar
--

ALTER SEQUENCE public.categories_id_seq OWNED BY public.categories.id;


--
-- TOC entry 232 (class 1259 OID 33908)
-- Name: departments_4nf; Type: TABLE; Schema: public; Owner: aidar
--

CREATE TABLE public.departments_4nf (
    department_id bigint NOT NULL,
    department_name character varying(255)
);


ALTER TABLE public.departments_4nf OWNER TO aidar;

--
-- TOC entry 231 (class 1259 OID 33907)
-- Name: departments_4nf_department_id_seq; Type: SEQUENCE; Schema: public; Owner: aidar
--

CREATE SEQUENCE public.departments_4nf_department_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.departments_4nf_department_id_seq OWNER TO aidar;

--
-- TOC entry 3611 (class 0 OID 0)
-- Dependencies: 231
-- Name: departments_4nf_department_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: aidar
--

ALTER SEQUENCE public.departments_4nf_department_id_seq OWNED BY public.departments_4nf.department_id;


--
-- TOC entry 234 (class 1259 OID 33915)
-- Name: departments_5nf; Type: TABLE; Schema: public; Owner: aidar
--

CREATE TABLE public.departments_5nf (
    department_id bigint NOT NULL,
    department_name character varying(255)
);


ALTER TABLE public.departments_5nf OWNER TO aidar;

--
-- TOC entry 233 (class 1259 OID 33914)
-- Name: departments_5nf_department_id_seq; Type: SEQUENCE; Schema: public; Owner: aidar
--

CREATE SEQUENCE public.departments_5nf_department_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.departments_5nf_department_id_seq OWNER TO aidar;

--
-- TOC entry 3612 (class 0 OID 0)
-- Dependencies: 233
-- Name: departments_5nf_department_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: aidar
--

ALTER SEQUENCE public.departments_5nf_department_id_seq OWNED BY public.departments_5nf.department_id;


--
-- TOC entry 236 (class 1259 OID 33922)
-- Name: employee_addresses_4nf; Type: TABLE; Schema: public; Owner: aidar
--

CREATE TABLE public.employee_addresses_4nf (
    address_id bigint NOT NULL,
    address character varying(255),
    employee_id bigint
);


ALTER TABLE public.employee_addresses_4nf OWNER TO aidar;

--
-- TOC entry 235 (class 1259 OID 33921)
-- Name: employee_addresses_4nf_address_id_seq; Type: SEQUENCE; Schema: public; Owner: aidar
--

CREATE SEQUENCE public.employee_addresses_4nf_address_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.employee_addresses_4nf_address_id_seq OWNER TO aidar;

--
-- TOC entry 3613 (class 0 OID 0)
-- Dependencies: 235
-- Name: employee_addresses_4nf_address_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: aidar
--

ALTER SEQUENCE public.employee_addresses_4nf_address_id_seq OWNED BY public.employee_addresses_4nf.address_id;


--
-- TOC entry 238 (class 1259 OID 33929)
-- Name: employee_addresses_5nf; Type: TABLE; Schema: public; Owner: aidar
--

CREATE TABLE public.employee_addresses_5nf (
    address_id bigint NOT NULL,
    address character varying(255),
    city character varying(255),
    employee_id bigint,
    state character varying(255),
    zip_code character varying(255)
);


ALTER TABLE public.employee_addresses_5nf OWNER TO aidar;

--
-- TOC entry 237 (class 1259 OID 33928)
-- Name: employee_addresses_5nf_address_id_seq; Type: SEQUENCE; Schema: public; Owner: aidar
--

CREATE SEQUENCE public.employee_addresses_5nf_address_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.employee_addresses_5nf_address_id_seq OWNER TO aidar;

--
-- TOC entry 3614 (class 0 OID 0)
-- Dependencies: 237
-- Name: employee_addresses_5nf_address_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: aidar
--

ALTER SEQUENCE public.employee_addresses_5nf_address_id_seq OWNED BY public.employee_addresses_5nf.address_id;


--
-- TOC entry 239 (class 1259 OID 33937)
-- Name: employee_details_3nf; Type: TABLE; Schema: public; Owner: aidar
--

CREATE TABLE public.employee_details_3nf (
    employee_id bigint NOT NULL,
    hire_date date,
    salary numeric(38,2),
    position_id bigint
);


ALTER TABLE public.employee_details_3nf OWNER TO aidar;

--
-- TOC entry 240 (class 1259 OID 33942)
-- Name: employee_details_4nf; Type: TABLE; Schema: public; Owner: aidar
--

CREATE TABLE public.employee_details_4nf (
    employee_id bigint NOT NULL,
    hire_date date,
    salary numeric(38,2),
    position_id bigint
);


ALTER TABLE public.employee_details_4nf OWNER TO aidar;

--
-- TOC entry 242 (class 1259 OID 33948)
-- Name: employee_details_5nf; Type: TABLE; Schema: public; Owner: aidar
--

CREATE TABLE public.employee_details_5nf (
    details_id bigint NOT NULL,
    employee_id bigint,
    hire_date date,
    salary numeric(38,2),
    position_id bigint
);


ALTER TABLE public.employee_details_5nf OWNER TO aidar;

--
-- TOC entry 241 (class 1259 OID 33947)
-- Name: employee_details_5nf_details_id_seq; Type: SEQUENCE; Schema: public; Owner: aidar
--

CREATE SEQUENCE public.employee_details_5nf_details_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.employee_details_5nf_details_id_seq OWNER TO aidar;

--
-- TOC entry 3615 (class 0 OID 0)
-- Dependencies: 241
-- Name: employee_details_5nf_details_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: aidar
--

ALTER SEQUENCE public.employee_details_5nf_details_id_seq OWNED BY public.employee_details_5nf.details_id;


--
-- TOC entry 243 (class 1259 OID 33954)
-- Name: employee_positions_5nf; Type: TABLE; Schema: public; Owner: aidar
--

CREATE TABLE public.employee_positions_5nf (
    employee_id bigint NOT NULL,
    position_id bigint NOT NULL
);


ALTER TABLE public.employee_positions_5nf OWNER TO aidar;

--
-- TOC entry 245 (class 1259 OID 33960)
-- Name: employee_salaries_4nf; Type: TABLE; Schema: public; Owner: aidar
--

CREATE TABLE public.employee_salaries_4nf (
    salary_id bigint NOT NULL,
    salary numeric(38,2),
    employee_id bigint
);


ALTER TABLE public.employee_salaries_4nf OWNER TO aidar;

--
-- TOC entry 244 (class 1259 OID 33959)
-- Name: employee_salaries_4nf_salary_id_seq; Type: SEQUENCE; Schema: public; Owner: aidar
--

CREATE SEQUENCE public.employee_salaries_4nf_salary_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.employee_salaries_4nf_salary_id_seq OWNER TO aidar;

--
-- TOC entry 3616 (class 0 OID 0)
-- Dependencies: 244
-- Name: employee_salaries_4nf_salary_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: aidar
--

ALTER SEQUENCE public.employee_salaries_4nf_salary_id_seq OWNED BY public.employee_salaries_4nf.salary_id;


--
-- TOC entry 246 (class 1259 OID 33966)
-- Name: employee_salaries_5nf; Type: TABLE; Schema: public; Owner: aidar
--

CREATE TABLE public.employee_salaries_5nf (
    hire_date date,
    salary numeric(38,2),
    employee_id bigint NOT NULL
);


ALTER TABLE public.employee_salaries_5nf OWNER TO aidar;

--
-- TOC entry 248 (class 1259 OID 33972)
-- Name: employees_1nf; Type: TABLE; Schema: public; Owner: aidar
--

CREATE TABLE public.employees_1nf (
    employee_id bigint NOT NULL,
    address character varying(100),
    department character varying(50),
    first_name character varying(50),
    hire_date timestamp(6) without time zone,
    last_name character varying(50),
    phone character varying(20),
    "position" character varying(50),
    salary numeric(10,2)
);


ALTER TABLE public.employees_1nf OWNER TO aidar;

--
-- TOC entry 247 (class 1259 OID 33971)
-- Name: employees_1nf_employee_id_seq; Type: SEQUENCE; Schema: public; Owner: aidar
--

CREATE SEQUENCE public.employees_1nf_employee_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.employees_1nf_employee_id_seq OWNER TO aidar;

--
-- TOC entry 3617 (class 0 OID 0)
-- Dependencies: 247
-- Name: employees_1nf_employee_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: aidar
--

ALTER SEQUENCE public.employees_1nf_employee_id_seq OWNED BY public.employees_1nf.employee_id;


--
-- TOC entry 250 (class 1259 OID 33979)
-- Name: employees_2nf; Type: TABLE; Schema: public; Owner: aidar
--

CREATE TABLE public.employees_2nf (
    employee_id bigint NOT NULL,
    address character varying(100),
    first_name character varying(50),
    last_name character varying(50),
    phone character varying(20)
);


ALTER TABLE public.employees_2nf OWNER TO aidar;

--
-- TOC entry 249 (class 1259 OID 33978)
-- Name: employees_2nf_employee_id_seq; Type: SEQUENCE; Schema: public; Owner: aidar
--

CREATE SEQUENCE public.employees_2nf_employee_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.employees_2nf_employee_id_seq OWNER TO aidar;

--
-- TOC entry 3618 (class 0 OID 0)
-- Dependencies: 249
-- Name: employees_2nf_employee_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: aidar
--

ALTER SEQUENCE public.employees_2nf_employee_id_seq OWNED BY public.employees_2nf.employee_id;


--
-- TOC entry 252 (class 1259 OID 33986)
-- Name: employees_3nf; Type: TABLE; Schema: public; Owner: aidar
--

CREATE TABLE public.employees_3nf (
    employee_id bigint NOT NULL,
    address character varying(255),
    first_name character varying(255),
    last_name character varying(255),
    phone character varying(255),
    department_id bigint
);


ALTER TABLE public.employees_3nf OWNER TO aidar;

--
-- TOC entry 251 (class 1259 OID 33985)
-- Name: employees_3nf_employee_id_seq; Type: SEQUENCE; Schema: public; Owner: aidar
--

CREATE SEQUENCE public.employees_3nf_employee_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.employees_3nf_employee_id_seq OWNER TO aidar;

--
-- TOC entry 3619 (class 0 OID 0)
-- Dependencies: 251
-- Name: employees_3nf_employee_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: aidar
--

ALTER SEQUENCE public.employees_3nf_employee_id_seq OWNED BY public.employees_3nf.employee_id;


--
-- TOC entry 254 (class 1259 OID 33995)
-- Name: employees_4nf; Type: TABLE; Schema: public; Owner: aidar
--

CREATE TABLE public.employees_4nf (
    employee_id bigint NOT NULL,
    first_name character varying(255),
    last_name character varying(255),
    phone character varying(255),
    department_id bigint
);


ALTER TABLE public.employees_4nf OWNER TO aidar;

--
-- TOC entry 253 (class 1259 OID 33994)
-- Name: employees_4nf_employee_id_seq; Type: SEQUENCE; Schema: public; Owner: aidar
--

CREATE SEQUENCE public.employees_4nf_employee_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.employees_4nf_employee_id_seq OWNER TO aidar;

--
-- TOC entry 3620 (class 0 OID 0)
-- Dependencies: 253
-- Name: employees_4nf_employee_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: aidar
--

ALTER SEQUENCE public.employees_4nf_employee_id_seq OWNED BY public.employees_4nf.employee_id;


--
-- TOC entry 256 (class 1259 OID 34004)
-- Name: employees_5nf; Type: TABLE; Schema: public; Owner: aidar
--

CREATE TABLE public.employees_5nf (
    employee_id bigint NOT NULL,
    first_name character varying(255),
    last_name character varying(255),
    phone character varying(255),
    department_id bigint
);


ALTER TABLE public.employees_5nf OWNER TO aidar;

--
-- TOC entry 255 (class 1259 OID 34003)
-- Name: employees_5nf_employee_id_seq; Type: SEQUENCE; Schema: public; Owner: aidar
--

CREATE SEQUENCE public.employees_5nf_employee_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.employees_5nf_employee_id_seq OWNER TO aidar;

--
-- TOC entry 3621 (class 0 OID 0)
-- Dependencies: 255
-- Name: employees_5nf_employee_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: aidar
--

ALTER SEQUENCE public.employees_5nf_employee_id_seq OWNED BY public.employees_5nf.employee_id;


--
-- TOC entry 258 (class 1259 OID 34013)
-- Name: employees_details_2nf; Type: TABLE; Schema: public; Owner: aidar
--

CREATE TABLE public.employees_details_2nf (
    employee_id bigint NOT NULL,
    department character varying(50),
    hire_date timestamp(6) without time zone,
    "position" character varying(50),
    salary numeric(38,2)
);


ALTER TABLE public.employees_details_2nf OWNER TO aidar;

--
-- TOC entry 257 (class 1259 OID 34012)
-- Name: employees_details_2nf_employee_id_seq; Type: SEQUENCE; Schema: public; Owner: aidar
--

CREATE SEQUENCE public.employees_details_2nf_employee_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.employees_details_2nf_employee_id_seq OWNER TO aidar;

--
-- TOC entry 3622 (class 0 OID 0)
-- Dependencies: 257
-- Name: employees_details_2nf_employee_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: aidar
--

ALTER SEQUENCE public.employees_details_2nf_employee_id_seq OWNED BY public.employees_details_2nf.employee_id;


--
-- TOC entry 260 (class 1259 OID 34020)
-- Name: positions3nf; Type: TABLE; Schema: public; Owner: aidar
--

CREATE TABLE public.positions3nf (
    position_id bigint NOT NULL,
    "position" character varying(255)
);


ALTER TABLE public.positions3nf OWNER TO aidar;

--
-- TOC entry 259 (class 1259 OID 34019)
-- Name: positions3nf_position_id_seq; Type: SEQUENCE; Schema: public; Owner: aidar
--

CREATE SEQUENCE public.positions3nf_position_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.positions3nf_position_id_seq OWNER TO aidar;

--
-- TOC entry 3623 (class 0 OID 0)
-- Dependencies: 259
-- Name: positions3nf_position_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: aidar
--

ALTER SEQUENCE public.positions3nf_position_id_seq OWNED BY public.positions3nf.position_id;


--
-- TOC entry 262 (class 1259 OID 34027)
-- Name: positions4nf; Type: TABLE; Schema: public; Owner: aidar
--

CREATE TABLE public.positions4nf (
    position_id bigint NOT NULL,
    position_name character varying(255)
);


ALTER TABLE public.positions4nf OWNER TO aidar;

--
-- TOC entry 261 (class 1259 OID 34026)
-- Name: positions4nf_position_id_seq; Type: SEQUENCE; Schema: public; Owner: aidar
--

CREATE SEQUENCE public.positions4nf_position_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.positions4nf_position_id_seq OWNER TO aidar;

--
-- TOC entry 3624 (class 0 OID 0)
-- Dependencies: 261
-- Name: positions4nf_position_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: aidar
--

ALTER SEQUENCE public.positions4nf_position_id_seq OWNED BY public.positions4nf.position_id;


--
-- TOC entry 264 (class 1259 OID 34034)
-- Name: positions5nf; Type: TABLE; Schema: public; Owner: aidar
--

CREATE TABLE public.positions5nf (
    position_id bigint NOT NULL,
    position_name character varying(255)
);


ALTER TABLE public.positions5nf OWNER TO aidar;

--
-- TOC entry 263 (class 1259 OID 34033)
-- Name: positions5nf_position_id_seq; Type: SEQUENCE; Schema: public; Owner: aidar
--

CREATE SEQUENCE public.positions5nf_position_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.positions5nf_position_id_seq OWNER TO aidar;

--
-- TOC entry 3625 (class 0 OID 0)
-- Dependencies: 263
-- Name: positions5nf_position_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: aidar
--

ALTER SEQUENCE public.positions5nf_position_id_seq OWNED BY public.positions5nf.position_id;


--
-- TOC entry 214 (class 1259 OID 24940)
-- Name: products; Type: TABLE; Schema: public; Owner: aidar
--

CREATE TABLE public.products (
    id bigint NOT NULL,
    created_on timestamp(6) without time zone,
    description character varying(4096),
    photo_url character varying(4096),
    platform character varying(255),
    price double precision,
    size character varying(255),
    title character varying(255),
    updated_on timestamp(6) without time zone,
    category_id bigint,
    created_by bigint
);


ALTER TABLE public.products OWNER TO aidar;

--
-- TOC entry 215 (class 1259 OID 24945)
-- Name: products_id_seq; Type: SEQUENCE; Schema: public; Owner: aidar
--

CREATE SEQUENCE public.products_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.products_id_seq OWNER TO aidar;

--
-- TOC entry 3626 (class 0 OID 0)
-- Dependencies: 215
-- Name: products_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: aidar
--

ALTER SEQUENCE public.products_id_seq OWNED BY public.products.id;


--
-- TOC entry 216 (class 1259 OID 24946)
-- Name: recently_watched_products; Type: TABLE; Schema: public; Owner: aidar
--

CREATE TABLE public.recently_watched_products (
    id bigint NOT NULL
);


ALTER TABLE public.recently_watched_products OWNER TO aidar;

--
-- TOC entry 217 (class 1259 OID 24949)
-- Name: recently_watched_products_cart_products; Type: TABLE; Schema: public; Owner: aidar
--

CREATE TABLE public.recently_watched_products_cart_products (
    recently_watched_id bigint NOT NULL,
    product_id bigint NOT NULL
);


ALTER TABLE public.recently_watched_products_cart_products OWNER TO aidar;

--
-- TOC entry 218 (class 1259 OID 24952)
-- Name: recently_watched_products_seq; Type: SEQUENCE; Schema: public; Owner: aidar
--

CREATE SEQUENCE public.recently_watched_products_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.recently_watched_products_seq OWNER TO aidar;

--
-- TOC entry 219 (class 1259 OID 24953)
-- Name: roles; Type: TABLE; Schema: public; Owner: aidar
--

CREATE TABLE public.roles (
    id bigint NOT NULL,
    name character varying(255)
);


ALTER TABLE public.roles OWNER TO aidar;

--
-- TOC entry 220 (class 1259 OID 24956)
-- Name: roles_id_seq; Type: SEQUENCE; Schema: public; Owner: aidar
--

CREATE SEQUENCE public.roles_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.roles_id_seq OWNER TO aidar;

--
-- TOC entry 3627 (class 0 OID 0)
-- Dependencies: 220
-- Name: roles_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: aidar
--

ALTER SEQUENCE public.roles_id_seq OWNED BY public.roles.id;


--
-- TOC entry 221 (class 1259 OID 24957)
-- Name: sub_categories; Type: TABLE; Schema: public; Owner: aidar
--

CREATE TABLE public.sub_categories (
    id smallint NOT NULL,
    name character varying(255)
);


ALTER TABLE public.sub_categories OWNER TO aidar;

--
-- TOC entry 226 (class 1259 OID 33688)
-- Name: t1; Type: TABLE; Schema: public; Owner: aidar
--

CREATE TABLE public.t1 (
    id bigint NOT NULL,
    value character varying(255)
);


ALTER TABLE public.t1 OWNER TO aidar;

--
-- TOC entry 225 (class 1259 OID 33687)
-- Name: t1_id_seq; Type: SEQUENCE; Schema: public; Owner: aidar
--

CREATE SEQUENCE public.t1_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.t1_id_seq OWNER TO aidar;

--
-- TOC entry 3628 (class 0 OID 0)
-- Dependencies: 225
-- Name: t1_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: aidar
--

ALTER SEQUENCE public.t1_id_seq OWNED BY public.t1.id;


--
-- TOC entry 227 (class 1259 OID 33694)
-- Name: t2; Type: TABLE; Schema: public; Owner: aidar
--

CREATE TABLE public.t2 (
    value character varying(255) NOT NULL
);


ALTER TABLE public.t2 OWNER TO aidar;

--
-- TOC entry 228 (class 1259 OID 33699)
-- Name: t3; Type: TABLE; Schema: public; Owner: aidar
--

CREATE TABLE public.t3 (
    index character varying(255) NOT NULL,
    data character varying(255)
);


ALTER TABLE public.t3 OWNER TO aidar;

--
-- TOC entry 230 (class 1259 OID 33707)
-- Name: t4; Type: TABLE; Schema: public; Owner: aidar
--

CREATE TABLE public.t4 (
    id bigint NOT NULL,
    data character varying(255)
);


ALTER TABLE public.t4 OWNER TO aidar;

--
-- TOC entry 229 (class 1259 OID 33706)
-- Name: t4_id_seq; Type: SEQUENCE; Schema: public; Owner: aidar
--

CREATE SEQUENCE public.t4_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.t4_id_seq OWNER TO aidar;

--
-- TOC entry 3629 (class 0 OID 0)
-- Dependencies: 229
-- Name: t4_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: aidar
--

ALTER SEQUENCE public.t4_id_seq OWNED BY public.t4.id;


--
-- TOC entry 222 (class 1259 OID 24960)
-- Name: user_roles; Type: TABLE; Schema: public; Owner: aidar
--

CREATE TABLE public.user_roles (
    user_id bigint NOT NULL,
    role_id bigint NOT NULL
);


ALTER TABLE public.user_roles OWNER TO aidar;

--
-- TOC entry 223 (class 1259 OID 24963)
-- Name: users; Type: TABLE; Schema: public; Owner: aidar
--

CREATE TABLE public.users (
    id bigint NOT NULL,
    email character varying(255),
    password character varying(255),
    username character varying(255),
    cart_id bigint,
    recently_watched_id bigint
);


ALTER TABLE public.users OWNER TO aidar;

--
-- TOC entry 224 (class 1259 OID 24968)
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: aidar
--

CREATE SEQUENCE public.users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_id_seq OWNER TO aidar;

--
-- TOC entry 3630 (class 0 OID 0)
-- Dependencies: 224
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: aidar
--

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;


--
-- TOC entry 3357 (class 2604 OID 24969)
-- Name: categories id; Type: DEFAULT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.categories ALTER COLUMN id SET DEFAULT nextval('public.categories_id_seq'::regclass);


--
-- TOC entry 3363 (class 2604 OID 33911)
-- Name: departments_4nf department_id; Type: DEFAULT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.departments_4nf ALTER COLUMN department_id SET DEFAULT nextval('public.departments_4nf_department_id_seq'::regclass);


--
-- TOC entry 3364 (class 2604 OID 33918)
-- Name: departments_5nf department_id; Type: DEFAULT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.departments_5nf ALTER COLUMN department_id SET DEFAULT nextval('public.departments_5nf_department_id_seq'::regclass);


--
-- TOC entry 3365 (class 2604 OID 33925)
-- Name: employee_addresses_4nf address_id; Type: DEFAULT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.employee_addresses_4nf ALTER COLUMN address_id SET DEFAULT nextval('public.employee_addresses_4nf_address_id_seq'::regclass);


--
-- TOC entry 3366 (class 2604 OID 33932)
-- Name: employee_addresses_5nf address_id; Type: DEFAULT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.employee_addresses_5nf ALTER COLUMN address_id SET DEFAULT nextval('public.employee_addresses_5nf_address_id_seq'::regclass);


--
-- TOC entry 3367 (class 2604 OID 33951)
-- Name: employee_details_5nf details_id; Type: DEFAULT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.employee_details_5nf ALTER COLUMN details_id SET DEFAULT nextval('public.employee_details_5nf_details_id_seq'::regclass);


--
-- TOC entry 3368 (class 2604 OID 33963)
-- Name: employee_salaries_4nf salary_id; Type: DEFAULT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.employee_salaries_4nf ALTER COLUMN salary_id SET DEFAULT nextval('public.employee_salaries_4nf_salary_id_seq'::regclass);


--
-- TOC entry 3369 (class 2604 OID 33975)
-- Name: employees_1nf employee_id; Type: DEFAULT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.employees_1nf ALTER COLUMN employee_id SET DEFAULT nextval('public.employees_1nf_employee_id_seq'::regclass);


--
-- TOC entry 3370 (class 2604 OID 33982)
-- Name: employees_2nf employee_id; Type: DEFAULT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.employees_2nf ALTER COLUMN employee_id SET DEFAULT nextval('public.employees_2nf_employee_id_seq'::regclass);


--
-- TOC entry 3371 (class 2604 OID 33989)
-- Name: employees_3nf employee_id; Type: DEFAULT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.employees_3nf ALTER COLUMN employee_id SET DEFAULT nextval('public.employees_3nf_employee_id_seq'::regclass);


--
-- TOC entry 3372 (class 2604 OID 33998)
-- Name: employees_4nf employee_id; Type: DEFAULT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.employees_4nf ALTER COLUMN employee_id SET DEFAULT nextval('public.employees_4nf_employee_id_seq'::regclass);


--
-- TOC entry 3373 (class 2604 OID 34007)
-- Name: employees_5nf employee_id; Type: DEFAULT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.employees_5nf ALTER COLUMN employee_id SET DEFAULT nextval('public.employees_5nf_employee_id_seq'::regclass);


--
-- TOC entry 3374 (class 2604 OID 34016)
-- Name: employees_details_2nf employee_id; Type: DEFAULT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.employees_details_2nf ALTER COLUMN employee_id SET DEFAULT nextval('public.employees_details_2nf_employee_id_seq'::regclass);


--
-- TOC entry 3375 (class 2604 OID 34023)
-- Name: positions3nf position_id; Type: DEFAULT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.positions3nf ALTER COLUMN position_id SET DEFAULT nextval('public.positions3nf_position_id_seq'::regclass);


--
-- TOC entry 3376 (class 2604 OID 34030)
-- Name: positions4nf position_id; Type: DEFAULT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.positions4nf ALTER COLUMN position_id SET DEFAULT nextval('public.positions4nf_position_id_seq'::regclass);


--
-- TOC entry 3377 (class 2604 OID 34037)
-- Name: positions5nf position_id; Type: DEFAULT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.positions5nf ALTER COLUMN position_id SET DEFAULT nextval('public.positions5nf_position_id_seq'::regclass);


--
-- TOC entry 3358 (class 2604 OID 24970)
-- Name: products id; Type: DEFAULT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.products ALTER COLUMN id SET DEFAULT nextval('public.products_id_seq'::regclass);


--
-- TOC entry 3359 (class 2604 OID 24971)
-- Name: roles id; Type: DEFAULT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.roles ALTER COLUMN id SET DEFAULT nextval('public.roles_id_seq'::regclass);


--
-- TOC entry 3361 (class 2604 OID 33691)
-- Name: t1 id; Type: DEFAULT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.t1 ALTER COLUMN id SET DEFAULT nextval('public.t1_id_seq'::regclass);


--
-- TOC entry 3362 (class 2604 OID 33710)
-- Name: t4 id; Type: DEFAULT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.t4 ALTER COLUMN id SET DEFAULT nextval('public.t4_id_seq'::regclass);


--
-- TOC entry 3360 (class 2604 OID 24972)
-- Name: users id; Type: DEFAULT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);


--
-- TOC entry 3379 (class 2606 OID 24974)
-- Name: carts carts_pkey; Type: CONSTRAINT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.carts
    ADD CONSTRAINT carts_pkey PRIMARY KEY (id);


--
-- TOC entry 3381 (class 2606 OID 24976)
-- Name: categories categories_pkey; Type: CONSTRAINT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.categories
    ADD CONSTRAINT categories_pkey PRIMARY KEY (id);


--
-- TOC entry 3405 (class 2606 OID 33913)
-- Name: departments_4nf departments_4nf_pkey; Type: CONSTRAINT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.departments_4nf
    ADD CONSTRAINT departments_4nf_pkey PRIMARY KEY (department_id);


--
-- TOC entry 3407 (class 2606 OID 33920)
-- Name: departments_5nf departments_5nf_pkey; Type: CONSTRAINT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.departments_5nf
    ADD CONSTRAINT departments_5nf_pkey PRIMARY KEY (department_id);


--
-- TOC entry 3409 (class 2606 OID 33927)
-- Name: employee_addresses_4nf employee_addresses_4nf_pkey; Type: CONSTRAINT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.employee_addresses_4nf
    ADD CONSTRAINT employee_addresses_4nf_pkey PRIMARY KEY (address_id);


--
-- TOC entry 3411 (class 2606 OID 33936)
-- Name: employee_addresses_5nf employee_addresses_5nf_pkey; Type: CONSTRAINT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.employee_addresses_5nf
    ADD CONSTRAINT employee_addresses_5nf_pkey PRIMARY KEY (address_id);


--
-- TOC entry 3413 (class 2606 OID 33941)
-- Name: employee_details_3nf employee_details_3nf_pkey; Type: CONSTRAINT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.employee_details_3nf
    ADD CONSTRAINT employee_details_3nf_pkey PRIMARY KEY (employee_id);


--
-- TOC entry 3415 (class 2606 OID 33946)
-- Name: employee_details_4nf employee_details_4nf_pkey; Type: CONSTRAINT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.employee_details_4nf
    ADD CONSTRAINT employee_details_4nf_pkey PRIMARY KEY (employee_id);


--
-- TOC entry 3417 (class 2606 OID 33953)
-- Name: employee_details_5nf employee_details_5nf_pkey; Type: CONSTRAINT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.employee_details_5nf
    ADD CONSTRAINT employee_details_5nf_pkey PRIMARY KEY (details_id);


--
-- TOC entry 3419 (class 2606 OID 33958)
-- Name: employee_positions_5nf employee_positions_5nf_pkey; Type: CONSTRAINT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.employee_positions_5nf
    ADD CONSTRAINT employee_positions_5nf_pkey PRIMARY KEY (employee_id, position_id);


--
-- TOC entry 3421 (class 2606 OID 33965)
-- Name: employee_salaries_4nf employee_salaries_4nf_pkey; Type: CONSTRAINT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.employee_salaries_4nf
    ADD CONSTRAINT employee_salaries_4nf_pkey PRIMARY KEY (salary_id);


--
-- TOC entry 3423 (class 2606 OID 33970)
-- Name: employee_salaries_5nf employee_salaries_5nf_pkey; Type: CONSTRAINT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.employee_salaries_5nf
    ADD CONSTRAINT employee_salaries_5nf_pkey PRIMARY KEY (employee_id);


--
-- TOC entry 3425 (class 2606 OID 33977)
-- Name: employees_1nf employees_1nf_pkey; Type: CONSTRAINT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.employees_1nf
    ADD CONSTRAINT employees_1nf_pkey PRIMARY KEY (employee_id);


--
-- TOC entry 3427 (class 2606 OID 33984)
-- Name: employees_2nf employees_2nf_pkey; Type: CONSTRAINT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.employees_2nf
    ADD CONSTRAINT employees_2nf_pkey PRIMARY KEY (employee_id);


--
-- TOC entry 3429 (class 2606 OID 33993)
-- Name: employees_3nf employees_3nf_pkey; Type: CONSTRAINT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.employees_3nf
    ADD CONSTRAINT employees_3nf_pkey PRIMARY KEY (employee_id);


--
-- TOC entry 3431 (class 2606 OID 34002)
-- Name: employees_4nf employees_4nf_pkey; Type: CONSTRAINT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.employees_4nf
    ADD CONSTRAINT employees_4nf_pkey PRIMARY KEY (employee_id);


--
-- TOC entry 3433 (class 2606 OID 34011)
-- Name: employees_5nf employees_5nf_pkey; Type: CONSTRAINT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.employees_5nf
    ADD CONSTRAINT employees_5nf_pkey PRIMARY KEY (employee_id);


--
-- TOC entry 3435 (class 2606 OID 34018)
-- Name: employees_details_2nf employees_details_2nf_pkey; Type: CONSTRAINT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.employees_details_2nf
    ADD CONSTRAINT employees_details_2nf_pkey PRIMARY KEY (employee_id);


--
-- TOC entry 3437 (class 2606 OID 34025)
-- Name: positions3nf positions3nf_pkey; Type: CONSTRAINT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.positions3nf
    ADD CONSTRAINT positions3nf_pkey PRIMARY KEY (position_id);


--
-- TOC entry 3439 (class 2606 OID 34032)
-- Name: positions4nf positions4nf_pkey; Type: CONSTRAINT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.positions4nf
    ADD CONSTRAINT positions4nf_pkey PRIMARY KEY (position_id);


--
-- TOC entry 3441 (class 2606 OID 34039)
-- Name: positions5nf positions5nf_pkey; Type: CONSTRAINT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.positions5nf
    ADD CONSTRAINT positions5nf_pkey PRIMARY KEY (position_id);


--
-- TOC entry 3383 (class 2606 OID 24978)
-- Name: products products_pkey; Type: CONSTRAINT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.products
    ADD CONSTRAINT products_pkey PRIMARY KEY (id);


--
-- TOC entry 3385 (class 2606 OID 24980)
-- Name: recently_watched_products recently_watched_products_pkey; Type: CONSTRAINT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.recently_watched_products
    ADD CONSTRAINT recently_watched_products_pkey PRIMARY KEY (id);


--
-- TOC entry 3387 (class 2606 OID 24982)
-- Name: roles roles_pkey; Type: CONSTRAINT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_pkey PRIMARY KEY (id);


--
-- TOC entry 3389 (class 2606 OID 24984)
-- Name: sub_categories sub_categories_pkey; Type: CONSTRAINT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.sub_categories
    ADD CONSTRAINT sub_categories_pkey PRIMARY KEY (id);


--
-- TOC entry 3397 (class 2606 OID 33693)
-- Name: t1 t1_pkey; Type: CONSTRAINT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.t1
    ADD CONSTRAINT t1_pkey PRIMARY KEY (id);


--
-- TOC entry 3399 (class 2606 OID 33698)
-- Name: t2 t2_pkey; Type: CONSTRAINT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.t2
    ADD CONSTRAINT t2_pkey PRIMARY KEY (value);


--
-- TOC entry 3401 (class 2606 OID 33705)
-- Name: t3 t3_pkey; Type: CONSTRAINT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.t3
    ADD CONSTRAINT t3_pkey PRIMARY KEY (index);


--
-- TOC entry 3403 (class 2606 OID 33712)
-- Name: t4 t4_pkey; Type: CONSTRAINT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.t4
    ADD CONSTRAINT t4_pkey PRIMARY KEY (id);


--
-- TOC entry 3391 (class 2606 OID 24986)
-- Name: users uk_pjn47huiafla03vr0wqksy5dr; Type: CONSTRAINT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT uk_pjn47huiafla03vr0wqksy5dr UNIQUE (recently_watched_id);


--
-- TOC entry 3393 (class 2606 OID 24988)
-- Name: users uk_pnp1baae4enifkkuq2cd01r9l; Type: CONSTRAINT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT uk_pnp1baae4enifkkuq2cd01r9l UNIQUE (cart_id);


--
-- TOC entry 3395 (class 2606 OID 24990)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 3447 (class 2606 OID 24991)
-- Name: recently_watched_products_cart_products fk15jcp0cah9tikkttlob30odi8; Type: FK CONSTRAINT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.recently_watched_products_cart_products
    ADD CONSTRAINT fk15jcp0cah9tikkttlob30odi8 FOREIGN KEY (product_id) REFERENCES public.products(id);


--
-- TOC entry 3451 (class 2606 OID 24996)
-- Name: users fk20sie7lmn61mp0dtfa9ignekh; Type: FK CONSTRAINT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT fk20sie7lmn61mp0dtfa9ignekh FOREIGN KEY (recently_watched_id) REFERENCES public.recently_watched_products(id);


--
-- TOC entry 3458 (class 2606 OID 34065)
-- Name: employee_details_5nf fk2ky3sjapxl0pdjhh35aoty0me; Type: FK CONSTRAINT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.employee_details_5nf
    ADD CONSTRAINT fk2ky3sjapxl0pdjhh35aoty0me FOREIGN KEY (position_id) REFERENCES public.positions5nf(position_id);


--
-- TOC entry 3459 (class 2606 OID 34075)
-- Name: employee_positions_5nf fk5r5od7saq602n3e2jyuypapph; Type: FK CONSTRAINT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.employee_positions_5nf
    ADD CONSTRAINT fk5r5od7saq602n3e2jyuypapph FOREIGN KEY (position_id) REFERENCES public.positions5nf(position_id);


--
-- TOC entry 3460 (class 2606 OID 34070)
-- Name: employee_positions_5nf fk7mymkqe854l15hvsvctp3ncf6; Type: FK CONSTRAINT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.employee_positions_5nf
    ADD CONSTRAINT fk7mymkqe854l15hvsvctp3ncf6 FOREIGN KEY (employee_id) REFERENCES public.employees_5nf(employee_id);


--
-- TOC entry 3442 (class 2606 OID 25001)
-- Name: cart_products fkbilp3o9irlsvmbot68kfpthom; Type: FK CONSTRAINT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.cart_products
    ADD CONSTRAINT fkbilp3o9irlsvmbot68kfpthom FOREIGN KEY (cart_id) REFERENCES public.carts(id);


--
-- TOC entry 3454 (class 2606 OID 34050)
-- Name: employee_details_3nf fkbplm2sgk69y2jqfvphkftgnoe; Type: FK CONSTRAINT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.employee_details_3nf
    ADD CONSTRAINT fkbplm2sgk69y2jqfvphkftgnoe FOREIGN KEY (employee_id) REFERENCES public.employees_3nf(employee_id);


--
-- TOC entry 3443 (class 2606 OID 25006)
-- Name: cart_products fkdayy17at10up1qqwlri9cocb3; Type: FK CONSTRAINT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.cart_products
    ADD CONSTRAINT fkdayy17at10up1qqwlri9cocb3 FOREIGN KEY (product_id) REFERENCES public.products(id);


--
-- TOC entry 3452 (class 2606 OID 25011)
-- Name: users fkdv26y3bb4vdmsr89c9ppnx85w; Type: FK CONSTRAINT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT fkdv26y3bb4vdmsr89c9ppnx85w FOREIGN KEY (cart_id) REFERENCES public.carts(id);


--
-- TOC entry 3456 (class 2606 OID 34060)
-- Name: employee_details_4nf fkfs3138fcgjqfohipixiffquli; Type: FK CONSTRAINT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.employee_details_4nf
    ADD CONSTRAINT fkfs3138fcgjqfohipixiffquli FOREIGN KEY (employee_id) REFERENCES public.employees_4nf(employee_id);


--
-- TOC entry 3448 (class 2606 OID 25016)
-- Name: recently_watched_products_cart_products fkh4gfp9dupivvvj83pn4d3k4ox; Type: FK CONSTRAINT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.recently_watched_products_cart_products
    ADD CONSTRAINT fkh4gfp9dupivvvj83pn4d3k4ox FOREIGN KEY (recently_watched_id) REFERENCES public.recently_watched_products(id);


--
-- TOC entry 3449 (class 2606 OID 25021)
-- Name: user_roles fkh8ciramu9cc9q3qcqiv4ue8a6; Type: FK CONSTRAINT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.user_roles
    ADD CONSTRAINT fkh8ciramu9cc9q3qcqiv4ue8a6 FOREIGN KEY (role_id) REFERENCES public.roles(id);


--
-- TOC entry 3450 (class 2606 OID 25026)
-- Name: user_roles fkhfh9dx7w3ubf1co1vdev94g3f; Type: FK CONSTRAINT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.user_roles
    ADD CONSTRAINT fkhfh9dx7w3ubf1co1vdev94g3f FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- TOC entry 3462 (class 2606 OID 34085)
-- Name: employee_salaries_5nf fkkux2ty44lj2aknqvsm1jmi2ib; Type: FK CONSTRAINT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.employee_salaries_5nf
    ADD CONSTRAINT fkkux2ty44lj2aknqvsm1jmi2ib FOREIGN KEY (employee_id) REFERENCES public.employees_5nf(employee_id);


--
-- TOC entry 3453 (class 2606 OID 34040)
-- Name: employee_addresses_4nf fkkx1sr2ww5rujwy76akpswn30l; Type: FK CONSTRAINT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.employee_addresses_4nf
    ADD CONSTRAINT fkkx1sr2ww5rujwy76akpswn30l FOREIGN KEY (employee_id) REFERENCES public.employees_4nf(employee_id);


--
-- TOC entry 3445 (class 2606 OID 25031)
-- Name: products fkl0lce8i162ldn9n01t2a6lcix; Type: FK CONSTRAINT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.products
    ADD CONSTRAINT fkl0lce8i162ldn9n01t2a6lcix FOREIGN KEY (created_by) REFERENCES public.users(id);


--
-- TOC entry 3464 (class 2606 OID 34095)
-- Name: employees_4nf fkn60v5efcv3gb59tlisa6c3vhp; Type: FK CONSTRAINT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.employees_4nf
    ADD CONSTRAINT fkn60v5efcv3gb59tlisa6c3vhp FOREIGN KEY (department_id) REFERENCES public.departments_4nf(department_id);


--
-- TOC entry 3457 (class 2606 OID 34055)
-- Name: employee_details_4nf fkno5ts2hiw2ebja7su49fixx5o; Type: FK CONSTRAINT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.employee_details_4nf
    ADD CONSTRAINT fkno5ts2hiw2ebja7su49fixx5o FOREIGN KEY (position_id) REFERENCES public.positions4nf(position_id);


--
-- TOC entry 3446 (class 2606 OID 25036)
-- Name: products fkog2rp4qthbtt2lfyhfo32lsw9; Type: FK CONSTRAINT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.products
    ADD CONSTRAINT fkog2rp4qthbtt2lfyhfo32lsw9 FOREIGN KEY (category_id) REFERENCES public.categories(id);


--
-- TOC entry 3461 (class 2606 OID 34080)
-- Name: employee_salaries_4nf fkpaq6iou2yr88stl62xqn865r7; Type: FK CONSTRAINT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.employee_salaries_4nf
    ADD CONSTRAINT fkpaq6iou2yr88stl62xqn865r7 FOREIGN KEY (employee_id) REFERENCES public.employee_details_4nf(employee_id);


--
-- TOC entry 3465 (class 2606 OID 34100)
-- Name: employees_5nf fkr0k0c8a2q44ufbx7dp6m22oyt; Type: FK CONSTRAINT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.employees_5nf
    ADD CONSTRAINT fkr0k0c8a2q44ufbx7dp6m22oyt FOREIGN KEY (department_id) REFERENCES public.departments_5nf(department_id);


--
-- TOC entry 3455 (class 2606 OID 34045)
-- Name: employee_details_3nf fksujcgr67avdtky3ad5oqwydtb; Type: FK CONSTRAINT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.employee_details_3nf
    ADD CONSTRAINT fksujcgr67avdtky3ad5oqwydtb FOREIGN KEY (position_id) REFERENCES public.positions3nf(position_id);


--
-- TOC entry 3463 (class 2606 OID 34090)
-- Name: employees_3nf fksyrb9xg4epswtjq2ngu1qk0lx; Type: FK CONSTRAINT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.employees_3nf
    ADD CONSTRAINT fksyrb9xg4epswtjq2ngu1qk0lx FOREIGN KEY (department_id) REFERENCES public.employee_details_3nf(employee_id);


--
-- TOC entry 3444 (class 2606 OID 25041)
-- Name: categories fkt4020k96bmxugqbmrxi7yaim9; Type: FK CONSTRAINT; Schema: public; Owner: aidar
--

ALTER TABLE ONLY public.categories
    ADD CONSTRAINT fkt4020k96bmxugqbmrxi7yaim9 FOREIGN KEY (sub_category_id) REFERENCES public.sub_categories(id);


-- Completed on 2023-06-19 23:05:35 MSK

--
-- PostgreSQL database dump complete
--

