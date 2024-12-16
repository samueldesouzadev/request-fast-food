provider "aws" {
  region = "us-east-2"
}

# Criando o banco de dados RDS MySQL
resource "aws_db_instance" "request_fast_food" {
  allocated_storage    = 20
  max_allocated_storage = 50
  engine               = "mysql"
  engine_version       = "8.0"
  instance_class       = "db.t3.micro"
  name                 = "request_fast_food_db"
  username             = "admin"
  password             = "admin"
  parameter_group_name = "default.mysql8.0"
  publicly_accessible  = false
  vpc_security_group_ids = [aws_security_group.db_access.id]
  db_subnet_group_name = aws_db_subnet_group.rds_subnet_group.name
}

# Criando o Security Group para permitir o acesso ao RDS
resource "aws_security_group" "db_access" {
  name        = "db_access"
  description = "Allow access to the RDS database"

  ingress {
    from_port   = 3306
    to_port     = 3306
    protocol    = "tcp"
    cidr_blocks = ["<IP_do_ECS>/32"]
  }

  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }
}

# Grupo de Subnets para o RDS (subnets privadas)
resource "aws_db_subnet_group" "rds_subnet_group" {
  name       = "rds_subnet_group"
  subnet_ids = ["subnet-0b5c32a446cbadff2", "subnet-083d857811d33853e"]

  tags = {
    Name = "RDS subnet group"
  }
}
