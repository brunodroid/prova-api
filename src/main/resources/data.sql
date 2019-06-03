insert into pessoa_model(nome, rg, data_nascimento)
values('Bruno', '123456789', '1987-09-25');

insert into pessoa_contato_model(nome, id_pessoa)
values('Renato', 1);

insert into pessoa_contato_model(nome, id_pessoa)
values('Romario', 1);

insert into pessoa_model(nome, rg, data_nascimento)
values('Jaqueline', '123456789', '1987-06-20');

insert into pessoa_contato_model(nome, id_pessoa)
values('Yasmin', 2);

insert into palavra_model(id, palavra, dica)
select 1, 'LUKE', 'Eu nunca vou cair para o lado sombrio'
union all
select 2, 'LEIA', 'Ajude-me, Obi Wan, você é minha última esperança'
union all
select 3, 'HANSOLO', 'Nunca me diga as probabilidades'
union all
select 4, 'DARTHVADER', 'Junte-se a mim, e juntos podemos governar a galáxia como pai e filho'
union all
select 5, 'YODA', 'Maior professor, o fracasso é'
union all
select 6, 'OBIWAN', 'Se você me derrubar, me tornarei mais poderoso do que você pode imaginar'
union all
select 7, 'KYLO', 'Deixe o passado morrer. Mate-o, se for preciso'
union all
select 8, 'FINN', 'Eu não sou Resistência. Eu não sou um herói. Eu sou um stormtrooper'
union all
select 9, 'REY', 'Eu não sabia que existia tanto verde assim na galáxia'
union all
select 10, 'ANAKIN', 'Se você não está comigo, então você é meu inimigo'
union all
select 11, 'PADME', 'Então é assim que a liberdade morre. Com um estrondoso aplauso'
union all
select 12, 'STORMTROOPER', 'Esses não são os droids que estamos procurando'
union all
select 13, 'PALPATINE', 'O lado sombrio é o caminho para várias habilidades que alguns consideram como não-naturais'
union all
select 14, 'LANDO', 'Eu sou responsável agora. É o preço que se paga por ser bem sucedido'
union all
select 15, 'JABBA', 'Han, ma bookie, keel-ee calleya ku kah'
union all
select 16, 'DOOKU', 'Duas vezes o orgulho, o dobro da queda'
union all
select 17, 'DARTHMAUL', 'Morra, Jedi. Morra!'
union all
select 18, 'BOBAFETT', 'Todos morrem. É a única justiça que restou'
union all
select 19, 'ACKBAR', 'É uma armadilha!'
union all
select 20, 'CHEWBACCA', 'Grrrroooooowr!!';