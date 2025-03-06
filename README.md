# Sistema de Gestão de Pistas de Corrida e Piloto

## Descrição
Este projeto é um sistema de gestão de pistas de corrida e pilotos, focado em facilitar o gerenciamento de competições, além de permitir o controle de dados relacionados às pistas, pilotos, e corridas. O sistema oferece uma interface intuitiva para a criação, edição e visualização de informações essenciais para eventos de corrida.

## Funcionalidades
- Cadastro de pistas e pilotos
- Agendamento e gerenciamento de corridas
- Registro e monitoramento de resultados de competições
- Relatórios e estatísticas sobre pilotos e corridas
- Integração com sistemas externos para análise de performance

## Tecnologias Utilizadas
- **Backend**: Java com Spring Boot
- **Frontend**: React
- **Banco de Dados**: PostgreSQL
- **Monitoramento**: OpenTelemetry, Prometheus, Grafana
- **Observabilidade**: Jaeger
- **Mensageria**: Kafka
- **Documentação da API**: Swagger

## Como Executar Localmente
1. Clone o repositório:
    ```bash
    git clone https://github.com/dennysnascimento/gpcp.git
    ```
2. Navegue até o diretório:
    ```bash
    cd automotive
    ```
3. Execute o Docker Compose para iniciar os serviços:
    ```bash
    docker-compose up
    ```
4. Acesse o sistema no navegador em `http://localhost:8080/swagger-ui/index.html`.

## Contribuição
Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou pull requests.

## Licença
Este projeto está licenciado sob a licença MIT.
