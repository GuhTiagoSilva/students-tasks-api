INSERT INTO Tb_Student (Name, UserName, Password, Email, Gender, Is_Active) Values ('Gustavo Tiago da Silva', 'GuhTiagoSilva', '987654','gustavo.teste@gmail.com' ,True, True);
INSERT INTO Tb_Student (Name, UserName, Password, Email, Gender, Is_Active) Values ('Paulo Henrique Nunes Silva', 'PHNSilva', '123456','ph.teste@gmail.com' ,True, True);
INSERT INTO Tb_Student (Name, UserName, Password, Email, Gender, Is_Active) Values ('Julio Costa Machado', 'JuhCostaMachado', '56984','julio.teste@gmail.com' ,True, True);
INSERT INTO Tb_Student (Name, UserName, Password, Email, Gender, Is_Active) Values ('Receba Silva', 'ReSilva', 'Re1234','rebeca.teste@gmail.com' ,False, True);
INSERT INTO Tb_Student (Name, UserName, Password, Email, Gender, Is_Active) Values ('Adriano Costa Silva', 'DriSilva', 'dri1234','dri.teste@gmail.com' ,True, True);
INSERT INTO Tb_Student (Name, UserName, Password, Email, Gender, Is_Active) Values ('Michele Santos Aguiar', 'MiSantosAguiar', '569874','mi.teste@gmail.com' ,False, True);
INSERT INTO Tb_Student (Name, UserName, Password, Email, Gender, Is_Active) Values ('Gustavo Henrique Gois da Silva', 'GustavoGois33', '852147','gustavogois33.teste@gmail.com' ,True, True);
INSERT INTO Tb_Student (Name, UserName, Password, Email, Gender, Is_Active) Values ('Gabriel Costa', 'GabrielCosta', 'gabriel1234','gabriel.teste@gmail.com' ,True, True);
INSERT INTO Tb_Student (Name, UserName, Password, Email, Gender, Is_Active) Values ('Gabrielle Silva', 'Gabi123', 'gabi1234','gabi.teste@gmail.com' ,False, True);
INSERT INTO Tb_Student (Name, UserName, Password, Email, Gender, Is_Active) Values ('Eduarda Gomes', 'EduardaG', '123435','eduarda.teste@gmail.com' ,False, True);
INSERT INTO Tb_Student (Name, UserName, Password, Email, Gender, Is_Active) Values ('Julia Costa', 'JuhCosta', '898956532','juh.teste@gmail.com' ,False, False);



INSERT INTO Tb_Task (Title, Is_Active) Values ('Fazer a compra do mês', True);
INSERT INTO Tb_Task (Title, Is_Active) Values ('Estudar para a prova', True);
INSERT INTO Tb_Task (Title, Is_Active) Values ('Fazer o trabalho da faculdade', True);
INSERT INTO Tb_Task (Title, Is_Active) Values ('Pagar as contas', True);
INSERT INTO Tb_Task (Title, Is_Active) Values ('Enviar email do trabalho', True);
INSERT INTO Tb_Task (Title, Is_Active) Values ('Comprar presente de natal', True);
INSERT INTO Tb_Task (Title, Is_Active) Values ('Reservar viagem de ano novo', True);
INSERT INTO Tb_Task (Title, Is_Active) Values ('Praticar Exercícios', True);
INSERT INTO Tb_Task (Title, Is_Active) Values ('Estudar para apresentação', True);


INSERT INTO Tb_Task_Item (Delivery_Date, Description, Is_Active, Title, Task_Id) Values ('2020-12-31', 'Separar dinheiro', True,'Dinheiro', 1);
INSERT INTO Tb_Task_Item (Delivery_Date, Description, Is_Active, Title, Task_Id) Values ('2020-12-30', 'Organizar Material para Estudo', True, 'Organizar', 2);
INSERT INTO Tb_Task_Item (Delivery_Date, Description, Is_Active, Title, Task_Id) Values ('2020-12-29', 'Conversar com o grupo sobre o trabalho',  True,'Organizar', 3);
INSERT INTO Tb_Task_Item (Delivery_Date, Description, Is_Active, Title, Task_Id) Values ('2020-12-28', 'Separar as contas que precisam ser pagas', True,'Separação de Contas', 4);
INSERT INTO Tb_Task_Item (Delivery_Date, Description, Is_Active, Title, Task_Id) Values ('2020-12-27', 'Entrar na conta de email',  True, 'Email', 5);
INSERT INTO Tb_Task_Item (Delivery_Date, Description, Is_Active, Title, Task_Id) Values ('2020-12-26', 'Colocar o relógio para despertar mais cedo para praticar exercícios',  True,'Despertador', 9);


