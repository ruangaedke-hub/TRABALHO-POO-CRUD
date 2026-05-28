# 📚 Sistema de Gerenciamento de Biblioteca

Sistema web desenvolvido com **Spring Boot + Thymeleaf** para gerenciamento de acervo bibliográfico.

## 🎯 Funcionalidades

- **CRUD completo** para 3 entidades: Livro, Autor e Categoria
- **Relacionamentos**: Livro → Autor (ManyToOne), Livro → Categoria (ManyToOne)
- **Dashboard de relatórios** com 3 tipos de gráfico (Chart.js):
  - 🍩 Gráfico de rosca — Livros por categoria
  - 📊 Gráfico de barras — Livros por autor
  - 📈 Gráfico de linha — Publicações por ano
- **Busca** por nome/título em todas as entidades
- **Dados de exemplo** carregados automaticamente na inicialização
- **Validação** de formulários com mensagens de erro
- **Proteção** contra exclusão de registros com dependências

## 🛠️ Tecnologias

| Camada | Tecnologia |
|--------|-----------|
| Backend | Spring Boot 3.2 |
| View | Thymeleaf |
| Persistência | Spring Data JPA |
| Banco de dados | H2 (in-memory) |
| Validação | Jakarta Validation |
| Boilerplate | Lombok |
| Gráficos | Chart.js 4.4 |

## 🚀 Como Executar

### Pré-requisitos
- Java 17+
- Maven 3.8+

### Rodando o projeto

```bash
# Clone o repositório
git clone <url-do-repo>
cd biblioteca

# Execute com Maven
mvn spring-boot:run
```

Acesse: **http://localhost:8080**

Console H2 (banco de dados): **http://localhost:8080/h2-console**
- JDBC URL: `jdbc:h2:mem:biblioteca`
- User: `sa` | Password: *(vazio)*

## 📁 Estrutura do Projeto

```
src/main/
├── java/com/biblioteca/
│   ├── BibliotecaApplication.java    # Main class
│   ├── DataLoader.java               # Dados de exemplo
│   ├── model/
│   │   ├── Livro.java
│   │   ├── Autor.java
│   │   └── Categoria.java
│   ├── repository/
│   │   ├── LivroRepository.java
│   │   ├── AutorRepository.java
│   │   └── CategoriaRepository.java
│   ├── service/
│   │   ├── LivroService.java
│   │   ├── AutorService.java
│   │   └── CategoriaService.java
│   └── controller/
│       ├── HomeController.java
│       ├── LivroController.java
│       ├── AutorController.java
│       ├── CategoriaController.java
│       └── RelatorioController.java
└── resources/
    ├── templates/
    │   ├── index.html
    │   ├── livro/   (lista.html, form.html)
    │   ├── autor/   (lista.html, form.html)
    │   ├── categoria/ (lista.html, form.html)
    │   └── relatorio/ (dashboard.html)
    └── static/
        ├── css/style.css
        └── js/main.js
```

## 🗺️ Endpoints

| Método | URL | Descrição |
|--------|-----|-----------|
| GET | `/` | Dashboard principal |
| GET | `/livros` | Listar livros |
| GET | `/livros/novo` | Formulário novo livro |
| POST | `/livros/salvar` | Salvar livro |
| GET | `/livros/editar/{id}` | Editar livro |
| GET | `/livros/deletar/{id}` | Deletar livro |
| GET | `/autores` | Listar autores |
| GET | `/categorias` | Listar categorias |
| GET | `/relatorio` | Dashboard de relatórios |

## 📊 Diagrama de Classes

Veja o arquivo `docs/diagrama-classes.md`
