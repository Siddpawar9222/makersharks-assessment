INSERT INTO role_table (role_id, role_name)
VALUES (1, 0),
       (2, 1);

INSERT INTO user_table (user_username, user_password)
VALUES ('siddhesh@gmail.com', '$2a$10$FEKqM1emae3gyLs0ySYH6OiJ0K2xgZbgOxvw.lGqYCyVDRPEbKLTS');
-- password is 123456

INSERT INTO user_roles (user_id, role_id)
VALUES (1, 1),
       (1, 2);


-- manufacturer_table

INSERT INTO manufacturer_table (supplier_id, company_name, website, location, nature_of_business, manufacturing_processes)
VALUES (1, 'Acme Manufacturing', 'http://acme-manufacturing.com', 'USA', 'large_scale', 'moulding'),
       (2, 'Beta Industries', 'http://beta-industries.com', 'USA', 'medium_scale', '3d_printing'),
       (3, 'Gamma Co.', 'http://gamma-co.com', 'Canada', 'small_scale', 'casting'),
       (4, 'Delta Corp', 'http://delta-corp.com', 'Canada', 'large_scale', 'coating'),
       (5, 'Epsilon Ltd', 'http://epsilon-ltd.com', 'UK', 'medium_scale', 'moulding'),
       (6, 'Zeta Technologies', 'http://zeta-technologies.com', 'UK', 'large_scale', '3d_printing'),
       (7, 'Eta Enterprises', 'http://eta-enterprises.com', 'Australia', 'small_scale', 'casting'),
       (8, 'Theta Manufacturing', 'http://theta-manufacturing.com', 'Australia', 'large_scale', 'coating'),
       (9, 'Iota Industries', 'http://iota-industries.com', 'Australia', 'medium_scale', 'moulding'),
       (10, 'Kappa Corp', 'http://kappa-corp.com', 'India', 'small_scale', '3d_printing'),
       (11, 'Lambda Ltd', 'http://lambda-ltd.com', 'India', 'large_scale', 'casting'),
       (12, 'Mu Technologies', 'http://mu-technologies.com', 'USA', 'medium_scale', 'coating'),
       (13, 'Nu Enterprises', 'http://nu-enterprises.com', 'USA', 'small_scale', 'moulding'),
       (14, 'Xi Manufacturing', 'http://xi-manufacturing.com', 'Canada', 'large_scale', '3d_printing'),
       (15, 'Omicron Industries', 'http://omicron-industries.com', 'Canada', 'medium_scale', 'casting'),
       (16, 'Pi Corp', 'http://pi-corp.com', 'UK', 'small_scale', 'coating'),
       (17, 'Rho Ltd', 'http://rho-ltd.com', 'UK', 'large_scale', 'moulding'),
       (18, 'Sigma Technologies', 'http://sigma-technologies.com', 'Australia', 'medium_scale', '3d_printing'),
       (19, 'Tau Enterprises', 'http://tau-enterprises.com', 'Australia', 'small_scale', 'casting'),
       (20, 'Upsilon Manufacturing', 'http://upsilon-manufacturing.com', 'Australia', 'large_scale', 'coating'),
       (21, 'Phi Industries', 'http://phi-industries.com', 'India', 'medium_scale', 'moulding'),
       (22, 'Chi Corp', 'http://chi-corp.com', 'India', 'small_scale', '3d_printing'),
       (23, 'Psi Ltd', 'http://psi-ltd.com', 'USA', 'large_scale', 'casting'),
       (24, 'Omega Technologies', 'http://omega-technologies.com', 'USA', 'medium_scale', 'coating'),
       (25, 'Alpha Manufacturing', 'http://alpha-manufacturing.com', 'Canada', 'small_scale', 'moulding'),
       (26, 'Beta Corp', 'http://beta-corp.com', 'Canada', 'large_scale', '3d_printing'),
       (27, 'Gamma Ltd', 'http://gamma-ltd.com', 'UK', 'medium_scale', 'casting'),
       (28, 'Delta Technologies', 'http://delta-technologies.com', 'UK', 'small_scale', 'coating'),
       (29, 'Epsilon Enterprises', 'http://epsilon-enterprises.com', 'Australia', 'large_scale', 'moulding'),
       (30, 'Zeta Manufacturing', 'http://zeta-manufacturing.com', 'Australia', 'medium_scale', '3d_printing'),
       (31, 'Eta Industries', 'http://eta-industries.com', 'Australia', 'small_scale', 'casting'),
       (32, 'Theta Corp', 'http://theta-corp.com', 'India', 'large_scale', 'coating'),
       (33, 'Iota Ltd', 'http://iota-ltd.com', 'India', 'medium_scale', 'moulding'),
       (34, 'Kappa Technologies', 'http://kappa-technologies.com', 'USA', 'small_scale', '3d_printing'),
       (35, 'Lambda Enterprises', 'http://lambda-enterprises.com', 'USA', 'large_scale', 'casting'),
       (36, 'Mu Manufacturing', 'http://mu-manufacturing.com', 'Canada', 'medium_scale', 'coating'),
       (37, 'Nu Industries', 'http://nu-industries.com', 'Canada', 'small_scale', 'moulding'),
       (38, 'Xi Corp', 'http://xi-corp.com', 'UK', 'large_scale', '3d_printing'),
       (39, 'Omicron Ltd', 'http://omicron-ltd.com', 'UK', 'medium_scale', 'casting'),
       (40, 'Pi Technologies', 'http://pi-technologies.com', 'Australia', 'small_scale', 'coating'),
       (41, 'Rho Enterprises', 'http://rho-enterprises.com', 'Australia', 'large_scale', 'moulding'),
       (42, 'Sigma Manufacturing', 'http://sigma-manufacturing.com', 'Australia', 'medium_scale', '3d_printing'),
       (43, 'Tau Industries', 'http://tau-industries.com', 'India', 'small_scale', 'casting'),
       (44, 'Upsilon Corp', 'http://upsilon-corp.com', 'India', 'large_scale', 'coating'),
       (45, 'Phi Ltd', 'http://phi-ltd.com', 'USA', 'medium_scale', 'moulding'),
       (46, 'Chi Technologies', 'http://chi-technologies.com', 'USA', 'small_scale', '3d_printing'),
       (47, 'Psi Enterprises', 'http://psi-enterprises.com', 'Canada', 'large_scale', 'casting'),
       (48, 'Omega Manufacturing', 'http://omega-manufacturing.com', 'Canada', 'medium_scale', 'coating'),
       (49, 'Alpha Industries', 'http://alpha-industries.com', 'UK', 'small_scale', 'moulding'),
       (50, 'Beta Technologies', 'http://beta-technologies.com', 'UK', 'large_scale', '3d_printing'),
       (51, 'Shree Casting', 'http://shreecasting.com', 'India', 'small_scale', 'casting'),
       (52, 'Bharat Foundries', 'http://bharatfoundries.com', 'India', 'small_scale', 'casting'),
       (53, 'Mithila Metals', 'http://mithilametals.com', 'India', 'small_scale', 'casting'),
       (54, 'Vishnu Castings', 'http://vishnucastings.com', 'India', 'small_scale', 'casting'),
       (55, 'Kaveri Foundries', 'http://kaverifoundries.com', 'India', 'small_scale', 'casting'),
       (56, 'Himalaya Castings', 'http://himalayacastings.com', 'India', 'small_scale', 'casting'),
       (57, 'Saraswati Metals', 'http://saraswatimetals.com', 'India', 'small_scale', 'casting'),
       (58, 'Ganga Foundry', 'http://gangafoundry.com', 'India', 'small_scale', 'casting'),
       (59, 'Krishna Castings', 'http://krishnacastings.com', 'India', 'small_scale', 'casting'),
       (60, 'Deccan Foundries', 'http://deccanfoundries.com', 'India', 'small_scale', 'casting'),
       (61, 'Maruthi Metals', 'http://maruthimetals.com', 'India', 'small_scale', 'casting'),
       (62, 'Sindhu Castings', 'http://sindhucastings.com', 'India', 'small_scale', 'casting'),
       (63, 'Triveni Foundry', 'http://trivenifoundry.com', 'India', 'small_scale', 'casting'),
       (64, 'Narmada Metals', 'http://narmadametals.com', 'India', 'small_scale', 'casting'),
       (65, 'Sangam Castings', 'http://sangamcastings.com', 'India', 'small_scale', 'casting');



