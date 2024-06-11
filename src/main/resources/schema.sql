CREATE TABLE IF NOT EXISTS `customer` (
  `appNumber` int AUTO_INCREMENT  PRIMARY KEY,
  `name` varchar(100) NOT NULL,
  `dob` date NOT NULL,
  `ssn` long NOT NULL,
  `gender` varchar(5) NOT NULL,
  `plan_id` int NOT NULL,
  `citizenId` int NOT NULL,
  `created_date` date NOT NULL,
  `updated_date` date DEFAULT NULL
);
