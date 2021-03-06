USE [master]
GO

/****** Object:  Database [locadora_carro]    Script Date: 15/12/2020 18:36:28 ******/
DROP DATABASE [locadora_carro]
GO

/****** Object:  Database [locadora_carro]    Script Date: 15/12/2020 18:36:28 ******/
CREATE DATABASE [locadora_carro]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'locadora_carro', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS02\MSSQL\DATA\locadora_carro.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'locadora_carro_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS02\MSSQL\DATA\locadora_carro_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO

IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [locadora_carro].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO

ALTER DATABASE [locadora_carro] SET ANSI_NULL_DEFAULT OFF 
GO

ALTER DATABASE [locadora_carro] SET ANSI_NULLS OFF 
GO

ALTER DATABASE [locadora_carro] SET ANSI_PADDING OFF 
GO

ALTER DATABASE [locadora_carro] SET ANSI_WARNINGS OFF 
GO

ALTER DATABASE [locadora_carro] SET ARITHABORT OFF 
GO

ALTER DATABASE [locadora_carro] SET AUTO_CLOSE ON 
GO

ALTER DATABASE [locadora_carro] SET AUTO_SHRINK OFF 
GO

ALTER DATABASE [locadora_carro] SET AUTO_UPDATE_STATISTICS ON 
GO

ALTER DATABASE [locadora_carro] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO

ALTER DATABASE [locadora_carro] SET CURSOR_DEFAULT  GLOBAL 
GO

ALTER DATABASE [locadora_carro] SET CONCAT_NULL_YIELDS_NULL OFF 
GO

ALTER DATABASE [locadora_carro] SET NUMERIC_ROUNDABORT OFF 
GO

ALTER DATABASE [locadora_carro] SET QUOTED_IDENTIFIER OFF 
GO

ALTER DATABASE [locadora_carro] SET RECURSIVE_TRIGGERS OFF 
GO

ALTER DATABASE [locadora_carro] SET  ENABLE_BROKER 
GO

ALTER DATABASE [locadora_carro] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO

ALTER DATABASE [locadora_carro] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO

ALTER DATABASE [locadora_carro] SET TRUSTWORTHY OFF 
GO

ALTER DATABASE [locadora_carro] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO

ALTER DATABASE [locadora_carro] SET PARAMETERIZATION SIMPLE 
GO

ALTER DATABASE [locadora_carro] SET READ_COMMITTED_SNAPSHOT OFF 
GO

ALTER DATABASE [locadora_carro] SET HONOR_BROKER_PRIORITY OFF 
GO

ALTER DATABASE [locadora_carro] SET RECOVERY SIMPLE 
GO

ALTER DATABASE [locadora_carro] SET  MULTI_USER 
GO

ALTER DATABASE [locadora_carro] SET PAGE_VERIFY CHECKSUM  
GO

ALTER DATABASE [locadora_carro] SET DB_CHAINING OFF 
GO

ALTER DATABASE [locadora_carro] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO

ALTER DATABASE [locadora_carro] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO

ALTER DATABASE [locadora_carro] SET DELAYED_DURABILITY = DISABLED 
GO

ALTER DATABASE [locadora_carro] SET QUERY_STORE = OFF
GO

ALTER DATABASE [locadora_carro] SET  READ_WRITE 
GO

