# Alert Aggregator

A Spring Boot REST API that receives, stores, and forwards system alerts based on severity. Built as a portfolio project to demonstrate IT infrastructure monitoring concepts using Java 21 and Spring Boot 4.

---

## Features

- Ingest alerts from any external source via REST
- Persist alerts to a database (H2 for local, PostgreSQL for production)
- Automatically send email notifications for critical alerts
- Query and filter stored alerts by severity, source, or status
- Scheduled re-notification for unacknowledged critical alerts
- Health and metrics endpoints via Spring Boot Actuator

## Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 21 (Eclipse Temurin) |
| Framework | Spring Boot 4 |
| Persistence | Spring Data JPA + PostgreSQL |
| Dev Database | H2 (in-memory) |
| Email | Spring Mail (SMTP) |
| Monitoring | Spring Boot Actuator |
| Build | Gradle |

## Data Model

Each alert contains:

| Field | Type | Description |
|---|---|---|
| `id` | Long | Auto-generated primary key |
| `source` | String | Origin of the alert (e.g. `server-01`) |
| `message` | String | Alert description |
| `severity` | Enum | `LOW`, `MEDIUM`, or `CRITICAL` |
| `status` | Enum | `NEW` or `ACKNOWLEDGED` |
| `createdAt` | LocalDateTime | Timestamp of ingestion |

## API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/api/alerts` | Ingest a new alert |
| `GET` | `/api/alerts` | List all alerts |
| `GET` | `/api/alerts?severity=CRITICAL` | Filter by severity |
| `PATCH` | `/api/alerts/{id}/acknowledge` | Acknowledge an alert |

## Getting Started

```bash
# Clone the repository
git clone https://github.com/your-username/alert-aggregator.git
cd alert-aggregator

# Run with Gradle (uses H2 in-memory DB by default)
./gradlew bootRun
```

The API will be available at `http://localhost:8080`.

## Configuration

Copy `application.properties` and adjust for your environment:

```properties
# Email (for critical alert forwarding)
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=your@email.com
spring.mail.password=your-app-password

# PostgreSQL (for production)
spring.datasource.url=jdbc:postgresql://localhost:5432/alertdb
spring.datasource.username=postgres
spring.datasource.password=yourpassword
```

## License

MIT

---

---

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
