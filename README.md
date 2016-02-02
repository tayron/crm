# CRM usando JPA, EJB e JSF
Exemplo de um sistema usando JPA, EJB e JSF para estudo rodando em cima da jre java 7 e jboss 6 eap.

Adicionar configuração no arquivo standalone.xml do jboss 7 dentro da tag ```<security-domains>```:

```
<security-domain name="crm-jsf-security-domain" cache-type="default">
    <authentication>
        <login-module code="Database" flag="required">
            <module-option name="dsJndiName" value="java:jboss/datasources/MySqlDS"/>
            <module-option name="principalsQuery" value="select senha from usuarios where login=?"/>
            <module-option name="rolesQuery" value="select grupo.nome, 'Roles' as Grupo from grupos as grupo inner join usuarios as usuario on (usuario.grupo_id = grupo.id) where usuario.login=?"/>
            <module-option name="hashAlgorithm" value="MD5"/>
            <module-option name="hashEncoding" value="base64"/>
        </login-module>
    </authentication>
</security-domain>
```
Sql para inserção de um usuário no banco de dados: 
```INSERT INTO `usuarios` (`id`, `ativo`, `cpf`, `endereco`, `nome`, `login`, `senha`, `grupo_id`) VALUES (NULL, NULL, '12345698787', 'asdfasdfa', 'admin', 'admin', 'ISMvKXpXpadDiUoOSoAfww==', '1');```

Usuario: admin
Senha: admin
