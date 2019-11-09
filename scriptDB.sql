-- MySQL Script generated by MySQL Workbench
-- Fri Nov  8 00:31:40 2019
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema kursDB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema kursDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `kursDB` DEFAULT CHARACTER SET utf8 ;
USE `kursDB` ;

-- -----------------------------------------------------
-- Table `kursDB`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kursDB`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `role` ENUM('', 'admin', 'user') NOT NULL,
  `login` VARCHAR(45) NOT NULL,
  `password` VARCHAR(80) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kursDB`.`fund`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kursDB`.`fund` (
  `date` DATE NOT NULL,
  `cash` DOUBLE NOT NULL,
  `payment_account` DOUBLE NOT NULL,
  `currency_account` DOUBLE NOT NULL,
  PRIMARY KEY (`date`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kursDB`.`sources_of_equity`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kursDB`.`sources_of_equity` (
  `date` DATE NOT NULL,
  `authorized_capital` DOUBLE NOT NULL,
  `undestributed_profits` DOUBLE NOT NULL,
  `reserves` DOUBLE NOT NULL,
  `sinking_fund` DOUBLE NOT NULL,
  PRIMARY KEY (`date`),
  CONSTRAINT `fund_date`
    FOREIGN KEY (`date`)
    REFERENCES `kursDB`.`fund` (`date`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kursDB`.`liquid_parameters`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kursDB`.`liquid_parameters` (
  `date` DATE NOT NULL,
  `accounts_receivable` DOUBLE NOT NULL,
  `securities` DOUBLE NOT NULL,
  PRIMARY KEY (`date`),
  CONSTRAINT `sources_of_equity_date`
    FOREIGN KEY (`date`)
    REFERENCES `kursDB`.`sources_of_equity` (`date`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kursDB`.`loan_sources`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kursDB`.`loan_sources` (
  `date` DATE NOT NULL,
  `shortterm_debt` DOUBLE NOT NULL,
  `longterm_debt` DOUBLE NOT NULL,
  PRIMARY KEY (`date`),
  CONSTRAINT `liquid_param_date`
    FOREIGN KEY (`date`)
    REFERENCES `kursDB`.`liquid_parameters` (`date`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `kursDB`.`business_activity_param`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kursDB`.`business_activity_param` (
  `date` DATE NOT NULL,
  `net_balance_currency` DOUBLE NOT NULL,
  `fixed_assets` DOUBLE NOT NULL,
  `other_investments` DOUBLE NOT NULL,
  PRIMARY KEY (`date`),
  CONSTRAINT `loan_sources_date`
    FOREIGN KEY (`date`)
    REFERENCES `kursDB`.`loan_sources` (`date`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
