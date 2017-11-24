# AEBD


Povoamento:
Consulta (1..5000)
Especialidade (1..8)
Hospital (1..7)
Hospital_Medico (1..50)
Medico (1..30)
Utente_Hospital (1..1000)
Utente (0..499)



ToDo:
Criar Trigger para não deixar inserir o mesmo médico/utente 2 vezes no mesmo hospital.



---------------------------
CREATE TRIGGER trigger_name 
ON table_name 
instead OF INSERT 
AS 
    BEGIN 
        IF (true) 
            INSERT INTO table_name VALUES () 
    END