--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.4 (Postgres-XL 9.5r1.3)
-- Dumped by pg_dump version 9.5.5

-- Started on 2017-01-09 18:26:46

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;
--
-- TOC entry 3216 (class 0 OID 67649)
-- Dependencies: 197
-- Data for Name: Organization; Type: TABLE DATA; Schema: um; Owner: postgres
--

INSERT INTO "Organization" ("OrganizationID", "Name", "Description", "ParentID", "Fields") VALUES (5, 'Organization1', 'Organization1 Description', NULL, '{"districtId": 4, "upazillaId": 5}');
INSERT INTO "Organization" ("OrganizationID", "Name", "Description", "ParentID", "Fields") VALUES (6, 'Organization1', 'Organization1 Description', 2, '{"districtId": 4, "upazillaId": 5}');
INSERT INTO "Organization" ("OrganizationID", "Name", "Description", "ParentID", "Fields") VALUES (8, 'Organization1', 'Organization1 Description', 2, '{"districtId": 4, "upazillaId": 5}');
INSERT INTO "Organization" ("OrganizationID", "Name", "Description", "ParentID", "Fields") VALUES (3, 'Organization1', 'Organization1 Description', NULL, '{"districtId": 4, "upazillaId": 5}');
INSERT INTO "Organization" ("OrganizationID", "Name", "Description", "ParentID", "Fields") VALUES (4, 'Organization1', 'Organization1 Description', 2, '{"districtId": 4, "upazillaId": 5}');
INSERT INTO "Organization" ("OrganizationID", "Name", "Description", "ParentID", "Fields") VALUES (7, 'Organization1', 'Organization1 Description', NULL, '{"districtId": 4, "upazillaId": 5}');
INSERT INTO "Organization" ("OrganizationID", "Name", "Description", "ParentID", "Fields") VALUES (10, 'Organization1', 'Organization1 Description', 2, '{"districtId": 4, "upazillaId": 5}');
INSERT INTO "Organization" ("OrganizationID", "Name", "Description", "ParentID", "Fields") VALUES (2, 'Organization2', 'Organization2', NULL, '{"districtId": 4, "upazillaId": 5}');
INSERT INTO "Organization" ("OrganizationID", "Name", "Description", "ParentID", "Fields") VALUES (9, 'Organization1', 'Organization1 Description', NULL, '{"districtId": 4, "upazillaId": 5}');
INSERT INTO "Organization" ("OrganizationID", "Name", "Description", "ParentID", "Fields") VALUES (1, 'Organization1', 'Organization1 Description', 2, '{"districtId": 4, "upazillaId": 5}');


--
-- TOC entry 3217 (class 0 OID 67657)
-- Dependencies: 198
-- Data for Name: OrganizationPermission; Type: TABLE DATA; Schema: um; Owner: postgres
--

INSERT INTO "OrganizationPermission" ("OrganizationId", "PermissionId") VALUES (1, '53ded76c-9041-11e6-821f-0050568f767f');
INSERT INTO "OrganizationPermission" ("OrganizationId", "PermissionId") VALUES (1, '5c9e9b56-9041-11e6-821f-0050568f767f');
INSERT INTO "OrganizationPermission" ("OrganizationId", "PermissionId") VALUES (1, '4fd4f13e-9041-11e6-821f-0050568f767f');
INSERT INTO "OrganizationPermission" ("OrganizationId", "PermissionId") VALUES (1, '571f3964-9041-11e6-821f-0050568f767f');


--
-- TOC entry 3244 (class 0 OID 0)
-- Dependencies: 196
-- Name: organization_id_seq; Type: SEQUENCE SET; Schema: um; Owner: postgres
--

SELECT pg_catalog.setval('organization_id_seq', 141, true);

-- Completed on 2017-01-09 18:26:46

--
-- PostgreSQL database dump complete
--

