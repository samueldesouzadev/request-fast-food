provider "aws" {
  region = "us-east-2"
}

# Criando o Security Group para permitir o acesso ao RDS
resource "aws_security_group" "rds_sg" {
  name        = "rds_sg"
  description = "Security group for RDS"
  vpc_id      = var.vpc_id  # ID do VPC

  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }

  ingress {
    from_port   = 3306  # Porta do MySQL
    to_port     = 3306
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]  # Altere conforme a segurança necessária
  }
}

# Criando o grupo de subnets para o RDS (subnets privadas)
resource "aws_db_subnet_group" "my_db_subnet_group" {
  name       = "my_db_subnet_group"
  subnet_ids = var.subnet_ids

  tags = {
    Name = "my-db-subnet-group"
  }
}

# Criando o banco de dados RDS MySQL
resource "aws_db_instance" "request_fast_food" {
  allocated_storage    = 20
  max_allocated_storage = 50
  engine               = "mysql"
  engine_version       = "8.0"
  instance_class       = "db.t3.micro"
  db_name              = "fastfooddb"
  username             = var.db_username
  password             = var.db_password
  parameter_group_name = "default.mysql8.0"
  publicly_accessible  = false
  vpc_security_group_ids = [aws_security_group.rds_sg.id]
  db_subnet_group_name = aws_db_subnet_group.my_db_subnet_group.name
}
