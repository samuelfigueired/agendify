-- Atualiza a senha do usuário admin
-- Senha real: 123456 (BCrypt)

UPDATE tb_usuarios
SET senha = '$2a$10$j0NMA8wqBaKOYcyYpJ5jTutuOB.1R6UPjwWyr5EqsCYC2N.vodpeG'
WHERE email = 'admin@agendify.com';
