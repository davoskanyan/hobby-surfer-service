--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.4 (Postgres-XL 9.5r1.3)
-- Dumped by pg_dump version 9.5.5

-- Started on 2017-01-09 18:25:19

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;
--
-- TOC entry 196 (class 1259 OID 67647)
-- Name: organization_id_seq; Type: SEQUENCE; Schema: um; Owner: postgres
--

CREATE SEQUENCE organization_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE organization_id_seq OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 67649)
-- Name: Organization; Type: TABLE; Schema: um; Owner: postgres
--

CREATE TABLE "Organization" (
    "OrganizationID" integer DEFAULT nextval('organization_id_seq'::regclass) NOT NULL,
    "Name" character varying(255) NOT NULL,
    "Description" character varying(1024) DEFAULT NULL::character varying,
    "ParentID" integer,
    "Fields" jsonb
);


ALTER TABLE "Organization" OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 67657)
-- Name: OrganizationPermission; Type: TABLE; Schema: um; Owner: postgres
--

CREATE TABLE "OrganizationPermission" (
    "OrganizationId" integer NOT NULL,
    "PermissionId" uuid NOT NULL
);


ALTER TABLE "OrganizationPermission" OWNER TO postgres;

--
-- TOC entry 3056 (class 2606 OID 67754)
-- Name: OrganizationPermission_pkey; Type: CONSTRAINT; Schema: um; Owner: postgres
--

ALTER TABLE ONLY "OrganizationPermission"
    ADD CONSTRAINT "OrganizationPermission_pkey" PRIMARY KEY ("OrganizationId", "PermissionId");


--
-- TOC entry 3053 (class 2606 OID 67756)
-- Name: Organization_pkey; Type: CONSTRAINT; Schema: um; Owner: postgres
--

ALTER TABLE ONLY "Organization"
    ADD CONSTRAINT "Organization_pkey" PRIMARY KEY ("OrganizationID");

--
-- TOC entry 3054 (class 1259 OID 67787)
-- Name: IX_OrganizationPermission_PermissionID; Type: INDEX; Schema: um; Owner: postgres
--

CREATE INDEX "IX_OrganizationPermission_PermissionID" ON "OrganizationPermission" USING btree ("PermissionId" NULLS FIRST);


--
-- TOC entry 3051 (class 1259 OID 67788)
-- Name: IX_Organization_OrganizationID; Type: INDEX; Schema: um; Owner: postgres
--

CREATE INDEX "IX_Organization_OrganizationID" ON "Organization" USING btree ("ParentID" NULLS FIRST);

-- Completed on 2017-01-09 18:25:20

--
-- PostgreSQL database dump complete
--

