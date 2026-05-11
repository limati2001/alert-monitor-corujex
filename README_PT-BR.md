# Alert Aggregator

Uma API REST em Spring Boot que recebe, armazena e encaminha alertas de sistema com base na severidade. Desenvolvida como projeto de portfólio para demonstrar conceitos de monitoramento de infraestrutura de TI usando Java 21 e Spring Boot 4.

---

## Funcionalidades

- Receber alertas de qualquer fonte externa via REST
- Persistir alertas em banco de dados (H2 para desenvolvimento, PostgreSQL para produção)
- Enviar notificações por e-mail automaticamente para alertas críticos
- Consultar e filtrar alertas armazenados por severidade, origem ou status
- Renotificação agendada para alertas críticos não reconhecidos
- Endpoints de saúde e métricas via Spring Boot Actuator

## Stack de Tecnologias

| Camada | Tecnologia |
|---|---|
| Linguagem | Java 21 (Eclipse Temurin) |
| Framework | Spring Boot 4 |
| Persistência | Spring Data JPA + PostgreSQL |
| Banco de Dados (dev) | H2 (em memória) |
| E-mail | Spring Mail (SMTP) |
| Monitoramento | Spring Boot Actuator |
| Build | Gradle |

## Modelo de Dados

Cada alerta contém:

| Campo | Tipo | Descrição |
|---|---|---|
| `id` | Long | Chave primária gerada automaticamente |
| `source` | String | Origem do alerta (ex: `server-01`) |
| `message` | String | Descrição do alerta |
| `severity` | Enum | `LOW`, `MEDIUM` ou `CRITICAL` |
| `status` | Enum | `NEW` ou `ACKNOWLEDGED` |
| `createdAt` | LocalDateTime | Timestamp de recebimento |

## Endpoints da API

| Método | Endpoint | Descrição |
|---|---|---|
| `POST` | `/api/alerts` | Receber um novo alerta |
| `GET` | `/api/alerts` | Listar todos os alertas |
| `GET` | `/api/alerts?severity=CRITICAL` | Filtrar por severidade |
| `PATCH` | `/api/alerts/{id}/acknowledge` | Reconhecer um alerta |

## Como Executar

```bash
# Clonar o repositório
git clone https://github.com/seu-usuario/alert-aggregator.git
cd alert-aggregator

# Executar com Gradle (usa H2 em memória por padrão)
./gradlew bootRun
```

A API estará disponível em `http://localhost:8080`.

## Configuração

Ajuste o `application.properties` conforme o seu ambiente:

```properties
# E-mail (para encaminhamento de alertas críticos)
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=seu@email.com
spring.mail.password=sua-senha-de-app

# PostgreSQL (para produção)
spring.datasource.url=jdbc:postgresql://localhost:5432/alertdb
spring.datasource.username=postgres
spring.datasource.password=suasenha
```

## Licença

MIT